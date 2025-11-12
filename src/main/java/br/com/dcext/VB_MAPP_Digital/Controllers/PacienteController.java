package br.com.dcext.VB_MAPP_Digital.Controllers;


import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.PacienteDTOs;
import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;
import br.com.dcext.VB_MAPP_Digital.Services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody PacienteDTOs dto) {
        return ResponseEntity.ok(pacienteService.cadastrarPaciente(dto));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deletarPaciente(@RequestBody int idPaciente) {
        return ResponseEntity.ok(pacienteService.deletarPaciente(idPaciente));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPaciente(String nome){
        return ResponseEntity.ok(pacienteService.listarPaciente(nome));
    }

    @PutMapping
    public ResponseEntity<Paciente> atualizarPaciente(@RequestBody int idPaciente, Paciente paciente) {
        return ResponseEntity.ok(pacienteService.editarPaciente(idPaciente, paciente));
    }


}
