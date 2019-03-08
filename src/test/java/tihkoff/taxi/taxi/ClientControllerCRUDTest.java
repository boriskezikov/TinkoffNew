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
import tihkoff.taxi.domain.ClientEntity;
import tihkoff.taxi.dto.ClientEntityDTO;
import tihkoff.taxi.mapper.ClientEntityMapper;
import tihkoff.taxi.repository.ClientRepository;

import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ClientControllerCRUDTest {
    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();
    private ClientEntityDTO clientEntityDTO = new ClientEntityDTO();
    private ClientEntityDTO clientEntityDTO2 = new ClientEntityDTO();
    private ClientEntity clientEntity;
    private ClientEntity clientEntity2;

    @Autowired
    private ClientEntityMapper clientEntityMapper;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ClientRepository clientRepository;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();

        clientRepository.deleteAll();

        clientEntityDTO.setStatus(true);
        clientEntityDTO.setName("Boris");
        clientEntityDTO.setPhoneNumber("79308196302");

        clientEntityDTO2.setPhoneNumber("79308991239");
        clientEntityDTO2.setName("Polina");
        clientEntityDTO2.setStatus(false);

        clientEntity = clientRepository.save(clientEntityMapper.clientEntityDTOmap(clientEntityDTO));
        clientEntity2 = clientRepository.save(clientEntityMapper.clientEntityDTOmap(clientEntityDTO2));

    }

    @After
    public void tearDown() {

        clientRepository.deleteAll();
    }

    @Test
    public void getAllClientsTest() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/clients/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        List<ClientEntityDTO> expected = clientEntityMapper.conveter(clientRepository.findAll());
        List<ClientEntityDTO> factsheet = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<ClientEntityDTO>>() {
        });
        Assertions.assertThat(expected).usingFieldByFieldElementComparator().isEqualTo(factsheet);
    }

    @Test
    public void getClientIdTest() throws Exception {
        String phone = clientEntity.getPhoneNumber();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/clients/" + phone)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        ClientEntityDTO expected = clientEntityMapper.clientEntityMap(clientEntity);
        ClientEntityDTO factsheet = mapper.readValue(mvcResult.getResponse().getContentAsString(), ClientEntityDTO.class);

        Assertions.assertThat(expected).isEqualToIgnoringGivenFields(factsheet, "taxiOrders");
    }

    @Test
    public void saveClientTest() throws Exception {
        clientRepository.deleteAll();

        String json = mapper.writeValueAsString(clientEntityDTO);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/clients/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String jsonFile = mvcResult.getResponse().getContentAsString();

        ClientEntityDTO factsheet = mapper.readValue(jsonFile, ClientEntityDTO.class);
        ClientEntityDTO expected = clientEntityMapper.clientEntityMap(clientRepository.findAll().get(0));

        Assertions.assertThat(expected).isEqualToIgnoringGivenFields(factsheet, "id");
    }

    @Test
    @Transactional
    public void deleteClientTest() throws Exception {
        clientRepository.deleteAll();
        clientRepository.saveAndFlush(clientEntityMapper.clientEntityDTOmap(clientEntityDTO));
        mvc.perform(MockMvcRequestBuilders.delete("/clients/" + clientRepository.findAll().get(0).getPhoneNumber())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        List<ClientEntity> list = clientRepository.findAll();

        Assertions.assertThat(list.isEmpty()).isEqualTo(true);
    }

    @Test
    public void editClientTest() throws Exception {
        String json = mapper.writeValueAsString(clientEntityDTO);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/clients/" + clientEntity.getPhoneNumber())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        json = mvcResult.getResponse().getContentAsString();
        ClientEntityDTO factsheet = mapper.readValue(json, ClientEntityDTO.class);
        ClientEntityDTO expected = clientEntityMapper.clientEntityMap(clientRepository.findAll().get(0));

        Assertions.assertThat(expected).isEqualToComparingFieldByField(factsheet);
    }


}

