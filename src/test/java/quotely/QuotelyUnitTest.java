package quotely;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class QuotelyUnitTest {
    
    private static final String SEPARATOR = "\n - ";
    private static final String RUSSIAN_AUTHOR = "russian author";
    private static final String ENGLISH_AUTHOR = "english author";
    private static final String RUSSIAN_QUOTE_TEXT = "russian quote";
    private static final String ENGLISH_QUOTE_TEXT = "english quote";
    private static final Quote ENGLISH_QUOTE = new Quote(ENGLISH_QUOTE_TEXT, ENGLISH_AUTHOR);
    private static final Quote RUSSIAN_QUOTE = new Quote(RUSSIAN_QUOTE_TEXT, RUSSIAN_AUTHOR);

    @Mock
    QuoteFinder mockQuoteFinder;
    
    @Test
    void getsEnglishQuote() {
        Quotely quotely = new Quotely(mockQuoteFinder);
        when(mockQuoteFinder.getQuote(anyString())).thenReturn(ENGLISH_QUOTE);
        assertEquals(ENGLISH_QUOTE_TEXT + SEPARATOR + ENGLISH_AUTHOR, quotely.getQuote(Quotely.ENGLISH));
        verify(mockQuoteFinder).getQuote(Quotely.EN);
    }
    
    @Test
    void getsRussianQuote() {
        Quotely quotely = new Quotely(mockQuoteFinder);
        when(mockQuoteFinder.getQuote(anyString())).thenReturn(RUSSIAN_QUOTE);
        assertEquals(RUSSIAN_QUOTE_TEXT + SEPARATOR + RUSSIAN_AUTHOR, quotely.getQuote(Quotely.RUSSIAN));
        verify(mockQuoteFinder).getQuote(Quotely.RU);
    }

}
