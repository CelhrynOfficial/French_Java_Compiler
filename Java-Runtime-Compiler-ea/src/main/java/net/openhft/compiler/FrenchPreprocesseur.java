package net.openhft.compiler;

import java.util.HashMap;
import java.util.Map; 


// Préprocesseur java qui applique une couche de traduction sur les instructions en français
// Le premier babouche qui vient me voir pour me dire que le code est mauvais parce que le nom des variables est mal fait
// je le broie. C'est un compilateur java en français




public class FrenchPreprocesseur {

    private static final Map<String, String> dictionnaire = new HashMap<>();

    static{
        // Mappage des mots clés du français vers l'anglais
        dictionnaire.put('si', 'if');
        dictionnaire.put('sinon', 'else');
        dictionnaire.put('pour', 'for');
        dictionnaire.put('tantque', 'while');
        dictionnaire.put('retourner', 'return');
        dictionnaire.put('rien', 'void');
        dictionnaire.put('prive', 'private');
        dictionnaire.put('protege', 'protect');
        dictionnaire.put('statique', 'static');
        dictionnaire.put('entier', 'int');
        dictionnaire.put('flottant', 'float');
        dictionnaire.put('double', 'double');
        dictionnaire.put('booleen', 'boolean');
        dictionnaire.put('vrai', 'true');
        dictionnaire.put('faux', 'false');
        dictionnaire.put('nouveau', 'new');
        dictionnaire.put('nul', 'null');

    }

    // Méthode pour traduire un fichier .java
    public void traduireFichier(File fichierEntree, File fichierSortie) throws IOException {
        String contenu = new String(Files.readAllBytes(fichierEntree.toPath()));
        String contenuTraduit = traduire(contenu);
        Files.write(fichierSortie.toPath(), contenuTraduit.getBytes());
    }

    // Méthode qui traduit le contenu d'un fichier ou d'une chaîne de caractères
    public String traduire(String contenu) {
        for (Map.Entry<String, String> entry : traductions.entrySet()) {
            String motFrancais = entry.getKey();
            String motAnglais = entry.getValue();
            contenu = contenu.replaceAll("\\b" + motFrancais + "\\b", motAnglais);
        }
        return contenu;
    }

    // Exemple d'utilisation
    public static void main(String[] args) {
        FrenchPreprocesseur preprocesseur = new FrenchPreprocesseur();
        File fichierEntree = new File("chemin/vers/votre/fichier.java");
        File fichierSortie = new File("chemin/vers/fichier_traduit.java");

        try {
            preprocesseur.traduireFichier(fichierEntree, fichierSortie);
            System.out.println("Fichier traduit avec succès !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}