package urlShortner;

import urlShortner.entity.Client;
import urlShortner.entity.URL;
import urlShortner.service.ClientService;
import urlShortner.service.URLService;

import java.time.LocalDateTime;

public class MainClass {
    public static void main(String[] args) {
        ClientService clientService = ClientService.getInstance();
        URLService urlService = URLService.getInstance();

        try {
            Client client1 = clientService.createClient("Twitter", "twitter@gmail.com");
            Client client2 = clientService.createClient("Facebook", "facebook@gmail.com");

            URL url1 = urlService.shortenURL("twitter@gmail.com", "https://www.cyz-pqr.com/ancabcabcabcabc123abc", null, LocalDateTime.now());
            URL url2 = urlService.getUrl(url1.getShortUrl());
            System.out.println(url2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
