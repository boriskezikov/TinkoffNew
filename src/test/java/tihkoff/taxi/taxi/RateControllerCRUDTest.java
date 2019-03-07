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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import tihkoff.taxi.domain.RateEntity;
import tihkoff.taxi.dto.RateEntityDTO;
import tihkoff.taxi.mapper.RateEntityMapper;
import tihkoff.taxi.repository.RateRepository;
import java.util.List;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RateControllerCRUDTest {
    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();
    private RateEntityDTO rateEntityDTO = new RateEntityDTO();
    private RateEntityDTO rateEntityDTO2 = new RateEntityDTO();
    private RateEntity rateEntity;

    @Autowired
    private RateEntityMapper rateEntityMapper;
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private RateRepository rateRepository;

    @Before
    public void setUp() {
        rateRepository.deleteAll();
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();

        rateEntityDTO.setReview("Lada");


        rateEntityDTO2.setReview("kfkf");

        rateEntity = rateRepository.save(rateEntityMapper.rateEntityDTOmap(rateEntityDTO));
        rateRepository.save(rateEntityMapper.rateEntityDTOmap(rateEntityDTO2));


    }

    @After
    public void tearDown() {
        rateRepository.deleteAll();
    }

    @Test
    public void getAllRates() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/rates/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        List<RateEntityDTO> expected = rateEntityMapper.conveter(rateRepository.findAll());
        String json = mvcResult.getResponse().getContentAsString();
        String type = mvcResult.getResponse().getContentType();

        List<RateEntityDTO> factsheet = mapper.readValue(json, new TypeReference<List<RateEntityDTO>>() {
        });

        Assertions.assertThat(expected.size()).isEqualTo(factsheet.size());
        Assertions.assertThat(expected).usingFieldByFieldElementComparator().containsAll(factsheet);
    }

    @Test
    public void getRatesByIdTest() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/rates/" + rateEntity.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();

        RateEntityDTO expected = rateEntityMapper.rateEntityMAp(rateEntity);
        RateEntityDTO factsheet = mapper.readValue(json, RateEntityDTO.class);

        System.out.println("Второй тест json" + json);
        Assertions.assertThat(expected).isEqualToComparingFieldByField(factsheet);

    }

    @Test
    public void postRateTest() throws Exception {
        rateRepository.deleteAll();

        String json = mapper.writeValueAsString(rateEntityDTO);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/rates/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String jsonFile = mvcResult.getResponse().getContentAsString();

        RateEntityDTO factsheet = mapper.readValue(jsonFile, RateEntityDTO.class);
        RateEntityDTO expected = rateEntityMapper.rateEntityMAp(rateRepository.findAll().get(0));

        Assertions.assertThat(expected).isEqualToIgnoringGivenFields(factsheet, "id");
    }

    @Test
    public void editRateTest() throws Exception {
        String json = mapper.writeValueAsString(rateEntityDTO);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/rates/" + rateEntity.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        json = mvcResult.getResponse().getContentAsString();
        RateEntityDTO factsheet = mapper.readValue(json, RateEntityDTO.class);
        RateEntityDTO expected = rateEntityMapper.rateEntityMAp(rateRepository.findAll().get(0));

        Assertions.assertThat(expected).isEqualToIgnoringGivenFields(factsheet, "id");
    }

    @Test
    //@Transactional
    public void deleteRateTest() throws Exception {
        Long id = rateEntity.getId();
        mvc.perform(MockMvcRequestBuilders.delete("/rates/" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Assertions.assertThat(rateRepository.existsById(id)).isFalse();

    }


}











