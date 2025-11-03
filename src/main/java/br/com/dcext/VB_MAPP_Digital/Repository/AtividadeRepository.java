package br.com.dcext.VB_MAPP_Digital.Repository;

import br.com.dcext.VB_MAPP_Digital.Entities.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {
}
