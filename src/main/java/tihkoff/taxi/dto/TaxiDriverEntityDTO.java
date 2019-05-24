package tihkoff.taxi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaxiDriverEntityDTO {
    private Long id;

    @Length(max = 12)
    private String licenseNumber;

    @NotNull
    @Length(max=12)
    private String passport;

    @NotNull
    private Integer status;

    @NotNull
    @Length(max = 30)
    private String name;

    private CarEntityDTO carEntity;

    private List<Long> taxiOrders;

}
