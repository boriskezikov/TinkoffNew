package tihkoff.taxi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RateEntityDTO {

    private Long id;

    @NotNull
    @Length(max = 500)
    private String review;

    private TaxiOrderDTO taxiOrder;

}
