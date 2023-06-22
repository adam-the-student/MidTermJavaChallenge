import java.io.*;
import java.util.ArrayList;

public class Scanner {
    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Please enter a file path: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        ArrayList<String> fileData = new ArrayList<>();

        System.out.println("Trying to read from that file...");
        try {
//            This doesn't have to be a Scanner, it could also be a BufferedReader or FileReader.
//            Another way to get all the text in the file is to use Files.readAllLines
            java.util.Scanner fileScanner = new java.util.Scanner(file);
            while (fileScanner.hasNextLine()){
                String data = fileScanner.nextLine();
                fileData.add(data);
            }
            fileScanner.close();
            System.out.println(fileData);
        }
        catch (FileNotFoundException e){
            System.out.println("Error trying to read the file: " + e.toString());
        }





    }
}
// C:\Users\Adam\repos\MidTermJavaChallenge\Test.txt