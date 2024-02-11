package pl.micede.spring_rest_app.controller.clientcontroller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.micede.spring_rest_app.model.Client;
import pl.micede.spring_rest_app.service.car_service.CarService;
import pl.micede.spring_rest_app.service.client_service.ClientService;

import java.lang.annotation.Repeatable;
import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    private final ClientService clientService;


    @PostMapping("/newClienttt")
    public ResponseEntity<Client> addNewClient(@RequestBody Client newClient) {
        log.info(newClient.toString());
//        log.info(String.format("Dodano nowego klienta: [%s] [%s], [%s], [%s], [%d], [%s], [%s]", newClient.getFirstName(), newClient.getLastName(), newClient.getEmail(),
//                newClient.getPhoneNumber(), newClient.getBirthYear(), newClient.getPesel(), newClient.isPremium()));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/newClient")
    public ResponseEntity<List<Client>> createNewClient (@RequestBody Client newClient) {
        List<Client> newClientsList = clientService.createNewClient(newClient);
        return ResponseEntity.ok(newClientsList);
    }

    @GetMapping("/getClients")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getClients();
        return ResponseEntity.ok(clients);
    }

    @PatchMapping("/updateClients")
    public ResponseEntity<List<Client>> updateClientsList(@RequestParam String pesel,@RequestParam String newEmail) {
        List<Client> clients = clientService.updateClientsEmail(pesel, newEmail);
        return ResponseEntity.ok(clients);
    }

    @DeleteMapping("/delete/{pesel}")
    public ResponseEntity<List<Client>> deleteClient(@PathVariable String pesel) {
        List<Client> clients = clientService.deleteClient(pesel);
        return ResponseEntity.ok(clients);
    }
}
