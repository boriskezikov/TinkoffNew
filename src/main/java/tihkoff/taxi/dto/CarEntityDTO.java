package tihkoff.taxi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class CarEntityDTO {
    private long  carId;

    private String manufacturerId;

    private int techCondition;

    private int category;

    private List<TaxiDriverEntityDTO> taxiDriverEntityDTOS;

}
