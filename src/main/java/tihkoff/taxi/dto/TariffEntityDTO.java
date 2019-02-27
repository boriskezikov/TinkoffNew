package tihkoff.taxi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TariffEntityDTO {
    private int price;
    private int tariffId;
    private String tariffInfo;
    private List<TaxiOrderDTO> taxiOrderDTOS;


}
