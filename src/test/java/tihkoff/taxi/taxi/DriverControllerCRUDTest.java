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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import tihkoff.taxi.domain.TaxiDriverEntity;
import tihkoff.taxi.dto.CarEntityDTO;
import tihkoff.taxi.dto.TaxiDriverEntityDTO;
import tihkoff.taxi.mapper.TaxiDriverEntityMapper;
import tihkoff.taxi.repository.TaxiDriverEntityRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DriverControllerCRUDTest {
    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();
    private TaxiDriverEntityDTO taxiDriverEntityDTO = new TaxiDriverEntityDTO();
    private TaxiDriverEntityDTO taxiDriverEntityDTO2 = new TaxiDriverEntityDTO();
    private TaxiDriverEntity taxiDriverEntity;

    @Autowired
    private TaxiDriverEntityMapper taxiDriverEntityMapper;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private TaxiDriverEntityRepository taxiDriverEntityRepository;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        taxiDriverEntityDTO.setPassport("14885");
        taxiDriverEntityDTO.setLicenseNumber("984189");
        taxiDriverEntityDTO.setName("BOris");
        taxiDriverEntityDTO.setStatus(1);
        taxiDriverEntityDTO2.setStatus(1);
        taxiDriverEntityDTO2.setName("jfjf");
        taxiDriverEntityDTO2.setLicenseNumber("234636");
        taxiDriverEntityDTO2.setPassport("lsfdljsdf");

        taxiDriverEntity = taxiDriverEntityRepository.save(taxiDriverEntityMapper.taxiDriverDTOmap(taxiDriverEntityDTO));
        taxiDriverEntityRepository.save(taxiDriverEntityMapper.taxiDriverDTOmap(taxiDriverEntityDTO2));


    }

    @After
    public void tearDown() throws Exception {
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
        List<TaxiDriverEntityDTO> factsheeet = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<TaxiDriverEntityDTO>>(){});

        Assertions.assertThat(expected).usingFieldByFieldElementComparator().isEqualTo(factsheeet);
    }

    @Test
    public void getDriverByIdTest() throws Exception {
        Long id = taxiDriverEntity.getDriverID();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/drivers/" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        TaxiDriverEntityDTO expected = taxiDriverEntityMapper.taxiDriverMap(taxiDriverEntity);
        TaxiDriverEntityDTO factesheet = mapper.readValue(mvcResult.getResponse().getContentAsString(),TaxiDriverEntityDTO.class);
        Assertions.assertThat(expected).isEqualToComparingFieldByField(factesheet);
    }

    @Test
    public void editDriversTest() throws Exception {

    }

    @Test
    public void deleteDriversTest() throws Exception {

    }

    @Test
    public void addDriverTest() throws Exception {

    }


}

