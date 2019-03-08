package tihkoff.taxi.domain;



import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;





@Entity
@Getter
@Setter
@Table(name = "client", schema = "public", catalog = "tinkofftaxi")
public class ClientEntity {
    @Id
    @Column(name="phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column (name= "status", nullable = false)
    private Boolean status;



}
