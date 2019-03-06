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
import tihkoff.taxi.domain.TariffEntity;
import tihkoff.taxi.dto.TariffEntityDTO;
import tihkoff.taxi.mapper.TariffEntityMapper;
import tihkoff.taxi.repository.TariffRepository;

import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TariffControllerCRUDTest {
    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();
    private TariffEntityDTO tariffEntityDTO = new TariffEntityDTO();
    private TariffEntityDTO tariffEntityDTO2 = new TariffEntityDTO();
    private TariffEntity tariffEntity;

    @Autowired
    private TariffEntityMapper tariffEntityMapper;
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private TariffRepository tariffRepository;

    @Before
    public void setUp() {
        tariffRepository.deleteAll();
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();

        tariffEntityDTO.setTariffInfo("lk;gdslk;g");
        tariffEntityDTO.setPrice(124);


        tariffEntityDTO2.setTariffInfo("kfkf");
        tariffEntityDTO2.setPrice(120);

        tariffEntity = tariffRepository.save(tariffEntityMapper.tariffEntityDTOmap(tariffEntityDTO));
        tariffRepository.save(tariffEntityMapper.tariffEntityDTOmap(tariffEntityDTO2));


    }

    @After
    public void tearDown() {
        tariffRepository.deleteAll();
    }

    @Test
    public void getAllTariffs() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/tariffs/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        List<TariffEntityDTO> expected = tariffEntityMapper.conveter(tariffRepository.findAll());
        String json = mvcResult.getResponse().getContentAsString();
        String type = mvcResult.getResponse().getContentType();

        List<TariffEntityDTO> factsheet = mapper.readValue(json, new TypeReference<List<TariffEntityDTO>>() {
        });

        Assertions.assertThat(expected.size()).isEqualTo(factsheet.size());
        Assertions.assertThat(expected).usingFieldByFieldElementComparator().containsAll(factsheet);
    }

    @Test
    public void getTariffsByIdTest() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/tariffs/" + tariffEntity.getTariffId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();

        TariffEntityDTO expected = tariffEntityMapper.tariffEntityMap(tariffEntity);
        TariffEntityDTO factsheet = mapper.readValue(json, TariffEntityDTO.class);

        System.out.println("Второй тест json" + json);
        Assertions.assertThat(expected).isEqualToComparingFieldByField(factsheet);

    }

    @Test
    public void postTariffTest() throws Exception {
        tariffRepository.deleteAll();

        String json = mapper.writeValueAsString(tariffEntityDTO);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/tariffs/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String jsonFile = mvcResult.getResponse().getContentAsString();

        TariffEntityDTO factsheet = mapper.readValue(jsonFile, TariffEntityDTO.class);
        TariffEntityDTO expected = tariffEntityMapper.tariffEntityMap(tariffRepository.findAll().get(0));

        Assertions.assertThat(expected).isEqualToIgnoringGivenFields(factsheet, "tariffId");
    }

    @Test
    public void editTariffTest() throws Exception {
        String json = mapper.writeValueAsString(tariffEntityDTO);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/tariffs/" + tariffEntity.getTariffId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        json = mvcResult.getResponse().getContentAsString();
        TariffEntityDTO factsheet = mapper.readValue(json, TariffEntityDTO.class);
        TariffEntityDTO expected = tariffEntityMapper.tariffEntityMap(tariffRepository.findAll().get(0));

        Assertions.assertThat(expected).isEqualToIgnoringGivenFields(factsheet, "tariffId");
    }

    @Test

    public void deleteTariffTest() throws Exception {
        Integer tariffId = tariffEntity.getTariffId();
        mvc.perform(MockMvcRequestBuilders.delete("/tariffs/" + tariffId)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
            Assertions.assertThat(tariffRepository.existsById(tariffId)).isFalse();

        }
}


