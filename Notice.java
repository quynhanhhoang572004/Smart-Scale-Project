public class Notice extends Stage{

    public Notice(String title, String content) {
        super(title, content);
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
        return "Notice{\t" + title +
                "\t" + content
                +"\t}";
    }
}

