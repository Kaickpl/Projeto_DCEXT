package br.com.dcext.VB_MAPP_Digital.Repositories;

import br.com.dcext.VB_MAPP_Digital.Entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    @Query( "SELECT c " +
            "FROM Consulta c "
            + "JOIN c.paciente p"
            + " WHERE p.pacienteId = :pacienteId"
            + " ORDER BY c.dataConsulta DESC"
            )
    public List<Consulta> findConsultasByPacienteId(@Param("pacienteId") Integer pacienteId);
}
