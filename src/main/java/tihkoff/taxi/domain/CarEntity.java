package tihkoff.taxi.domain;

import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long carId;

    @Column(name = "model_info", nullable = false, length = 100)
    private String modelInfo;

    @Column(name = "tech_condition", nullable = false)
    private int techCondition;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Column(nullable = false)
    private Integer category;

    @OneToMany(mappedBy = "carEntity", fetch = FetchType.EAGER)
    private List<TaxiDriverEntity> taxiDrivers;

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {this.carId = carId;
    }

    public String getModelInfo() {
        return modelInfo;
    }

    public void setModelInfo(String modelInfo) {
        this.modelInfo = modelInfo;
    }

    public int getTechCondition() {
        return techCondition;
    }

    public void setTechCondition(Integer techCondition) {
        this.techCondition = techCondition;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Collection<TaxiDriverEntity> getTaxiDrivers() {
        return taxiDrivers;
    }

    public void setTaxiDrivers(List<TaxiDriverEntity> taxiDrivers) {
        this.taxiDrivers = taxiDrivers;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
