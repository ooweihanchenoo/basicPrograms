package rps;
import java.util.*;

public class rps {
    public static String randomGenerator(Random randomGenerater) {
        int randomNumber = 0;
        randomGenerater = new Random();
        randomNumber = randomGenerater.nextInt(3) + 1;
        if (randomNumber == 1) {
            return "Rock";
        } else if (randomNumber == 2) {
            return "Paper";
        } else if (randomNumber == 3) {
            return "Scissor";
        }
        return null;
    }
    public static void showMenu(){
        System.out.println("Computer Has Made Its Choice, It is Your Turn.");
        System.out.println("1.Rock \n2.Paper \n3.Scissor");
    }
    public static String getUserOption(Scanner userinput){
        System.out.println("Please Enter Your Choice (In Numbers)");
        int userChoices;
        String usrChoice = null;
        userChoices = userinput.nextInt();
        if (userChoices == 1) {
            usrChoice = "Rock";
        }else if(userChoices == 2){
            usrChoice = "Paper";
        }else if (userChoices == 3){
            usrChoice = "Scissor";
        }
        return usrChoice;
    }

    public static String whoWins(String computerChoice, String humanChoice) {
        String result = null;
        if (computerChoice.equals("Rock") && humanChoice.equalsIgnoreCase("Rock") || computerChoice.equals("Paper") && humanChoice.equalsIgnoreCase("Paper") || computerChoice.equals("Scissor") && humanChoice.equalsIgnoreCase("Scissor")) {
            result = "It's A TIE!!!";
        }
        if (computerChoice.equals("Rock") && humanChoice.equalsIgnoreCase("Scissor") || computerChoice.equals("Paper") && humanChoice.equalsIgnoreCase("Rock") || computerChoice.equals("Scissor") && humanChoice.equalsIgnoreCase("Paper")) {
            result = "Computer Won!!!";
        }
        if (computerChoice.equals("Rock") && humanChoice.equalsIgnoreCase("Paper") || computerChoice.equals("Paper") && humanChoice.equalsIgnoreCase("Scissor") || computerChoice.equals("Scissor") && humanChoice.equalsIgnoreCase("Rock")) {
            result = "You Won!!!";
        }
        return result;
    }

    public static void main(String [ ] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        showMenu();
        String computerChoice = randomGenerator(random);
        String humanChoice = getUserOption(scanner);
        String endGame = whoWins(computerChoice, humanChoice);
        System.out.println("Computer Choose: " + computerChoice);
        System.out.println("You Choose: " + humanChoice);
        System.out.println(endGame);

    }
}
