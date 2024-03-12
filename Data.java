import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data{

    private ArrayList<NewExperiment> news;
    public Data(){
        Scanner sc = new Scanner(System.in);
        news = new ArrayList<>();
        boolean End = false;
        System.out.println("-----------------------Open------------------------");
        while(!End){
            System.out.println("Choose your choice: New Experiment(n), Edit Experiment(e), Results (r), Stop(s):");
            String choice = sc.nextLine();
            String titleEn, contentEn;
            switch(choice){
                case "n":
                    newEx();
                    break;
                case "e":
                    int count = 1;
                    for (NewExperiment newex: news) {
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
                            break;
                        case 2:
                            news.get(count).addInput(titleEn, contentEn);
                            break;
                        case 3:
                            news.get(count).addTimer(titleEn, contentEn);
                            break;
                        case 4:
                            news.get(count).addVas(titleEn,contentEn);
                            break;
                        case 5:
                            news.get(count).addgLMS(titleEn,contentEn);
                            break;
                        case 6:
                            news.get(count).addQues(titleEn,contentEn);
                            break;
                        default:
                            break;
                    }
                    break;
                case "r":
                    for (NewExperiment newex: news) {
                        newex.show();
                    }
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
    public void newEx(){
        NewExperiment newex = new NewExperiment();
        news.add(newex);
        try {
            ExperimentManager.saveExperiments(news, "data/experiments.txt");  // Pass a list containing the experiment and the desired file path
            System.out.println("Experiment saved successfully to: data/experiments.txt");
        } catch (Exception e) {
            System.out.println("Error saving experiment: " + e.getMessage());
        }
    }
}