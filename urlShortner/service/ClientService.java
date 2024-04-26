package urlShortner.service;

import com.sun.deploy.util.StringUtils;
import urlShortner.dao.DAO;
import urlShortner.entity.Client;
import urlShortner.entity.IDGenerator;
import urlShortner.exceptions.ClientAlreadyExistException;
import urlShortner.exceptions.InvalidClientException;
import urlShortner.exceptions.InvalidEmailException;

public class ClientService {

    private static ClientService clientService=null;

    private DAO dao = DAO.getInstance();
    public ClientService() {
    }

    public static ClientService getInstance(){
        if(clientService == null){
            clientService = new ClientService();
        }
        return clientService;
    }

    public Client createClient(String name, String email) throws Exception {
        if(email == null){
            throw new InvalidEmailException("Invalid Email in Request");
        }
        if(!dao.validatedUniqueClient(email)){
            throw new ClientAlreadyExistException("Email already present");
        }

        Client client= new Client();
        client.setId(IDGenerator.getId());
        client.setEmail(email);
        client.setName(name);
        client.setActive(true);
        dao.storeClient(client);
        return client;
    }

    public void changeClientStatus(String email, boolean status) throws Exception {
        if(email == null){
            throw new InvalidEmailException("Invalid Email in Request");
        }
        if(!dao.validatedUniqueClient(email)){
            throw new InvalidClientException("Client does not exist");
        }

        Client client = dao.getClient(email);
        client.setActive(status);
    }
}
