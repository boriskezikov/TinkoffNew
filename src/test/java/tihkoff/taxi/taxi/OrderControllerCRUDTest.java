package tihkoff.taxi.taxi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import tihkoff.taxi.domain.*;
import tihkoff.taxi.dto.TaxiOrderDTO;
import tihkoff.taxi.mapper.*;
import tihkoff.taxi.repository.*;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class OrderControllerCRUDTest {
    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();
    private TaxiOrderEntity taxiOrderEntity = new TaxiOrderEntity();

    @Autowired
    private TaxiOrderMapper taxiOrderMapper;

    @Autowired
    private ClientEntityMapper clientEntityMapper;
    @Autowired
    private TaxiDriverEntityMapper taxiDriverEntityMapper;

    @Autowired
    private RateEntityMapper rateEntityMapper;

    @Autowired
    private CarEntityMapper carEntityMapper;

    @Autowired
    private TariffEntityMapper tariffEntityMapper;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private TaxiOrderRepository taxiOrderRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TariffRepository tariffRepository;

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private TaxiDriverEntityRepository taxiDriverEntityRepository;


    @Before
    public void setUp() {

        mvc = MockMvcBuilders.webAppContextSetup(wac).build();

        ClientEntity clientEntity = new ClientEntity();
        RateEntity rateEntity = new RateEntity();
        TariffEntity tariffEntity = new TariffEntity();
        TaxiDriverEntity taxiDriverEntity = new TaxiDriverEntity();
        CarEntity carEntity = new CarEntity();

        carEntity.setManufacturerId(12L);
        carEntity.setCategory(1);
        carEntity.setModelInfo(RandomStringUtils.randomAlphabetic(8));
        carEntity.setTechCondition(5);
        carEntity = carRepository.save(carEntity);

        clientEntity.setStatus(true);
        clientEntity.setPhoneNumber(RandomStringUtils.randomNumeric(10));
        clientEntity.setName(RandomStringUtils.randomNumeric(8));
        clientEntity = clientRepository.save(clientEntity);

        tariffEntity.setTariffInfo(RandomStringUtils.randomNumeric(8));
        tariffEntity.setPrice(124);
        tariffEntity = tariffRepository.save(tariffEntity);

        taxiDriverEntity.setStatus(1);
        taxiDriverEntity.setPassport(RandomStringUtils.randomNumeric(8));
        taxiDriverEntity.setLicenseNumber(RandomStringUtils.randomNumeric(8));
        taxiDriverEntity.setName(RandomStringUtils.randomAlphabetic(8));
        taxiDriverEntity.setCarEntity(carEntity);
        taxiDriverEntity = taxiDriverEntityRepository.save(taxiDriverEntity);

        rateEntity.setReview(" ");

        taxiOrderEntity.setStatus(0);
        taxiOrderEntity.setClientEntity(clientEntity);
        taxiOrderEntity.setClientLocation("kfkfkf");
        taxiOrderEntity.setRateEntity(rateEntity);
        taxiOrderEntity.setTariffEntity(tariffEntity);
        taxiOrderEntity.setDestination("kkf");
        taxiOrderEntity.setTaxiDriverEntity(taxiDriverEntity);

        taxiOrderEntity = taxiOrderRepository.save(taxiOrderEntity);









    }
    
    @After
    public void tearDown(){

        taxiOrderRepository.deleteAll();
        taxiDriverEntityRepository.deleteAll();
        clientRepository.deleteAll();
        tariffRepository.deleteAll();
        rateRepository.deleteAll();
        carRepository.deleteAll();

    }


  //  @Test
    public void getOrders() throws Exception {
        String uri = "/orders/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON))
                //.andExpect(status().isOk())
                .andReturn();
        List<TaxiOrderDTO> expected = taxiOrderMapper.conveter(taxiOrderRepository.findAll());
        List<TaxiOrderDTO> factsheet = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<TaxiOrderDTO>>() {
        });
        Assertions.assertThat(expected.size()).isEqualTo(factsheet.size());
        Assertions.assertThat(expected).usingFieldByFieldElementComparator().containsAll(factsheet);

    }

   // @Test
    public void getOrderByIdTest() throws Exception {
        String uri = "/orders/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + taxiOrderEntity.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        TaxiOrderDTO expected = taxiOrderMapper.taxiOrderEntityMap(taxiOrderEntity);
        TaxiOrderDTO factsheet = mapper.readValue(json, TaxiOrderDTO.class);
        Assertions.assertThat(expected).isEqualToIgnoringGivenFields(factsheet, "id");

    }
}
