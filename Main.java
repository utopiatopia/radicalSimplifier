import java.util.Scanner;
import java.lang.Math;

class Main {
  public static void main(String[] args) {
    System.out.println("This program is licenced under the MIT License by utopiatopia.\nSource available here: https://github.com/utopiatopia/radicalSimplifier\n");
    // Getting input
    Scanner inputScanner = new Scanner(System.in);
    System.out.print("What is the radical? ");
    long radiand = inputScanner.nextLong();

    // Checking if the solution is imaginary.
    String isImaginary = "";
    if (radiand<0) {
      isImaginary = "i";
      radiand = Math.abs(radiand);
    }


    // Check for a perfect square
    double squareRoot = Math.sqrt(radiand);
    if (squareRoot==(long)squareRoot) {
      System.out.println("The simplified radical is " + (long)squareRoot + isImaginary);
      return;
    }

    // Initializing variables
    long outsideRadical = 1;
    int i = 3;

    // Checking if four can be taken out.
    while (radiand%4==0) {
      radiand /= 4; // Removing that perfect square
      outsideRadical *= 2; // Adding the perfect square to the outside
    }

    // Checking if i squared is greater than the radiand. You can't divide (take out) a pair if the pair is greater than the radiand.
    while (i<=(int)Math.sqrt(radiand)) {
      System.out.println(100.0*i/(int)Math.sqrt(radiand) +"%"); // Progress indicator

      // Checking if a perfect square can be taken out of the radiand (number inside the radical)
      while (radiand%(i*i)== 0) {
        radiand /= i*i; // Removing that perfect square
        outsideRadical *= i; // Adding the perfect square to the outside
      }
      // My reasoning behind this is complex. Ask me during class if you want my reasoning. I don't want to type it out.
      i += 2;
    }
    
    // Outputting the result.
    if (outsideRadical==1) {
      if (isImaginary.equals("i")) {
        System.out.println("The simplified radical is i√" + radiand + ".");
      } else {
        System.out.println("The radical √" + radiand + " cannot be simplified.");
      }
    } else {
      System.out.println("The simplified radical is " + outsideRadical + isImaginary + "√" + radiand + ".");
    }
  }
}
