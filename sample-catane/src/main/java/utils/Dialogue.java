package utils;

import java.io.*;
import java.util.Scanner;

public class Dialogue {
    
    private Scanner scanner = new Scanner(System.in);

    public Integer demandeEntier(InputStream in) {
        return scanner.nextInt();
    }

    public String demandeChaine(InputStream in) {
        return scanner.next();
    }
}
