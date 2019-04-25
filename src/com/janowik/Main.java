/**
 * @author Jacek Nowak
 * @email jacek.nowak.jn@gmail.com
 * @tel. 534736980
 */
package com.janowik;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = null;
        String fromInput, fromFile;

        System.out.println("Wprowadź ścieżkę do pliku: ");
        String filePath = scanner.nextLine();

        try  {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            fromFile = bufferedReader.readLine();
            long start  = System.currentTimeMillis();
            while (fromFile != null){
                boolean result = false;
                do {
                    System.out.println(fromFile);
                    System.out.println("Wpisz poprawną formę: ");
                    fromInput = scanner.nextLine().trim();
                        if (fromInput.length() != fromFile.length()){
                            System.out.println("Zbyt krótki lub długi tekst.");
                        }
                        else
                            result = compareTwoLines(fromFile, fromInput);
                }while (!result);
                fromFile = bufferedReader.readLine();
            }
            long stop = System.currentTimeMillis();
            System.out.println(
                    "GRATULACJĘ! \tZadanie wykonano w czasie: " + (stop - start) / 1000 + "s");
        } catch (IOException e) {
            System.out.println("Niepoprawna ścieżka do pliku. \n" + e);
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            scanner.close();
        }
    }

    private static boolean compareTwoLines(String fromFile, String fromInput){
        int i;
        if (!fromFile.equals(fromInput)) {
            for (i = 0; i <= fromFile.length(); i++) {
                if (fromFile.charAt(i) != fromInput.charAt(i))
                    break;
            }
            System.out.println("Zły index na: " + (i + 1));
            return false;
        }
        return true;
    }
}
