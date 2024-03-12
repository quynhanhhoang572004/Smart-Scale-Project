import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExperimentManager {
    public static void saveData(String value) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("data/experiments.txt", false));
        writer.write(value);
        writer.newLine();
        writer.close();
    }

    public static ArrayList<NewExperiment> loadExperiments(String filePath) throws Exception {
        ArrayList<NewExperiment> experiments = new ArrayList<>();
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
                }experiments.add(experiment);
            }
        }

        reader.close();
        return experiments;
    }
}


