package quotely;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class QuotelyUnitTest {
    
    private Quotely quotely = new Quotely();
    
    @Test
    void getsEnglishQuote() {
        assertEquals("english quote", quotely.getQuote(Quotely.ENGLISH));
    }
    
    @Test
    void getsRussianQuote() {
        assertEquals("russian quote", quotely.getQuote(Quotely.RUSSIAN));
    }

}
