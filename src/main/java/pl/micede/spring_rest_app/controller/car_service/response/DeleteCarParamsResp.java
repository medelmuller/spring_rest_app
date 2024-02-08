package pl.micede.spring_rest_app.controller.car_service.response;

import lombok.Data;
import pl.micede.spring_rest_app.model.Car;

import java.util.List;
@Data
public class DeleteCarParamsResp {
    private List<Car> cars;
    private Integer amount;
}
