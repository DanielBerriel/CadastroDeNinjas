package dev.java10x.CadastroDeNinjas.Service;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import dev.java10x.CadastroDeNinjas.Repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> getAll() { return missoesRepository.findAll(); }
    public MissoesModel save(MissoesModel missoes) { return missoesRepository.save(missoes); }
    public void delete(Long id) { missoesRepository.deleteById(id); }

}
