package dev.java10x.CadastroDeNinjas.Service;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastroDeNinjas.Repository.MissoesRepository;
import dev.java10x.CadastroDeNinjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final MissoesRepository missoesRepository;

    public NinjaService(NinjaRepository ninjaRepository,  MissoesRepository missoesRepository) {
        this.ninjaRepository = ninjaRepository;
        this.missoesRepository = missoesRepository;
    }

    public List<NinjaModel> getAll() { return ninjaRepository.findAll(); }
    public NinjaModel save(NinjaModel ninja) { return ninjaRepository.save(ninja); }
    public void delete(Long id) { ninjaRepository.deleteById(id); }
    public NinjaModel bindsNinjaToMission (Long ninjaId, Long missaoId) {
        NinjaModel ninja =  ninjaRepository.findById(ninjaId)
                .orElseThrow(() -> new RuntimeException("Ninja não encontrado com esse id: " + ninjaId));

        if(ninja.getMissoes() != null) {
            throw new RuntimeException("Este ninja já está em uma missão");
        }

        MissoesModel missoes = missoesRepository.findById(missaoId)
                .orElseThrow(()-> new RuntimeException("Missão não encontrada com esse id: " +missaoId));

        ninja.setMissoes(missoes);
        return ninjaRepository.save(ninja);
    }

}
