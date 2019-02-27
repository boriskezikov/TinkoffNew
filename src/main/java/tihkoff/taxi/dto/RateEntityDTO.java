package tihkoff.taxi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tihkoff.taxi.domain.TaxiOrderEntity;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RateEntityDTO {
    private long orderId;
    private String review;
    private List<TaxiDriverEntityDTO> taxiDriverEntityDTOS;

}
