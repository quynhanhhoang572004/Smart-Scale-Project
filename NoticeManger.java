import java.util.ArrayList;
public class NoticeManger {
    private ArrayList<NoticeStage> notices = new ArrayList<>();

    public void addNotice (NoticeStage notice){
        notices.add(notice);
    }
    public ArrayList<NoticeStage> getNotices(){
        return notices;
    }

}
