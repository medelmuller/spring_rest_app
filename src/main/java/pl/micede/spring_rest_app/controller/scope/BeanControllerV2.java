package pl.micede.spring_rest_app.controller.scope;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.micede.spring_rest_app.scope.PrototypeBean;
import pl.micede.spring_rest_app.scope.RequestBean;
import pl.micede.spring_rest_app.scope.SingletonBean;

@RestController
@RequestMapping("/beans/v2")
@RequiredArgsConstructor
public class BeanControllerV2 {

    private final SingletonBean singletonBean; // zawsze tylko jeden bean i zawsze będzie mieć ten sam hashcode niezależnie od miejsca wywołania
                                                // / np do przetrzymywania logiki jak carservice albo repozytorium

    private final PrototypeBean prototypeBean; // tworzy nowy ale tylko jeden/ np do wykorzystania do zamówienia (tworzenie koszyka w online zamówieniu)

    private final RequestBean requestBean; // zawsze inny hashcode / dane odnośnie daty i czasu przy wyszukiwaniu requestów

    @GetMapping("/singleton")
    public ResponseEntity<Integer> showSingleton() {
        return ResponseEntity.ok(singletonBean.showHashCode());
    }

    @GetMapping("/prototype")
    public ResponseEntity<Integer> showPrototype() {
        return ResponseEntity.ok(prototypeBean.showHashCode());
    }

    @GetMapping("/request")
    public ResponseEntity<Integer> showRequest() {
        return ResponseEntity.ok(requestBean.showHashCode());
    }

}
