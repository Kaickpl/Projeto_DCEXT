package br.com.dcext.VB_MAPP_Digital.Controllers;


import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.PacienteDTOs;
import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;
import br.com.dcext.VB_MAPP_Digital.Mappers.PacienteMapper;
import br.com.dcext.VB_MAPP_Digital.Services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

        @Autowired
        private PacienteService pacienteService;

        @PostMapping("/cadastrar")
        public ResponseEntity<PacienteDTOs> cadastrarPaciente(@RequestBody PacienteDTOs pacienteDTOs) {
            Paciente paciente = pacienteService.cadastrarPaciente(pacienteDTOs);
            PacienteDTOs pacienteDTO = PacienteMapper.paraDTO(paciente);
            return ResponseEntity.ok(pacienteDTO);
        }

        @DeleteMapping("/{idPaciente}")
        public ResponseEntity<Boolean> deletarPaciente(@PathVariable int idPaciente) {
            return ResponseEntity.ok(pacienteService.deletarPaciente(idPaciente));
        }

        @GetMapping
        public ResponseEntity<List<PacienteDTOs>> listarPacientes(@RequestParam(required = false) String nome) {
            List<PacienteDTOs> pacientes = pacienteService.listarPacienteNome(nome).stream().map(p -> new PacienteDTOs(p)).collect(Collectors.toList());
            if (nome != null) {
                return ResponseEntity.status(200).body(pacientes);
            }

            return ResponseEntity.status(404).body(null);
        }

    @PutMapping("/{idPaciente}")
        public ResponseEntity<Paciente> atualizarPaciente(
                @PathVariable int idPaciente,
                @RequestBody Paciente paciente) {

            Paciente atualizado = pacienteService.editarPaciente(idPaciente, paciente);

            if (atualizado == null) {
                return ResponseEntity.badRequest().build();
            }

            return ResponseEntity.ok(atualizado);
        }
    }
