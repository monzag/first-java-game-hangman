import java.util.ArrayList;

public class Capital {

    private String capital_name;
    private String country;
    private String hidden_word;

    public Capital(String capital_name, String country) {
        this.capital_name = capital_name.toLowerCase();
        this.country = country;
        this.hidden_word = hide();
    }

    public String hide() {
        String hidden_word = "";
        String sign = "_";
        char space = ' ';

        for (int i = 0; i < capital_name.length(); i++) {
            char letter = capital_name.charAt(i);
            if (letter == space) {
                hidden_word += space;
            } else { 
                hidden_word += sign;
            }
        }

        return hidden_word;
    }

    public String unhideLetters(char guessed_letter) {
        for (int i = 0; i < capital_name.length(); i++) {
            if (capital_name.charAt(i) == guessed_letter) {
                hidden_word = hidden_word.substring(0, i) + guessed_letter + hidden_word.substring(i+1);
            }
        }

        return hidden_word;
    }

    public String getHiddenWord() {
        return hidden_word;
    }

    public void setHiddenWord(String unhidden_letter) {
        this.hidden_word = unhidden_letter;
    }

    public String getCapitalName() {
        return capital_name;
    }

    public String getCountry() {
        return country;
    }

}

