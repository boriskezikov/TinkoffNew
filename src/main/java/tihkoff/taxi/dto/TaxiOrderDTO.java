package tihkoff.taxi.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tihkoff.taxi.domain.TaxiDriverEntity;


@Getter
@Setter
@NoArgsConstructor
public class TaxiOrderDTO {

    private TaxiDriverEntityDTO taxiDriverEntity;

    private ClientEntityDTO clientEntity;

    private String clientLocation;

    private String destination;

    private Integer status;

    private TariffEntityDTO tariffEntity;

    private Long id;

    private RateEntityDTO rateEntity;


}

