package tihkoff.taxi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "taxi_driver")
public class TaxiDriverEntity {

    @Id
    @Column(name = "id_driver")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long driverID;

    @Column
    private Integer status;

    @Column(name = "license_number", length = 12)
    private String licenseNumber;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 12)
    private String passport;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id", nullable = false)
    private CarEntity carEntity;

    @OneToMany(mappedBy = "taxiDriverEntity")
    private List<TaxiOrderEntity> taxiOrders;

   /* public List<TaxiOrderEntity> getTaxiOrderEntities() {
        return taxiOrders;
    }

    public void setTaxiOrderEntities(List<TaxiOrderEntity> taxiOrderEntities) {
        this.taxiOrders = taxiOrderEntities;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getIdDriver() {
        return driverID;
    }

    public void setIdDriver(long idDriver) {
        this.driverID = idDriver;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public CarEntity getCarEntity() {
        return carEntity;
    }

    public void setCarEntity(CarEntity carEntity) {
        this.carEntity = carEntity;
    }*/
}
