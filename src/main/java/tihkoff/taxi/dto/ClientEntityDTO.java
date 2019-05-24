package tihkoff.taxi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntityDTO {
    @NotNull
    private String phoneNumber;

    @NotNull
    private String name;

    @NotNull
    private Boolean status;

    private List<Long> taxiOrders ;

}
