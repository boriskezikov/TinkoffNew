package tihkoff.taxi.domain;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "client", schema = "public", catalog = "tinkofftaxi")
public class ClientEntity {
    @Id
    @Column(name="phone_number", nullable = false)
    private String PhoneNumber;

    @Column(name = "name", nullable = false)
    private String Name;

    @Column (name= "status", nullable = false)
    private Boolean Status;

    /**taxi-order connection </>*/
    @OneToMany (mappedBy = "clientEntity", fetch = FetchType.EAGER)
    private Collection<TaxiOrderEntity> taxiOrderEntities;


    public String getPhoneNumber(){return PhoneNumber;    }

    public void setPhoneNumber(String phoneNumber){this.PhoneNumber = phoneNumber;    }

    public String getName(){return Name;    }

    public void setName(String name) {this.Name = name;    }

    public Boolean getStatus() {return Status;  }

    public void setStatus(Boolean status) {this.Status = status;    }
}
