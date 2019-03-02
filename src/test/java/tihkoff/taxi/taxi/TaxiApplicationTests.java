/**package tihkoff.taxi.taxi;

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
public class TaxiApplicationTests {

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

    @Before
    public void tearDown() {
        taxiOrderRepository.deleteAll();
        taxiDriverRepository.deleteAll();
        tariffRepository.deleteAll();
        rateRepository.deleteAll();
        clientRepository.deleteAll();
        carRepository.deleteAll();


    }

    @Test
    public void contextLoads() {
        CarEntity carEntity = new CarEntity();

        carEntity.setManufacturer(1);
        carEntity.setModelInfo("modelк14Info1");
        carEntity.setTechCondition(2);
        carEntity.setCategory(0);
        carEntity = carRepository.save(carEntity);
        //Assertions.assertThat(carRepository.findAll()).hasSize(1);

        TaxiDriverEntity taxiDriverEntity = new TaxiDriverEntity();
        taxiDriverEntity.setCarEntity(carEntity);
        taxiDriverEntity.setLicenseNumber("3324411111");
        taxiDriverEntity.setPassport("3114424213");
        taxiDriverEntity.setName("naqarакуfme");
        taxiDriverEntity = taxiDriverRepository.save(taxiDriverEntity);
        //Assertions.assertThat(taxiDriverRepository.findById(taxiDriverEntity.getIdDriver())).isNotEmpty();

       TariffEntity tariffEntity = new TariffEntity();
        tariffEntity.setPrice(156);
        tariffEntity.setTariffInfo("FADFйеуKS");
       tariffEntity = tariffRepository.save(tariffEntity);

        RateEntity rateEntity = new RateEntity();
        rateEntity.setReview(";kdafkйецу;lfdak;l");
        rateEntity = rateRepository.save(rateEntity);

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName("BOriафаыs");
        clientEntity.setPhoneNumber("798196392");
        clientEntity.setStatus(true);
      clientEntity = clientRepository.save(clientEntity);

        TaxiOrderEntity taxiOrderEntity = new TaxiOrderEntity();
        taxiOrderEntity.setClientLocation("Moфываscow");
        taxiOrderEntity.setDistination("Kiфыаev");
        taxiOrderEntity.setStatus(1);
        taxiOrderEntity.setTaxiDriverEntity(taxiDriverEntity);
       taxiOrderEntity.setClientEntity(clientEntity);
        taxiOrderEntity.setTariffEntity(tariffEntity);
        taxiOrderEntity.setRateEntity(rateEntity);
       taxiOrderEntity = taxiOrderRepository.save(taxiOrderEntity);




    }
}
*/
