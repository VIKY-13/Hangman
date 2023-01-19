import java.beans.VetoableChangeListenerProxy;
import java.security.KeyStore.LoadStoreParameter;
import java.util.Random;
import java.util.Scanner;

import javax.tools.DocumentationTool.Location;

import org.w3c.dom.TypeInfo;

public class Hangman {
    static int location;
    public static void main(String[] args) {
        String missedWords = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome player. Let's start?");
        String randWord = randomWord();
        char[] gWord = new char[randWord.length()];
        for (int i = 0; i < randWord.length() ; i++){
            gWord[i]='_';
        }
        System.out.println(randWord);
        int count = 0;
        while(count< 6){
            System.out.println(printGallows(count)); 
            printPlaceholders(gWord);
            System.out.print("Misses:  ");
            System.out.print(missedWords+"\n"+"\n");
            System.out.print("Guess:   ");
            char guessedWord = scan.next().charAt(0);
            System.out.println("\n");
            if(checkGuess(randWord,guessedWord,gWord)){
            upadtePlaceHolders(guessedWord,location,gWord);}
            else{
                missedWords += guessedWord;
                count++;
            }
            if (checkEqual(gWord,randWord)){
                System.out.println(printGallows(count)); 
                System.out.println("Word : "+randWord);
                System.out.println("WELL DONE!");
                return;
            }
        }
        System.out.println(printGallows(count)); 
        System.out.println("RIP!");
        System.out.println("Word : "+randWord);        
    }


    public static boolean checkEqual(char[] gWord, String randWord){
        for (int i = 0; i<randWord.length(); i++){
            if (gWord[i]!= randWord.charAt(i)){
                return false;
            }
        }
        return true;
    }



    public static void upadtePlaceHolders(char guessedWord, int location,char[] gWord){
        gWord[location]= guessedWord;
    }



    public static boolean checkGuess(String randword, char guessedWord,char[] gWord){
        for (int i = 0 ; i < randword.length() ; i++){
            if (randword.charAt(i) == guessedWord && gWord[i] == '_'){
                location = i;
                return true;
            }
        }
        return false;
    }



    public static String randomWord(){
        String[] words = {"ant", "baboon", "badger", "bat", "bear","beaver", "camel", "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer", "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat", "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose", "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal", "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan", "tiger", "toad", "trout", "turkey","turtle", "weasel", "whale", "wolf", "wombat", "zebra"};
        int num = (int) (Math.random()*65);
        return words[num];
    }



    public static void printPlaceholders(char[] gWord){
        System.out.print("Word:   ");
        
        for (int i = 0; i < gWord.length ; i++){
            System.out.print(gWord[i]);
        }
        System.out.println("\n");
    }



    public static String printGallows(int count){
        String[] gallows = {
            "+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +   //if the user didn't miss any guesses.
            "    |\n" +
            "    |\n" +
            "=========\n",
        
            "+---+\n" +
            "|   |\n" +
            "O   |\n" +   //if the user missed one guess.
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",
        
            "+---+\n" +
            "|   |\n" +
            "O   |\n" +    //if the user missed two guesses.
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",
        
            " +---+\n" +
            " |   |\n" +
            " O   |\n" +   //if the user missed three guesses.
            "/|   |\n" +
            "     |\n" +
            "     |\n" +
            " =========\n",
        
            " +---+\n" +
            " |   |\n" +
            " O   |\n" +
            "/|\\  |\n"+   //if the user missed four guesses.
            "     |\n" +
            "     |\n" +
            " =========\n",
        
            " +---+\n" +
            " |   |\n" +
            " O   |\n" +
            "/|\\  |\n" +  //if the user missed five guesses.
            "/    |\n" +
            "     |\n" +
            " =========\n",
        
            " +---+\n" +
            " |   |\n" +
            " O   |\n" +
            "/|\\  |\n" +   //if the user missed six guesses.
            "/ \\  |\n" +
            "     |\n" +
            " =========\n"};
            switch(count){
                case 0 : return gallows[0];
                case 1 : return gallows[1];
                case 2 : return gallows[2];
                case 3 : return gallows[3];
                case 4 : return gallows[4];
                case 5 : return gallows[5];
                case 6 : return gallows[6];
                default : return "invalid";
            }
    }

    
}
