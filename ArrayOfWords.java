import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayOfWords {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            File file = new File("src/ScrambleWordFile.txt");
            Scanner scan = new Scanner(file);
            System.out.println(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String array[] = line.split(",");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}