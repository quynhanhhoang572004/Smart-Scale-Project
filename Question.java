public class Question extends Stage{
    public Question(String title, String content){
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
        return "Question{\t" + title +
                "\t" + content
                +"\t}";
    }
}
