import java.util.ArrayList;

public class Vas extends Stage{
    String lowText;
    String highText;
    int lowValue;
    int highValue;
    public Vas(String title, String content){

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
}

