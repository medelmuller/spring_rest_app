package pl.micede.spring_rest_app;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.micede.spring_rest_app.configuration.WorkshopConfiguration;
import pl.micede.spring_rest_app.configuration.WorkshopInfo;

import java.time.LocalDate;

@RestController // @Controller +@ResponseBody
@RequestMapping("/dummy")
public class DummyController {

    private final WorkshopInfo workshopInfo;
    private final WorkshopConfiguration workshopConfiguration;

    public DummyController(WorkshopInfo workshopInfo, WorkshopConfiguration workshopConfiguration) {
        this.workshopInfo = workshopInfo;
        this.workshopConfiguration = workshopConfiguration;
    }


    @GetMapping
    //@ResponseBody // -> to zmienia kod do Body czyli do JSONa
    public LocalDate getDate() {
        return LocalDate.now();
    }

    @PostMapping
    public ResponseEntity<String> post() {
        return ResponseEntity.ok("Hello from POST method!");
    }

    @PutMapping
    public ResponseEntity<String> put() {
        return ResponseEntity.ok("Hello from PUT method!");
    }

    @PatchMapping
    public ResponseEntity<String> patch() {
        return ResponseEntity.ok("Hello from PATCH method!");
    }

    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("Hello from DELETE method!");
    }

    @GetMapping("/500")
    public ResponseEntity<String> return500() {
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/400")
    public ResponseEntity<Void> return400() {
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/notFound")
    public ResponseEntity<Void> notFound() { //moze być <String> ale <Void> jeśli wiemy że nic nie zwracamy
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //moze być też .notfound()
    }

    @GetMapping("/header")
    public ResponseEntity<String> withHeader(@RequestHeader("my-header") String myHeader) {
        return ResponseEntity.ok("Hello with HEADER VALUE: " + myHeader);
    }

    @GetMapping("/header2")
    public ResponseEntity<String> withHeader2(@RequestHeader("my-header") String myHeader) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "My custom header value");

        return new ResponseEntity<>("Hello with header value " + myHeader, headers, 200 /* lub normalnie HttpStatus.OK */ );
    }

    @GetMapping("/path/{id}")
    public ResponseEntity<String> withPathVariable(@PathVariable String id) {
        return ResponseEntity.ok("Otrzymany id od klienta: " + id);
    }

    @GetMapping("/path")
    public ResponseEntity<String> withRequestParam(@RequestParam String parametr1, @RequestParam String param2) {
        return ResponseEntity.ok("Otrzymany parametr od klienta: " + parametr1 + param2);
    }

    @GetMapping("/workshop")
    public ResponseEntity<Void> showConfigsInConsole() {
        workshopInfo.showDataFromProperties();
        return ResponseEntity.ok().build();
    }
    @GetMapping("/config")
    public ResponseEntity<Void> showConfigsInConsole2() {
        workshopConfiguration.showDataFromProperties();
        return ResponseEntity.ok().build();
    }

}
