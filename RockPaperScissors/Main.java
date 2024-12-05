package RockPaperScissors;
import java.util.*;
public class Main {
    static Player player1;
    static Computer playerOne;
    static Computer playerTwo;
    static Scanner keyboard = new Scanner(System.in);
    static String input;
    static String selection;
    public static void main(String[] args) {
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("[1] Player vs Computer or [2]Computer vs Computer?");
        input = keyboard.nextLine();
        while(!verifyInput(input))
        {
            System.out.println("Please enter a valid input");
            input = keyboard.nextLine();
            verifyInput(input);
        }
        if (input.equals("1"))
        {
            System.out.println("Please enter Player name: ");
            player1 = new Player(keyboard.nextLine());
            playerTwo = new Computer("Computer 1");
        }
        else
        {
             playerOne = new Computer("Computer 1");
             playerTwo = new Computer("Computer 2");
        }
        getMenu();
        String selection = keyboard.nextLine();
        option(selection);
    }
    public static boolean verifyInput(String input)
    {
        return input.equals("1")||input.equals("2");
    }
    public static void getMenu()
    {
        System.out.println("Menu: \n----- \n" +
        "[1]View Score\n"+
        "[2]Play game\n"+
        "[3]Quit");
        selection = keyboard.nextLine();
        option(selection);
    }
    public static void option(String selection)
    {
        switch (selection)
        {
            case "1": getScore();
                break;
            case "2": playGame();
                break;
            case "3": quit();
                break;
            default:
                System.out.println("Invalid selection");
        }
    }

    public static void playGame()
    {
        String playerSelection;
        String computer1Selection;
        String computer2Selection;
        if (input.equals("1"))
        {
            System.out.println("Rock 🪨, Paper 📄 or Scissors ✂️?");
            player1.setMove(keyboard.nextLine());
            while (!player1.getMove().equalsIgnoreCase("rock")&&!player1.getMove().equalsIgnoreCase("paper")
                    &&!player1.getMove().equalsIgnoreCase("scissors"))
            {
                System.out.println("Invalid Selection");
                playerSelection = keyboard.nextLine();
            }
           determineWinnerWithPlayer(playerTwo.computerMove(), player1.getMove());
           getMenu();
        }
        else
        {
            determineWinnerWithComputers(playerOne.computerMove(), playerTwo.computerMove());
            getMenu();
        }
    }
    public static void determineWinnerWithPlayer(String move1, String move2)
    {
        if (move1.equalsIgnoreCase(move2))
        {
            System.out.println("Game resulted in a draw!");
        }
        else if (move1.equalsIgnoreCase("Paper") && move2.equalsIgnoreCase("rock"))
        {
            System.out.println("Paper 📄 beats rock! Computer wins!");
            playerTwo.win();
        }
        else if (move1.equalsIgnoreCase("rock") && move2.equalsIgnoreCase("paper"))
        {
            System.out.println("Paper 📄 beats rock! "+ player1.getName() +" wins!");
            player1.win();
        }
        else if (move1.equalsIgnoreCase("Scissors") && move2.equalsIgnoreCase("Paper"))
        {
            System.out.println("Scissors ✂️ beats paper! Computer wins!");
            playerTwo.win();
        }
        else if (move1.equalsIgnoreCase("Paper") && move2.equalsIgnoreCase("Scissors"))
        {
            System.out.println("Scissors ✂️ beats paper! "+ player1.getName() +" wins!");
            player1.win();
        }
        else if (move1.equalsIgnoreCase("Rock") && move2.equalsIgnoreCase("Scissors"))
        {
            System.out.println("Rock 🪨️ beats scissors! Computer wins!");
            playerTwo.win();
        }
        else if (move1.equalsIgnoreCase("Scissors") && move2.equalsIgnoreCase("rock"))
        {
            System.out.println("Rock 🪨️ beats scissors! "+ player1.getName() +" wins!");
            player1.win();
        }
    }
    public static void determineWinnerWithComputers(String move1, String move2)
    {
        if (move1.equalsIgnoreCase(move2))
        {
            System.out.println("Game resulted in a draw!");
        }
        else if (move1.equalsIgnoreCase("Paper") && move2.equalsIgnoreCase("rock"))
        {
            System.out.println("Paper 📄 beats rock! Computer 2 wins!");
            playerTwo.win();
        }
        else if (move1.equalsIgnoreCase("rock") && move2.equalsIgnoreCase("paper"))
        {
            System.out.println("Paper 📄 beats rock! Computer 1 wins!");
            playerOne.win();
        }
        else if (move1.equalsIgnoreCase("Scissors") && move2.equalsIgnoreCase("Paper"))
        {
            System.out.println("Scissors ✂️ beats paper! Computer 2 wins!");
            playerTwo.win();
        }
        else if (move1.equalsIgnoreCase("Paper") && move2.equalsIgnoreCase("Scissors"))
        {
            System.out.println("Scissors ✂️ beats paper! Computer 1 wins!");
            playerOne.win();
        }
        else if (move1.equalsIgnoreCase("Rock") && move2.equalsIgnoreCase("Scissors"))
        {
            System.out.println("Rock 🪨️ beats scissors! Computer 2 wins!");
            playerTwo.win();
        }
        else if (move1.equalsIgnoreCase("Scissors") && move2.equalsIgnoreCase("rock"))
        {
            System.out.println("Rock 🪨️ beats scissors! Computer 1 wins!");
            playerOne.win();
        }
    }

    public static void quit()
    {
        System.out.println("Thank you for playing! \nFinal Scores:");
        getScore();
        System.exit(0);
    }

    public static void getScore()
    {
        if(input.equals("1"))
        {
            System.out.println(player1.getName()+ ": " + player1.getScore());
            System.out.println("Player 2: " + playerTwo.getScore());
        }
        else
        {
            System.out.println("Player 1: " + playerOne.getScore());
            System.out.println("Player 2: " + playerTwo.getScore());
        }

        if (!selection.equals("3")){
            getMenu();
            selection = keyboard.nextLine();
            option(selection);
        }
    }
}
