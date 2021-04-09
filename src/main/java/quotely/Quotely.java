package quotely;

public class Quotely {
    
    public static final String ENGLISH = "English";
    public static final String RUSSIAN = "Russian";

    public static void main( String[] args )
    {
        if (args.length > 1 || (args.length == 1 && (!args[0].equals(RUSSIAN) && !args[0].equals(ENGLISH)))) {
            System.out.println( "Usage: java -jar quotely.jar [English|Russian]" );
        } else {
            String language = ENGLISH;
            if (args.length == 1) {
                language = args[0];
            }
            Quotely quotely = new Quotely();
            System.out.println(quotely.getQuote(language));
        }
    }

    String getQuote(String language) {
        if (language.equals(ENGLISH)) {
            return "english quote";
        } else if (language.equals(RUSSIAN)) {
            return "russian quote";
        } else {
            throw new IllegalArgumentException("Expected 'Russian' or 'English'.");
        }
    }

}
