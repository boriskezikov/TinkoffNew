package tihkoff.taxi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RateEntityDTO {
    private Long orderId;

    private String review;

    private TaxiOrderDTO taxiOrder;

}
