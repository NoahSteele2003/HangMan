import java.util.Scanner;

public class HangMan{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        String pickedPhrase;
        String hiddenPhrase;
        String pickedLetter;
        int position, tries;
        tries = 15;


        System.out.println("Welcome to hangman! To play, one player types a phrase to use for the hangman.\nThen, the other player picks letters that may be in the phrase, and then they will be told if they are correct or not.\nKeep guessing letters until you guess the phrase or you run out of tries.\n");
        System.out.println("Player 1, type a phrase that will be used for the game of hangman.\n");
        pickedPhrase = keyboard.nextLine().toLowerCase();

        hiddenPhrase = phraseToDash(pickedPhrase);

        for(int x=0;x<15;x++) {
            if(!hiddenPhrase.contains("-")){
                System.out.println("You guessed the phrase! You win!");
                break;
            }
            System.out.println(tries+" tries left");
            System.out.println("\nPlayer 2, pick a letter that might be in the phrase.");
            pickedLetter = keyboard.nextLine().toLowerCase();
            if (pickedPhrase.contains(pickedLetter)) {
                x--;
                while (pickedPhrase.contains(pickedLetter)) {
                    position = pickedPhrase.indexOf(pickedLetter);
                    //System.out.println(position);
                    hiddenPhrase = hiddenPhrase.substring(0, position) + pickedLetter + hiddenPhrase.substring(position + 1, pickedPhrase.length());
                    pickedPhrase = pickedPhrase.replaceFirst(pickedLetter, " ");
                }
                System.out.println(hiddenPhrase);
            }
            else if(!pickedPhrase.contains(pickedLetter)&&x<14){
                System.out.println("Sorry, try a different letter.\n");
                System.out.println(hiddenPhrase);
                tries--;
            }
            if(x==14){
                System.out.println("Sorry, you ran out of tries, the correct phrase was \""+pickedPhrase+"\"");
            }
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


