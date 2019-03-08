package tihkoff.taxi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "taxi_driver")
@Getter
@Setter
public class TaxiDriverEntity {

    @Id
    @Column(name = "id_driver")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer status;

    @Column(name = "license_number", length = 12)
    private String licenseNumber;

    @Column(length = 50)
    private String name;

    @Column(length = 12)
    private String passport;

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    private CarEntity carEntity;

    @OneToOne(mappedBy = "taxiDriverEntity")
    private TaxiOrderEntity taxiOrder;


}
