import java.util.ArrayList;
import java.util.Scanner;

public class NewExperiment {
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
    private int[] tree;
    private Node root, stage1, stage2, stage3, stage4, stage5, stage6;
    public static int count = 0;
    public NewExperiment(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Creator: ");
        setCreatorName(sc.nextLine());
        System.out.print("Enter the Experiment Name: ");
        setExName(sc.nextLine());
        System.out.print("Enter the Experiment Description: ");
        setExDescription(sc.nextLine());
        System.out.print("Enter the Additional Notes: ");
        setAddNote(sc.nextLine());
        tree = new int[6];
        timers = new ArrayList<>();
        notices = new ArrayList<>();
        inputs=new ArrayList<>();
        vass = new ArrayList<>();
        glmss = new ArrayList<>();
        quess = new ArrayList<>();
        root = new Node("Experiment");
        createList();
    }
    public void createList(){
        stage1 = new Node("Notice");
        stage2 = new Node("Input");
        stage3 = new Node("Timer");
        stage4 = new Node("Vas");
        stage5 = new Node("gLMS");
        stage6 = new Node("Question");
    }
    public void addStage(int stage) {
        boolean add = true;
        for (int i = 0 ; i < count ; i++ )
            if (tree[i] == stage){
                add = false;
                break;
            }
        if (add) {
            tree[count++] = stage;
            switch (tree[count - 1]) {
                case 1:
                    root.addChild(stage1);
                    break;
                case 2:
                    root.addChild(stage2);
                    break;
                case 3:
                    root.addChild(stage3);
                    break;
                case 4:
                    root.addChild(stage4);
                    break;
                case 5:
                    root.addChild(stage5);
                    break;
                case 6:
                    root.addChild(stage6);
                    break;
                default:
                    break;
            }
        }
    }
    public void addNotice(String title, String content){
        Notice temp = new Notice(title,content);
        notices.add(temp);
        System.out.println("Add Notice is done");
        Node no = new Node("Notice " + notices.size());
        stage1.addChild(no);
        no.addChild("Title: " + title);
        no.addChild("Content: "+ content);
    }
    public void addInput(String title, String content){
        Input temp = new Input(title, content);
        inputs.add(temp);
        System.out.println(" Add Input is done");
        Node in = new Node("Input " + inputs.size());
        stage2.addChild(in);
        in.addChild("Title: " + title);
        in.addChild("Content: "+ content);
    }
    public void addTimer(String title, String content){
        Timer temp = new Timer(title,content);
        timers.add(temp);
        System.out.println(" Add Timer stage is done");
        Node ti = new Node("Timer " + timers.size());
        stage3.addChild(ti);
        ti.addChild("Title: " + title);
        ti.addChild("Content: "+ content);
    }
    public void addVas(String title, String content) {
        Vas temp = new Vas(title,content);
        vass.add(temp);
        System.out.println("Add Vas is done");
        Node va = new Node("Vas " + vass.size());
        stage4.addChild(va);
        va.addChild("Title: " + title);
        va.addChild("Content: "+ content);
    }
    public void addgLMS(String title, String content) {
        gLMS temp = new gLMS(title,content);
        glmss.add(temp);
        System.out.println("Add gLMS is done");
        Node g = new Node("gLMS " + glmss.size());
        stage5.addChild(g);
        g.addChild("Title: " + title);
        g.addChild("Content: "+ content);
    }
    public void addQues(String title, String content) {
        Question temp = new Question(title,content);
        quess.add(temp);
        System.out.println("Add Question is done");
        Node q = new Node("Question " + quess.size());
        stage6.addChild(q);
        q.addChild("Title: " + title);
        q.addChild("Content: "+ content);

    }
    public void showNotice(){
        if (!notices.isEmpty()){
            System.out.println("-----------------------Stage 1: Notice Stage---------------------"); // Stag 1:
            for(Notice notice: notices){
                //System.out.print("Title: " + notice.getTitle()+ "\nContent: "+ notice.getContent()+ "\n");
                stage1.addChild("Title: " + notice.getTitle());
                stage1.addChild("Content: "+ notice.getContent());
            }
        }
    }
    public void showInput() {
        if (!inputs.isEmpty()) {
            System.out.println("-----------------------Stage 2: Input Stage----------------------"); // Stag 2:
            for (Input input : inputs) {
                //System.out.print("Title: " + input.getTitle()+ "\nContent: "+ input.getContent()+ "\n");
                stage2.addChild("Title: " + input.getTitle());
                stage2.addChild("Content: " + input.getContent());
            }
        }
    }
    public void showTimer(){
        if (!timers.isEmpty()){
            System.out.println("-----------------------Stage 3: Timer Stage----------------------"); // Stag 3:
            for(Timer timer: timers) {
                //System.out.print("Title: " + timer.getTitle() + "\nContent: " + timer.getContent() + "\n");
                stage3.addChild("Title: " + timer.getTitle());
                stage3.addChild("Content: "+ timer.getContent());
            }
        }
    }
    public void showVas(){
        if (!vass.isEmpty()){
            System.out.println("-----------------------Stage 4: VAS Stage------------------------"); // Stag 4:
            for (Vas vas: vass) {
                stage4.addChild("Title: " + vas.getTitle());
                stage4.addChild("Content: "+ vas.getContent());
                //System.out.print("Title: " + vas.getTitle() + "\nContent: " + vas.getContent() + "\n");
            }
        }
    }
    public void showgLms(){
        if (!glmss.isEmpty()){
            System.out.println("-----------------------Stage 5: gLMS Stage ----------------------"); // Stage 5:
            for (gLMS glms: glmss) {
                stage5.addChild("Title: " + glms.getTitle());
                stage5.addChild("Content: "+ glms.getContent());
                //System.out.print("Title: " + glms.getTitle() + "\nContent: " + glms.getContent() + "\n");
            }
        }
    }
    public void showQues(){
        if (!quess.isEmpty()){
            System.out.println("-----------------------Stage 6: Question Stage ------------------"); // Stage 6:
            for (Question ques: quess) {
                stage6.addChild("Title: " + ques.getTitle());
                stage6.addChild("Content: "+ ques.getContent());
                //System.out.print("Title: " + ques.getTitle() + "\nContent: " + ques.getContent() + "\n");
            }
        }
    }
    public void show(){
        System.out.println("\n-----------------------The edit experiment-----------------------");
        System.out.println("Creator:" + creatorName + "\nExperiment Name: " + exName);
//
//        for (int i = 0 ; i < count ; i++){
//            switch (tree[i]) {
//                case 1:
//                    root.addChild(stage1);
//                    break;
//                case 2:
//                    root.addChild(stage2);
//                    break;
//                case 3:
//                    root.addChild(stage3);
//                    break;
//                case 4:
//                    root.addChild(stage4);
//                    break;
//                case 5:
//                    root.addChild(stage5);
//                    break;
//                case 6:
//                    root.addChild(stage6);
//                    break;
//                default:
//                    break;
//            }
//        }
        root.display(0);
        System.out.println("-------------------------------------------------------------------");
    }
    public String getCreatorName() {
        return creatorName;
    }

    public String getExName() {
        return exName;
    }

    public String getExDescription() {
        return exDescription;
    }

    public String getAddNote() {
        return addNote;
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
