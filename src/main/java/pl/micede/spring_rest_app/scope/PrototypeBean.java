package pl.micede.spring_rest_app.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {

    private final Integer hashCode;


    public PrototypeBean() {
        this.hashCode = this.hashCode();
    }

    public Integer showHashCode() {
        return hashCode;
    }
}
