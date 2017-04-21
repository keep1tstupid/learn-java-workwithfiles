import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class MainFiles {
    public static void main(String[] args) throws IOException {
        File file1 = new File("test.txt");
        try (FileWriter fw = new FileWriter(file1);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("String 1" + "\n");
            bw.write("String 2" + "\n");
            bw.write("String 3" + "\n");
        } catch (IOException ex) {
            System.out.println();
        }

        ArrayList<String> fileData = new ArrayList<String>();

        try (FileReader fr = new FileReader("test.txt");
             BufferedReader br = new BufferedReader(fr)) {

            String line;

            while ((line = br.readLine()) != null) {
                fileData.add(line);
            }
        } catch (IOException ex) {
            System.out.println();
        }

        Collections.reverse(fileData);

        File file2 = new File("reversed.txt");
        try (FileWriter fw = new FileWriter(file2);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (String s : fileData) {
                bw.write(s + System.getProperty("line.separator"));
            }
            bw.close();
        } catch (IOException ex) {
            System.out.println();
        }

        try {
            if (file1.delete()) {
                System.out.println("File 1 is deleted.");
            } else {
                System.out.println("Something went wrong.");
            }
        } catch (IOException | SecurityException ex) {
            System.out.println(ex.toString());
        }
    }
}