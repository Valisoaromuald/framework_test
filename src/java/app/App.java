package app;

import utilitaire.ClasseUtilitaire;
import utilitaire.MappingMethodClass;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import annotation.Controleur;
import annotation.UrlMapping;

public class App {
    public static List<String> findAllPathClassFiles(File rootDir, String packageName) throws ClassNotFoundException {
        List<String> classes = new ArrayList<>();
        for (File file : rootDir.listFiles()) {
            if (file.isDirectory()) {
                if (!file.getName().trim().equals(".git")) {
                    String subPackage = packageName.isEmpty() ? file.getName() : packageName + "." + file.getName();
                    classes.addAll(findAllPathClassFiles(file, subPackage));
                }
            } else if (file.getName().endsWith(".class")) {
                String pathClassFile = packageName.isEmpty()
                        ? file.getName().replace(".class", "")
                        : packageName + "." + file.getName().replace(".class", "");
                classes.add(pathClassFile);
            }
        }
        return classes;
    }

    public static Class<?> createClass(String name) throws Exception {
        String[] sousChemin = name.split("\\.");
        int cpt = sousChemin.length - 1;
        String realClassName = "";
        Class<?> classe = null;
        while (cpt >= 0) {
            if (cpt == sousChemin.length - 1) {
                realClassName = sousChemin[cpt];
            } else {
                realClassName = sousChemin[cpt] + "." + realClassName;
            }
            try {
                classe = Class.forName(realClassName);
                if (classe != null) {
                    break;
                }
            } catch (ClassNotFoundException e) {
            }
            cpt--;
        }
        return classe;
    }

    public static void main(String[] args) throws Exception {
    File root = new File(System.getProperty("user.dir")); // adapte ce chemin
    System.out.println("\n=== Classes trouvées ===");
    try {
        Map<String,MappingMethodClass> results = ClasseUtilitaire.generateUrlsWithMappedMethodClass(root);
        Map.Entry<String, MappingMethodClass> entry = ClasseUtilitaire.getRelevantMethodAndClassNames(results, root, "/informatique");
            System.out.println(entry.getKey()+":"+(entry.getValue()).getClassName()+" ; "+(entry.getValue()).getMethodName());
        
        //  List<String> methodAndClassNames = getMappingClassAndMethodByUrl(root, "");
        // System.out.println(methodAndClassNames.get(0)+" ; "+methodAndClassNames.get(1));
        } catch (Exception e) {
            System.out.println("erreur: "+e.getMessage());
        }
    }

    public static Map<String, Object> getUrlWithMappingMethodClass(File file) throws Exception {
        Map<String, Object> results = new HashMap<String, Object>();
        System.out.println("nom de dosier: "+file.getAbsolutePath());
        List<String> classNames = ClasseUtilitaire.findAllClassNames(file, "");
        for (String className : classNames) {
            Class<?> clazz = createClass(className);
            System.out.println("nom de classe: "+clazz.getName()+" misy annotation ve: "+clazz.isAnnotationPresent(Controleur.class));
            if (clazz.isAnnotationPresent(Controleur.class)) {
                Method[] methodes = clazz.getDeclaredMethods();
                for (Method m : methodes) {
                    if (m.isAnnotationPresent(UrlMapping.class)) {
                        results.put(m.getAnnotation(UrlMapping.class).url(),
                                new MappingMethodClass(clazz.getName(), m.getName()));
                    }
                }
            }
        }
        return results;
    }
    public static List<String> getMappingClassAndMethodByUrl(File root, String url) throws Exception {
        List<String> classes = ClasseUtilitaire.findAllClassNames(root, "");
        System.out.println(classes.size());
        List<String> results =  new ArrayList<String>();
        try {
            for (String pathClassFile : classes) {
                Class<?> clazz = createClass(pathClassFile);
                System.out.println("nom de classe: "+clazz.getName()+" misy annotation ve: "+clazz.isAnnotationPresent(Controleur.class));
                if (clazz.isAnnotationPresent(Controleur.class)) {
                    Method[] methodes = clazz.getDeclaredMethods();
                    for (Method m : methodes) {
                        UrlMapping urlAnnotation = m.getAnnotation(UrlMapping.class);
                            if (m.isAnnotationPresent(UrlMapping.class)) {
                                results.add(clazz.getName());
                                results.add(m.getName());
                                break;
                            }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("erreur : "+e.getMessage());
        }
        return results;
    }
}