package RockPaperScissors;

public class Player {
    private String name;
    private int score = 0;
    private String move;

    public Player(String name) {
        this.name = name;
        move = null;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public String getMove() {
        return move;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void win()
    {
        score++;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + "]";
    }

    
}
