package enums;

import utils.AnsiColors;

public enum Couleur {
    BLEU(AnsiColors.ANSI_BLUE, AnsiColors.ANSI_BLUE_BACKGROUND + AnsiColors.ANSI_BLACK), 
    BLANC(AnsiColors.ANSI_WHITE, AnsiColors.ANSI_WHITE_BACKGROUND + AnsiColors.ANSI_BLACK), 
    ROUGE(AnsiColors.ANSI_RED, AnsiColors.ANSI_RED_BACKGROUND + AnsiColors.ANSI_BLACK), 
    VERT(AnsiColors.ANSI_GREEN, AnsiColors.ANSI_GREEN_BACKGROUND + AnsiColors.ANSI_BLACK),
    MAUVE(AnsiColors.ANSI_PURPLE, AnsiColors.ANSI_PURPLE_BACKGROUND + AnsiColors.ANSI_BLACK),
    JAUNE(AnsiColors.ANSI_YELLOW, AnsiColors.ANSI_YELLOW_BACKGROUND + AnsiColors.ANSI_BLACK);

    private String stylo;
    private String marqueur;  
      
    private Couleur(String stylo, String marqueur) {  
        this.stylo = stylo;
        this.marqueur = marqueur;  
    }  
      
    public String getStylo() {  
        return this.stylo ;  
    }  

    public String getMarqueur() {
        return this.marqueur;
    }

}
