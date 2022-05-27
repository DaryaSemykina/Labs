package com.company;

import java.io.IOException;


class Rush {
    public static void main(String[] args) throws Exception  {


        int password = 35;
        String contentOfFile = Encryption.readFile();

        System.out.println(contentOfFile);

       String myNewСontentOfFile= Encryption.selectAlphabet(contentOfFile, password);
       Encryption.showNewPassword(myNewСontentOfFile);
       Encryption.newFile(myNewСontentOfFile);
//        String myFirstСontentOfFile = Encryption.unEncryptionFile(myNewСontentOfFile, password);
//        Encryption.showNewPassword(myFirstСontentOfFile);
    }

}
//        int stroka = 3;
//        int stolb = 4;
//        int[][] mat1 = MatrixCalculator.doMat(stroka, stolb);
//        int[][] mat2 = MatrixCalculator.doMat(stroka, stolb);
//        int[][] mat3 = MatrixCalculator.calcSumMat(mat1, mat2);
//        MatrixCalculator.showMat(mat1);
//        MatrixCalculator.showMat(mat2);
//        MatrixCalculator.showMat(mat3);









