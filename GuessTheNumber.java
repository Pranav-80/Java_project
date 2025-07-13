import java.util.Random;
import java.util.Scanner;
//you can use both classes they work, class guess2 is more clean than class guess but I have us Guess class

class Guess2{
    int guess;
    int userGuess;
    int randomNumber;
    public Guess2(){
        Random random = new Random();
        guess = 0;
        randomNumber = random.nextInt(101);
    }
    public void userInput(){
        Scanner scn = new Scanner(System.in);
        System.out.println("If you want to quit then enter number less than 0 or greater than 100 else");
        System.out.println("enter the guessing number b/w 0 to 100: ");
        this.userGuess = scn.nextInt();
    }
    public void isCorrectNumber(){
        while(true){
            if (userGuess == randomNumber){
                System.out.println("You guessed the correct number! ");
                System.out.println("Number of guesses used: "+guess);
                System.out.println("The number to be guessed is: "+randomNumber );
                break;
            }
            else if (userGuess > randomNumber && userGuess >= 0 && userGuess <= 100 ){ 
                System.out.println("You are gussing number greater than the number. Try Smaller number.");
                guess++;
                userInput();
                
            }
            else if (userGuess < randomNumber && userGuess >= 0 && userGuess <= 100){
                System.out.println("You are gussing number smaller than the number. Try greater number.");
                guess++;
                userInput();
            }
            else{
                System.out.println("The gussing number was: "+randomNumber);
                System.out.println("Quitting the game...");
                break;
            }
        }
    }
}
class Guess{
    int guess;
    int userGuess;
    int randomNumber;
    public Guess(){
        Random random = new Random();
        guess = 0;
        randomNumber = random.nextInt(101);
    }
    public void userInput(){
        Scanner scn = new Scanner(System.in);
        System.out.println("If you want to quit then enter number less than 0 or greater than 100 else");
        System.out.println("enter the guessing number b/w 0 to 100: ");
        this.userGuess = scn.nextInt();
    }
    public int isCorrectNumber(){
        if (userGuess == randomNumber){
            return 1;
        }
        else if (userGuess > randomNumber && userGuess >= 0 && userGuess <= 100 ){ 
            System.out.println("You are gussing number greater than the number. Try Smaller number.");
            guess++;
            
        }
        else if (userGuess < randomNumber && userGuess >= 0 && userGuess <= 100){
            System.out.println("You are gussing number smaller than the number. Try greater number.");
            guess++;
        }
        else{
            return 2;
        }
        return 0;
    }
}

public class GuessTheNumber{
    public static void main(String[] args) {
        Guess game = new Guess();
        int returnValue = 0;
        do { 
            if (returnValue == 1){
                System.out.println("You guessed the correct number! ");
                System.out.println("Number of guesses used: "+game.guess);
                System.out.println("The number to be guessed is: "+game.randomNumber );
                break;
            }
            if (returnValue == 2){
                System.out.println("The gussing number was: "+game.randomNumber);
                System.out.println("Quitting the game...");
                break;
            }
            game.userInput();
            returnValue = game.isCorrectNumber();
            System.out.println();
        } while (true);
    }
}