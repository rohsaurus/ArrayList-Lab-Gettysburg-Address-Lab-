/**
 * Rohan Parikh
 * Employee Lab
 * 25 October 2021
 */
 import java.util.ArrayList;
 import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    File xyz = new File ("Address.txt");
    try {
    Scanner file = new Scanner(xyz);
    }
    catch (FileNotFoundException) {
      System.out.println("Exception");
    }
    int counter = 0;
    ArrayList<String> x = new ArrayList<String> ();
    while (file.hasNextLine()) {
      String data = file.nextLine();
      x.add(data);
      System.out.println(data);
    }
  }
}