import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.ArrayList;
public class ExperimentManager {
    public static void saveData(String value) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("data/experiments.txt", true));
        writer.write(value);
        writer.newLine();
        writer.close();
    }

    public static ArrayList<NewExperiment> loadExperiments(String filePath) throws Exception {
        ArrayList<NewExperiment> newExperiments = new ArrayList<>();
        ArrayList<Notice> notices = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int index = 0;
        String line;
        NewExperiment currentExperiment = new NewExperiment(null,null,null,null);
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("NewExperiment")) {
                String txtExperiment[] = line.split("\\s+");
                currentExperiment = new NewExperiment(txtExperiment[1], txtExperiment[2], txtExperiment[3], txtExperiment[4]);
                newExperiments.add(currentExperiment);
                currentExperiment.setNotices(notices);
                index++;
            }
            else if (line.startsWith("Notice")){
                String txtNotice[] = line.split("\\s+");
                notices.add(new Notice(txtNotice[1],txtNotice[2]));
            }
        }
        return newExperiments;
    }
}

