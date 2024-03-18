import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Data extends ExperimentManager {

    private ArrayList<NewExperiment> news;

    public Data() throws Exception {
        Scanner sc = new Scanner(System.in);
        news = new ArrayList<>();
        boolean End = false;
        System.out.println("-----------------------Open------------------------");
        while (!End) {
            System.out.println("Choose your choice: New Experiment(n), Edit Experiment(e), Results (r), Stop(s), Load(l):");
            String choice = sc.nextLine();
            String titleEn, contentEn;
            switch (choice) {
                case "n":
                    newEx();
                    break;
                case "e":
                    int count = 1;
                    for (NewExperiment newex : news) {
                        System.out.print(count + ". Creator name: " + newex.getCreatorName() + "\n  Experiment Name: " + newex.getExName() + "\n");
                        count++;
                    }
                    System.out.println("Choose the experiment you want to edit:");
                    count = sc.nextInt() - 1;
                    System.out.println("Choose the stage you want to add:");
                    int stage = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the title: ");
                    titleEn = sc.nextLine();
                    System.out.print("Enter the content: ");
                    contentEn = sc.nextLine();
                    news.get(count).addStage(stage);
                    switch (stage) {
                        case 1:
                            news.get(count).addNotice(titleEn, contentEn);
                            saveData((new Notice(titleEn, contentEn)).toString());
                            break;
                        case 2:
                            news.get(count).addInput(titleEn, contentEn);
                            saveData((new Input(titleEn, contentEn)).toString());
                            break;
                        case 3:
                            news.get(count).addTimer(titleEn, contentEn);
                            saveData((new Timer(titleEn, contentEn)).toString());
                            break;
                        case 4:
                            news.get(count).addVas(titleEn, contentEn);
                            saveData((new Vas(titleEn, contentEn)).toString());
                            break;
                        case 5:
                            news.get(count).addgLMS(titleEn, contentEn);
                            saveData((new gLMS(titleEn, contentEn)).toString());
                            break;
                        case 6:
                            news.get(count).addQues(titleEn, contentEn);
                            saveData((new Question(titleEn, contentEn)).toString());
                            break;
                        default:
                            break;
                    }
                    break;
                case "r":
                    for (NewExperiment newex : news) {
                        newex.show();
                    }
                    break;
                case "l":
                    this.news = loadExperiments(this.news, "data/experiments.txt");
                    this.news = loadOldExperiments(this.news, "data/data.txt");
                    break;
                case "s":
                    End = true;
                    System.out.println("-----------------------Close------------------------");
                    break;
                default:
                    break;
            }
        }
    }

    public void newEx() throws IOException {
        NewExperiment newex = new NewExperiment();
        news.add(newex);
        saveData(newex.toString());
    }
}
