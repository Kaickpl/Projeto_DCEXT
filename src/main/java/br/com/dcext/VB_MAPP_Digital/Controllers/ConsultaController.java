package br.com.dcext.VB_MAPP_Digital.Controllers;


import br.com.dcext.VB_MAPP_Digital.Entities.Consulta;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ConsultaDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.RealizarAtividadeDTO;
import br.com.dcext.VB_MAPP_Digital.Services.ConsultaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/api/paciente/{idPaciente}/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;


    @PostMapping
    public ResponseEntity<Consulta> criarConsulta(@PathVariable Integer idPaciente, @RequestBody ConsultaDTO dto){
        dto.setPacienteId(idPaciente);
        return ResponseEntity.ok(consultaService.criarConsulta(dto));
    }

    @GetMapping("/{idConsulta}")
    public ResponseEntity<List<Consulta>> listarConsultasPorPAciente(@PathVariable Integer idPaciente,@PathVariable Integer idConsulta){
        List<Consulta> consultas = consultaService.listarConsultasDoPaciente(idConsulta);
        if(consultas.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consultas);
    }

}
