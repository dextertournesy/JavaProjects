package RockPaperScissors;

import java.util.Random;

public class Computer extends Player{
    private int score = 0;
    private String computerName;
    private String move;

    public Computer(String name) {
        super(name);
    }


//    public Computer(String computerName) {
//        this.computerName = computerName;
//        score = 0;
//        move = null;
//    }

    public void setMove(String move) {
        this.move = move;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public void win(){score++;}

    public int getScore() {
        return score;
    }

    public String getMove() {
        return move;
    }

    public String computerMove()
    {
        Random myRandom = new Random();
        int x = myRandom.nextInt(3);
        if (x == 1)
        {
            return "Rock";
        }
        else if (x ==2)
        {
            return "Paper";
        }
        else
        {
            return "Scissors";
        }
    }
}
