package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Service.MissoesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService){
        this.missoesService = missoesService;
    }

    @GetMapping("/missoes")
    public List<MissoesModel> getAllMissoes() { return missoesService.getAll(); }

    @PostMapping("/addMissoes")
    public MissoesModel createMissoes(MissoesModel missoesModel) { return missoesService.save(missoesModel); }

}
