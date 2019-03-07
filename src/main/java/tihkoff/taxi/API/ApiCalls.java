package tihkoff.taxi.API;

import tihkoff.taxi.dto.TariffEntityDTO;
import tihkoff.taxi.dto.TaxiDriverEntityDTO;
import tihkoff.taxi.dto.TaxiOrderDTO;
import tihkoff.taxi.services.TariffService;
import tihkoff.taxi.services.TaxiDriverService;
import java.util.List;

class ApiCalls {
    private static TaxiDriverService taxiDriverService;
    private static TariffService tariffService;


    protected static TaxiOrderDTO searchDriver(TaxiOrderDTO taxiOrderDTO) {
        List<TaxiDriverEntityDTO> drivers = taxiDriverService.getAll();
        for (int i = 0; i < drivers.size(); ++i) {
            if (drivers.get(i).getStatus() == 0) {
                taxiOrderDTO.setTaxiDriverEntity(drivers.get(i));
                break;
            }
        }
        return taxiOrderDTO;

    }

     protected static TaxiOrderDTO setUpTariff(TaxiOrderDTO taxiOrderDTO) {
        List<TariffEntityDTO> tariff = tariffService.getAll();
       // if (taxiOrderDTO.getDestination() - taxiOrderDTO.getClientLocation() > 10)
        for (int i = 0; i < tariff.size(); ++i) {
            taxiOrderDTO.setTariffEntity(tariff.get(i));
            break;
        }
        return taxiOrderDTO;
    }

     protected static TaxiOrderDTO changeOrderStatus(TaxiOrderDTO taxiOrderDTO, Integer status) {
        if (status == 0 || status == 1 || status == 2) {
            taxiOrderDTO.setStatus(status);
            return taxiOrderDTO;
        }
        return null;
    }
}
