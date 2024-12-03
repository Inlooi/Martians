import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class project{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();




        int attempts = 0;
        int correct = 0;



        while(attempts < 5){
        attempts++;
        System.out.println("Attempt "+(attempts)+":");
        System.out.println("Write your numbers(please with space between)");
        ArrayList<Integer> guessedCorrect = new ArrayList<>();


        ArrayList<Integer> coordinates = new ArrayList<>();
        while (coordinates.size() < 3) {
            int randomNumber = rd.nextInt(7) + 1;
                coordinates.add(randomNumber);
            if (!coordinates.contains(randomNumber)) {
                coordinates.add(randomNumber);
            }
        }

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
        System.out.println(coordinates);
        if(checkCorrect(guessedCorrect, coordinates, correct) == 3){
            System.out.println("Congratulations! You correctly guessed all boxes!");
            System.exit(0);
        }
        if(attempts == 5){
          System.out.println("You've run out of attempts.");
          return;
        }
       }
       sc.close();
    }
    public static int checkCorrect(ArrayList<Integer> guessedCorrect, ArrayList<Integer> coordinates, int correct){
        for (Integer pos : coordinates) {
            if (guessedCorrect.contains(pos)) {
                correct++;
            }
        }
        return correct;
    }
}