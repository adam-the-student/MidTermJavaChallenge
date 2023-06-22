import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Scanner {
    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Please enter a file path: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        ArrayList<String> fileData = new ArrayList<>();
        ArrayList<String> noiseData = new ArrayList<>();

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
            for (int i = 0; i<fileData.size(); i++){
                String x = fileData.get(i);
                if (x.length()>4){
                    noiseData.add(x);
                    fileData.remove(i);
                }
            }
            HashMap<Integer, Integer> valMaxMinGD = new HashMap<Integer, Integer>();
            for (int i = 0; i < fileData.size(); i++){
                String X = fileData.get(i);
                int x = Integer.parseInt(X);
                if (valMaxMinGD.containsKey(x)){
                    int y = valMaxMinGD.get(x) + 1;
                    valMaxMinGD.put(x , y);
                }
                else {
                    valMaxMinGD.put(x,1);
                }

            }
            for (Integer i : valMaxMinGD.keySet()) {
                System.out.println("Value: " + i + " Reps: " + valMaxMinGD.get(i));
            }


        }
        catch (FileNotFoundException e){
            System.out.println("Error trying to read the file: " + e.toString());
        }




    }
}
// C:\Users\Adam\repos\MidTermJavaChallenge\Test.txt