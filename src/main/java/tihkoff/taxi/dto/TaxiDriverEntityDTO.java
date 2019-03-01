package tihkoff.taxi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TaxiDriverEntityDTO {
    private Integer driverID;

    private String licenceNumber;

    private String passport;

    private CarEntityDTO carEntityDTO;

    private List<TaxiOrderDTO> taxiOrderDTO;

}
