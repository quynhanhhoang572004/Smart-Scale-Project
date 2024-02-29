
import java.util.ArrayList;
import java.util.Scanner;
public class Showing extends Stage{
    Experiment experiment;
    private ArrayList<Vas> vass;
    private ArrayList<gLMS> glmss;
    private ArrayList<Question> quess;
    private ArrayList<Notice> notices;
    private Data data;

    public Showing(String title, String content, Experiment experiment){
        super(title,content);
        this.experiment = experiment;
        loadData();
    }

    private void loadData() {
        vass = new ArrayList<>();
        glmss = new ArrayList<>();
        quess = new ArrayList<>();
        notices = new ArrayList<>();
        Vas vas = new Vas(title,content);
        vass.add(vas);
        gLMS glms = new gLMS(title,content);
        glmss.add(glms);
        Question ques = new Question(title,content);
        quess.add(ques);
        Notice notice = new Notice(title,content);
        notices.add(notice);
    }
    public void addStage(int stage){
        Scanner sc = new Scanner(System.in);
        String titleEn, contentEn;
        System.out.print("Enter the title: ");
        titleEn = sc.nextLine();
        System.out.print("Enter the content: ");
        contentEn = sc.nextLine();
        switch (stage) {
           case 1:
                addNotice(titleEn, contentEn);
               break;
//            case 2:
//                break;
//            case 3:
//                break;
            case 4:
                addVas(titleEn,contentEn);
                break;
            case 5:
                addgLMS(titleEn,contentEn);
                break;
            case 6:
                addQues(titleEn,contentEn);
                break;
            default:
                break;
        }
    }

    public void addNotice(String title, String content){
        Notice temp = new Notice(title,content);
        notices.add(temp);
        System.out.println("Add Notice is done");
    }
    public void addVas(String title, String content) {
        Vas temp = new Vas(title,content);
        vass.add(temp);
        System.out.println("Add Vas is done");
    }
    public void addgLMS(String title, String content) {
        gLMS temp = new gLMS(title,content);
        glmss.add(temp);
        System.out.println("Add gLMS is done");
    }
    public void addQues(String title, String content) {
        Question temp = new Question(title,content);
        quess.add(temp);
        System.out.println("Add Question is done");
    }
    public void show(){
        // At position (count = 0), store the Creator'name
        int count = 0;
        System.out.println("\n-----------------------The edit experiment-----------------------");
        System.out.println("Creator: Mia\n Experiment Name: Testing");
        System.out.println("-----------------------Stage 1: Notice Stage---------------------"); // Stag 1:
            count=0;
            for(Notice notice: notices){
                if(count>0)
                    System.out.print("Title: " + notice.getTitle()+ "\nContent: "+ notice.getContent());
                count++;
            }
                
        System.out.println("-----------------------Stage 2: Input Stage----------------------"); // Stag 2:
        /*
                QuynhAnh fill
         */
        System.out.println("-----------------------Stage 3: Timer Stage----------------------"); // Stag 3:
        /*
                QuynhAnh fill
         */
        count = 0;
        System.out.println("-----------------------Stage 4: VAS Stage------------------------"); // Stag 4:
        for (Vas vas: vass){
            if (count > 0)
                System.out.print("Title: " + vas.getTitle() + "\nContent: " + vas.getContent() + "\n");
            count++;
        }
        System.out.println("-----------------------Stage 5: gLMS Stage ----------------------"); // Stage 5:

        count = 0;
        for (gLMS glms: glmss){
            if (count > 0)
                System.out.print("Title: " + glms.getTitle() + "\nContent: " + glms.getContent() + "\n");
            count++;
        }
        System.out.println("-----------------------Stage 6: Question Stage ------------------"); // Stage 6:
        count = 0;
        for (Question ques: quess){
            if (count > 0)
                System.out.print("Title: " + ques.getTitle() + "\nContent: " + ques.getContent() + "\n");
            count++;
        }
        System.out.println("-------------------------------------------------------------------");
    }
}

