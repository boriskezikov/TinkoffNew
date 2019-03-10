package tihkoff.taxi.domain;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.criterion.Order;
import org.hibernate.internal.CriteriaImpl;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@Setter
@Table(name = "rate", schema = "public", catalog="tinkofftaxi")
public class RateEntity {

    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String review;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    private TaxiOrderEntity taxiOrderEntity;



}
