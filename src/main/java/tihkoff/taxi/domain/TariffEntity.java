package tihkoff.taxi.domain;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tariff", schema = "public", catalog = "tinkofftaxi")
public class TariffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tariff_id;

    @Column(name = "price")
    private int price;

    @Column (name = "tariff_info", length = 150)
    private String tariffInfo;

    @OneToMany(mappedBy = "tariffEntity", fetch = FetchType.EAGER)
    private List<TaxiOrderEntity> taxiOrderEntities;

    public int getPrice() { return price;    }

    public int getTariff_id() { return tariff_id;  }

    public String getTariffInfo() {  return tariffInfo;   }

    public void setPrice(int price) {     this.price = price;  }

    public void setTariff_id(int tariff_id) {   this.tariff_id = tariff_id;  }

    public void setTariffInfo(String tariffInfo) {   this.tariffInfo = tariffInfo;    }
}
