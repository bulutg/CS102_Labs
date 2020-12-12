/**
 * Hangman game class 
 * @author Bulut Gozubuyuk
 * @version 10.07.2019
 */

public class Hangman
{

  private StringBuffer secretWord;
  private StringBuffer allLetters;
  private StringBuffer usedLetters;
  private StringBuffer knownSoFar;
  private int numberOfIncorrectTries;
  private int maxAllowedIncorrectTries;

  public Hangman()
  {
    this.secretWord = new StringBuffer(chooseSecretWord());
    this.allLetters = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWYXZ");
    this.maxAllowedIncorrectTries = 6;
    this.numberOfIncorrectTries = 0;
    this.usedLetters = new StringBuffer("");
    this.knownSoFar = new StringBuffer("");

    for ( int i = 0; i < secretWord.length(); i++)
    {
      this.knownSoFar.append('*');
    }

  }

  public int getNumOfIncorrectTries() {
    return numberOfIncorrectTries;
  }

  public int getMaxAllowedIncorrectTries() {
    return maxAllowedIncorrectTries;
  }

  public String getAllLetters() {
    return allLetters.toString();
  }

  public String getUsedLetters() {
    return usedLetters.toString();
  }

  public String getKnownSoFar() {
    return knownSoFar.toString();
  }

  public boolean isGameOver() {
    if ( knownSoFar.toString().equals(secretWord.toString()) || hasLost() ) {
      return true;
    }
    else {
      return false;
    }
  }

  public boolean hasLost() {
    if ( numberOfIncorrectTries > maxAllowedIncorrectTries ) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * @param letter the letter that are tried by the user.
   * @return count shows how many letters found.
   * @return -1 if the letter is not valid.
   * @return -2 if the letter was already used.
   * @return -3 if the game is over.
   */
  public int tryThis(char letter)
  {
    int count;
    boolean found;
	
	count = 0;
    found = false;
    numberOfIncorrectTries++;
	
    for(int a = 0; a < usedLetters.length(); a++)
    {
      if ( letter == usedLetters.charAt(a))
      {
        found = true;
      }
    }
	
    if ( !found )
    {
      usedLetters.append(letter);
      for(int i = 0; i < secretWord.length(); i++)
      {
        if ( letter == secretWord.charAt(i))
        {
          knownSoFar.replace(i,i+1,letter + "");
          count++;
        }
      }
      if ( count == 0 )
      {
        return -1;
      }
      else if( (knownSoFar.toString()).equals(secretWord.toString()))
      {
        return -3;
      }
      else
      {
        return count;
      }
    }
    else{
      return -2;
    }
  }

  private String chooseSecretWord() {

    int choosen;
    String[] words = {"apple","pencil","human","water","sense","pirate","trust"};

    choosen = ((int)(Math.random()*1000)) % words.length;

    return words[choosen];
  }
}
  
  