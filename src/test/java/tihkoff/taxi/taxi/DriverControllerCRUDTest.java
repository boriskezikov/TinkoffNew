package tihkoff.taxi.taxi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import tihkoff.taxi.domain.TaxiDriverEntity;
import tihkoff.taxi.dto.CarEntityDTO;
import tihkoff.taxi.dto.TaxiDriverEntityDTO;
import tihkoff.taxi.mapper.TaxiDriverEntityMapper;
import tihkoff.taxi.repository.TaxiDriverEntityRepository;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DriverControllerCRUDTest {
    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();
    private TaxiDriverEntity taxiDriverEntity;
    private TaxiDriverEntity taxiDriverEntity2;

    private TaxiDriverEntityDTO taxiDriverEntityDTO = new TaxiDriverEntityDTO();
    private TaxiDriverEntityDTO taxiDriverEntityDTO2 = new TaxiDriverEntityDTO();


    @Autowired
    private TaxiDriverEntityMapper taxiDriverEntityMapper;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private TaxiDriverEntityRepository taxiDriverEntityRepository;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        taxiDriverEntityRepository.deleteAll();

        CarEntityDTO carEntityDTO = new CarEntityDTO();
        carEntityDTO.setManufacturerId(12L);
        carEntityDTO.setModelInfo(";ldas");


        taxiDriverEntityDTO.setPassport("14885");
        taxiDriverEntityDTO.setLicenseNumber("9884189");
        taxiDriverEntityDTO.setName("BOris");
        taxiDriverEntityDTO.setStatus(1);

        taxiDriverEntityDTO2.setStatus(1);
        taxiDriverEntityDTO2.setName("jfjf");
        taxiDriverEntityDTO2.setLicenseNumber("2034636");
        taxiDriverEntityDTO2.setPassport("1512");

        taxiDriverEntity = taxiDriverEntityRepository.save(taxiDriverEntityMapper.taxiDriverDTOmap(taxiDriverEntityDTO));
        taxiDriverEntity2 = taxiDriverEntityRepository.save(taxiDriverEntityMapper.taxiDriverDTOmap(taxiDriverEntityDTO2));


    }

    @After
    public void tearDown() {
        taxiDriverEntityRepository.deleteAll();
    }


    @Test
    public void getAllDriversTest() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/drivers/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        List<TaxiDriverEntityDTO> expected = taxiDriverEntityMapper.conveter(taxiDriverEntityRepository.findAll());
        List<TaxiDriverEntityDTO> factsheeet = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<TaxiDriverEntityDTO>>() {
        });

        Assertions.assertThat(expected).usingFieldByFieldElementComparator().isEqualTo(factsheeet);
    }

    @Test
    public void getDriverByIdTest() throws Exception {
        Long id = taxiDriverEntity.getId();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/drivers/driversId/" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        TaxiDriverEntityDTO expected = taxiDriverEntityMapper.taxiDriverMap(taxiDriverEntity);
        TaxiDriverEntityDTO factsheet = mapper.readValue(mvcResult.getResponse().getContentAsString(), TaxiDriverEntityDTO.class);

        Assertions.assertThat(expected).isEqualToComparingFieldByField(factsheet);
    }

    @Test
    public void editDriversTest() throws Exception {
        String json = mapper.writeValueAsString(taxiDriverEntityDTO);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/drivers/" + taxiDriverEntity.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        json = mvcResult.getResponse().getContentAsString();
        TaxiDriverEntityDTO expected = taxiDriverEntityMapper.taxiDriverMap(taxiDriverEntity);
        TaxiDriverEntityDTO factsheet = mapper.readValue(json, TaxiDriverEntityDTO.class);

        Assertions.assertThat(expected).isEqualToIgnoringGivenFields(factsheet, "id");


    }

    @Test
    public void deleteDriversTest() throws Exception {
        taxiDriverEntityRepository.deleteAll();
        taxiDriverEntity = taxiDriverEntityRepository.save(taxiDriverEntityMapper.taxiDriverDTOmap(taxiDriverEntityDTO));
        mvc.perform(MockMvcRequestBuilders.delete("/drivers/driversId/" + taxiDriverEntity.getId()))
                .andExpect(status().isOk())
                .andReturn();

        List<TaxiDriverEntity> list = taxiDriverEntityRepository.findAll();

        Assertions.assertThat(list.isEmpty()).isTrue();
    }

    @Test
    public void addDriverTest() throws Exception {
        taxiDriverEntityRepository.deleteAll();

        String json = mapper.writeValueAsString(taxiDriverEntityDTO);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/drivers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andReturn();

        json = mvcResult.getResponse().getContentAsString();
        TaxiDriverEntityDTO factsheet = mapper.readValue(json, TaxiDriverEntityDTO.class);
        TaxiDriverEntityDTO expected = taxiDriverEntityMapper.taxiDriverMap(taxiDriverEntityRepository.findAll().get(0));

        Assertions.assertThat(expected).isEqualToIgnoringGivenFields(factsheet, "id");
    }


}

