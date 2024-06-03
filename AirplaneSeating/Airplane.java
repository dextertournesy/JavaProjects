/**
        * @author Dexter Tournesy
        * Title: Airplane
        * This progam displays a seat arrangement for a plane using
        * a 2 dimensional array. The user then is prompted to select
        * a seat. Once all seats are selected, or the user chooses to
        * quit, the program then ends.
        */
import java.util.Scanner;

public class Airplane {
    /**
     * Global Variable Declarations
     */

    public static Scanner keyboard = new Scanner(System.in);
    public static String rowNumber;
    public static String columnLetter;
    public static int assignedSeatCount = 0;

    /**
     * Main method
     */

    public static void main(String[] args)
    {
        String[][] availableAirplaneSeats = airplaneSeats();
        System.out.println("You will be selecting seats for this airplane.");
        printAllSeats(availableAirplaneSeats);
        System.out.println("You will input the seat selection using the row number and then " +
                "the seat letter (ex - 3B)");
        seatSelection(availableAirplaneSeats);
    }

    public static String[][] airplaneSeats() {
        /**
         * 2D Array declaration and initialization
         */

        String[][] planeSeats = new String[7][5];
        planeSeats[0][0] = "1";
        planeSeats[0][1] = "A";
        planeSeats[0][2] = "B";
        planeSeats[0][3] = "C";
        planeSeats[0][4] = "D";

        planeSeats[1][0] = "2";
        planeSeats[1][1] = "A";
        planeSeats[1][2] = "B";
        planeSeats[1][3] = "C";
        planeSeats[1][4] = "D";

        planeSeats[2][0] = "3";
        planeSeats[2][1] = "A";
        planeSeats[2][2] = "B";
        planeSeats[2][3] = "C";
        planeSeats[2][4] = "D";

        planeSeats[3][0] = "4";
        planeSeats[3][1] = "A";
        planeSeats[3][2] = "B";
        planeSeats[3][3] = "C";
        planeSeats[3][4] = "D";

        planeSeats[4][0] = "5";
        planeSeats[4][1] = "A";
        planeSeats[4][2] = "B";
        planeSeats[4][3] = "C";
        planeSeats[4][4] = "D";

        planeSeats[5][0] = "6";
        planeSeats[5][1] = "A";
        planeSeats[5][2] = "B";
        planeSeats[5][3] = "C";
        planeSeats[5][4] = "D";

        planeSeats[6][0] = "7";
        planeSeats[6][1] = "A";
        planeSeats[6][2] = "B";
        planeSeats[6][3] = "C";
        planeSeats[6][4] = "D";


        return planeSeats;
    }

    /**
     * Print seats method
     */

    public static void printAllSeats(String[][] planeSeats) {
        /**
         * For Loop to iterate through rows, then nested for loop
         * to iterate through columns.
         */

        for(int row = 0; row < planeSeats.length; row++) {
            for(int col = 0; col < planeSeats[row].length; col++) {
                System.out.print(planeSeats[row][col]);
                if (col < planeSeats[row].length - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     *Seat selection method
     */
    public static void seatSelection(String[][] availableAirplaneSeats)
    {
        /**
         *Boolean variable declared and initialed to be used as
         * condition of while loop
         */
        boolean quit = false;

        /**
         *While loop to request user input and verify if input
         * is valid
         */
        while (quit == false && assignedSeatCount < 28)
        {
            System.out.println("Please enter the seat number or Q to quit." + "\n");
            String response = keyboard.nextLine();
            if (response.equalsIgnoreCase("Q"))
            {
                quit = true;
            }
            else
            {
                /**
                 *Substring method takes valid user input and
                 * stores necessary parts
                 */
                if (response.length() == 2)
                {
                    rowNumber = response.substring(0, 1);
                    columnLetter = response.substring(1, 2);
                    assignSeat(availableAirplaneSeats);
                }
                else
                {
                    System.out.println("Invalid input, valid input ex - 3B");
                    /**
                     *After invalid input seat arrangement redisplays unchanged.
                     */
                    printAllSeats(availableAirplaneSeats);
                }
            }

        }
        /**
         *Conditional if statement when all seats are occupied
         */
        if (assignedSeatCount == 28)
        {
            System.out.println("All seats are occupied.");
        }
        /**
         *Send off statement
         */
        System.out.println("Have a nice day!");
        System.exit(0);
    }

    /**
     *Method for seat assignment
     */
    public static void assignSeat(String[][] availableAirplaneSeats)
    {
        /**
         *Switch statement to take passed String variable and convert
         * into integer value
         */
        int row;
        switch (rowNumber)
        {
            case "1":
                row = 0;
                break;

            case "2":
                row = 1;
                break;

            case "3":
                row = 2;
                break;

            case "4":
                row = 3;
                break;

            case "5":
                row = 4;
                break;

            case "6":
                row = 5;
                break;

            case "7":
                row = 6;
                break;

            default:
                row = -1;
        }
        /**Switch statement to take passed String variable and convert
         * into integer value
         */
        int column;
        switch (columnLetter)
        {
            case "A":
                column = 1;
                break;

            case "B":
                column = 2;
                break;

            case "C":
                column = 3;
                break;

            case "D":
                column = 4;
                break;

            default:
                column = 0;
        }
        /**
         *If-else statement that checks for a valid seat selection
         * and either updates value with an "X", or prints error
         * message.
         */
        if ( row >= 0 && column > 0 && availableAirplaneSeats[row][column] != "X")
        {
            availableAirplaneSeats[row][column] = "X";
            printAllSeats(availableAirplaneSeats);
            assignedSeatCount++;
        }
        else
        {
            System.out.println("Seat selected is either invalid or taken, please select another.");
            printAllSeats(availableAirplaneSeats);
        }


    }
}
