package tihkoff.taxi.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tihkoff.taxi.domain.RateEntity;
import tihkoff.taxi.domain.TaxiDriverEntity;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaxiOrderDTO {

    private TaxiDriverEntityDTO taxiDriverEntity;

    private ClientEntityDTO clientEntity;

    private String clientLocation;

    private String destination;

    private Integer status;

    private TariffEntityDTO tariffEntity;

    private Long id;

    private RateEntityDTO rateEntity;




    public TaxiOrderDTO(TaxiDriverEntityDTO taxiDriverEntity, ClientEntityDTO clientEntity, String clientLocation, String destination, Integer status, TariffEntityDTO tariffEntity, RateEntityDTO rateEntity) {
        this.taxiDriverEntity = taxiDriverEntity;
        this.clientEntity = clientEntity;
        this.clientLocation = clientLocation;
        this.destination = destination;
        this.status = status;
        this.tariffEntity = tariffEntity;
        this.rateEntity = rateEntity;
    }
}

