package tihkoff.taxi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TariffEntityDTO {
    private Integer price;

    private Integer tariffId;

    private String tariffInfo;

    private List<TaxiOrderDTO> taxiOrderDTOS;


}
