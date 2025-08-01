package dev.java10x.CadastroDeNinjas.Service;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastroDeNinjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> getAll() { return ninjaRepository.findAll(); }
    public NinjaModel save(NinjaModel ninja) { return ninjaRepository.save(ninja); }
    public void delete(Long id) { ninjaRepository.deleteById(id); }

}
