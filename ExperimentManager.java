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
                        String[] txtNotice = line.split("\\s+");
                        currentExperiment.addNotice(txtNotice[1], txtNotice[2]);
                    } else if (line.startsWith("Input")) {
                        String[] txtInput = line.split("\\s+");
                        currentExperiment.addInput(txtInput[1], txtInput[2]);
                    } else if (line.startsWith("Timer")) {
                        String[] txtTimer = line.split("\\s+");
                        currentExperiment.addTimer(txtTimer[1], txtTimer[2]);
                    } else if (line.startsWith("Vas")) {
                        String[] txtVas = line.split("\\s+");
                        currentExperiment.addVas(txtVas[1], txtVas[2]);
                    } else if (line.startsWith("gLMS")) {
                        String[] txtgLMS = line.split("\\s+");
                        currentExperiment.addgLMS(txtgLMS[1], txtgLMS[2]);
                    } else if (line.startsWith("Question")) {
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

        /*ArrayList<Notice> notices = new ArrayList<>();
        ArrayList<Input> inputs = new ArrayList<>();
        ArrayList<Timer> timers = new ArrayList<>();
        ArrayList<Vas> vass = new ArrayList<>();
        ArrayList<gLMS> glmss = new ArrayList<>();
        ArrayList<Question> quess = new ArrayList<>();
        String line;
        int count=0;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("NewExperiment")) {
                String[] txtExperiment;
                txtExperiment = line.split("\\s+");
                NewExperiment currentExperiment = new NewExperiment(txtExperiment[1], txtExperiment[2], txtExperiment[3], txtExperiment[4]);
                newExperiments.add(currentExperiment);
                count++;
            }
            if (line.startsWith("Notice")) {
                String[] txtStage;
                txtStage = line.split("\\s+");
                notices.add(new Notice(txtStage[1], txtStage[2]));
                newExperiments.get(count).setNotices(notices);

            }
            if (line.startsWith("Input")) {
                String[] txtStage;
                txtStage = line.split("\\s+");
                inputs.add(new Input(txtStage[1], txtStage[2]));
                newExperiments.get(count).setInputs(inputs);

            }
            if (line.startsWith("Timer")) {
                String[] txtStage;
                txtStage = line.split("\\s+");
                timers.add(new Timer(txtStage[1], txtStage[2]));
                newExperiments.get(count).setTimers(timers);

            }
            if (line.startsWith("Vas")) {
                String[] txtStage;
                txtStage = line.split("\\s+");
                vass.add(new Vas(txtStage[1], txtStage[2]));
                newExperiments.get(count).setVass(vass);

            }
            if (line.startsWith("gLMS")) {
                String[] txtStage;
                txtStage = line.split("\\s+");
                glmss.add(new gLMS(txtStage[1], txtStage[2]));
                newExperiments.get(count).setGlmss(glmss);

            }
            if (line.startsWith("Question")) {
                String[] txtStage;
                txtStage = line.split("\\s+");
                quess.add(new Question(txtStage[1], txtStage[2]));
                newExperiments.get(count).setQuess(quess);
            }
        }
        return newExperiments;
    }*/
}

