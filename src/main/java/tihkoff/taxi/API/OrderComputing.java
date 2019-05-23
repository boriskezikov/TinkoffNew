package tihkoff.taxi.API;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import tihkoff.taxi.domain.TaxiDriverEntity;
import tihkoff.taxi.dto.TariffEntityDTO;
import tihkoff.taxi.dto.TaxiDriverEntityDTO;
import tihkoff.taxi.mapper.TaxiDriverEntityMapper;
import tihkoff.taxi.repository.TaxiDriverEntityRepository;
import tihkoff.taxi.services.TariffService;
import tihkoff.taxi.services.TaxiDriverService;

import java.util.List;


@RequiredArgsConstructor
@Component
public class OrderComputing {

    private final TaxiDriverService taxiDriverService;
    private final TariffService tariffService;
    private final TaxiDriverEntityRepository taxiDriverEntityRepository;
    private final TaxiDriverEntityMapper taxiDriverEntityMapper;

    TaxiDriverEntityDTO searchDriver() {
        try {
            TaxiDriverEntityDTO taxiDriverEntityDTO = taxiDriverService.getAll()
                    .stream()
                    .filter(x -> x.getStatus() == 0)
                    .findFirst()
                    .orElseThrow(NullPointerException::new);
            taxiDriverEntityDTO.setStatus(1);

            taxiDriverService.editDriver(taxiDriverEntityDTO, taxiDriverEntityDTO.getId());

            return taxiDriverEntityDTO;
        } catch (NullPointerException ex) {
            System.out.println("NO DRIVERS");
            return null;
        }
    }


    TariffEntityDTO searchTariff() {
        return tariffService.getAll()
                .stream()
                .findAny()
                .orElseThrow(NullPointerException::new);

    }


}

