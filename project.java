import java.util.Scanner;
import java.util.ArrayList;

public class project{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int attempts = 0;
        int correct = 0;

        int[] coordinates = {1, 3, 5};

        while(attempts < 5){
        attempts++;
        System.out.println("Attempt "+(attempts)+":");
        System.out.println("Write your numbers(please with space between)");
        ArrayList<Integer> guessedCorrect = new ArrayList<>();

        for(int i = 0; i<3;i++){
            int input = sc.nextInt();
            if (input >= 0 && input <= 7) {
                guessedCorrect.add(input);
            } else {
                System.out.println("Invalid input. Please enter a value between 0 and 7.");
                i--;
        }     
        }

        System.out.println("Correctly guessed locations: "+checkCorrect(guessedCorrect, coordinates, correct));

        if(checkCorrect(guessedCorrect, coordinates, correct) == 3){
            System.out.println("Congratulations! You correctly guessed all boxes!");
            System.exit(0);
        }
        if(attempts == 5){
          System.out.println("You've run out of attempts.");
          System.exit(0);
        }
       }
       sc.close(); 
    }
    public static int checkCorrect(ArrayList<Integer> guessedCorrect, int[] coordinates, int correct){
        for (Integer pos : coordinates) {
            if (guessedCorrect.contains(pos)) {
                correct++;
            }
        }
        return correct;
    }
}

