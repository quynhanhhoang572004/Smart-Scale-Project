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
        return this.title;
    } 
    public String getContent(){
        return this.content;
    }

    @Override
    public String toString() {
        return "Timer{\t" + title +
                "\t" + content
                +"\t}";
    }
}
