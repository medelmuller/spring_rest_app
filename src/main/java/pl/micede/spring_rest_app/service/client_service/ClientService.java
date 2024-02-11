package pl.micede.spring_rest_app.service.client_service;

import org.springframework.stereotype.Service;
import pl.micede.spring_rest_app.model.Client;
import pl.micede.spring_rest_app.repository.client_repo.ClientRepository;
import pl.micede.spring_rest_app.repository.client_repo.ClientRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> createNewClient(Client newClient){
        clientRepository.crateNewClient(newClient);
        return new ArrayList<>();
    }

    public List<Client> getClients() {
        return clientRepository.getAllClients();
    }

    public List<Client> updateClientsEmail(String pesel, String email) {
        return clientRepository.updateClientsEmail(pesel, email);
    }

    public List<Client> deleteClient(String pesel){
        return clientRepository.deleteClient(pesel);
    }
}
