package pl.micede.spring_rest_app.controller.commercial;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.micede.spring_rest_app.service.commercial.CommercialService;

@RestController
@RequestMapping("/commercial")
@RequiredArgsConstructor
public class CommercialController {

    private final CommercialService commercialService;

//    public CommercialController(@Qualifier("businessCustomerCommercialService") CommercialService commercialService) {
//        this.commercialService = commercialService;
//    }

    @PostMapping
    public ResponseEntity<Void> sendCommercial(@RequestBody String content) {
        commercialService.sendCommercialOffer(content);
        return ResponseEntity.ok().build();
    }


}
