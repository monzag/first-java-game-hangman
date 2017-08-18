import java.util.Scanner;
import java.util.ArrayList;

public class Game {

    private Player player;
    private Capital capital;
    private ArrayList<Character> bad_answers;
    private long gameTime;
    private Integer bonus;
    private Integer guessing;


    public Game(Player player, Capital capital) {
        this.player = player;
        this.capital = capital;
        bad_answers = new ArrayList<Character>();
        this.bad_answers = bad_answers;
        this.gameTime = 0;
        this.bonus = 0;
        this.guessing = 0;
    }

    public void runGame() {
        LeaderBoard highscore = new LeaderBoard();
        boolean is_win = false;
        Integer score = player.getScore();
        long startTime = System.currentTimeMillis();
        while (!is_win && score > 0) {
            if (score == 1) {
                show_hint();
            }      
            guessing += 1;
            System.out.println(capital.getHiddenWord());
            System.out.println("Score: " + player.getScore());
            String guess = getUserGuess();
            is_win = checkLength(guess);
            score = player.getScore();
        }

        long endTime   = System.currentTimeMillis();
        gameTime = ((endTime - startTime)/1000) - bonus;

        if (is_win == true) {
            highscore.saveNewRecord(player, capital, gameTime, guessing);
            win();

        } else {
            loose();
        }

        highscore.displayLeaderBoard();
    }

    public static String getUserGuess() {
        Scanner input;
        String guess;

        input = new Scanner(System.in);
        System.out.println("Your guess: ");
        guess = input.next().toLowerCase();

        return guess;
    }

    public boolean checkLength(String guess) {
        boolean is_win;
        Integer length_guess = 1;
        if (guess.length() > length_guess) {
            is_win = wordGuess(guess);
        } else {
            char letter = guess.charAt(0);
            is_win = letterGuess(letter);
        }
        return is_win;
    }

    public boolean wordGuess(String guess) {
        boolean is_win = false;
        if (capital.getCapitalName().toLowerCase().equals(guess.toLowerCase())) {
            this.bonus = 5;
            is_win = true;
        } else {
            Integer subtract = 2;
            changeScore(subtract);
            getDraw();
        }
        return is_win;

    }

    public boolean letterGuess(char letter) {
        boolean is_win = false;

        String hidden_word = capital.getHiddenWord();
        String unhidden_word = capital.unhideLetters(letter);

        if (unhidden_word == hidden_word) {
            // bad answer 
            bad_answers.add(letter);
            System.out.println(bad_answers);
            Integer subtract = 1;
            changeScore(subtract);
            getDraw();

        } else {
            if (capital.getCapitalName().toLowerCase().equals(unhidden_word.toLowerCase())) {
                is_win = true;
            } else {
                capital.setHiddenWord(unhidden_word);
            }
        }
        return is_win;
    }

    public void win() {
        System.out.format("You win!! You guessed after %d letters. It took you %d seconds!! %n", guessing, gameTime);

    }

    public static void loose() {
        System.out.println("Game over!!");

    }

    public void changeScore(Integer subtract) {
        Integer score = player.getScore();
        score -= subtract;
        player.setScore(score);
    }

    public void show_hint() {
        System.out.format("Hint! Capital of %s. %n", capital.getCountry());
    }

    public void getDraw() {
        if (player.getScore() == 9) {
            score_9();
        } else if (player.getScore() == 8) {
            score_8();
        } else if (player.getScore() == 7) {
            score_7();
        } else if (player.getScore() == 6) {
            score_6();
        } else if (player.getScore() == 5) {
            score_5();
        } else if (player.getScore() == 4) {
            score_4();
        } else if (player.getScore() == 3) {
            score_3();
        } else if (player.getScore() == 2) {
            score_2();
        } else if (player.getScore() == 1) {
            score_1();
        } else if (player.getScore() == 0) {
            score_0();
        }
    }

    public static void score_0() {
       System.out.println(" +---+");
       System.out.println(" |   |");
       System.out.println(" 0   |");
       System.out.println("/|\\ |");
       System.out.println("/ \\ |");
       System.out.println("     |");
       System.out.println(" =======");
    }

    public static void score_1() {
       System.out.println(" +---+");
       System.out.println(" |   |");
       System.out.println(" 0   |");
       System.out.println("/|\\ |");
       System.out.println("/    |");
       System.out.println("     |");
       System.out.println(" =======");
    }

    public static void score_2() {
       System.out.println(" +---+");
       System.out.println(" |   |");
       System.out.println(" 0   |");
       System.out.println("/|\\ |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println(" =======");
    }

    public static void score_3() {
       System.out.println(" +---+");
       System.out.println(" |   |");
       System.out.println(" 0   |");
       System.out.println("/|   |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println(" =======");
    }

    public static void score_4() {
       System.out.println(" +---+");
       System.out.println(" |   |");
       System.out.println(" 0   |");
       System.out.println(" |   |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println(" =======");
    }

    public static void score_5() {
       System.out.println(" +---+");
       System.out.println(" |   |");
       System.out.println(" 0   |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println(" =======");
    }

    public static void score_6() {
       System.out.println(" +---+");
       System.out.println(" |   |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println(" =======");
    }

    public static void score_7() {
       System.out.println(" +---+");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println(" =======");
    }

    public static void score_8() {
       System.out.println("   --+");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println(" =======");
    }
    
    public static void score_9() {
       System.out.println("      ");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println("     |");
       System.out.println(" =======");
    }
}