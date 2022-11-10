
//<ScrambleGame> -- The purpose of this program is to create a scramble game which will utilize various aspects throughout the course
// such as arrays, methods, loops , etc.
//CSIS 212-<001>
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
//creates array of the words the program needs
public class ScrambleGame {
    private static final String[] ArrayWords = new String[]{
           "Friend","Bird", "Apple","Spiderman", "School","Java","Police","Phone","Island"
    };
//creates an array of list needed//
    private static final String[] ArrayHint = new String[]{
            "Someone who you can rely on and spend time with", "an animal that flys", "one a day keeps the doctor away"," Friendly neighborhood hero", "a Place where you learn and graduate from",
            "language used to program this game", "People who keep the peace", " Something that everyone has and uses to communicate","Surrounded by water"
    };

    public static void main(String[] args) {
        ScrambleGame SGame = new ScrambleGame();
        System.out.println("Domanrovil Ovalle -Assignment Final Project\n ");
        SGame.startGame();
    }

    public String selectRandomWord() {
        int RandomW = ThreadLocalRandom.current().nextInt(0, ArrayWords.length);
        return ArrayWords[RandomW];
    }

  //Shuffles word 5 times//
    public String getShuffledWord(String OriginalWord) {
        String ShuffledWord = OriginalWord;
        int WordLength = OriginalWord.length();
        int ShuffledTimes = 5;
        for (int i = 0; i < ShuffledTimes; i++) {
           //code to randomize the word using threadlocalrandom to increase the randomness.
            int Randomized = ThreadLocalRandom.current().nextInt(0, WordLength);
            int Randomized1 = ThreadLocalRandom.current().nextInt(0, WordLength);
            ShuffledWord = swapCharacters(ShuffledWord, Randomized, Randomized1);
        }
        return ShuffledWord;
    }
    private String swapCharacters(String ShuffledWord, int Randomized, int Randomized1) {
        char[] ArrayRandom = ShuffledWord.toCharArray();
        char TP = ArrayRandom[Randomized];
        ArrayRandom[Randomized] = ArrayRandom[Randomized1];
        ArrayRandom[Randomized1] = TP;
        return new String(ArrayRandom);
    }
// display hint for the word needed to unscramble//
    private void displayHint(String s) {
        for (int i = 0; i < ArrayWords.length; i++) {
            if (ArrayWords[i].equals(s)) {
                System.out.println("Hint:" + ArrayHint[i]);
            }
        }
    }
    private void startGame() {
        //String shuffled = getShuffledWord(original);
        boolean Replay = true;
        while (Replay) {
            String OriginalWord = selectRandomWord();
            String Shuffled = getShuffledWord(OriginalWord);
            displayHint(OriginalWord);
            System.out.println("The word you must unshuffle: " + Shuffled);

            String userGuess = getPlayerWord();
            if (OriginalWord.equalsIgnoreCase(userGuess)) {
                System.out.println("Success! You unscrambled the word and beat the game.");
                        Replay = false;
            }
            else {
// Displays incorrect message if wrong guess is given
                System.out.println("Incorrect new word will be generated");
                System.out.println("______________________________________");

                }
            }
        }


    // Retrieves the players guess using scanner//
    public String getPlayerWord() {
        Scanner Scan = new Scanner(System.in);
        System.out.println("Take a guess on the word: ");
        return Scan.nextLine();
    }}


