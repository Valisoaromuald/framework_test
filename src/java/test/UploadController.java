package test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import annotation.Controleur;
import annotation.PostHttp;
import annotation.UrlMapping;
import utilitaire.ModelView;
@Controleur
public class UploadController {

    private  Path uploadDir;

    public Path getUploadDir() {
        return uploadDir;
    }
    public void setUploadDir(Path uploadDir) {
        this.uploadDir = uploadDir;
         try {
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }
        } catch (IOException e) {
            throw new RuntimeException("Impossible de créer le dossier d'upload", e);
        }
    }
    public UploadController(String uploadDirectory) {

        this.uploadDir = Paths.get(uploadDirectory);

        try {
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }
        } catch (IOException e) {
            throw new RuntimeException("Impossible de créer le dossier d'upload", e);
        }
    }
    public UploadController(){

    }

    @UrlMapping(url="/upload/form")
    public static ModelView uploadForm(){
        ModelView mv  = new ModelView();
        mv.setView("upload.jsp");
        return mv;
    }
    /**
     * Enregistre plusieurs fichiers sur le disque
     *
     * @param fichiers Map<nomDuFichier, contenu>
     */
    @PostHttp(url="/upload")
    public void saveFiles(Map<String, byte[]> fichiers) {
        
        for (Map.Entry<String, byte[]> entry : fichiers.entrySet()) {

            String fileName = entry.getKey();
            byte[] data = entry.getValue();

            Path filePath = uploadDir.resolve(fileName);

            try {
                Files.write(filePath, data);
            } catch (IOException e) {
                throw new RuntimeException(
                    "Erreur lors de l'enregistrement du fichier : " + fileName, e
                );
            }
        }
    }
}

