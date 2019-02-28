package tihkoff.taxi.taxi;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tihkoff.taxi.domain.*;
import tihkoff.taxi.repository.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DEl {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private TaxiDriverEntityRepository taxiDriverRepository;
    @Autowired
    private ClientRepository  clientRepository;
    @Autowired
    private TariffRepository tariffRepository;
    @Autowired
    private TaxiOrderRepository taxiOrderRepository;
    @Autowired
    private RateRepository rateRepository;

    @Test
    public void tearDown() {
        taxiOrderRepository.deleteAll();
        taxiDriverRepository.deleteAll();
        tariffRepository.deleteAll();
        rateRepository.deleteAll();
        clientRepository.deleteAll();
        carRepository.deleteAll();





    }


    }

