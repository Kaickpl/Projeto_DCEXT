package br.com.dcext.VB_MAPP_Digital.Repository;

import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
        public AlunoRepository findByMatricula(String matricula);
        public AlunoRepository findByNome(String nome);
}
