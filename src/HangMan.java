import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String pickedPhrase, originalPhrase, hiddenPhrase, pickedLetter, usedLetters, response;
        usedLetters = "";
        int position, tries, wrongGuesses, guesses, difficulty, difficultyNumber;
        difficultyNumber=0;
        difficulty = 0;

    //Introduction to game
        printALine("Welcome to hangman! To play, one player types a phrase to use for the hangman.\nThen, the other player picks letters that may be in the phrase, and then they will be told if they are correct or not.\nKeep guessing letters until you guess the phrase or you run out of tries.\n");
        System.out.println("Player 1, type a phrase that will be used for the game of hangman.");
        pickedPhrase = keyboard.nextLine().toLowerCase();
        originalPhrase = pickedPhrase;

    //Start of game
        do {
            printALine("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            difficulty = chooseDifficulty();
            difficultyNumber=pickDifficultyNumber(difficulty);
            hiddenPhrase = phraseToDash(pickedPhrase);
            guesses =0;
            position = 0;
            wrongGuesses=0;
            tries = difficultyNumber;
            for (int x = 0; x < difficultyNumber; x++) {
    //hangman setup
                if (hiddenPhrase.contains("-")) {
                    printALine("Your used letters are: " + usedLetters);
                }
                if (!hiddenPhrase.contains("-")) {
                    System.out.println("You guessed the phrase! You win!");
                    break;
                }
                showHangman(wrongGuesses,difficulty);
                System.out.println(tries + " tries left");

    //Game play
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
                } else if (!pickedPhrase.contains(pickedLetter) && x < difficultyNumber-1) {
                    System.out.println("Sorry, try a different letter.\n");
                    System.out.println(hiddenPhrase);
                    wrongGuesses++;
                    tries--;
                }
                if (x == difficultyNumber-1) {
                    showHangman(difficultyNumber,difficulty);
                    System.out.println("Sorry, you ran out of tries, the correct phrase was \"" + originalPhrase + "\"");
                }
            }

    //Option to restart
            printALine("\nWould you like to play again?(yes or no)");
            response = keyboard.next();
            if (response.equals("yes")) {
                System.out.println("\nPlayer 1, type a phrase that will be used for the game of hangman.");
                pickedPhrase = keyboard.nextLine().toLowerCase();
                pickedPhrase = keyboard.nextLine().toLowerCase();
                originalPhrase = pickedPhrase;
                usedLetters = "";
            }
        } while (response.equals("yes"));

        printALine("\nThanks for playing!");


    }

//Methods
    public static String phraseToDash(String inputPhrase) {
        String hiddenPhrase = "";
        String[] phrases = inputPhrase.split(" ");
        for (int i = 0; i < phrases.length; i++) {
            for (int y = 0; y < phrases[i].length(); y++) {
                hiddenPhrase = hiddenPhrase + "-";
            }
            hiddenPhrase = hiddenPhrase + " ";
        }
        System.out.println(hiddenPhrase);
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

    public static void showHangman(int numberWrong, int difficulty) {
        if(difficulty==1){
            String[] hangman20 = new String[21];
            hangman20[0] = "-----------\n     |    |\n          |\n          |\n          |\n          |\n          |\n          |\n          |\n-----------";
            hangman20[1] = "-----------\n     |    |\n     0    |\n          |\n          |\n          |\n          |\n          |\n          |\n-----------";
            hangman20[2] = "-----------\n     |    |\n     0    |\n     |    |\n          |\n          |\n          |\n          |\n          |\n-----------";
            hangman20[3] = "-----------\n     |    |\n     0    |\n    -|    |\n          |\n          |\n          |\n          |\n          |\n-----------";
            hangman20[4] = "-----------\n     |    |\n     0    |\n    -|-   |\n          |\n          |\n          |\n          |\n          |\n-----------";
            hangman20[5] = "-----------\n     |    |\n     0    |\n   --|-   |\n          |\n          |\n          |\n          |\n          |\n-----------";
            hangman20[6] = "-----------\n     |    |\n     0    |\n   --|--  |\n          |\n          |\n          |\n          |\n          |\n-----------";
            hangman20[7] = "-----------\n     |    |\n     0    |\n  ---|--  |\n          |\n          |\n          |\n          |\n          |\n-----------";
            hangman20[8] = "-----------\n     |    |\n     0    |\n  ---|--- |\n          |\n          |\n          |\n          |\n          |\n-----------";
            hangman20[9] = "-----------\n     |    |\n     0    |\n ----|--- |\n          |\n          |\n          |\n          |\n          |\n-----------";
            hangman20[10]= "-----------\n     |    |\n     0    |\n ----|----|\n          |\n          |\n          |\n          |\n          |\n-----------";
            hangman20[11]= "-----------\n     |    |\n     0    |\n ----|----|\n     |    |\n          |\n          |\n          |\n          |\n-----------";
            hangman20[12]= "-----------\n     |    |\n     0    |\n ----|----|\n     |    |\n     |    |\n          |\n          |\n          |\n-----------";
            hangman20[13]= "-----------\n     |    |\n     0    |\n ----|----|\n     |    |\n     |    |\n    /     |\n          |\n          |\n-----------";
            hangman20[14]= "-----------\n     |    |\n     0    |\n ----|----|\n     |    |\n     |    |\n    / \\   |\n          |\n          |\n-----------";
            hangman20[15]= "-----------\n     |    |\n     0    |\n ----|----|\n     |    |\n     |    |\n    / \\   |\n   /      |\n          |\n-----------";
            hangman20[16]= "-----------\n     |    |\n     0    |\n ----|----|\n     |    |\n     |    |\n    / \\   |\n   /   \\  |\n          |\n-----------";
            hangman20[17]= "-----------\n     |    |\n     0    |\n ----|----|\n     |    |\n     |    |\n    / \\   |\n   /   \\  |\n  /       |\n-----------";
            hangman20[18]= "-----------\n     |    |\n     0    |\n ----|----|\n     |    |\n     |    |\n    / \\   |\n   /   \\  |\n  /     \\ |\n-----------";
            hangman20[19]= "-----------\n     |    |\n     0    |\n ----|----|\n     |    |\n     |    |\n    / \\   |\n   /   \\  |\n _/     \\ |\n-----------";
            hangman20[20]= "-----------\n     |    |\n     0    |\n ----|----|\n     |    |\n     |    |\n    / \\   |\n   /   \\  |\n _/     \\_|\n-----------";


            printALine(hangman20[numberWrong]);
        }
        if(difficulty==2) {
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
        if(difficulty==3){
            String[] hangman10 = new String[11];

            hangman10[0] = "-----------\n     |    |\n          |\n          |\n          |\n-----------";
            hangman10[1] = "-----------\n     |    |\n     0    |\n          |\n          |\n-----------";
            hangman10[2] = "-----------\n     |    |\n     0    |\n     |    |\n          |\n-----------";
            hangman10[3] = "-----------\n     |    |\n     0    |\n    -|    |\n          |\n-----------";
            hangman10[4] = "-----------\n     |    |\n     0    |\n    -|-   |\n          |\n-----------";
            hangman10[5] = "-----------\n     |    |\n     0    |\n   --|-   |\n          |\n-----------";
            hangman10[6] = "-----------\n     |    |\n     0    |\n   --|--  |\n          |\n-----------";
            hangman10[7] = "-----------\n     |    |\n     0    |\n   --|--  |\n    /     |\n-----------";
            hangman10[8] = "-----------\n     |    |\n     0    |\n   --|--  |\n    / \\   |\n-----------";
            hangman10[9] = "-----------\n     |    |\n     0    |\n   --|--  |\n   _/ \\   |\n-----------";
            hangman10[10] ="-----------\n     |    |\n     0    |\n   --|--  |\n   _/ \\_  |\n-----------";

            printALine(hangman10[numberWrong]);
        }
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

    public static int chooseDifficulty(){
        int difficulty;
        Scanner keyboard = new Scanner(System.in);
        printALine("Player 2, choose one of the three difficulties: 1 is 20 guesses, 2 is 15 guesses, and 3 is 10 guesses.");
        difficulty = keyboard.nextInt();
        return difficulty;
    }

    public static int pickDifficultyNumber(int difficulty){
        int difficultyNumber;
        difficultyNumber=0;
        if(difficulty==1){
            difficultyNumber=20;
        }
        else if(difficulty==2){
            difficultyNumber=15;
        }
        else if(difficulty==3){
            difficultyNumber=10;
        }
        return difficultyNumber;

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






