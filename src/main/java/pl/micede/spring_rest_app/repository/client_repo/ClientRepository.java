package pl.micede.spring_rest_app.repository.client_repo;

import pl.micede.spring_rest_app.model.Client;
import java.util.List;
public interface ClientRepository {

List<Client> crateNewClient(Client newClient);

List<Client> getAllClients();


List<Client> updateClientsEmail(String clientPesel, String newClient);

List<Client> deleteClient(String clientPesel);

}
