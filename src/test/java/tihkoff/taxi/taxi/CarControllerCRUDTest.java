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
import tihkoff.taxi.domain.CarEntity;
import tihkoff.taxi.dto.CarEntityDTO;
import tihkoff.taxi.mapper.CarEntityMapper;
import tihkoff.taxi.repository.CarRepository;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CarControllerCRUDTest {
    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();
    private CarEntityDTO carEntityDTO = new CarEntityDTO();
    private CarEntityDTO carEntityDTO2 = new CarEntityDTO();
    private CarEntity carEntity;

    @Autowired
    private CarEntityMapper carEntityMapper;
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private CarRepository carRepository;

    @Before
    public void setUp() {
        carRepository.deleteAll();
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        carEntityDTO.setModelInfo("Lada");
        carEntityDTO.setCategory(1);
        carEntityDTO.setTechCondition(6);
        carEntityDTO.setManufacturerId(2L);

        carEntityDTO2.setCategory(1);
        carEntityDTO2.setModelInfo("kfkf");
        carEntityDTO2.setTechCondition(5);
        carEntityDTO2.setManufacturerId(2L);

        carEntity = carRepository.save(carEntityMapper.carEntityDTOmap(carEntityDTO));
        carRepository.save(carEntityMapper.carEntityDTOmap(carEntityDTO2));


    }

    @After
    public void tearDown() {
        carRepository.deleteAll();
    }

    @Test
    public void getAllCars() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/cars/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        List<CarEntityDTO> expected = carEntityMapper.conveter(carRepository.findAll());
        String json = mvcResult.getResponse().getContentAsString();
        String type = mvcResult.getResponse().getContentType();
        List<CarEntityDTO> factsheet = mapper.readValue(json, new TypeReference<List<CarEntityDTO>>() {
        });
        Assertions.assertThat(expected.size()).isEqualTo(factsheet.size());
        Assertions.assertThat(expected).usingFieldByFieldElementComparator().containsAll(factsheet);
    }

    @Test
    public void getCarByIdTest() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/cars/" + carEntity.getCarId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        String json = mvcResult.getResponse().getContentAsString();
        CarEntityDTO expected = carEntityMapper.carEntityMap(carEntity);
        CarEntityDTO factsheet = mapper.readValue(json, CarEntityDTO.class);
        System.out.println("Второй тест json" + json);
        Assertions.assertThat(expected).isEqualToComparingFieldByField(factsheet);

    }

    @Test
    public void postCarTest() throws Exception {
        carRepository.deleteAll();

        String json = mapper.writeValueAsString(carEntityDTO);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/cars/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String jsonFile = mvcResult.getResponse().getContentAsString();

        CarEntityDTO factsheet = mapper.readValue(jsonFile, CarEntityDTO.class);
        CarEntityDTO expected = carEntityMapper.carEntityMap(carRepository.findAll().get(0));

        Assertions.assertThat(expected).isEqualToIgnoringGivenFields(factsheet, "carId");
    }

    @Test
    public void editCarTest() throws Exception {
        String json = mapper.writeValueAsString(carEntityDTO);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/cars/" + carEntity.getCarId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        json = mvcResult.getResponse().getContentAsString();
        CarEntityDTO factsheet = mapper.readValue(json, CarEntityDTO.class);
        CarEntityDTO expected = carEntityMapper.carEntityMap(carRepository.findAll().get(0));

        Assertions.assertThat(expected).isEqualToIgnoringGivenFields(factsheet, "carId");
    }

    @Test
    public void deleteCarTest() throws Exception {
        carRepository.deleteAll();
        carRepository.save(carEntityMapper.carEntityDTOmap(carEntityDTO));
        mvc.perform(MockMvcRequestBuilders.delete("/cars/" + carRepository.findAll().get(0).getCarId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        List<CarEntity> list = carRepository.findAll();
        Assertions.assertThat(list.isEmpty()).isEqualTo(true);

    }


}









