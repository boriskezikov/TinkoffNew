package tihkoff.taxi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;


@Getter
@Setter
@NoArgsConstructor
public class CarEntityDTO {
    private long  carId;

    private String manufacturerId;

    private int techCondition;

    private int category;

    private String modelInfo;

    private List<TaxiDriverEntityDTO> taxiDrivers;

}
