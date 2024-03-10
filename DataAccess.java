import java.io.*;
import java.util.ArrayList;

public class DataAccess {
    public void writeLine(String address, String data){
        try (FileWriter fw = new FileWriter(address);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(data);
            System.out.println("Data written to " + address);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeArrayListToFile(String address, ArrayList<String> list){
        try (FileWriter fw = new FileWriter(address);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (String item : list) {
                bw.write(item);
                bw.newLine(); // Add a newline after each item
            }
            System.out.println("Data written to " + address);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String readLine(String address) {
        try (FileReader fr = new FileReader(address);
             BufferedReader br = new BufferedReader(fr)) {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
