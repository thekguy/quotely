package quotely;

import java.util.Map;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

public class Quotely {
    
    public static final String RU = "ru";
    public static final String EN = "en";
    public static final String ENGLISH = "English";
    public static final String RUSSIAN = "Russian";
    private QuoteFinder quoteFinder;
    
    Map<String, String> languageToForismaticLanguage = Map.of(
            ENGLISH, EN,
            RUSSIAN, RU
        );

    public static void main( String[] args )
    {
        if (args.length > 1 || (args.length == 1 && (!args[0].equals(RUSSIAN) && !args[0].equals(ENGLISH)))) {
            System.out.println( "Usage: java -jar target/quotely-0.0.1-SNAPSHOT-jar-with-dependencies.jar [English|Russian]" );
        } else {
            String language = ENGLISH;
            if (args.length == 1) {
                language = args[0];
            }
            Client client = ClientBuilder.newBuilder().build().register(MyCustomResponseReader.class);
            Quotely quotely = new Quotely(new QuoteFinder(client));
            System.out.println(quotely.getQuote(language));
        }
    }
    
    Quotely(QuoteFinder quoteFinder) {
        this.quoteFinder = quoteFinder;
    }

    String getQuote(String language) {
        final Quote quote = quoteFinder.getQuote(getForismaticLanguage(language));
        return quote.quoteText + "\n - " + quote.quoteAuthor; 
    }

    String getForismaticLanguage(String language) {
        return languageToForismaticLanguage.get(language);
    }

}
