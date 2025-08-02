package dev.java10x.CadastroDeNinjas.Repository;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {

}
