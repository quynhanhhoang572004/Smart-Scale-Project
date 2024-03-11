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
            writer.write("{[" + experiment.getCreatorName() + "],");
            writer.write("[" + experiment.getExName() + "],");
            writer.write("[" + experiment.getExDescription() + "]}");
            writer.newLine();
            // Write notes with indentation
            String addNote = experiment.getAddNote();
            if (!addNote.isEmpty()) {
                writer.write("\t Notes: " + addNote);
                writer.newLine();
            }
            writer.write("***** Details *****");
            writer.newLine();
            if (!experiment.getVass().isEmpty()) {
                writer.write("\t *** Vas ***");
                writer.newLine();
                for (Vas v : experiment.getVass()) {
                    writer.write(v.getTitle() + " | " + v.getContent());
                    writer.newLine();
                }
            }
            if (!experiment.getGlmss().isEmpty()) {
                writer.write("\t *** gLMS ***");
                writer.newLine();
                for (gLMS g : experiment.getGlmss()) {
                    writer.write(g.getTitle() + " | " + g.getContent());
                    writer.newLine();
                }
            }
            if (!experiment.getQuess().isEmpty()) {
                writer.write("\t *** Question ***");
                writer.newLine();
                for (Question q : experiment.getQuess()) {
                    writer.write(q.getTitle() + " | " + q.getContent());
                    writer.newLine();
                }
            }
            if (!experiment.getInputs().isEmpty()) {
                writer.write("\t *** Input ***");
                writer.newLine();
                for (Input i : experiment.getInputs()) {
                    writer.write(i.getTitle() + " | " + i.getContent());
                    writer.newLine();
                }
            }
            if (!experiment.getNotices().isEmpty()) {
                writer.write("\t *** Notice ***");
                writer.newLine();
                for (Notice n : experiment.getNotices()) {
                    writer.write(n.getTitle() + " | " + n.getContent());
                    writer.newLine();
                }
            }
            if (!experiment.getTimers().isEmpty()) {
                writer.write("\t *** Timer ***");
                writer.newLine();
                for (Timer t : experiment.getTimers()) {
                    writer.write(t.getTitle() + " | " + t.getContent());
                    writer.newLine();
                }
            }
            writer.write("------ End line ------");
            writer.newLine();
            writer.close();
        }
    }

    public static List<NewExperiment> loadExperiments(String filePath) throws Exception {
        List<NewExperiment> experiments = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.equals("------ Experiment Data ------")) {
                NewExperiment experiment = new NewExperiment();

                // Creator Name
                line = reader.readLine();  // Read the next line
                experiment.setCreatorName(line.substring(1, line.length() - 1));  // Extract name (remove brackets)

                // Experiment Name
                line = reader.readLine();
                experiment.setExName(line.substring(1, line.length() - 1));

                // Experiment Description
                line = reader.readLine();
                experiment.setExDescription(line.substring(1, line.length() - 1));

                // Notes (optional)
                line = reader.readLine();
                if (line.startsWith("\t Notes: ")) {
                    experiment.setAddNote(line.substring(9));  // Extract note content (remove prefix)
                }

                // Details (Vas, gLMS, Question, Input, Timer)
                while ((line = reader.readLine()) != null && !line.equals("------ End line ------")) {
                    if (line.startsWith("\t *** ")) {
                        String section = line.substring(3, line.indexOf(" ***"));  // Extract section name (e.g., Vas)
                        while ((line = reader.readLine()) != null && !line.isEmpty()) {  // Read details until empty line
                            String[] content = line.split(" \\| ");  // Split details by pipe delimiter
                            switch (section) {
                                case "Vas":
                                    experiment.addVas(content[0], content[1]);
                                    break;
                                case "gLMS":
                                    experiment.addgLMS(content[0], content[1]);
                                    break;
                                case "Question":
                                    experiment.addQues(content[0], content[1]);
                                    break;
                                case "Input":
                                    experiment.addInput(content[0], content[1]);
                                    break;
                                case "Timer":
                                    experiment.addTimer(content[0],content[1]);
                                    break;
                            }
                        }
                    }
                }

                experiments.add(experiment);
            }
        }

        reader.close();
        return experiments;
    }
}


