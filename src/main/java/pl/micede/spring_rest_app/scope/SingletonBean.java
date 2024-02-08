package pl.micede.spring_rest_app.scope;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton") //-> definiowanie scope, ale singletone jest defaultowo więc nie potrzebny
public class SingletonBean {
    private final Integer hashCode;

    public SingletonBean() {
        this.hashCode = this.hashCode(); //przy odpaleniu appki, przypisanie hashcode do zmiennej hashcode
    }
    public Integer showHashCode() {
        return hashCode;
    }
}
