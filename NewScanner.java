import java.io.*;
import java.util.Scanner;

public class NewScanner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a file path: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        short currData=0;
        short maxNoise = 0;
        short minNoise = Short.MAX_VALUE;
        short counter = 0;
        short maxRep=0;
        short minRep=0;
        short minRepCounter=0;
        short maxRepCounter=0;
        System.out.println("Trying to read from that file...");
        scanner.close();
        try {
             Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextShort()) {
                short data = fileScanner.nextShort();

                if (data < 3000) {
                    if (currData == data) {
                        counter++;
                    } else if (counter <= minRepCounter && currData > 2000) {
                        currData = data;
                        minRepCounter = counter;
                        minRep = currData;
                        counter = 1;
                    }
                    else if (counter >= maxRepCounter) {
                        currData = data;
                        maxRepCounter = counter;
                        maxRep = currData;
                        counter = 1;
                    }
                } else if (data > maxNoise) {
                    maxNoise = data;
                } else if (data < minNoise) {
                    minNoise = data;
                }

            }
            fileScanner.close();
            System.out.println("Most Frequent GOOD Value: " + maxRep + ". " + "Number of Reps: " + maxRepCounter + ".");
            System.out.println("Least Frequent GOOD Value: " + minRep + ". " + "Number of Reps: " + minRepCounter + ".");
            System.out.println("Largest NOISE Value: " + maxNoise);
            System.out.println("Smallest NOISE Value: " + minNoise);
        } catch (Exception e) {
            System.out.println("Error trying to read the file: " +e);
        }
    }

}