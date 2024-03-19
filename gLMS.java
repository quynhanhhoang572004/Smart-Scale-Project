import java.util.ArrayList;
public class gLMS extends Stage{
    public gLMS(String title, String content){
        super(title,content);
    }
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "glMS{\t" + title +
                "\t" + content
                +"\t}";
    }
    public String OldData(){
        return "glmsStage(\""+ title +"\", " +"\"" + content + "\")";
    }
}





