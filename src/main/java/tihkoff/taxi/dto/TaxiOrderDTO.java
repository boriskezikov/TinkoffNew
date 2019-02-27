package tihkoff.taxi.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tihkoff.taxi.domain.TaxiDriverEntity;


@Getter
@Setter
@NoArgsConstructor
public class TaxiOrderDTO {

    private TaxiDriverEntity taxiDriverEntityDTO;

    private ClientEntityDTO clientEntityDTO;

    private String clientLocation;

    private int status;

    private TariffEntityDTO tariffEntityDTO;

    private long orderId;

    private RateEntityDTO rateEntityDTO;


}

