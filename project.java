import java.util.Scanner;
import java.util.Random;

public class project{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();


        int attempts = 0;
        int[] coordinates = randomCoordinates(rd);
        
        while(attempts < 5){

        attempts++;
        System.out.println("Attempt "+(attempts)+":");
        System.out.println("Write your 3 numbers (please with space between)");

        int[] guessedCorrect = new int [3];
        

        
        for(int i = 0; i < 3;i++){
            int input = sc.nextInt();
            if (input >= 1 && input <= 7) {
                guessedCorrect[i] = input;
            }else{
                System.out.println("Invalid input. Please enter a value between 1 and 7.");
                i--;
            }
        }

        System.out.println("Correctly guessed locations: "+checkCorrect(guessedCorrect, coordinates)+"/3");

        if(checkCorrect(guessedCorrect, coordinates) == 3){
            System.out.println("Congratulations! You correctly guessed all boxes!");
            System.out.println("The correct numbers were: " + coordinates[0] + ", " + coordinates[1] + ", " + coordinates[2]);
            System.exit(0);
        }

        if(attempts == 5){
            System.out.println("You've run out of attempts.");
            System.out.println("The correct numbers were: " + coordinates[0] + ", " + coordinates[1] + ", " + coordinates[2]);
            System.exit(0);
        }

       }
       sc.close();
    }

    private static int checkCorrect(int[] guessedCorrect, int[] coordinates){
        int correctCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (guessedCorrect[i] == coordinates[j]) {
                    correctCount++;
                    break;
                }
            }
        }
        return correctCount;
    }

    private static int[] randomCoordinates(Random rd){
       int[] coordinates = new int [3];
       int count = 0;

       while (count < 3) {

        boolean exists = false;
        int randomNumber = rd.nextInt(7) + 1;

        for(int i = 0; i < count; i++){
           if(coordinates[i] == randomNumber){
              exists = true;
              break;
            }
        }

        if (!exists) {
            coordinates[count] = randomNumber;
            count++;
        }
      }
     return coordinates;
    }
}