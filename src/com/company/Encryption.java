package com.company;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.*;

public class Encryption {

    public static String readFile() throws IOException {
        String fileName = "F:\\Учёба\\Программирование\\HomeWork\\input.txt";
        Scanner sc = new Scanner(new File(fileName));
        String contentOfFileE = sc.nextLine();
        sc.close();
        return contentOfFileE;
    }

    public static String encryptionFileCyrillic(char a, int b) {
        String newcontentOfFileE = "";

        int letter = (int) a;

        char newLetter ;

        if (letter == 1072) {
            int newNum = letter + b % 32;
            newLetter = (char) (newNum);
            newcontentOfFileE += newLetter;
        } else if (letter >= 1073 && letter <= 1103) {
            int newNum = letter + (b % 32);
            if (newNum > 1103) {
                newLetter = (char) (1072 + ((newNum % 1103) - 1));
                newcontentOfFileE += newLetter;
            } else {
                newLetter = (char) newNum;
                newcontentOfFileE += newLetter;
            }
        }

        return newcontentOfFileE;
    }

    public static String encryptionFileLatin(char a, int b) {
        String newcontentOfFileE = "";
        int letter = (int) a;

        char newLetter;

        if (letter == 97) {
            int newNum = letter + b % 25;
            newLetter = (char) (newNum);
            newcontentOfFileE += newLetter;
        } else if (letter >= 98 && letter <= 122) {
            int newNum = letter + (b % 25);
            if (newNum > 122) {
                newLetter = (char) (97 + ((newNum % 122) - 1));
                newcontentOfFileE += newLetter;
            } else {
                newLetter = (char) newNum;
                newcontentOfFileE += newLetter;
            }
        }

        return newcontentOfFileE;
    }

    public static String encryptionFileNumbers(char a, int b) {
        String newcontentOfFileE = "";
        int letter = (int) a;

        char newLetter;
        if (letter == 48) {
            int newNum = letter + b % 10;
            newLetter = (char) (newNum);
            newcontentOfFileE += newLetter;
        } else if (letter >= 49 && letter <= 57) {
            int newNum = letter + (b % 10);
            if (newNum > 57) {
                newLetter = (char) (48 + ((newNum % 57) - 1));
                newcontentOfFileE += newLetter;
            } else {
                newLetter = (char) newNum;
                newcontentOfFileE += newLetter;

            }
        }
        return newcontentOfFileE;
    }

    public static String selectAlphabet(String a, int b) {
        String newcontentOfFileE = "";

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);

            int letter = (int) a.charAt(i);
            if (letter == 32) {
                char newLetter = (char) letter;
                newcontentOfFileE += newLetter;
            } else if (letter >= 1072 && letter <= 1103) {
                newcontentOfFileE += encryptionFileCyrillic(c, b);
            } else if (letter >= 97 && letter <= 122) {
                newcontentOfFileE += encryptionFileLatin(c, b);
            } else if (letter >= 48 && letter <= 57) {
                newcontentOfFileE += encryptionFileNumbers(c, b);
            }
        }
        return newcontentOfFileE;
    }

    public static void newFile(String r) throws Exception {
        FileWriter nFile = new FileWriter("input.txt");
        nFile.write(r);
        nFile.close();
    }


    public static String unEncryptionFile(String a, int b) {
        String firstContentOfFile = "";
        for (int i = 0; i < a.length(); i++) {
            int letter = (int) a.charAt(i);
            if (letter == 32) {
                char newLetter = (char) letter;
                firstContentOfFile += newLetter;
            } else if (letter == 1103) {
                int newNum = letter - b % 32;
                char newLetter = (char) (newNum);
                firstContentOfFile += newLetter;
            } else if (letter >= 1072 && letter <= 1102) {
                int newNum = letter - (b % 32);
                if (newNum < 1072) {
                    char newLetter = (char) (1103 - ((1072 % newNum) - 1));
                    firstContentOfFile += newLetter;
                } else {
                    char newLetter = (char) newNum;
                    firstContentOfFile += newLetter;
                }
            }

        }
        return firstContentOfFile;
    }

    public static void showNewPassword(String w) {
        System.out.println(w);
    }
}
