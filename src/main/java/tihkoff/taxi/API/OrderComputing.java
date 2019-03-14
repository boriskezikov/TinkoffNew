package tihkoff.taxi.API;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import tihkoff.taxi.dto.TariffEntityDTO;
import tihkoff.taxi.dto.TaxiDriverEntityDTO;
import tihkoff.taxi.services.TariffService;
import tihkoff.taxi.services.TaxiDriverService;



@RequiredArgsConstructor
@Component
public class OrderComputing {

    private  final TaxiDriverService taxiDriverService;
    private  final TariffService tariffService;

    public TaxiDriverEntityDTO searchDriver() {
        try{
        TaxiDriverEntityDTO taxiDriverEntityDTO = taxiDriverService.getAll()
                .stream()
                .filter(x -> x.getStatus() == 0)
                .findFirst()
                .orElseThrow(NullPointerException::new);
        taxiDriverEntityDTO.setStatus(1);
        return taxiDriverEntityDTO;}
        catch (NullPointerException ex){
            System.out.println("NO DRIVERS");
            return null;
        }
    }


    public  TariffEntityDTO searchTariff() {
        return tariffService.getAll()
                .stream()
                .findAny()
                .orElseThrow(NullPointerException::new);

    }


}

