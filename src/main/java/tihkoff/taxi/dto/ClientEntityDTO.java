package tihkoff.taxi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ClientEntityDTO {
    @NotNull
    private String phoneNumber;

    @NotNull
    private String name;

    @NotNull
    private Boolean status;

    private List<Long> taxiOrders ;

}
