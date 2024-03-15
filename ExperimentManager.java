import java.io.*;
import java.util.ArrayList;

public class ExperimentManager {
    public static void saveData(String value) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("data/experiments.txt", true));
        writer.write(value);
        writer.newLine();
        writer.close();
    }

    public static ArrayList<NewExperiment> loadExperiments(ArrayList<NewExperiment> newExperiments, String filePath) throws Exception {
        NewExperiment currentExperiment = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("NewExperiment")) {
                    String[] txtExperiment = line.split("\\s+");
                    currentExperiment = new NewExperiment(txtExperiment[1], txtExperiment[2], txtExperiment[3], txtExperiment[4]);
                    newExperiments.add(currentExperiment);
                } else if (currentExperiment != null) {
                    if (line.startsWith("Notice")) {
                        currentExperiment.addStage(1);
                        String[] txtNotice = line.split("\\s+");
                        currentExperiment.addNotice(txtNotice[1], txtNotice[2]);
                    } else if (line.startsWith("Input")) {
                        currentExperiment.addStage(2);
                        String[] txtInput = line.split("\\s+");
                        currentExperiment.addInput(txtInput[1], txtInput[2]);
                    } else if (line.startsWith("Timer")) {
                        currentExperiment.addStage(3);
                        String[] txtTimer = line.split("\\s+");
                        currentExperiment.addTimer(txtTimer[1], txtTimer[2]);
                    } else if (line.startsWith("Vas")) {
                        currentExperiment.addStage(4);
                        String[] txtVas = line.split("\\s+");
                        currentExperiment.addVas(txtVas[1], txtVas[2]);
                    } else if (line.startsWith("gLMS")) {
                        currentExperiment.addStage(5);
                        String[] txtgLMS = line.split("\\s+");
                        currentExperiment.addgLMS(txtgLMS[1], txtgLMS[2]);
                    } else if (line.startsWith("Question")) {
                        currentExperiment.addStage(6);
                        String[] txtQuestion = line.split("\\s+");
                        currentExperiment.addQues(txtQuestion[1], txtQuestion[2]);
                    } else if (line.startsWith("END")) {
                        for (NewExperiment e : newExperiments) {
                            e.show();
                        }
                    }
                } else {
                    // Handle lines encountered before the first "NewExperiment" (optional)
                    System.out.println("Warning: Line encountered before first experiment: " + line); // Log a warning (optional)
                }
            }
        }
        return newExperiments;
    }
}

