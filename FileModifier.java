//import java.io.*;
//import java.util.ArrayList;
//
//public class FileModifier {
//    String oldFilePath;
//    String NewFilePath;
//
//    public FileModifier() throws IOException {
//        NewFilePath = "Data/Experiment.txt";
//        oldFilePath = "Data/data.txt";
//        BufferedReader reader = new BufferedReader(new FileReader(oldFilePath));
//        BufferedWriter writer = new BufferedWriter(new FileWriter(NewFilePath, true));
//
//
//    }
//    public static writeOldExperiment(){
//
//    }
//
//
//    public static ArrayList<NewExperiment> loadOldExperiments(ArrayList<NewExperiment> newExperiments, String filePath) throws Exception {
//        NewExperiment currentExperiment = null;
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String currentExperimentName = null;
//
//                if (line.startsWith("ExperimentName")) {
//                    currentExperimentName = line.split(": ")[1].trim(); // Extract and store ExperimentName
//                } else if (line.startsWith("ExperimenterName")) {
//                    String experimenterName = line.split(": ")[1].trim(); // Extract ExperimenterName
//
//                    String[] txtExperiment = {currentExperimentName, experimenterName}; // Assuming these are the only 2 fields after ":"
//                    currentExperiment = new NewExperiment(txtExperiment[0], txtExperiment[1], null, null); // Modify based on your actual constructor arguments
//                    newExperiments.add(currentExperiment);
//
//                }
//            }
//        }
//        return newExperiments;
//    }
//}