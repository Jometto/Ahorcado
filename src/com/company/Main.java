package com.company;

public class Main {

    public static void main(String[] args) {
        //variables
        final int VIDAS = 5;
        String direction;

        //Seleccionar archivo

        direction = MainGame.langEvent();

        //Leer Archivos
        String words = MainGame.readerEvent(direction);

        //Seleccion de palabras
        String wordInUse = MainGame.randomWord(words);

        //creacion EmptyWord
        char[] emptyWord = MainGame.compEmptyWord(wordInUse);

        //game
        if (MainGame.theGame(wordInUse,emptyWord,VIDAS)){
            System.out.println("Bien, ganaste");
        } else {
            System.out.println("omae wa mo shinderu!");
        }
        System.out.println("(La palabra era: " + wordInUse + ")");
    }
}
