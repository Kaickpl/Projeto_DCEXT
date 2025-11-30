package br.com.dcext.VB_MAPP_Digital.Controllers;


import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.*;
import br.com.dcext.VB_MAPP_Digital.Repositories.AlunoRepository;
import br.com.dcext.VB_MAPP_Digital.Services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<AlunoDTO> cadastrarAluno(@RequestBody @Valid RegisterDTO dto) {

        Aluno aluno = alunoService.cadastrarAluno(dto);

        return ResponseEntity.ok().body(new AlunoDTO(aluno));

    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> listarAlunos() {
        return ResponseEntity.ok(alunoService.listarAlunos());
    }


    @DeleteMapping("/{alunoId}")
    public ResponseEntity<Void> deletarAluno(@PathVariable int alunoId) {
        boolean deletado = alunoService.deletarAluno(alunoId);

        return deletado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();

    }

    @PutMapping("/atualizarPerfil")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable int id, @RequestBody Aluno aluno) {
        Aluno alunoatualizado = alunoService.atualizarAluno(id,aluno);

        return ResponseEntity.ok().body(alunoatualizado);

    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginDTO dto) {
        var resultado =  alunoService.login(dto);
        return ResponseEntity.ok(resultado);
    }

    @PutMapping("/recuperarSenha")
    public ResponseEntity<AlunoDTO> recuperarSenha(@RequestBody TrocaSenhaDTos senhaDTOs) {
        Aluno alunoExixste = alunoService.trocarSenha(senhaDTOs);
        if (alunoExixste == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(new AlunoDTO(alunoExixste));
    }
}
