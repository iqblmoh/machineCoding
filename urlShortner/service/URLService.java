package urlShortner.service;

import com.sun.xml.internal.ws.util.StringUtils;
import urlShortner.dao.DAO;
import urlShortner.entity.Client;
import urlShortner.entity.IDGenerator;
import urlShortner.entity.URL;
import urlShortner.exceptions.ClientAlreadyExistException;
import urlShortner.exceptions.InvalidEmailException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class URLService {

    private static final String BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int SHORT_URL_LENGTH = 7;

    private DAO dao = DAO.getInstance();
    private static URLService urlService=null;

    public URLService() {
    }

    public static URLService getInstance(){
        if(urlService == null){
            urlService = new URLService();
        }
        return urlService;
    }

    public URL shortenURL(String email, String longUrl, String customShortURL, LocalDateTime expireBy) throws Exception {
        if(email == null){
            throw new InvalidEmailException("Invalid Email in Request");
        }
        if(dao.validatedUniqueClient(email)){
            throw new ClientAlreadyExistException("Email doesn't exist");
        }
        Client client = dao.getClient(email);
        if (!client.getActive()){
            throw new Exception("Client is not active");
        }
        URL url = new URL();
        url.setId(IDGenerator.getId());
        url.setLongUrl(longUrl);
        if(customShortURL!=null){
            URL tempUrl = dao.getURL(customShortURL);
            if(tempUrl!=null) throw new Exception("Custom short url already present");
            url.setShortUrl(customShortURL);
        }
        else {
            url.setShortUrl(createShortUrl(longUrl));
        }
        dao.storeURL(url);
        return url;
    }

    public URL getUrl(String shortUrl) throws Exception {
        URL url =  dao.getURL(shortUrl);

        if(shortUrl == null || url==null){
            throw new Exception("Short Url Does not exist");
        }
        return url;
    }
    private String createShortUrl(String longUrl) throws Exception {
        String combinedString = longUrl + System.currentTimeMillis(); // Concatenate with current timestamp
        byte[] hash = computeMD5Hash(combinedString.getBytes());

        StringBuilder shortUrlBuilder = new StringBuilder();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int index = Math.abs(hash[i % hash.length]) % 62;
            shortUrlBuilder.append(BASE62.charAt(index));
        }

        return shortUrlBuilder.toString();
    }
    private  byte[] computeMD5Hash(byte[] data) throws Exception {
        try {
            return MessageDigest.getInstance("MD5").digest(data);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("Something Went Wrong");
        }
    }
}
