package tihkoff.taxi.controller;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tihkoff.taxi.dto.ClientEntityDTO;
import tihkoff.taxi.services.ClientService;
import javax.validation.Valid;
import java.util.List;




@RestController
@RequiredArgsConstructor
@RequestMapping("/CLIENT_ENTITY")
public class ClientEntityController {
    private final ClientService clientService;


    @GetMapping("{client_id}")
    public ClientEntityDTO getClient(@PathVariable("client_id") String phoneNumber)throws NumberFormatException
    {
        return clientService.getByPhone(phoneNumber);
    }

    @GetMapping
    public List<ClientEntityDTO>getAll()
    {
        return clientService.getAll();
    }

    @PostMapping("/post")
    public void addClient(@RequestBody @Valid ClientEntityDTO clientEntityDTO) throws java.lang.IllegalStateException
    {
        clientService.addClient(clientEntityDTO);
    }


    @PutMapping("/edit/{phone}")
    public ClientEntityDTO editClient(@RequestBody @Valid ClientEntityDTO clientEntityDTO, @PathVariable("phone") String phoneNumber)
    {
        return clientService.editClient(clientEntityDTO, phoneNumber);

    }

    @DeleteMapping("delete/{phone}")
    public void deleteClient(@PathVariable("phone") String phone)
    {
        clientService.deleteByPhone(phone);

    }

}
