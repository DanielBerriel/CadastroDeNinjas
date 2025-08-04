package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastroDeNinjas.Service.NinjaService;

import java.util.List;

@RestController
@RequestMapping
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/ninjas")
    public List<NinjaModel> getAllNinjas() { return ninjaService.getAll(); }

    @PostMapping
    public NinjaModel saveNinja(NinjaModel ninjaModel) { return ninjaService.save(ninjaModel); }

    @DeleteMapping("/{id}")
    public void deleteNinja(@PathVariable Long id) { ninjaService.delete(id); }

    @PutMapping("{ninjaId}/missao/{missaoId}")
    public ResponseEntity<NinjaModel> vincularMissao(
            @PathVariable Long ninjaId,
            @PathVariable Long missaoId
    ) {
        NinjaModel ninjaAtualizado = ninjaService.bindsNinjaToMission(ninjaId, missaoId);
        return ResponseEntity.ok(ninjaAtualizado);
    }

}
