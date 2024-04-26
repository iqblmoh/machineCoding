package urlShortner.dao;

import urlShortner.entity.Client;
import urlShortner.entity.URL;

import java.util.HashMap;

public class DAO {

    private HashMap<Integer, Client> clientIdHashMap = new HashMap<>();

    private HashMap<String, Client> clientEmailHashMap = new HashMap<>();

    private HashMap<String, URL> urlHashMap = new HashMap<>();;

    private static DAO dao=null;

    private DAO(){

    }
    public static DAO getInstance(){
        if(dao==null){
            dao=new DAO();
        }
        return dao;
    }
    public void storeClient(Client client){
        clientEmailHashMap.put(client.getEmail(),client);
        clientIdHashMap.put(client.getId(), client);
        System.out.println(client.toString());
    }


    public Client getClient(Integer id){
        return clientIdHashMap.get(id);
    }

    public Client getClient(String email){
        return clientEmailHashMap.get(email);
    }

    public boolean validatedUniqueClient(String email){
        return clientEmailHashMap.get(email) == null;
    }
    public void storeURL(URL url){
        urlHashMap.put(url.getShortUrl(), url);
        System.out.println(url.toString());
    }

    public URL getURL(String shortUrl){
       return urlHashMap.get(shortUrl);
    }


}
