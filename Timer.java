public class Timer extends Stage {

    public Timer(String title, String content) {
        super(title, content);
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setContent(String content){
        this.content=content;
    }
    public String getTitle(){
        return title;
    } 
    public String getContent(){
        return content;
    }

}
