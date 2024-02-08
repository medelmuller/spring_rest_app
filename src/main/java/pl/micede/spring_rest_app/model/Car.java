package pl.micede.spring_rest_app.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
@Getter
@Setter
@Builder
public class Car {

    @Size(min = 2, max = 5)
    private String brand;

    @NotNull(message = "Model cannot be null")
    private String model;

    @Range(min = 500, max = 1_000_000)
    private BigDecimal carValue;

    @Min(2000)
    @Max(2025)
    private Integer productionYear;
    private FuelType fuelType;
}
