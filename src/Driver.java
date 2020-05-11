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

        System.out.print("\nPlease enter your name: ");
        String name = in.nextLine();
        System.out.println("Hello, " + name + "!");

        System.out.print("Play Lottery Game? Enter 'y' for YES, otherwise enter any other letter: ");
        char choice = in.next().charAt(0);

        //Main interactive portion for lottery number generation
        while(choice == 'y' || choice == 'Y'){
            playLottery(in);

            System.out.println("\nPlay again?: Enter 'y' for YES, otherwise enter any other letter: ");
            choice = in.next().charAt(0);
        }

        System.out.printf("Thank you for playing, %s! Goodbye!", name);
        in.close();

    }//End of Main -----------------------------------------------------------

    //Main game method. Plays the lottery game.
    private static void playLottery(Scanner in) {
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
        int userNum1 = (int)answer1.charAt(0);
        int userNum2 = answer2 + answer5;
        int userNum3 = answer3 + 42;
        int userNum4 = answer4 + answer2 + answer3;
        int userNum5 = answer5 + answer3;

        //array to hold lottery numbers
        int[] lotteryArray = {userNum1, userNum2, userNum3, userNum4, userNum5, magicBall};
        checkRange(lotteryArray);
        checkDuplicate(lotteryArray);

        //sort user numbers in ascending order and printing
        Arrays.sort(lotteryArray);
        System.out.print("Lottery Numbers: ");
        printNumbers(lotteryArray);

        //winning lottery numbers
        int[] winningNumbers = generateWinningNumbers();
        checkDuplicate(winningNumbers);

        //sort winning numbers and print
        Arrays.sort(winningNumbers);
        System.out.print("\nWinning Numbers: ");
        printNumbers(winningNumbers);

        //check to see if user wins any
        checkWinning(lotteryArray, winningNumbers);
    }

    //method to check users nums are in range and adjusts
    private static void checkRange(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            while(numbers[i] < 1) {
                numbers[i] += 65;
            }
            while(numbers[i] > 65) {
                numbers[i] -= 65;
            }

            if(i == numbers.length -1) {
                while(numbers[i] < 1) {
                    numbers[i] += 75;
                }
                while(numbers[i] > 75) {
                    numbers[i] -= 75;
                }
            }
        }
    }

    //method to check for duplicates and adjusts
    private static void checkDuplicate(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1 ; j < numbers.length - 1; j++) {
                 if (numbers[i] == numbers[j]) {
                        numbers[j] *= (int)((Math.random()*10)+1);
                        while(numbers[j] < 1) {
                            numbers[j] += 65;
                        }
                        while(numbers[j] > 65) {
                            numbers[j] -= 65;
                        }
                 }
            }
        }
    }

    //method to generate an array of winning numbers
    private static int[] generateWinningNumbers() {
        int[] winNum = new int[6];
        for(int i = 0; i < winNum.length; i++) {
            if(i == winNum.length - 1) {
                winNum[i] = (int)((Math.random()*75)+1);
            }else {
                winNum[i] = (int)((Math.random()*65)+1);
            }
        }
        return winNum;
    }

    //print method
    private static void printNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if(i == numbers.length - 1) {
                System.out.print("Magic Ball: " + numbers[i]);
            }else {
                System.out.print(numbers[i] + " ");
            }
        }
    }

    //method to check if there are any winnings
    private static void checkWinning(int[] userNumbers, int[] winNumbers) {
        int matchingNums = 0;
        boolean matchMagicBall = false;
        for(int i = 0; i < userNumbers.length; i++) {
            if(userNumbers[i] == winNumbers[i]) {
                matchingNums++;
            }
            if(i == userNumbers.length - 1) {
                if(userNumbers[i] == winNumbers[i]) {
                    matchMagicBall = true;
                }
            }
        }
        if(matchMagicBall) {
            System.out.print("\nYOU GOT THE MAGIC BALL NUMBER");
            switch(matchingNums) {
                case 0: System.out.println(" and You matched 0 numbers! You win 4 Dollars!"); break;
                case 1: System.out.println(" and You matched 1 number! You win 4 Dollars!"); break;
                case 2: System.out.print(" and You matched 2 numbers! You win 7 Dollars!"); break;
                case 3: System.out.print(" and You matched 3 numbers! You win 100 Dollars!"); break;
                case 4: System.out.print(" and You matched 4 numbers! You win 50,000 Dollars!"); break;
                case 5: System.out.print(" and You matched all numbers! You win THE JACKPOT!"); break;
            }
        } else {
            System.out.print("\nYou didn't get the Magic Ball number");
            switch(matchingNums) {
                case 0: System.out.println(" and You matched 0 numbers! No winnings."); break;
                case 1: System.out.println(" but You matched 1 number! No winnings."); break;
                case 2: System.out.println(" but You matched 2 numbers! No winnings."); break;
                case 3: System.out.print(" but You matched 3 numbers! You win 7 Dollars!"); break;
                case 4: System.out.print(" but You matched 4 numbers! You win 100 Dollars!"); break;
                case 5: System.out.print(" but You matched 5 numbers! You win 1,000,000 Dollars!"); break;
            }
        }
    }

}//End of Class