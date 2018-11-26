import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String pickedPhrase;
        String originalPhrase;
        String hiddenPhrase;
        String pickedLetter;
        String usedLetters;
        String response;
        String pickedPhrase2;
        int guesses;
        usedLetters = "";
        int position, tries, wrongGuesses;
        position = 0;
        tries = 15;
        wrongGuesses = 0;


        printALine("Welcome to hangman! To play, one player types a phrase to use for the hangman.\nThen, the other player picks letters that may be in the phrase, and then they will be told if they are correct or not.\nKeep guessing letters until you guess the phrase or you run out of tries.\n");
        System.out.println("Player 1, type a phrase that will be used for the game of hangman.");
        pickedPhrase = keyboard.nextLine().toLowerCase();
        originalPhrase = pickedPhrase;

        hiddenPhrase = phraseToDash(pickedPhrase);

        do {
            guesses =0;
            wrongGuesses=0;
            tries=15;
            for (int x = 0; x < 15; x++) {
                //System.out.println(guesses);
                //System.out.println(originalPhrase.length());
                if (hiddenPhrase.contains("-")) {
                    printALine("Your used letters are: " + usedLetters);
                }
                if (!hiddenPhrase.contains("-")) {
                    System.out.println("You guessed the phrase! You win!");
                    break;
                }
                showHangman(wrongGuesses);
                System.out.println(tries + " tries left");
                randomPhrases(guesses, originalPhrase);
                System.out.println("\nPlayer 2, pick a letter that might be in the phrase.");
                pickedLetter = keyboard.nextLine().toLowerCase();
                usedLetters += pickedLetter + ", ";
                if (pickedPhrase.contains(pickedLetter)) {
                    guesses++;
                    x--;
                    while (pickedPhrase.contains(pickedLetter)) {
                        hiddenPhrase = checkForLetter(pickedPhrase, pickedLetter, hiddenPhrase, position);
                        pickedPhrase = pickedPhrase.replaceFirst(pickedLetter, " ");
                    }
                    System.out.println(hiddenPhrase);
                } else if (!pickedPhrase.contains(pickedLetter) && x < 14) {
                    System.out.println("Sorry, try a different letter.\n");
                    System.out.println(hiddenPhrase);
                    wrongGuesses++;
                    tries--;
                }
                if (x == 14) {
                    showHangman(15);
                    System.out.println("Sorry, you ran out of tries, the correct phrase was \"" + originalPhrase + "\"");
                }
            }
            printALine("\nWould you like to play again?(yes or no)");
            response = keyboard.next();
            if (response.equals("yes")) {
                System.out.println("\nPlayer 1, type a phrase that will be used for the game of hangman.");
                pickedPhrase = keyboard.nextLine().toLowerCase();
                pickedPhrase = keyboard.nextLine().toLowerCase();
                originalPhrase = pickedPhrase;
                hiddenPhrase = phraseToDash(pickedPhrase);
                usedLetters = "";
            }
        } while (response.equals("yes"));

        printALine("\nThanks for playing!");


    }


    public static String phraseToDash(String inputPhrase) {
        String hiddenPhrase = "";
        String[] phrases = inputPhrase.split(" ");
        for (int i = 0; i < phrases.length; i++) {
            for (int y = 0; y < phrases[i].length(); y++) {
                hiddenPhrase = hiddenPhrase + "-";
            }
            hiddenPhrase = hiddenPhrase + " ";
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + hiddenPhrase);
        return hiddenPhrase;
    }

    public static void printALine(String inputPhrase) {
        System.out.println(inputPhrase);
    }

    public static String checkForLetter(String pickedPhrase, String pickedLetter, String hiddenPhrase, int position) {
        position = pickedPhrase.indexOf(pickedLetter);
        hiddenPhrase = hiddenPhrase.substring(0, position) + pickedLetter + hiddenPhrase.substring(position + 1, pickedPhrase.length());
        return hiddenPhrase;
    }

    public static void showHangman(int numberWrong) {
        String[] hangman15 = new String[16];
        hangman15[0] = "-----------\n     |    |\n          |\n          |\n          |\n          |\n          |\n-----------";
        hangman15[1] = "-----------\n     |    |\n     0    |\n          |\n          |\n          |\n          |\n-----------";
        hangman15[2] = "-----------\n     |    |\n     0    |\n     |    |\n          |\n          |\n          |\n-----------";
        hangman15[3] = "-----------\n     |    |\n     0    |\n    -|    |\n          |\n          |\n          |\n-----------";
        hangman15[4] = "-----------\n     |    |\n     0    |\n    -|-   |\n          |\n          |\n          |\n-----------";
        hangman15[5] = "-----------\n     |    |\n     0    |\n   --|-   |\n          |\n          |\n          |\n-----------";
        hangman15[6] = "-----------\n     |    |\n     0    |\n   --|--  |\n          |\n          |\n          |\n-----------";
        hangman15[7] = "-----------\n     |    |\n     0    |\n  ---|--  |\n          |\n          |\n          |\n-----------";
        hangman15[8] = "-----------\n     |    |\n     0    |\n  ---|--- |\n          |\n          |\n          |\n-----------";
        hangman15[9] = "-----------\n     |    |\n     0    |\n  ---|--- |\n     |    |\n          |\n          |\n-----------";
        hangman15[10] = "-----------\n     |    |\n     0    |\n  ---|--- |\n     |    |\n    /     |\n          |\n-----------";
        hangman15[11] = "-----------\n     |    |\n     0    |\n  ---|--- |\n     |    |\n    / \\   |\n          |\n-----------";
        hangman15[12] = "-----------\n     |    |\n     0    |\n  ---|--- |\n     |    |\n    / \\   |\n   /      |\n-----------";
        hangman15[13] = "-----------\n     |    |\n     0    |\n  ---|--- |\n     |    |\n    / \\   |\n   /   \\  |\n-----------";
        hangman15[14] = "-----------\n     |    |\n     0    |\n  ---|--- |\n     |    |\n    / \\   |\n  _/   \\  |\n-----------";
        hangman15[15] = "-----------\n     |    |\n     0    |\n  ---|--- |\n     |    |\n    / \\   |\n  _/   \\_ |\n-----------";

        printALine(hangman15[numberWrong]);
    }

    public static void randomPhrases(int guesses, String originalPhrase) {
        guesses = guesses*2;
        if (guesses == originalPhrase.length() / 2) {
            printALine("You are halfway there.");
        }
        else if(guesses == originalPhrase.length()-1){
            printALine("Only a few more letters.");
        }
    }
}

    //15 tries
    //-----------
    //     |    |
    //     0    |
    //  ---|--- |
    //     |    |
    //    / \   |
    //  _/   \_ |
    //-----------


//10 tries
//-----------
//     |    |
//     0    |
//   --|--  |
//   _/ \_  |


// 20 tries
//-----------
//     |    |
//     0    |
// ----|----|
//     |    |
//     |    |
//    / \   |
//   /   \  |
// _/     \_|






