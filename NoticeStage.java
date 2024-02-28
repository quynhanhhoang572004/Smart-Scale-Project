public class NoticeStage {
    private String Content;
    private String Text;

    public NoticeStage(String Content, String Text){
        this.Text = Text;
        this.Content= Content;
    }
    public void setContent(String Content){
        this.Content= Content;
    }
    public String getContent(){
        return Content;
    }

    public void setTitle(String Text){
        this.Text = Text;
    }
    public String getText(){
        return Text;
    }
}
