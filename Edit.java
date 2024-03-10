
import java.util.Scanner;

public class Edit{
    private Experiment experiment;
    private Showing showing;
    String Creator = "Mia";
    String Name = "Hungry level";
    public Edit() {
        Scanner sc = new Scanner(System.in);
        experiment = new Experiment(this);
        showing = new Showing(Creator,Name,experiment);
        boolean End = false;
        System.out.println("-----------------------Open------------------------");
        while(!End){
            System.out.println("Choose your choice: Add(a), Show(s), End(e):");
            String choice = sc.nextLine();
            switch(choice){
                case "a":
                    System.out.println("Choose your stage you want to add 1 to 6");
                    int stage = sc.nextInt();
                    showing.addStage(stage);
                    break;
                case "s":
                    showing.show();
                    break;
                case "e":
                    End = true;
                    System.out.println("-----------------------Close------------------------");
                    break;
                default:
                    break;
            }
        }
    }
}



