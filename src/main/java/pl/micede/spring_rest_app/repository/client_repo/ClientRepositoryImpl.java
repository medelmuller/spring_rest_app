package pl.micede.spring_rest_app.repository.client_repo;

import org.springframework.stereotype.Repository;
import pl.micede.spring_rest_app.exceptions.ExistingClientException;
import pl.micede.spring_rest_app.exceptions.NoSuchClientException;
import pl.micede.spring_rest_app.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClientRepositoryImpl implements ClientRepository{

    private static List<Client> clientList = new ArrayList<>();

    static {
        clientList.add(Client.builder()
                .firstName("Adam")
                .lastName("Kowalski")
                .email("akowalski@gmail.com")
                .phoneNumber("600200888")
                .birthYear(1974)
                .pesel("74020201110")
                .isPremium(true)
                .build());
        clientList.add(Client.builder()
                .firstName("Konrad")
                .lastName("Nowak")
                .email("knowak@gmail.com")
                .phoneNumber("724210652")
                .birthYear(1988)
                .pesel("88030302210")
                .isPremium(false)
                .build());
        clientList.add(Client.builder()
                .firstName("Albert")
                .lastName("Majewski")
                .email("amajewski@gmail.com")
                .phoneNumber("660111222")
                .birthYear(1968)
                .pesel("68052330735")
                .isPremium(true)
                .build());
        clientList.add(Client.builder()
                .firstName("Maciej")
                .lastName("Nowak")
                .email("mnowak@gmail.com")
                .phoneNumber("772889007")
                .birthYear(1992)
                .pesel("92061907661")
                .isPremium(false)
                .build());

    }


    @Override
    public List<Client> crateNewClient(Client newClient) {
        if (clientList.contains(newClient)) {
            throw new ExistingClientException(newClient);
        }
        boolean addClient = clientList.add(newClient);
        return clientList;
    }

    @Override
    public List<Client> getAllClients() {
        return clientList;
    }

    @Override
    public List<Client> updateClientsEmail(String clientPesel, String email) {

        Optional<Client> first = clientList.stream()
                .filter(c -> c.getPesel().equals(clientPesel))
                .findFirst();
        first.ifPresent(client -> client.setEmail(email));
        if(first.isEmpty()){
            throw new NoSuchClientException(clientPesel);
        }

        return new ArrayList<>(clientList);
    }


    @Override
    public List<Client> deleteClient(String clientPesel) {

        boolean removed = clientList.removeIf(client -> client.getPesel().equals(clientPesel));
        if(!removed){
            throw new NoSuchClientException(clientPesel);
        }
        return new ArrayList<>(clientList);
    }
}
