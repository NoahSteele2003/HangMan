import java.util.Scanner;

public class HangMan{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        String pickedPhrase;
        String hiddenPhrase;
        String pickedLetter;
        int position;


        System.out.println("Welcome to hangman! To play, one player types a phrase to use for the hangman.\nThen, the other player picks letters that may be in the phrase, and then they will be told if they are correct or not.\nKeep guessing letters until you guess the phrase or you run out of tries.\n");
        System.out.println("Player 1, type a phrase that will be used for the game of hangman.\n");
        pickedPhrase = keyboard.nextLine();

        hiddenPhrase = phraseToDash(pickedPhrase);

        System.out.println("Player 2, pick a letter that might be in the phrase.");
        pickedLetter = keyboard.nextLine();


        if(pickedPhrase.contains(pickedLetter)){
            while(pickedPhrase.contains(pickedLetter)){
                position = pickedPhrase.indexOf(pickedLetter);
                //System.out.println(position);
                hiddenPhrase = hiddenPhrase.substring(0,position)+pickedLetter+hiddenPhrase.substring(position+1,pickedPhrase.length());
                pickedPhrase = pickedPhrase.replaceFirst(pickedLetter," ");
            }
            System.out.println(hiddenPhrase);
        }



    }









    public static String phraseToDash(String inputPhrase){
        String hiddenPhrase = "";
        String[] phrases = inputPhrase.split(" ");
        for(int i=0;i<phrases.length;i++){
            for(int y=0;y<phrases[i].length();y++){
                hiddenPhrase = hiddenPhrase+"-";
            }
            hiddenPhrase = hiddenPhrase+" ";
        }
        System.out.println(hiddenPhrase);
        return hiddenPhrase;
    }

}


