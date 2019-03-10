package tihkoff.taxi.domain;



import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;





@Entity
@Getter
@Setter
@Table(name = "client")
public class ClientEntity {
    @Id
    @Column(name="phone_number", nullable = false)
    private String phoneNumber;

    private String name;

    private Boolean status;



}
