import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LeaderBoard {

    private ArrayList<String> records;

    public LeaderBoard() {
        records = new ArrayList<String>();
        this.records = records;
    }

    public String getLeaderBoardFromFile() {
        //
        Scanner data = null;

        try {
            data = new Scanner(new File("highscore.txt"));
        }

        catch (FileNotFoundException ex) {
            System.out.println("File not found");
            System.exit(0);
        }

        while (data.hasNextLine()) {
            String line = data.nextLine().trim();
            records.add(line);

        }

        String joined = String.join(", ", records);
        //System.out.println(joined);
        return joined;
    } 

    public void saveNewRecord(Player player, Capital capital, long gameTime, Integer guessing) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String record = player.getName() + '|' + dateFormat.format(date) + '|' + gameTime + '|' + 
                        guessing + '|' + capital.getCapitalName() + "\n";
        saveLeaderBoard(record);
    }

    public static void saveLeaderBoard(String record) {
        String FILENAME = "highscore.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {
            bw.write(record);

            System.out.println("Done");

        } catch (IOException e) {

            System.out.println("File not exist");
        }
    }

    public void displayLeaderBoard() {
        String joined = getLeaderBoardFromFile();
        String[] records = joined.split(",");

        System.out.println("\nHighscore: ");
        for (String record : records) {
            System.out.println(record);
        }
        
    }

}