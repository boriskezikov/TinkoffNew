package tihkoff.taxi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tihkoff.taxi.dto.TariffEntityDTO;

import tihkoff.taxi.services.TariffService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tariff-entity")
public class TariffEntityController {
        private final TariffService tariffService;

        @GetMapping("/get/{id}")
        public TariffEntityDTO getTariff(@PathVariable("id") Integer tariffID)throws NumberFormatException
        {
            return tariffService.getById(tariffID);
        }

        @GetMapping
        public List<TariffEntityDTO> getAll()
        {
            return tariffService.getAll();
        }

        @PostMapping("/post")
        public void addTariff(@RequestBody @Valid TariffEntityDTO tariffEntityDTO) throws java.lang.IllegalStateException
        {
            tariffService.addTariff(tariffEntityDTO);
        }

        @PutMapping("/edit/{id}")
        public TariffEntityDTO editTariff(@RequestBody @Valid TariffEntityDTO tariffEntityDTO, @PathVariable("id") Integer tariffID)
        {
            return tariffService.editTariff(tariffEntityDTO, tariffID);
        }

        @DeleteMapping("delete/{id}")
        public void deleteTariff(@PathVariable("id") Integer carId)
        {
            tariffService.deleteById(carId);
        }
    }


