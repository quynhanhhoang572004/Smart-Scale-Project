import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class ExperimentManager {
    public static void saveExperiments(List<NewExperiment> experiments, String filePath) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        // Write a header line (optional)
        writer.write("------ Experiment Data ------");
        writer.newLine();

        for (NewExperiment experiment : experiments) {
            writer.write("Creator: " + experiment.getCreatorName());
            writer.newLine();
            writer.write("Experiment Name: " + experiment.getExName());
            writer.newLine();
            writer.write("Description: " + experiment.getExDescription());
            writer.newLine();

            // Write notes with indentation
            String addNote = experiment.getAddNote();
            if (!addNote.isEmpty()) {
                writer.write("  Notes:");
                writer.newLine();
                writer.write("    - " + addNote);  // Write the entire note directly
                writer.newLine();
            }

            writer.write("------------------------------");
            writer.newLine();
        }

        writer.close();
    }
}
