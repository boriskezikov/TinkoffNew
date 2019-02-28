package tihkoff.taxi.domain;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "client", schema = "public", catalog = "tinkofftaxi")
public class ClientEntity {
    @Id
    @Column(name="phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column (name= "status", nullable = false)
    private Boolean status;

    /**taxi-order connection </>*/
    @OneToMany (mappedBy = "clientEntity", fetch = FetchType.EAGER)
    private Collection<TaxiOrderEntity> taxiOrderEntities;


    public String getPhoneNumber(){return phoneNumber;    }

    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;    }

    public String getName(){return name;    }

    public void setName(String name) {this.name = name;    }

    public Boolean getStatus() {return status;  }

    public void setStatus(Boolean status) {this.status = status;    }
}
