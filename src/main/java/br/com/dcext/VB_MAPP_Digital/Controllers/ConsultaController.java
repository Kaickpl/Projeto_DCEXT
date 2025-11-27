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
//<<<<<<< HEAD
//    public ResponseEntity<ResponseConsultaDTO> criarConsulta(@RequestBody ConsultaDTO dto){
//
//=======
    public ResponseEntity<ResponseConsultaDTO> criarConsulta(@PathVariable Integer idPaciente, @RequestBody ConsultaDTO dto){
        dto.setPacienteId(idPaciente);


//>>>>>>> ab51fc45a58beba292c3b21529bce0be9a760b63
        return ResponseEntity.ok(consultaService.criarConsulta(dto));
    }

//<<<<<<< HEAD
//    @GetMapping
//    public ResponseEntity<List<ResponseConsultaDTO>> listarConsultas(){
//        return ResponseEntity.ok(consultaService.listarConsultas());
//=======
    @GetMapping()
    public ResponseEntity<List<ResponseConsultaDTO>> listarConsultasPorPAciente(){
        List<ResponseConsultaDTO> consultas = consultaService.listarConsultas();
        if(consultas.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consultas);
//>>>>>>> ab51fc45a58beba292c3b21529bce0be9a760b63
    }

}
