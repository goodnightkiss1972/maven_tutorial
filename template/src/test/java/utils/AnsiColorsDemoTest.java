package utils;

import org.junit.jupiter.api.Test;

public class AnsiColorsDemoTest {

    @Test
    public void testTermCol() {
        System.out.println(AnsiColors.ANSI_GREEN_BACKGROUND + "This text has a green background but default text!"
                + AnsiColors.ANSI_RESET);
        System.out.println(
                AnsiColors.ANSI_RED + "This text has red text but a default background!" + AnsiColors.ANSI_RESET);
        System.out.println(AnsiColors.ANSI_GREEN_BACKGROUND + AnsiColors.ANSI_RED
                + "This text has a green background and red text!" + AnsiColors.ANSI_RESET);

        // Bleu & inverse
        System.out.println(AnsiColors.ANSI_BLUE + "Bleu" + AnsiColors.ANSI_RESET);
        System.out.println(
                AnsiColors.ANSI_BLUE_BACKGROUND + AnsiColors.ANSI_BLACK + "Bleu Inverse" + AnsiColors.ANSI_RESET);

        // Blanc & inverse
        System.out.println(AnsiColors.ANSI_WHITE + "Blanc" + AnsiColors.ANSI_RESET);
        System.out.println(
                AnsiColors.ANSI_WHITE_BACKGROUND + AnsiColors.ANSI_BLACK + "Blanc Inverse" + AnsiColors.ANSI_RESET);

        // Rouge & inverse
        System.out.println(AnsiColors.ANSI_RED + "Rouge" + AnsiColors.ANSI_RESET);
        System.out.println(
                AnsiColors.ANSI_RED_BACKGROUND + AnsiColors.ANSI_BLACK + "Rouge Inverse" + AnsiColors.ANSI_RESET);

        // Vert & inverse
        System.out.println(AnsiColors.ANSI_GREEN + "Vert" + AnsiColors.ANSI_RESET);
        System.out.println(
                AnsiColors.ANSI_GREEN_BACKGROUND + AnsiColors.ANSI_BLACK + "Vert Inverse" + AnsiColors.ANSI_RESET);

    }
}
