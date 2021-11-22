package utils;

public class ConsoleJ {
    
    void print(String style, String chaine) {
        System.out.print(style + chaine + AnsiColors.ANSI_RESET);
    }

    void println(String style, String chaine) {
        System.out.println(style + chaine + AnsiColors.ANSI_RESET);
    }

}
