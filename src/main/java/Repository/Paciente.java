package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Paciente extends JpaRepository<Paciente, Integer> {
    public Paciente findByNome(String nome);
    public Paciente findByResponsavel(String responsavel);
}
