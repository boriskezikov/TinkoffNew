package tihkoff.taxi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ClientEntityDTO {
    private String phoneNumber;

    private String name;

    private boolean status;

    private List<TaxiOrderDTO> taxiOrderDTOS;

}
