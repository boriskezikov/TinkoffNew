package tihkoff.taxi.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tihkoff.taxi.dto.RateEntityDTO;
import tihkoff.taxi.services.RateService;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/RATE")
public class RateEntityController {

    private final RateService rateService;

    @GetMapping("{id}")
    public RateEntityDTO getRate(@PathVariable("id") Long rateID)throws NumberFormatException
    {
        return rateService.getRateById(rateID);
    }

    @GetMapping
    public List<RateEntityDTO> getAll()
    {
        return rateService.getAll();
    }

    @PostMapping("/post")
    public void addRate(@RequestBody @Valid RateEntityDTO rateEntityDTO) throws java.lang.IllegalStateException
    {
        rateService.addRate(rateEntityDTO);
    }

    @PutMapping("/edit/{id}")
    public RateEntityDTO editRate(@RequestBody @Valid RateEntityDTO rateEntityDTO, @PathVariable("id") Long rateID)
    {
        return rateService.editRate(rateEntityDTO, rateID);
    }

    @DeleteMapping("delete/{id}")
    public void deleteRate(@PathVariable("id") Long rateId)
    {
        rateService.deleteById(rateId);
    }
}
