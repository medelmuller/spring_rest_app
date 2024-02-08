package pl.micede.spring_rest_app.scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class RequestBean {

    private final Integer hashCode;


    public RequestBean() {
        this.hashCode = this.hashCode();
    }

    public Integer showHashCode() {
        return hashCode;
    }
}
