import javax.management.NotificationEmitter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExperimentManager {
    public static void saveData(String value) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("data/experiments.txt", true));
        writer.write(value);
        writer.newLine();
        writer.close();
    }

    public static ArrayList<NewExperiment> loadExperiments(String filePath) throws Exception {
        ArrayList<NewExperiment> newExperiments = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<String> noticeLines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            NewExperiment currentExperiment = null;
            if (line.startsWith("Experiment")) {
                String txtExperiment[] = line.split("\\s+");
                currentExperiment = new NewExperiment(txtExperiment[1], txtExperiment[2], txtExperiment[3], txtExperiment[4]);
                newExperiments.add(currentExperiment);
                noticeLines.clear();
            } else if (line.startsWith("Notice")) {
                // Add notices to the current experiment (if any)
                if (currentExperiment != null) {
                    noticeLines.add(line); // Buffer notice lines until the next Experiment
                }
                // Attach buffered notices to the first experiment
                if (!noticeLines.isEmpty() && !newExperiments.isEmpty()) {
                    for (String noticeLine : noticeLines) {
                        String[] txtNotice = noticeLine.split("\\s+");
                        currentExperiment = newExperiments.get(0); // Get the first experiment
                        currentExperiment.addNotice(txtNotice[1], txtNotice[2]);
                    }
                }
            }
        }
        return newExperiments;
    }
}

