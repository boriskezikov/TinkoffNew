package tihkoff.taxi.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@NamedEntityGraph(
        name = "driver-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("carEntity"),
                @NamedAttributeNode("taxiOrder"),
        }
)
@Entity
@Table(name = "taxi_driver")
@Getter
@Setter
public class TaxiDriverEntity {

    @Id
    @Column(name = "id_driver")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer status;

    @Column(name = "license_number")
    private String licenseNumber;

    private String name;

    private String passport;

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    private CarEntity carEntity;

    @OneToOne(mappedBy = "taxiDriverEntity")
    private TaxiOrderEntity taxiOrder;


}
