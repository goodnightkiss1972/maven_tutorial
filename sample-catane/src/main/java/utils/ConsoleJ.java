package utils;

public class ConsoleJ {
    
    void print(String style, String chaine) {
        if (style == null) {
            System.out.print(chaine);    
        } else {
            System.out.print(style + chaine + AnsiColors.ANSI_RESET);
        }
    }

    void println(String style, String chaine) {
        if (style == null) {
            System.out.println(chaine);    
        } else {
            System.out.println(style + chaine + AnsiColors.ANSI_RESET);
        }
    }

    void aLaLigne() {
        System.out.println();
    }

}
