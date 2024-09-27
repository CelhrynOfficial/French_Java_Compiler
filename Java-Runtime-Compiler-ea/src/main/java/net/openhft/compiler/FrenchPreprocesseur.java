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

    public String traduire(String codeFrancais){
        String[] tokens = codeFrancais.split("\\s+");
        StringBuilder codeAnglais = new StringBuilder();

        for (String token : tokens){
            String motTraduit = dictionnaire.getOrDefault(token, token); // On garde le mot original si non-traduit
            codeAnglais.append(motTraduit).append(" ");
        }

        return codeAnglais.toString().trim();

    }

    public static void main(String[] args) {
        FrenchPreprocessor preprocesseur = new FrenchPreprocessor();

        // Exemple de code en Français 
        String codeFrancais = "publique classe Exemple {publique rien methode() {si (vrai) {retourner; } sinon {retourner ; } } }";

        // Traduction du code 
        String codeAnglais = preprocesseur.traduction(codeFrancais);
        
        // Affichage du code traduit
        System.out.println("Code en anglais : ");
        System.out.println(codeAnglais);

    }


}