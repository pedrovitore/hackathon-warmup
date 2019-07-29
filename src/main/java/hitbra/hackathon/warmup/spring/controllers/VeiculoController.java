package hitbra.hackathon.warmup.spring.controllers;

import hitbra.hackathon.warmup.spring.model.Veiculo;
import hitbra.hackathon.warmup.spring.repositories.VeiculoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/vehicles")
@Api(value = "/vehicles")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repo;

    @GetMapping("/")
    public List<Veiculo> getByMarca(
            @ApiParam(value = "Marca do veículo", required = true) @RequestParam(value="marca") String marca) {
        return repo.findByMarca(marca);
    }

}