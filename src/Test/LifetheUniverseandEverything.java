package Test;

import java.io.FileInputStream;
import java.util.Scanner;

public class LifetheUniverseandEverything {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		while (true) {
            int number = scanner.nextInt();

            // Check if the number is 42, if yes, break out of the loop
            if (number == 42) {
                break;
            }

            // Otherwise, print the number
            System.out.println(number);
        }
	}

}
