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
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        ArrayList<NewExperiment> newExperiments = new ArrayList<>();
        ArrayList<Notice> notices = new ArrayList<>();
        ArrayList<Input> inputs = new ArrayList<>();
        ArrayList<Timer> timers = new ArrayList<>();
        ArrayList<Vas> vass = new ArrayList<>();
        ArrayList<gLMS> glmss = new ArrayList<>();
        ArrayList<Question> quess = new ArrayList<>();

        String line;

        NewExperiment currentExperiment = new NewExperiment(null,null,null,null);



        while ((line = reader.readLine()) != null) {
            if (line.startsWith("NewExperiment")) {
                String[] txtExperiment;
                txtExperiment = line.split("\\s+");
                currentExperiment = new NewExperiment(txtExperiment[1], txtExperiment[2], txtExperiment[3], txtExperiment[4]);
                newExperiments.add(currentExperiment);

            }
            if (line.startsWith("Notice")){
                String[] txtStage;
                txtStage = line.split("\\s+");
                notices.add(new Notice(txtStage[1],txtStage[2]));
                currentExperiment.setNotices(notices);

            }
            if (line.startsWith("Input")){
                String[] txtStage;
                txtStage = line.split("\\s+");
                inputs.add(new Input(txtStage[1],txtStage[2]));
                currentExperiment.setInputs(inputs);

            }
            if (line.startsWith("Timer")){
                String[] txtStage;
                txtStage = line.split("\\s+");
                timers.add(new Timer(txtStage[1],txtStage[2]));
                currentExperiment.setTimers(timers);

            }
            if (line.startsWith("Vas")){
                String[] txtStage;
                txtStage = line.split("\\s+");
                vass.add(new Vas(txtStage[1],txtStage[2]));
                currentExperiment.setVass(vass);

            }
            if (line.startsWith("gLMS")){
                String[] txtStage;
                txtStage = line.split("\\s+");
                glmss.add(new gLMS(txtStage[1],txtStage[2]));
                currentExperiment.setGlmss(glmss);

            }
            if(line.startsWith("Question")){
                String[] txtStage;
                txtStage = line.split("\\s+");
                quess.add(new Question(txtStage[1],txtStage[2]));
                currentExperiment.setQuess(quess);

            }
        }
        return newExperiments;
    }
}

