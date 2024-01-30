import java.util.Arrays;
import java.util.Scanner;

public class task1 {

    static String[] board;
    static String winner;
    static String player;

    public static String whoIsWinner(){

        for (int i=0; i<8; i++){

            String check = null;

            switch (i){

                case 0: check = board[0] + board[1] + board[2];
                        break;

                case 1: check = board[3] + board[4] + board[5];
                        break;

                case 2: check = board[6] + board[7] + board[8];
                        break;

                case 3: check = board[0] + board[3] + board[6];
                        break;

                case 4: check = board[1] + board[4] + board[7];
                        break;

                case 5: check = board[2] + board[5] + board[8];
                        break;

                case 6: check = board[0] + board[4] + board[8];
                        break;

                case 7: check = board[2] + board[4] + board[6];
                        break;

            }

            if(check.equals("XXX"))
                return "X";
            else if (check.equals("OOO"))
                return "O";

        }

        for (int i=0; i<9; i++){

            if(Arrays.asList(board).contains(String.valueOf(i+1)))
                break;
            else if(i == 8)
                return "Tie";

        }

        System.out.println("Its " + player + " Chance:");

        return null;

    }

    public static void showTheBoard(){

        System.out.println("#################################");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("#################################");

    }

    public static void main(String[] args) {

        winner = null;
        player = "X";
        board = new String[9];

        for(int i=0; i<9; i++){
            board[i] = String.valueOf(i+1);
        }

        showTheBoard();

        System.out.println("Now X Chance: ");

        Scanner sc = new Scanner(System.in);

        while(winner == null){

            int input;
            input = sc.nextInt();

            if(input > 0 && input <= 9){

                if(board[input-1].equals(String.valueOf(input))){

                    board[input-1] = player;

                    showTheBoard();

                    if(player == "X")
                        player = "O";
                    else
                        player = "X";

                    winner = whoIsWinner();
                } else {
                    System.out.println("Enter value into another slot as it is already taken");
                }

            }

        }

        if (winner == "Tie")
            System.out.println("Its a Tie among 'O' and 'X'!");

        else{
            System.out.println("Congratulations.........." + winner + " Wins");
        }

    }
}