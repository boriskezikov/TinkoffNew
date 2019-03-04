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
    @NotNull
    private long orderId;

    @Column(name="review", length = 250)
    @NotNull
    private String review;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    private TaxiOrderEntity taxiOrderEntity;


   /* public Long getOrderId(){
        return orderId;
    }
    public String getReview(){
        return review;
    }
    public void setOrderId(Long carId) {
        this.orderId = carId;
    }
    public void setReview(String review){
        this.review = review;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public TaxiOrderEntity getTaxiOrderEntity() {
        return taxiOrderEntity;
    }*/
}
