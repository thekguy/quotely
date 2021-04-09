package quotely;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;

public class QuoteFinder {

    public static final String API_ENDPOINT = "http://api.forismatic.com/api/1.0/";

    private Client client;

    public QuoteFinder(Client client) {
        this.client = client;
    }
    
    public Quote getQuote(String language) {
        WebTarget target = client.target(API_ENDPOINT);

        Form form = new Form();
        form.param("method", "getQuote");
        form.param("format", "json");
        form.param("lang", language);

        Quote quote =
        target.request(MediaType.APPLICATION_JSON)
            .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE),
               Quote.class);
        return quote;
    }
    
}
