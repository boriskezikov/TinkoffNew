//package tihkoff.taxi.taxi;
//
//import org.assertj.core.api.Assertions;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import tihkoff.taxi.domain.*;
//import tihkoff.taxi.repository.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TaxiApplicationTests {
//
//    @Autowired
//    private CarRepository carRepository;
//    @Autowired
//    private TaxiDriverEntityRepository taxiDriverRepository;
//    @Autowired
//    private ClientRepository  clientRepository;
//    @Autowired
//    private TariffRepository tariffRepository;
//    @Autowired
//    private TaxiOrderRepository taxiOrderRepository;
//    @Autowired
//    private RateRepository rateRepository;
//
//    @Before
//    public void tearDown() {
//        taxiDriverRepository.deleteAll();
//        carRepository.deleteAll();
//        clientRepository.deleteAll();
//        tariffRepository.deleteAll();
//        rateRepository.deleteAll();
//        taxiOrderRepository.deleteAll();
//
//     }
//
//    @Test
//    public void contextLoads() {
//        CarEntity carEntity = new CarEntity();
//
//        carEntity.setManufacturer(Manufacturer.BMW);
//        carEntity.setModelInfo("model14Info1");
//        carEntity.setTechCondition(2);
//        carEntity.setCategory(0);
//        carEntity = carRepository.save(carEntity);
//        //Assertions.assertThat(carRepository.findAll()).hasSize(1);
//
//        TaxiDriverEntity taxiDriverEntity = new TaxiDriverEntity();
//        taxiDriverEntity.setCarEntity(carEntity);
//        taxiDriverEntity.setLicenseNumber("3324");
//        taxiDriverEntity.setPassport("31424213");
//        taxiDriverEntity.setName("naqarfme");
//        taxiDriverEntity = taxiDriverRepository.save(taxiDriverEntity);
//        //Assertions.assertThat(taxiDriverRepository.findById(taxiDriverEntity.getIdDriver())).isNotEmpty();
//
//        TariffEntity tariffEntity = new TariffEntity();
//        tariffEntity.setPrice(156);
//        tariffEntity.setTariffInfo("FADFKS");
//        tariffEntity = tariffRepository.save(tariffEntity);
//
//        RateEntity rateEntity = new RateEntity();
//        rateEntity.setReview(";kdafk;lfdak;l");
//        rateEntity = rateRepository.save(rateEntity);
//
//        ClientEntity clientEntity = new ClientEntity();
//        clientEntity.setName("BOris");
//        clientEntity.setPhoneNumber("79308196392");
//        clientEntity.setStatus(true);
//        clientEntity = clientRepository.save(clientEntity);
//
//        TaxiOrderEntity taxiOrderEntity = new TaxiOrderEntity();
//        taxiOrderEntity.setClientLocation("Moscow");
//        taxiOrderEntity.setDistination("Kiev");
//        taxiOrderEntity.setStatus(1);
//        taxiOrderEntity.setTaxiDriverEntity(taxiDriverEntity);
//        taxiOrderEntity.setClientEntity(clientEntity);
//        taxiOrderEntity.setTariffEntity(tariffEntity);
//        taxiOrderEntity.setRateEntity(rateEntity);
//        taxiOrderEntity = taxiOrderRepository.save(taxiOrderEntity);
//
//
//
//
//    }
//}
