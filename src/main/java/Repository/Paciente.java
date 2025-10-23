package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Paciente extends JpaRepository<Paciente, Integer> {
    public Paciente findByNome(String nome);
    public Paciente findByResponsavel(String responsavel);
}
