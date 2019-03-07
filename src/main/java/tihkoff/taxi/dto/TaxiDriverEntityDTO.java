package tihkoff.taxi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TaxiDriverEntityDTO {
    private Long id;

    private String licenseNumber;

    private String passport;

    private Integer status;

    private String name;

    private CarEntityDTO carEntity;

    private List<TaxiOrderDTO> taxiOrders = new ArrayList<>();

}
