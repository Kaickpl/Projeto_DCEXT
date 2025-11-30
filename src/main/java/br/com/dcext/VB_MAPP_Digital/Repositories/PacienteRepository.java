package br.com.dcext.VB_MAPP_Digital.Repositories;

import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    public List<Paciente> findByNomePacienteContainsIgnoreCase(String nome);
    public Paciente findByResponsavel(String responsavel);

    @Query("SELECT p FROM Paciente p WHERE p.aluno.alunoId = :idAluno")
    List<Paciente> findByIdDoAluno(@Param("idAluno") int idAluno);
}
