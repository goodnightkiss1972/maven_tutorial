package utils;

import java.util.Scanner;
import java.util.List;

public class DialogueJ {
    
    private Scanner scanner = new Scanner(System.in);
    private ConsoleJ console = new ConsoleJ();

    public Integer demandeEntier(String decoration, String question) {
        Boolean erreurDetectee;
        do {
            console.print(decoration, question + " ");
            try {
                erreurDetectee = false;
                return scanner.nextInt();    
            }
            catch (Exception e) {
                scanner.next();
                erreurDetectee = true;
                console.println(AnsiColors.ANSI_RED, "Entree incorrecte, veuillez essayer a nouveau svp...");
            }
        } while (erreurDetectee == true);
        return null;
    }

    public Integer demandeEntierPrecis(String decoration, String question, List<Integer> listeDeControle) {
        Boolean erreurDetectee;
        Integer saisie;
        do {
            console.print(decoration, question + listeDeControle + " ");
            try {
                erreurDetectee = false;
                saisie = scanner.nextInt();
                if (listeDeControle.contains(saisie)) {
                    return saisie;
                }
                else {
                    console.println(AnsiColors.ANSI_RED, "La saisie " + saisie + " n'est pas autorisee...");
                    erreurDetectee = true;
                }
            }
            catch (Exception e) {
                scanner.next();
                erreurDetectee = true;
                console.println(AnsiColors.ANSI_RED, "Entree incorrecte, veuillez essayer a nouveau svp...");
            }
        } while (erreurDetectee == true);
        return null;
    }

    public String demandeChaine(String decoration, String question) {
        Boolean erreurDetectee;
        do {
            console.print(decoration, question + " ");
            try {
                erreurDetectee = false;
                return scanner.next();   
            }
            catch (Exception e) {
                scanner.next();
                erreurDetectee = true;
                console.println(AnsiColors.ANSI_RED, "Entree incorrecte, veuillez essayer a nouveau svp...");
            }
        } while (erreurDetectee == true);
        return null;
    }

    public String demandeChainePrecise(String decoration, String question, List<String> listeDeControle) {
        Boolean erreurDetectee;
        String saisie;
        do {
            console.print(decoration, question + listeDeControle + " ");
            try {
                erreurDetectee = false;
                saisie = scanner.next();
                if (listeDeControle.contains(saisie)) {
                    return saisie;
                }
                else {
                    console.println(AnsiColors.ANSI_RED, "La saisie " + saisie + " n'est pas autorisee...");
                    erreurDetectee = true;
                }
            }
            catch (Exception e) {
                scanner.next();
                erreurDetectee = true;
                console.println(AnsiColors.ANSI_RED, "Entree incorrecte, veuillez essayer a nouveau svp...");
            }
        } while (erreurDetectee == true);
        return null;
    }

    public void demandeUneTouche() {
        console.println(AnsiColors.ANSI_PURPLE, "Veuillez appuyer sur ENTREE");
        scanner.nextLine();
    }
}
