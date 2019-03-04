package tihkoff.taxi.taxi;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.parser.JSONParser;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import tihkoff.taxi.controller.CarEntityController;
import tihkoff.taxi.domain.CarEntity;
import tihkoff.taxi.dto.CarEntityDTO;
import tihkoff.taxi.dto.TaxiDriverEntityDTO;
import tihkoff.taxi.mapper.CarEntityMapper;
import tihkoff.taxi.repository.CarRepository;
import tihkoff.taxi.services.CarService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarEntityCRUDTest {

    private MockMvc mvc;
    private CarEntity carEntityTest;
    private ObjectMapper mapper = new ObjectMapper();
    private CarEntityDTO carEntityDTO = new CarEntityDTO();
    private TaxiDriverEntityDTO taxiDriverEntityDTO = new TaxiDriverEntityDTO();

    @Autowired
    private CarEntityMapper carEntityMapper;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private CarRepository carRepository;

    @Before
    public void setUp(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        carEntityDTO.setCarId((1L));
        carEntityDTO.setModelInfo("Lada");
        carEntityDTO.setCategory(1);
        carEntityDTO.setTechCondition(6);
        carEntityDTO.setManufacturerId((long)2);

            }

    @After
    public void tearDown(){
        carRepository.deleteAll();
    }


    @Test
    public void getAllCars() throws Exception{
        carEntityTest = carRepository.save(carEntityMapper.carEntityDTOmap(carEntityDTO));
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/car-entity/get-all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        System.out.println( );

    List<CarEntityDTO> expected = carEntityMapper.conveter(carRepository.findAll());
    String json = mvcResult.getResponse().getContentAsString();
    String type = mvcResult.getResponse().getContentType();
        System.out.println("ЭТО ВЫВОД " + json);
        System.out.println("ЭТО TYPE " + type);


    List<CarEntityDTO> factsheet = mapper.readValue(json, new TypeReference<List<CarEntityDTO>>(){});
        System.out.println("ЭТО JSON ИЗ ТЕСТА " + factsheet);
    Iterable<CarEntityDTO> carIterator = () -> factsheet.iterator();
        Assertions.assertThat(expected.size()).isEqualTo(factsheet.size());
        Assertions.assertThat(expected).usingFieldByFieldElementComparator().containsAll(factsheet);


}
}


