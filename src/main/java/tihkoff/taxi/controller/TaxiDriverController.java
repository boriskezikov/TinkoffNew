package tihkoff.taxi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tihkoff.taxi.dto.TaxiDriverEntityDTO;
import tihkoff.taxi.services.TaxiDriverService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/drivers")
public class TaxiDriverController {
    private final TaxiDriverService taxiDriverService;

    @GetMapping("/driversId/{id}")
    public TaxiDriverEntityDTO getDriverById(@PathVariable("id") Long driverID){
        return taxiDriverService.getById(driverID);
    }

    @GetMapping("/driversLic/{lic}")
    public TaxiDriverEntityDTO getDriverByLicence(@PathVariable("lic") String licence){
        return taxiDriverService.getByLicence(licence);
    }

    @GetMapping("/driversPass/{pass}")
    public TaxiDriverEntityDTO getDriverByPassport(@PathVariable("pass") String passport){
        return taxiDriverService.getByPassport(passport);
    }

    @GetMapping
    public List<TaxiDriverEntityDTO> getAll(){
        return taxiDriverService.getAll();
    }

    @DeleteMapping("/driversId/{id}")
    public void deleteById(@PathVariable("id") Long driverID){
        taxiDriverService.deleteById(driverID);
    }


    @DeleteMapping("/driversLic/{lic}")
    public void deleteByLicence (@PathVariable("lic")String licence){
        taxiDriverService.deleteByLicense(licence);
    }


    @DeleteMapping("/driversPass/{pass}")
    public void deleteByPassport(@PathVariable("pass") String passport){
        taxiDriverService.deleteByPassport(passport);
    }

    @DeleteMapping
    public void deleteAll(){
        taxiDriverService.deleteAll();
    }

    @PutMapping("/{id}")
    public TaxiDriverEntityDTO editByID(@PathVariable Long id,@RequestBody @Valid TaxiDriverEntityDTO taxiDriverEntityDTO){
        return taxiDriverService.editDriver(taxiDriverEntityDTO,id);
    }

    @PostMapping
    public TaxiDriverEntityDTO addDriver(@RequestBody @Valid TaxiDriverEntityDTO taxiDriverEntityDTO){
        return  taxiDriverService.addDriver(taxiDriverEntityDTO);
    }

}

