package utils;

public class ConsoleJ {
    
    public void print(String style, String chaine) {
        if (style == null) {
            System.out.print(chaine);    
        } else {
            System.out.print(style + chaine + AnsiColors.ANSI_RESET);
        }
    }

    public void println(String style, String chaine) {
        if (style == null) {
            System.out.println(chaine);    
        } else {
            System.out.println(style + chaine + AnsiColors.ANSI_RESET);
        }
    }

    public void aLaLigne() {
        System.out.println();
    }

    public void effaceTout() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void printNombreEntier99(String style, Integer nombre) {
        this.print(style, nombre + "" + AnsiColors.ANSI_RESET);
        if (nombre >= 0 && nombre < 10) {
            this.print(style, " " + AnsiColors.ANSI_RESET);
        }
        if (nombre < 0 || nombre >= 100) {
            throw new IllegalArgumentException("Cette methode ne peut afficher qu'entre 0 et 99");
        }
    }

    public String nombreEntier99(String style, Integer nombre) {
        if (nombre >= 0 && nombre < 10) {
            return style + nombre + " " + AnsiColors.ANSI_RESET;
        }
        return nombre + AnsiColors.ANSI_RESET;
    }

}
