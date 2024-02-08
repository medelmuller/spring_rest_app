package pl.micede.spring_rest_app.controller.car_service.request;

import lombok.Data;

@Data
public class DeleteRequest {
    private String brand;
    private String model;
}
