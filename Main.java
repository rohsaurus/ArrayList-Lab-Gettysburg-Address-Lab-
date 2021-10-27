/**
 * Rohan Parikh
 * Employee Lab
 * 25 October 2021 - 27 October 2021
 */
 import java.util.ArrayList;
 import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
class Main {
  public Main() {
  }

  public static void main(String[] args) {
      // importing file and printing value
    try {
    File xyz = new File ("Address.txt");
    Scanner file = new Scanner(xyz);
    int counter = 0;
      ArrayList<String> x = new ArrayList<String> ();
      while (file.hasNextLine()) {
        // printing each word on a separate line
        String data = file.next();
        // adding the words to the arraylist
        x.add(data);
        // printing the arraylist
        System.out.println(data);

      }
      System.out.println("");
      // method for finding the average word length
      findingAverageAndRounding(x);
      // Method for finding the longest word and its length
      findingLongestWordAndItsLength(x);
      // method for finding the amount of times a word apperas that the user requests
      findingUserWordFrequency(x);
      // method to store the list in lexicographic order
      sortingIntoLexicographicOrder(x);
      // removing duplicating words method
      duplicatingWordsRemoval(x);
    }
    catch (FileNotFoundException e) {
      System.out.println("Exception");
    }

  }

  // method to remove duplicate words
  private static void duplicatingWordsRemoval(ArrayList<String> x) {
    for (int i = 0; i<x.size(); i++) {
      for (int j = i+1; j < x.size();j++) {
        if (x.get(i).compareToIgnoreCase(x.get(j)) == 0) {
          x.remove(j);
        }
      }
    }
    System.out.println("Printing the arraylist with duplicated words removed.");
    System.out.println(x);
  }

  private static void sortingIntoLexicographicOrder(ArrayList<String> x) {
    // for loop to get order and sort
    for (int i = 0; i < x.size(); i++) {
      for (int j = i + 1; j < x.size(); j++) {
        if (x.get(i).compareToIgnoreCase(x.get(j)) > 0) {
          String temp = x.get(i);
          x.set(i, x.get(j));
          x.set(j, temp);
        }
      }
    }
    System.out.println("Printing the arraylist sorted in lexicographical order.");
    System.out.println(x);
  }

  // method for finding user word frequency
  private static void findingUserWordFrequency(ArrayList<String> x) {
    // asking user for their word
    Scanner in = new Scanner(System.in);
    System.out.println("Enter in a word, and the program will determine its frequency throughout the address.");
    String userWord = in.nextLine();
    int userCounter = 0;
    int theCounter = 0;
    for (String k: x) {
      if (k.equals(userWord)){
        userCounter++;
      }
      else if (k.equals("the")){
        theCounter++;
      }
    }
    System.out.println("Your word occurs " + userCounter + " times, and the word \"the\" occurs " + theCounter + " times");
  }

  // method for finding the longest word and length
  private static void findingLongestWordAndItsLength(ArrayList<String> x) {
    // finding the longest word and its length
    String longest = "";
    int longestLength = 0;
    for (String k: x) {
      if (k.length() > longestLength) {
        longest = k;
        longestLength = k.length();
      }
    }
    System.out.println("The longest word is " + longest + " with a length of " + longestLength + " characters");
  }

  private static void findingAverageAndRounding(ArrayList<String> temp) {
    // finding average word length
    double sum = 0;
    double speechLength = 265;
    for (String k: temp) {
      int size = k.length();
      sum += size;
    }
    double average = sum/speechLength;
    // truncating to the hundredths place
    String intToString = Double.toString(average);
    String finalValue = intToString.substring(0,4);
    // printing out the rounded decimal
    System.out.println("The average word length is " + finalValue + " words.");
  }
}