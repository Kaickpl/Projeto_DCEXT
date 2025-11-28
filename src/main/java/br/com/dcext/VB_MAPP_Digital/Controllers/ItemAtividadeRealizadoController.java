package br.com.dcext.VB_MAPP_Digital.Controllers;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.AtividadeRealizadaResponseDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.RealizarAtividadeDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ResponseConsultaDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.ItemAtividadeRealizado;
import br.com.dcext.VB_MAPP_Digital.Services.ConsultaService;
import br.com.dcext.VB_MAPP_Digital.Services.ItemAtividadeRealizadoService;
import br.com.dcext.VB_MAPP_Digital.Mappers.ItemAtividadeRealizadoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consultas/{idConsulta}/atividades-realizadas")
public class ItemAtividadeRealizadoController {

    @Autowired
    ItemAtividadeRealizadoService itemAtividadeRealizadoService;

    @Autowired
    ConsultaService consultaService;

    @Autowired
    ItemAtividadeRealizadoMapper itemAtividadeRealizadoMapper;

//    mudar para ResponseEntity<ResponseDTO> depois.
    @PostMapping
    public ResponseEntity<AtividadeRealizadaResponseDTO> salvarAtividade(@PathVariable Integer idConsulta, @RequestBody RealizarAtividadeDTO atividadeDTO){
        atividadeDTO.setConsultaId(idConsulta);
        ItemAtividadeRealizado entidade = itemAtividadeRealizadoService.salvarAtividadeRealizada(atividadeDTO);
        AtividadeRealizadaResponseDTO responseDTO = itemAtividadeRealizadoMapper.toReponseDTO(entidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

//    @PostMapping("/atividades")
//    public ResponseEntity<ResponseConsultaDTO> realizarAtividade(@RequestBody RealizarAtividadeDTO dto){
//        return ResponseEntity.ok(consultaService.realizarAtividade(dto));
//    }


    @GetMapping("/{idAtividade}")
    public ResponseEntity<AtividadeRealizadaResponseDTO> buscarAtividade(@PathVariable Integer idConsulta, @PathVariable Integer idAtividade){
        AtividadeRealizadaResponseDTO atividade = itemAtividadeRealizadoService.buscarAtividadeRealizada(idAtividade);
        return ResponseEntity.status(HttpStatus.OK).body(atividade);
    }

}
