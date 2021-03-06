package tihkoff.taxi.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;



@NamedEntityGraph(
        name = "order-entity-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "tariffEntity"),
                @NamedAttributeNode(value ="clientEntity"),
                @NamedAttributeNode(value ="rateEntity"),
        }
)
@Entity
@Getter
@Setter
@Table(name  = "taxi_order")
public class TaxiOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_driver", referencedColumnName = "id_driver")
    private TaxiDriverEntity taxiDriverEntity;

    @Column(name = "client_location")
    private String clientLocation;

    @Column(name = "distination")
    private String destination;

    private Integer status;

    @OneToOne
    @JoinColumn(name = "tariff_id", referencedColumnName = "tariff_id")
    private TariffEntity tariffEntity;

    @ManyToOne
    @JoinColumn(name = "phone_number", referencedColumnName = "phone_number")
    private ClientEntity clientEntity;

    @OneToOne(mappedBy = "taxiOrderEntity",cascade = CascadeType.PERSIST)
    private RateEntity rateEntity;

}