package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Aluno extends JpaRepository<Aluno, Integer> {
        public Aluno findByMatricula(String matricula);
        public Aluno findByNome(String nome);
}
