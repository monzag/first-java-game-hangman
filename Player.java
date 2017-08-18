public class Player {

    private String name;
    private Integer score;

    public Player(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

}