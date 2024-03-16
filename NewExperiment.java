import java.util.ArrayList;
import java.util.Scanner;

public class NewExperiment extends ExperimentManager{
    private Data data;
    private String creatorName;
    private String exName;
    private String exDescription;
    private String addNote;
    private ArrayList<Vas> vass;
    private ArrayList<gLMS> glmss;
    private ArrayList<Question> quess;
    private ArrayList<Notice> notices;
    private ArrayList<Input> inputs;
    private ArrayList<Timer>timers;
    private ArrayList<Integer> tree;
    public static int count = 0;
    public NewExperiment(){
        super();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Creator: ");
        setCreatorName(sc.nextLine());
        System.out.print("Enter the Experiment Name: ");
        setExName(sc.nextLine());
        System.out.print("Enter the Experiment Description: ");
        setExDescription(sc.nextLine());
        System.out.print("Enter the Additional Notes: ");
        setAddNote(sc.nextLine());
        tree = new ArrayList<>();
        timers = new ArrayList<>();
        notices = new ArrayList<>();
        inputs=new ArrayList<>();
        vass = new ArrayList<>();
        glmss = new ArrayList<>();
        quess = new ArrayList<>();
    }

    public NewExperiment(String creatorName, String exName, String exDescription, String addNote) {
        this.creatorName = creatorName;
        this.exName = exName;
        this.exDescription = exDescription;
        this.addNote = addNote;
        tree = new ArrayList<>();
        timers = new ArrayList<>();
        notices = new ArrayList<>();
        inputs=new ArrayList<>();
        vass = new ArrayList<>();
        glmss = new ArrayList<>();
        quess = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "NewExperiment[\t" +
                creatorName +
                "\t" + exName +
                "\t" + exDescription+
                "\t" + addNote +
                "\t]";
    }

    public void addStage(int stage) {
        if (tree.isEmpty()) {
            tree.add(stage);
            count++;
        }
        else{
            boolean add = true;
            for (Integer tr : tree){
                //for (int i = 0 ; i < count ; i++ ){
                if (tr == stage){
                    add = false;
                    break;
                }
            }
            if (add) {
                count++;
                tree.add(stage);
            }
        }
    }
    public void addNotice(String title, String content) {
        Notice temp = new Notice(title,content);
        this.notices.add(temp);
        System.out.println("Add Notice is done");
    }
    public void addInput(String title, String content) {
        Input temp = new Input(title, content);
        this.inputs.add(temp);
        System.out.println(" Add Input is done");
    }
    public void addTimer(String title, String content) {
        Timer temp = new Timer(title,content);
        this.timers.add(temp);
        System.out.println(" Add Timer stage is done");

    }
    public void addVas(String title, String content) {
        Vas temp = new Vas(title,content);
        this.vass.add(temp);
        System.out.println("Add Vas is done");
    }
    public void addgLMS(String title, String content) {
        gLMS temp = new gLMS(title,content);
        this.glmss.add(temp);
        System.out.println("Add gLMS is done");
    }
    public void addQues(String title, String content) {
        Question temp = new Question(title,content);
        this.quess.add(temp);
        System.out.println("Add Question is done");
    }
    public void showNotice(){
        if (!notices.isEmpty()){
            System.out.println("-----------------------Stage 1: Notice Stage---------------------"); // Stag 1:
            for(Notice notice: notices)
                System.out.print("Title: " + notice.getTitle()+ "\nContent: "+ notice.getContent()+ "\n");
        }
    }

    public void showInput(){
        if (!inputs.isEmpty()){
            System.out.println("-----------------------Stage 2: Input Stage----------------------"); // Stag 2:
            for(Input input: inputs)
                System.out.print("Title: " + input.getTitle()+ "\nContent: "+ input.getContent()+ "\n");
        }
    }

    public void showTimer(){
        if (!timers.isEmpty()){
            System.out.println("-----------------------Stage 3: Timer Stage----------------------"); // Stag 3:
            for(Timer timer: timers)
                System.out.print("Title: "+ timer.getTitle() + "\nContent: "+ timer.getContent()+ "\n");
        }
    }

    public void showVas(){
        if (!vass.isEmpty()){
            System.out.println("-----------------------Stage 4: VAS Stage------------------------"); // Stag 4:
            for (Vas vas: vass)
                System.out.print("Title: " + vas.getTitle() + "\nContent: " + vas.getContent() + "\n");
        }
    }

    public void showgLms(){
        if (!notices.isEmpty()){
            System.out.println("-----------------------Stage 5: gLMS Stage ----------------------"); // Stage 5:
            for (gLMS glms: glmss)
                System.out.print("Title: " + glms.getTitle() + "\nContent: " + glms.getContent() + "\n");
        }
    }

    public void showQues(){
        if (!quess.isEmpty()){
            System.out.println("-----------------------Stage 6: Question Stage ------------------"); // Stage 6:
            for (Question ques: quess)
                System.out.print("Title: " + ques.getTitle() + "\nContent: " + ques.getContent() + "\n");
        }
    }
    public void show(){
        System.out.println("\n-----------------------The edit experiment-----------------------");
        System.out.println("Creator:" + creatorName + "\n Experiment Name: " + exName);
        System.out.println("Description:" + exDescription + "\n Additional Note: " + addNote);
        if (count > 0)
            for (Integer tr: tree){
                int stage = tr;
                switch (stage) {
                    case 1:
                        showNotice();
                        break;
                    case 2:
                        showInput();
                        break;
                    case 3:
                        showTimer();
                        break;
                    case 4:
                        showVas();
                        break;
                    case 5:
                        showgLms();
                        break;
                    case 6:
                        showQues();
                        break;
                    default:
                        break;
                }
            }

        System.out.println("-------------------------------------------------------------------");
    }
    public String getCreatorName() {
        return creatorName;
    }

    public String getExName() {
        return exName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    public void setExDescription(String exDescription) {
        this.exDescription = exDescription;
    }

    public void setAddNote(String addNote) {
        this.addNote = addNote;
    }

}