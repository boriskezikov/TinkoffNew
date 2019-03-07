package tihkoff.taxi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tihkoff.taxi.dto.TariffEntityDTO;

import tihkoff.taxi.services.TariffService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tariffs")
public class TariffEntityController {
        private final TariffService tariffService;

        @GetMapping("{id}")
        public TariffEntityDTO getTariff(@PathVariable("id") Integer tariffID)throws NumberFormatException
        {
            return tariffService.getById(tariffID);
        }
        @GetMapping("/more/{price}")
        public List<TariffEntityDTO> getTariffsGraterThan(@PathVariable("price") Integer price) throws Exception{
            return tariffService.getByPriceGreater(price);
        }

        @GetMapping("/less/{price}")
        public List<TariffEntityDTO> getTariffsLessThan(@PathVariable("price") Integer price) throws Exception{
            return tariffService.getByPriceLess(price);
        }

        @GetMapping
        public List<TariffEntityDTO> getAll()
        {
            return tariffService.getAll();
        }

        @PostMapping
        public TariffEntityDTO addTariff(@RequestBody @Valid TariffEntityDTO tariffEntityDTO) throws java.lang.IllegalStateException
        {
            return tariffService.addTariff(tariffEntityDTO);
        }

        @PutMapping("{id}")
        public TariffEntityDTO editTariff(@RequestBody @Valid TariffEntityDTO tariffEntityDTO, @PathVariable("id") Integer tariffID)
        {
            return tariffService.editTariff(tariffEntityDTO, tariffID);
        }

        @DeleteMapping("{id}")
        public void deleteTariff(@PathVariable("id") Integer carId)
        {
            tariffService.deleteById(carId);
        }
    }


