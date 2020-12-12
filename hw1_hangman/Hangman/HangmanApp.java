import java.util.Scanner;

public class HangmanApp
{
  public static void main( String [] args )
  {
    Scanner scan = new Scanner(System.in);

    Hangman hangman;
    int tryLetterResult;
    
    hangman = new Hangman();
    
    System.out.println( "Your max allowed incorrect guess amount is: " + hangman.getMaxAllowedIncorrectTries() + " ." );
    
    do{

        System.out.println( "\n----------------------------------" );
        System.out.println( "Amount of incorrect tries left: " + ( hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries() ) );
        System.out.println( "The letters have been used before: " + hangman.getUsedLetters() );
        System.out.println( "----------------------------------" );

        System.out.println( "       " + hangman.getKnownSoFar() + "\n" );
        System.out.println( hangman.getAllLetters() );
        System.out.println( "Try a letter:" );

        tryLetterResult = hangman.tryThis(scan.next().charAt(0));


        if( tryLetterResult == -1 ){
          System.out.println( "Wrong guess. Please enter one of the letters you see above: " );
        }
        else if( tryLetterResult == -2 ){
          System.out.println( "You have choosen this letter already. Please enter a letter that you didn't guess before: " );
        }
        else if( tryLetterResult > -1 ){
          System.out.println( "The letter you choosed is in the word " + tryLetterResult + " times." );
        }
      
    }while( !hangman.isGameOver());

    if( !(hangman.hasLost()) ){
      System.out.println( "******CONGRUTULATIONS****** You guessed the secret word.\n" );
      System.out.println( "The secret word was: " + hangman.getKnownSoFar() + "\n" );
      System.out.println( "It took " + hangman.getNumOfIncorrectTries() + " incorrect tries to find the word" );
    }
    else {
      System.out.println( "Sorry, but you lost!\n" );
    }
  }
  
  
}








