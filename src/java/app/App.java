package app;

import utilitaire.ClasseUtilitaire;
import utilitaire.MappingMethodClass;
// import utilitaire.Sprint8Bis;
import utilitaire.Sprint8Bis.ObjectChecking;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import annotation.Controleur;
import annotation.UrlMapping;
import modele.Maison;
import test.MaisonController;

public class App {
    public static void main(String[] args) throws Exception {
        File root = new File(System.getProperty("user.dir")); // adapte ce chemin
        System.out.println("\n=== Classes trouvées ===");
        String str1 = "m.pieces[0][0]";
        String str2 = "m.pieces[0][1]";
        // String str3 = "m.pieces[0][2]";
        // // String str4 = "pieces[1]";
        // // String str5 = "pieces[1]";
        // List<String> chaines = new ArrayList<String>(List.of(str2, str1, str3));
        // System.out.println(str3.lastIndexOf("]"));

        // // List<Integer> listeNombresEntreCrochet1 =
        // // Sprint8Bis.getNombresEntreCrochet(str1);
        // // List<Integer> listeNombresEntreCrochet2 =
        // // Sprint8Bis.getNombresEntreCrochet(str2);
        // // System.out.println(Sprint8Bis.comparer(listeNombresEntreCrochet1,
        // // listeNombresEntreCrochet2));
        // // System.out.println("nombres entre crochet : "+listeNombresEntreCrochet);
         try {
            Class<?> clazz = MaisonController.class;
            // Method m = clazz.getMethod("showInfo", null);
            System.out.println(ObjectChecking.isListType(java.util.List.class));
            Map<String, List<MappingMethodClass>> hafahafa = ClasseUtilitaire.generateUrlsWithMappedMethodClass(root);
            System.out.println("hafahafa"+hafahafa);
        //     // System.out.println("chaines avant arrangements: "+chaines);
        //     // Sprint8Bis.arrangerChainesParNombresEntreCrochet(chaines);
        //     System.out.println("chaines eto e:"+chaines);
        //     // System.out.println("chaines apres arrangements: "+chaines);
        //     // List<String> chainesVaovao = Sprint8Bis.chainesAvecNombreCrochetAyantElementAtIndice(1, 1, chaines);
        //     //   Object obj = Sprint8Bis.allouerTableau(0, 0, chaines, String[].class);
        //     // System.out.println(Sprint8Bis.getTailleMax(0, chaines));
        //     Class<?> clazz  = Maison.class;
        //     Field f = clazz.getDeclaredField("pieces");
        //     System.out.println(f.getType().getName());
            // System.out.println("objet: "+obj);
            // List<Integer> listeEntiers1 = new ArrayList<>(List.of(1,2,3));
            // List<Integer> listeEntiers2 = new ArrayList<>(List.of(1,2,3));
            // System.out.println(listeEntiers1.equals(listeEntiers2));

            // System.out.println("liste chaines"+chainesVaovao);
            // Map<String,MappingMethodClass> results =
            // ClasseUtilitaire.generateUrlsWithMappedMethodClass(root);
            // Map.Entry<String, MappingMethodClass> entry =
            // ClasseUtilitaire.getRelevantMethodAndClassNames(results, root,
            // "/informatique");
            // System.out.println(entry.getKey()+":"+(entry.getValue()).getClassName()+" ;
            // "+(entry.getValue()).getMethodName());

            // List<String> methodAndClassNames = getMappingClassAndMethodByUrl(root, "");
            // System.out.println(methodAndClassNames.get(0)+" ;
            // "+methodAndClassNames.get(1));
        } catch (

        Exception e) {
            e.printStackTrace();
            System.out.println("erreur: " + e.getMessage());
        }
    }

    // public static Map<String, Object> getUrlWithMappingMethodClass(File file)
    // throws Exception {
    // Map<String, Object> results = new HashMap<String, Object>();
    // System.out.println("nom de dosier: "+file.getAbsolutePath());
    // List<String> classNames = ClasseUtilitaire.findAllClassNames(file, "");
    // for (String className : classNames) {
    // Class<?> clazz = createClass(className);
    // System.out.println("nom de classe: "+clazz.getName()+" misy annotation ve:
    // "+clazz.isAnnotationPresent(Controleur.class));
    // if (clazz.isAnnotationPresent(Controleur.class)) {
    // Method[] methodes = clazz.getDeclaredMethods();
    // for (Method m : methodes) {
    // if (m.isAnnotationPresent(UrlMapping.class)) {
    // results.put(m.getAnnotation(UrlMapping.class).url(),
    // new MappingMethodClass(clazz.getName(), m.getName()));
    // }
    // }
    // }
    // }
    // return results;
    // }
}