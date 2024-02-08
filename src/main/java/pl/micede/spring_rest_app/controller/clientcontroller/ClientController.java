package pl.micede.spring_rest_app.controller.clientcontroller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.micede.spring_rest_app.model.Client;
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {


    @PostMapping("/newClient")
    public ResponseEntity<Client> addNewClient(@RequestBody Client newClient) {
        log.info(newClient.toString());
//        log.info(String.format("Dodano nowego klienta: [%s] [%s], [%s], [%s], [%d], [%s], [%s]", newClient.getFirstName(), newClient.getLastName(), newClient.getEmail(),
//                newClient.getPhoneNumber(), newClient.getBirthYear(), newClient.getPesel(), newClient.isPremium()));
        return ResponseEntity.ok().build();
    }
}
