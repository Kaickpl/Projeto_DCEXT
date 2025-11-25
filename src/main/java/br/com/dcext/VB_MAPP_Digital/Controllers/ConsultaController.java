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
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;


    @PostMapping
    public ResponseEntity<Consulta> criarConsulta(@RequestBody ConsultaDTO dto){

        return ResponseEntity.ok(consultaService.criarConsulta(dto));

    }

    @GetMapping
    public ResponseEntity<List<Consulta>> listarConsultas(){
        return ResponseEntity.ok(consultaService.listarConsultas());
    }

    @PostMapping("/{consultaId}/atividades")
    public ResponseEntity<Consulta> realizarAtividade(@PathVariable int consultaId, @RequestBody RealizarAtividadeDTO dto){
        return ResponseEntity.ok(consultaService.realizarAtividade(consultaId, dto));
    }
}
