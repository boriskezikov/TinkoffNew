package tihkoff.taxi.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tariff")
public class TariffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tariff_id")
    private int tariffId;

    @Column(name = "price")
    private int price;

    @Column (name = "tariff_info", length = 150)
    private String tariffInfo;

    @OneToMany(mappedBy = "tariffEntity", fetch = FetchType.EAGER)
    private List<TaxiOrderEntity> taxiOrderEntities;

    public int getPrice() { return price;    }

    public int getTariffId() { return tariffId;  }

    public String getTariffInfo() {  return tariffInfo;   }

    public void setPrice(int price) {     this.price = price;  }

    public void setTariffId(int tariffId) {   this.tariffId = tariffId;  }

    public void setTariffInfo(String tariffInfo) {   this.tariffInfo = tariffInfo;    }
}
