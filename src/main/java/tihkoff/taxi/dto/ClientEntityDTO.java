package tihkoff.taxi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ClientEntityDTO {
    private String phoneNumber;

    private String name;

    private Boolean status;

    private List<TaxiOrderDTO> taxiOrders = new ArrayList<>();

}
