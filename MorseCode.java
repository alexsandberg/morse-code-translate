/****
 * This program translates between English and Morse code.
 * Module 5 assignment
 * By: Alex Sandberg-Bernard
 ****/

// import Java scanner
import java.util.Scanner;

public class MorseCode
{
    public static void main( String[] args )
    {
        // initialize new scanner input
        Scanner input = new Scanner( System.in );

        // initialize array for English
        String[] english = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
                "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "0", " ", "" };

        // initialize array for Morse code
        String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
                ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
                "-..-", "-.--", "--..", ".----", "..---", "...--", "....-",
                ".....", "-....", "--...", "---..", "----.", "-----", "|",
                " " };

        System.out.println();
        System.out.println( "Morse code translation program" );

        // establish string for program do while loop
        String answer;

        // use do while loop to execute program repeatedly if desired
        do
            {
                // use while loop to verify valid entry of 1 or 2
                int entryNum = 0;
                while ( !( entryNum == 1 ) && !( entryNum == 2 ) )
                {
                    System.out.println( "\n" + "Enter a 1 to translate from " +
                            "English to Morse, or a 2 to translate from " +
                            "Morse to English: " );
                    entryNum = input.nextInt();
                }

                // execute program based on user choice of 1 or 2
                switch ( entryNum )
                {
                    case 1:
                    {
                        System.out.println( "\n" + "Translation: " +
                                englishToMorse( input, english, morse ) );
                        break;
                    }
                    case 2:
                    {
                        System.out.println( "\n" + "Translation: " +
                                morseToEnglish( input, english, morse ) );
                        break;
                    }
                }

                // prompt user to translate again or to exit program
                do
                {   // use do while loop to evaluate response validity
                    System.out.println( "\n" + "Would you like to do " +
                            "another translation? (enter Y/N): ");
                    answer = input.next();
                } while ( ( !"Y".equals(answer) ) && ( !"N".equals(answer) ) );

                // program will restart if answer = "Y"
            } while ( answer.equals( "Y" ) );
    }


    /****
     * The method englishToMorse() takes a string input in English by the user
     and translates to Morse code. It does this by comparing each character in
     the string to an array containing the English alphabet, recording the index
     of each match, using that index to find the matching Morse symbol
     in the Morse alphabet array, and then sequentially building a resulting
     translation string.
     *
     * Pre-conditions: String input by user is in English. String arrays for
     English and Morse are ordered so that index of characters correctly match.
     *
     * Post-conditions: Method will return correct translation from English to
     Morse code.
     ****/


    public static String englishToMorse( Scanner input, String[] english,
                                        String[] morse )
    {
        // prompt user to enter String and store in entryString
        System.out.println( "\n" + "Enter a sentence in English: " );
        input.nextLine();
        String entryString = input.nextLine();

        // remove all punctuation from String, store in lettersOnly
        String lettersOnly = entryString.replaceAll("\\p{Punct}",
                "" );

        // initialize variables for use in for loop
        int alphabetIndex = 0;
        String translation = "";

        // execute until length of lettersOnly has been reached
        for ( int index = 0; index < lettersOnly.length(); index++ )
        {
            // load each character into currentChar, then convert to String
            char currentChar = lettersOnly.charAt(index);
            String currentString = String.valueOf(currentChar);

            // search English symbols array for match with currentString
            for ( int indexInt = 0; indexInt < english.length; indexInt++ )
            {
                // use equalsIgnoreCase() to match regardless of case
                if ( english[indexInt].equalsIgnoreCase( currentString ) )
                {
                    alphabetIndex = indexInt; // if match is found, copy index
                    break;
                }
            }

            // index morse array for each alphabetIndex
            String currentString2 = morse[alphabetIndex];

            // build translation by successive concatenation of currentString2
            // add space after each letter
            translation += ( currentString2 + " " );
        }
        return translation; // return final translation to main
    }


    /****
     * The method morseToEnglish() takes a string input in Morse by the user
     and translates to English. It does this by first separating the input
     string into each individual morse character and storing those characters in
     a new array, then comparing each character in the array to an array
     containing the Morse alphabet, recording the index of each match, using
     that index to find the matching English symbol in the English alphabet
     array, and then sequentially building a resulting translation string.
     *
     * Pre-conditions: String input by user is in Morse code. String arrays for
     English and Morse are ordered so that index of characters correctly match.
     *
     * Post-conditions: Method will return correct translation from Morse code
     to English.
     ****/


    public static String morseToEnglish( Scanner input, String[] english,
                                         String[] morse )
    {
        // prompt user to enter String
        System.out.println( "\n" + "Enter a sentence in Morse: " );
        input.nextLine();
        String entryString = input.nextLine();

        // split string into parts (separated by spaces) then store in array
        String[] parts = entryString.split("\\ ");

        // initialize variables for use in loop
        int alphabetIndex = 0;
        String translation = "";

        // execute until length of parts array has been reached
        for ( int index = 0; index < parts.length; index++ )
        {
            // for each iteration, store string at value of index in tempString
            String tempString = parts[index];

            // search morse array for match with tempString
            for ( int indexInt = 0; indexInt < morse.length; indexInt++ )
            {
                if ( morse[indexInt].equals(tempString) )
                {
                    alphabetIndex = indexInt; // if match is found, copy index
                    break;
                }
            }

            // index english array for each alphabetIndex
            String currentString2 = english[alphabetIndex];

            // build translation by successive concatenation of currentString2
            translation += ( currentString2 );
        }
        return translation; // return final translation to main
    }
}
