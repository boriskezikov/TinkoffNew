package tihkoff.taxi.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tihkoff.taxi.domain.RateEntity;
import tihkoff.taxi.dto.RateEntityDTO;
import tihkoff.taxi.services.RateService;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/rates")
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

    @PostMapping
    public RateEntityDTO addRate(@RequestBody @Valid RateEntityDTO rateEntityDTO) throws java.lang.IllegalStateException
    {
        return rateService.addRate(rateEntityDTO);
    }

    @PutMapping("{id}")
    public RateEntityDTO editRate(@RequestBody @Valid RateEntityDTO rateEntityDTO, @PathVariable("id") Long rateID)
    {
        return rateService.editRate(rateEntityDTO, rateID);
    }

    @DeleteMapping("{id}")
    public void deleteRate(@PathVariable("id") Long rateId)
    {
        rateService.deleteById(rateId);
    }
}
