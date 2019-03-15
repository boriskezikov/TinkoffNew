package tihkoff.taxi.dto;

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
public class TariffEntityDTO {

    @NotNull
    private Integer price;

    private Integer Id;

    @Length(max = 150)
    @NotNull
    private String tariffInfo;

    private List<Long> taxiOrders;


}
