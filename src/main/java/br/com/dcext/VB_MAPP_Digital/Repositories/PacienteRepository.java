package br.com.dcext.VB_MAPP_Digital.Repositories;

import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    public List<Paciente> findByNomeContainsIgnoreCase(String nome);
    public Paciente findByResponsavel(String responsavel);
}
