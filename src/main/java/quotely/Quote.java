package quotely;

public class Quote {
    public Quote() {}
    public Quote(String quoteText, String quoteAuthor) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
    }
    public String quoteText;
    public String quoteAuthor;
    public String senderName;
    public String senderLink;
}
