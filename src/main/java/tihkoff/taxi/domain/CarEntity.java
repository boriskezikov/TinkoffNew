package tihkoff.taxi.domain;



import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "model_info")
    private String modelInfo;

    @Column(name = "tech_condition")
    private Integer techCondition;

    @Column(name = "manufacturer_id")
    private Long manufacturerId;

    private Integer category;



}