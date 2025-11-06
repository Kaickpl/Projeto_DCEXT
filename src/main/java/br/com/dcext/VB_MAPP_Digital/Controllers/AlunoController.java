package br.com.dcext.VB_MAPP_Digital.Controllers;


import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import br.com.dcext.VB_MAPP_Digital.Repositories.AlunoRepository;
import br.com.dcext.VB_MAPP_Digital.Services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {

        return ResponseEntity.ok(alunoService.cadastrarAluno(aluno));

    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos() {
        return ResponseEntity.ok(alunoService.listarAlunos());
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAluno(@RequestBody int idAluno) {
        boolean deletado = alunoService.deletarAluno(idAluno);
        if (deletado == true) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.badRequest().build();
            }
    }

    @PutMapping
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable int id, @RequestBody Aluno aluno) {
        Aluno alunoatualizado = alunoService.atualizarAluno(id,aluno);

        return ResponseEntity.ok().body(alunoatualizado);

    }

}
