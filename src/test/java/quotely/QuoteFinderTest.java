package quotely;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

@ExtendWith(MockitoExtension.class)
public class QuoteFinderTest {

    private static final Quote QUOTE = new Quote("quote text", "author");
    
    @Mock
    Client mockClient;
    
    @Mock
    WebTarget mockTarget;
    
    @Mock
    Invocation.Builder mockSyncInvoker;

    @Test
    void findsQuote() {
        QuoteFinder finder = new QuoteFinder(mockClient);
        when(mockClient.target(anyString())).thenReturn(mockTarget);
        when(mockTarget.request(MediaType.APPLICATION_JSON)).thenReturn(mockSyncInvoker);
        when(mockSyncInvoker.post(ArgumentMatchers.any(Entity.class), ArgumentMatchers.eq(Quote.class))).thenReturn(QUOTE);
        
        Quote quote = finder.getQuote("en");
        
        assertEquals(QUOTE, quote);
    }
    
}
