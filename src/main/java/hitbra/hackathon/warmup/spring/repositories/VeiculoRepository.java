package hitbra.hackathon.warmup.spring.repositories;

import hitbra.hackathon.warmup.spring.model.Veiculo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VeiculoRepository extends MongoRepository<Veiculo, String> {

    public List<Veiculo> findByModelo(String modelo);
    public List<Veiculo> findByMarca(String marca);
    public List<Veiculo> findByMarcaOrAnoOrLocal(String marca, String ano, String local);

}
