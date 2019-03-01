package tihkoff.taxi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;



@Getter
@Setter
@NoArgsConstructor
public class CarEntityDTO {
    private Long  carId;

    private Long manufacturerId;

    private Integer techCondition;

    private Integer category;

    private String modelInfo;

    private List<TaxiDriverEntityDTO> taxiDrivers;

}
