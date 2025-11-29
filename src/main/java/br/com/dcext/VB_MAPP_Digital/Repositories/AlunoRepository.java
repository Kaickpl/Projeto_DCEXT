package br.com.dcext.VB_MAPP_Digital.Repositories;

import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
        public Aluno findByMatricula(String matricula);
        public Aluno findByNomeAluno(String nome);


        Optional<Aluno> findByEmail(String email);
}
