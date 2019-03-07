package tihkoff.taxi.domain;



import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "model_info", nullable = false, length = 100)
    private String modelInfo;

    @Column(name = "tech_condition", nullable = false)
    private int techCondition;

    @Column(name = "manufacturer_id")
    private Long manufacturerId;

    @Column(nullable = false)
    private Integer category;



}