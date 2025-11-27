package br.com.dcext.VB_MAPP_Digital.Controllers;


import br.com.dcext.VB_MAPP_Digital.Entities.Consulta;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ConsultaDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.RealizarAtividadeDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ResponseConsultaDTO;
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
    public ResponseEntity<ResponseConsultaDTO> criarConsulta(@RequestBody ConsultaDTO dto){

        return ResponseEntity.ok(consultaService.criarConsulta(dto));

    }

    @GetMapping
    public ResponseEntity<List<ResponseConsultaDTO>> listarConsultas(){
        return ResponseEntity.ok(consultaService.listarConsultas());
    }

    @PostMapping("/atividades")
    public ResponseEntity<Consulta> realizarAtividade(@RequestBody RealizarAtividadeDTO dto){
        return ResponseEntity.ok(consultaService.realizarAtividade(dto));
    }
}
