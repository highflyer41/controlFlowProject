import java.util.Scanner;
import java.util.Arrays;

public class Driver {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Prints the range of valid ASCII values in dec form
        AsciiChars.printNumbers();
        System.out.println();
        AsciiChars.printLowerCase();
        System.out.println();
        AsciiChars.printUpperCase();
        System.out.println();

        System.out.print("Please enter your name: ");
        String name = in.nextLine();
        System.out.println("Hello, " + name);

        System.out.print("Do you want to continue to the interactive portion? Enter 'y' for YES, otherwise enter any other letter: ");
        char choice = in.next().charAt(0);

        //Main interactive portion for lottery number generation
        while(choice == 'y' || choice == 'Y'){
            System.out.print("Enter the name of your favorite pet: ");
            String answer1 = in.next();
            System.out.print("Enter the age of your favorite pet: ");
            int answer2 = in.nextInt();
            System.out.print("Enter your lucky number: ");
            int answer3 = in.nextInt();
            System.out.print("Enter the jersey number of your favorite NBA player: ");
            int answer4 = in.nextInt();
            System.out.print("Enter the two-digit model year of your car: ");
            int answer5 = in.nextInt();
            // System.out.print("Enter the first name of your favorite actor/actress: ");
            // int answer6 = in.nextInt();

            int randNum1 = (int)((Math.random()*10)+1);
            // int randNum2 = (int)((Math.random()*10)+1);
            // int randNum3 = (int)((Math.random()*10)+1);

            //generating user's lottery numbers
            int magicBall = answer4 * randNum1;
            int userNum1 = (int)answer1.charAt(2);
            int userNum2 = answer2 + answer5;
            int userNum3 = answer3 + 42;
            int userNum4 = answer4 + answer2 + answer3;
            int userNum5 = answer5 + answer3;

            //array to hold lottery numbers
            int[] lotteryArray = {userNum1, userNum2, userNum3, userNum4, userNum5, magicBall};

            //checking if numbers are in range and adjusting
            for(int i = 0; i < lotteryArray.length; i++) {
                while(lotteryArray[i] < 1) {
                    lotteryArray[i] += 65;
                }
                while(lotteryArray[i] > 65) {
                    lotteryArray[i] -= 65;
                }

                if(i == lotteryArray.length -1) {
                    while(lotteryArray[i] < 1) {
                        lotteryArray[i] += 75;
                    }
                    while(lotteryArray[i] > 75) {
                        lotteryArray[i] -= 75;
                    }
                }
            }

            //checks for duplicate numbers and adjust
            //ignores the magic ball number
            for (int i = 0; i < lotteryArray.length - 1; i++) {
                for (int j = i + 1 ; j < lotteryArray.length - 1; j++) {
                     if (lotteryArray[i] == lotteryArray[j]) {
                            lotteryArray[j] *= randNum1;
                            while(lotteryArray[j] < 1) {
                                lotteryArray[j] += 65;
                            }
                            while(lotteryArray[j] > 65) {
                                lotteryArray[j] -= 65;
                            }
                     }
                }
            }

            //sort numbers in ascending order and printing
            Arrays.sort(lotteryArray);
            System.out.print("Lotter Numbers: ");
            for (int i = 0; i < lotteryArray.length; i++) {
                if(i == lotteryArray.length - 1) {
                    System.out.print("Magic Ball: " + lotteryArray[i]);
                }else {
                    System.out.print(lotteryArray[i] + " ");
                }
            }

            System.out.println("\nPlay again?: Enter 'y' for YES, otherwise enter any other letter: ");
            choice = in.next().charAt(0);
        }

        System.out.printf("Thank you for playing, %s! Goodbye!", name);
        in.close();
    }
}