package tihkoff.taxi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tihkoff.taxi.dto.TaxiDriverEntityDTO;
import tihkoff.taxi.services.TaxiDriverService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/driver-entity")
public class TaxiDriverController {
    private final TaxiDriverService taxiDriverService;

    @GetMapping("/getId/{id}")
    public TaxiDriverEntityDTO getDriverById(@PathVariable("id") Long driverID){
        return taxiDriverService.getById(driverID);
    }

    @GetMapping("/getLic{lic}")
    public TaxiDriverEntityDTO getDriverByLicence(@PathVariable("lic") String licence){
        return taxiDriverService.getByLicence(licence);
    }

    @GetMapping("/getPass/{pass}")
    public TaxiDriverEntityDTO getDriverByPassport(@PathVariable("pass") String passport){
        return taxiDriverService.getByPassport(passport);
    }

    @GetMapping
    public List<TaxiDriverEntityDTO> getAll(){
        return taxiDriverService.getAll();
    }

    @DeleteMapping("/delId/{id}")
    public void deleteById(@PathVariable("id") Long driverID){
        taxiDriverService.deleteById(driverID);
    }

    @DeleteMapping("/delLic/{lic}")
    public void deleteByLicence (@PathVariable("lic")String licence){
        taxiDriverService.deleteByLicense(licence);
    }

    @DeleteMapping("/delPass/{pass}")
    public void deleteByPassport(@PathVariable("pass") String passport){
        taxiDriverService.deleteByPassport(passport);
    }

    @DeleteMapping
    public void deleteAll(){
        taxiDriverService.deleteAll();
    }

    @PutMapping("/edit/{id}")
    public TaxiDriverEntityDTO editByID(@PathVariable("id") @RequestBody @Valid TaxiDriverEntityDTO taxiDriverEntityDTO, Long id){
        return taxiDriverService.editDriver(taxiDriverEntityDTO,id);
    }

    @PostMapping
    public void addDriver(@RequestBody @Valid TaxiDriverEntityDTO taxiDriverEntityDTO){
         taxiDriverService.addDriver(taxiDriverEntityDTO);
    }

}

