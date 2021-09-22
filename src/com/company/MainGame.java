package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public class MainGame {

    public static String langEvent(){
        //creacion scanner
        Scanner input = new Scanner(System.in);
        String idioma;
        String direccion;

        System.out.println("English / Español");

        while (true) {
            idioma = (input.next()).toLowerCase();
            if (idioma.equals("english") || idioma.equals("español")){
                if (idioma.equals("english")){
                    direccion = "src/com/company/words/engWords.txt";
                } else {
                    direccion = "src/com/company/words/espWords.txt";
                }
                break;
            } else {
                System.out.println("Try again / Intenta otra vez");
            }
        }
        return direccion;
    }

    public static String readerEvent(String str){
        BufferedReader br;

        String line;
        String result = "";

        try {
            br = new BufferedReader(new FileReader(str));

            while ((line = br.readLine()) != null) {
                result = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String randomWord(String str){
        Random rand = new Random();

        String[] allWord = str.split(" - ");

        return allWord[rand.nextInt(allWord.length)];
    }

    public static char[] compEmptyWord(String pal){
        //new Variables
        int palLenght = pal.length();
        char[] emptyWrd = new char[palLenght];

        //complete emptyWrd
        for (int i = 0; i < palLenght; i++) {
            emptyWrd[i] = '-';
        }
        return emptyWrd;
    }

    public static boolean theGame(String pal, char[] emptyWrd, int vidas){
        Scanner input = new Scanner(System.in);

        int vidActual = vidas;

        boolean resolved = false;
        boolean hasLetter = false;

        char[] actualString = pal.toCharArray();

        String str;

        while ((vidActual > 0) && (!resolved)) {
            //actualizar string
            str = new String(emptyWrd);

            //Mostrar estado actual
            System.out.print("Por el momento vas así: " + str);
            System.out.println(" "); //linead

            //Pedir letra
            System.out.println("Que letra queres intentar??");
            char currentLetter = input.next().charAt(0);

            //checkear por letra
            for (int i = 0; i < pal.length(); i++) {
                if (pal.charAt(i) == currentLetter) {
                    emptyWrd[i] = currentLetter;
                    hasLetter = true;
                }
            }

            //restar vida solo si no tiene letra
            if (!hasLetter) {
                vidActual--;
                System.out.println("Uuuy cagaste, perdiste una vida y ahora tenes: " + vidActual);
            }

            hasLetter = false;

            //revisar si esta resuelto
            if (Arrays.equals(actualString,emptyWrd)){
                resolved = true;
            }
        }

        return resolved;
    }
}
