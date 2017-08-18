import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Application {

    public static void main(String[] args) {
        System.out.println("Welcome in Hangman!!");
        String file_name = "countries_and_capitals.txt";
        boolean want_play = true;
        while (want_play) { 
            ArrayList rows = getCountriesFromFile(file_name);
            String[] random_country_city = getRandomIndex(rows);
            String country = random_country_city[0];
            String capital_name = random_country_city[1];
            System.out.println(capital_name);

            String name = GetName();
            Integer score = 10;
            Player player = new Player(name, score);
            Capital capital = new Capital(capital_name, country);
            Game game = new Game(player, capital);

            game.runGame();
            want_play = playAgain();
        }

        System.out.println("Good bye;)");

    }

    public static ArrayList getCountriesFromFile(String file_name) {
        Scanner data = null;
        String row[];
        ArrayList<String[]> rows;
        rows = new ArrayList<String[]>();
        row = new String[2];

        try {
            data = new Scanner(new File(file_name));
        }

        catch (FileNotFoundException ex) {
            System.out.println("File not found");
            System.exit(0);
        }

        while (data.hasNextLine()) {
            row = data.nextLine().trim().split("\\| ");

            rows.add(row);

        }

        return rows;
    }

    public static String[] getRandomIndex(ArrayList<String[]> rows) {

        int length = rows.size();
        Random random_data = new Random();
        int random_index = random_data.nextInt(length);

        return rows.get(random_index);
        }

    public static String GetName() {
        Scanner input;
        String name;

        input = new Scanner(System.in);
        System.out.println("Your nick: ");
        name = input.next();

        return name;
    }

    public static boolean playAgain() {
        Scanner input;
        String user_choice;
        boolean want_play;
        String agree = "y";

        input = new Scanner(System.in);
        System.out.println("Do you want to play again? (y/n)");
        user_choice = input.next().toLowerCase();

        if (user_choice.equals(agree)) {
            want_play = true;

        } else {
            want_play = false;
        }
        
        return want_play;
    }
        
}
