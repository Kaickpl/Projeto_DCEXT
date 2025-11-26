package br.com.dcext.VB_MAPP_Digital.Controllers;


import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.PacienteDTOs;
import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;
import br.com.dcext.VB_MAPP_Digital.Services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.cadastrarPaciente(paciente));
    }

    @DeleteMapping("/{idPaciente}")
    public ResponseEntity<Boolean> deletarPaciente(@PathVariable int idPaciente) {
        return ResponseEntity.ok(pacienteService.deletarPaciente(idPaciente));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes(){
        System.out.println("ENTROU");
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }



    @GetMapping("/{id}")
    public ResponseEntity<List<Paciente>> listarPaciente(String id){
        return ResponseEntity.ok(pacienteService.listarPaciente(id));
    }

    @PutMapping
    public ResponseEntity<Paciente> atualizarPaciente(@RequestBody int idPaciente, Paciente paciente) {
        return ResponseEntity.ok(pacienteService.editarPaciente(idPaciente, paciente));
    }


}
