package tihkoff.taxi.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tariff")
public class TariffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tariff_id")
    private Integer id;

    private Integer price;

    @Column (name = "tariff_info", length = 150)
    private String tariffInfo;

    @OneToMany(mappedBy = "tariffEntity", cascade = CascadeType.ALL)
    private List<TaxiOrderEntity> taxiOrders;


}
