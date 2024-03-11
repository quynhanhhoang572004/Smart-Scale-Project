import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ExperimentManager {
    public static void saveExperiments(List<NewExperiment> experiments, String filePath) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        for (NewExperiment experiment : experiments) {
            // Write a header line (optional)
            writer.write("------ Experiment Data ------");
            writer.newLine();
            writer.write("{["+experiment.getCreatorName()+"],");
            writer.write("["+experiment.getExName()+"],");
            writer.write("["+experiment.getExDescription()+"],");
            writer.newLine();
            // Write notes with indentation
            String addNote = experiment.getAddNote();
            if (!addNote.isEmpty()) {
                writer.write("  Notes:" + addNote);
                writer.newLine();
            }
            writer.write("***** Details *****");
            writer.newLine();
            if(!experiment.getVass().isEmpty()){
                writer.write("*** Vas ***");
                writer.newLine();
                for(Vas v : experiment.getVass()){
                    writer.write(v.getTitle() + " | " + v.getContent());
                    writer.newLine();
                }
            }
            if(!experiment.getGlmss().isEmpty()){
                writer.write("*** gLMS ***");
                writer.newLine();
                for(gLMS g : experiment.getGlmss()){
                    writer.write(g.getTitle() + " | " + g.getContent());
                    writer.newLine();
                }
            }
            if(!experiment.getQuess().isEmpty()){
                writer.write("*** Question ***");
                writer.newLine();
                for(Question q : experiment.getQuess()){
                    writer.write(q.getTitle() + " | " + q.getContent());
                    writer.newLine();
                }
            }
            if(!experiment.getInputs().isEmpty()){
                writer.write("*** Input ***");
                writer.newLine();
                for(Input i : experiment.getInputs()){
                    writer.write(i.getTitle() + " | " + i.getContent());
                    writer.newLine();
                }
            }
            if(!experiment.getTimers().isEmpty()){
                writer.write("*** Timer ***");
                writer.newLine();
                for(Timer t : experiment.getTimers()){
                    writer.write(t.getTitle() + " | " + t.getContent());
                    writer.newLine();
                }
            }
        writer.close();
        }
    }

    public static List<NewExperiment> loadExperiments(String filePath) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<NewExperiment> experiments = new ArrayList<>();
        NewExperiment currentExperiment = null;
        StringBuilder vasContent = new StringBuilder();
        StringBuilder gLMSContent = new StringBuilder();
        StringBuilder questionContent = new StringBuilder();
        StringBuilder inputContent = new StringBuilder();
        StringBuilder timerContent = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            // Identify experiment sections based on keywords
            if (line.startsWith("------ Experiment Data ------")) {
                currentExperiment = new NewExperiment();
                vasContent = new StringBuilder();  // Reset detail section builders
                gLMSContent = new StringBuilder();
                questionContent = new StringBuilder();
                inputContent = new StringBuilder();
                timerContent = new StringBuilder();
            } else if (line.startsWith("Creator:")) {
                if (currentExperiment != null) {
                    currentExperiment.setCreatorName(line.substring(line.indexOf(":") + 1).trim());
                }
            } else if (line.startsWith("Experiment Name:")) {
                if (currentExperiment != null) {
                    currentExperiment.setExName(line.substring(line.indexOf(":") + 1).trim());
                }
            } else if (line.startsWith("Description:")) {
                if (currentExperiment != null) {
                    currentExperiment.setExDescription(line.substring(line.indexOf(":") + 1).trim());
                }
            } else if (line.startsWith("  Notes:")) {
                if (currentExperiment != null) {
                    StringBuilder notes = new StringBuilder();
                    while ((line = reader.readLine()) != null && line.trim().length() > 0) {
                        notes.append(line.substring(2).trim()).append("\n");
                    }
                    currentExperiment.setAddNote(notes.toString().trim());
                }
            } else if (line.startsWith("*** Vas ***")) {
                vasContent = new StringBuilder();  // Reset builder for new Vas section
            } else if (line.startsWith("*** gLMS ***")) {
                gLMSContent = new StringBuilder();  // Reset builder for new gLMS section
            } else if (line.startsWith("*** Question ***")) {
                questionContent = new StringBuilder();  // Reset builder for new Question section
            } else if (line.startsWith("*** Input ***")) {
                inputContent = new StringBuilder();  // Reset builder for new Input section
            } else if (line.startsWith("*** Timer ***")) {
                timerContent = new StringBuilder();  // Reset builder for new Timer section
            } else if (line.startsWith("***** Details *****")) {
                continue;
            } else if (!line.trim().isEmpty() && !line.startsWith("---")) {  // Valid detail content line
                if (!vasContent.isEmpty()) {
                    vasContent.append("\n").append(line);
                } else if (!gLMSContent.isEmpty()) {
                    gLMSContent.append("\n").append(line);
                } else if (!questionContent.isEmpty()) {
                    questionContent.append("\n").append(line);
                } else if (!inputContent.isEmpty()) {
                    inputContent.append("\n").append(line);
                } else if (!timerContent.isEmpty()) {
                    timerContent.append("\n").append(line);
                }
            } else if (line.startsWith("------------------------------")) {
                if (currentExperiment != null) {
                    if (!vasContent.isEmpty()) {
                        parseVasContent(currentExperiment, vasContent.toString());  // Parse Vas content after section ends
                    }
                    if (!gLMSContent.isEmpty()) {
                        parsegLMSContent(currentExperiment, gLMSContent.toString());  // Parse gLMS content
                    }
                    if (!questionContent.isEmpty()) {
                        parseQuestionContent(currentExperiment, questionContent.toString());  // Parse Question content
                    }
                    if (!inputContent.isEmpty()) {
                        parseInputContent(currentExperiment, inputContent.toString());  // Parse Input content
                    }
                    if (!timerContent.isEmpty()){
                        parseTimerContent(currentExperiment, timerContent.toString());  // Parse Timer content
                    }

                }
            }
        }
        return experiments;
    }

    private static void parseTimerContent(NewExperiment currentExperiment, String string) {
    }

    private static void parseVasContent(NewExperiment currentExperiment, String string) {

    }

    private static void parsegLMSContent(NewExperiment currentExperiment, String string) {

    }

    private static void parseQuestionContent(NewExperiment currentExperiment, String string) {

    }

    private static void parseInputContent(NewExperiment currentExperiment, String string) {

    }
}


