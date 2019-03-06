package tihkoff.taxi.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import javax.websocket.OnError;

@Entity
@Getter
@Setter
@Table(name  = "taxi_order" , schema = "public", catalog = "tinkofftaxi")
public class TaxiOrderEntity {

    @ManyToOne
    @JoinColumn(name = "id_driver", referencedColumnName = "id_driver")
    private TaxiDriverEntity taxiDriverEntity;

    @Column(name = "client_location")
    private String clientLocation;

    @Column(name="distination")

    private String destination;

    @Column(name="status")
    private int status;

    /**Tariff-entity connection </>*/
    @ManyToOne
    @JoinColumn(name="tariff_id", referencedColumnName = "tariff_id", nullable = false)
    private TariffEntity tariffEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    private Long orderId;

    /**Client-entity connection </>*/
    @ManyToOne
    @JoinColumn(name = "phone_number", referencedColumnName = "phone_number", nullable = false)
    private ClientEntity clientEntity;

    @OneToOne(mappedBy = "taxiOrderEntity")
    private RateEntity rateEntity;

  /*  public TaxiDriverEntity getTaxiDriverEntity() {
        return taxiDriverEntity;
    }

    public void setTaxiDriverEntity(TaxiDriverEntity taxiDriverEntity) {
        this.taxiDriverEntity = taxiDriverEntity;
    }

    public String getClientLocation() { return clientLocation;    }

    public int getStatus() {  return status;    }

    public TariffEntity getTariffEntity() {  return tariffEntity ;   }

    public ClientEntity getClientEntity(){ return clientEntity;  }

    public Long getOrderId() {  return orderId;    }

    public String getDistination() { return destination;    }

    public void setClientLocation(String clientLocation) { this.clientLocation = clientLocation;    }

    public void setDistination(String distination) { this.destination = distination;    }

    public RateEntity getRateEntity() {
        return rateEntity;
    }


    public void setRateEntity(RateEntity rateEntity) {
        this.rateEntity = rateEntity;
    }

    public void setStatus(int status) { this.status = status;    }


    public void setOrderId(Long orderId) { this.orderId = orderId;    }

    public void setTariffEntity(TariffEntity tariffEntity) { this.tariffEntity = tariffEntity;    }


    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }*/
}

