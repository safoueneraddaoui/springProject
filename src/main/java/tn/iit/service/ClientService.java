package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.dao.ClientDaoSpringData;
import tn.iit.entity.Client;

import java.util.List;

@Service
public class ClientService {

    //private final CompteDaoJPA compteDao;

    private final ClientDaoSpringData clientDaoSpringData;

    @Autowired
    public ClientService(ClientDaoSpringData clientDaoSpringData) {
        super();
        this.clientDaoSpringData = clientDaoSpringData;
    }

    public void save(Client client) {
        clientDaoSpringData.saveAndFlush(client);
    }

    public List<Client> getAll() {
        return clientDaoSpringData.findAll();
    }
    /*public int getCount() {
        return clientDaoSpringData.getCount();
    }*/

    public void delete(Client client) {
        clientDaoSpringData.delete(client);
    }

    public void delete(String cin) {
        clientDaoSpringData.deleteById(cin);
    }

    public Client findById(String cin) {
        return clientDaoSpringData.findById(cin).get();
    }

    public void update(Client client) {
        clientDaoSpringData.saveAndFlush(client);
    }
}