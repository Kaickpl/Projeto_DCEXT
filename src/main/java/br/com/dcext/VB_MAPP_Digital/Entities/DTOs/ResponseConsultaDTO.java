package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;


import br.com.dcext.VB_MAPP_Digital.Entities.Consulta;
import br.com.dcext.VB_MAPP_Digital.Entities.ItemAtividadeRealizado;
import br.com.dcext.VB_MAPP_Digital.Entities.Relatorio;

import java.util.Date;
import java.util.List;

public record ResponseConsultaDTO(int consultaId,
                                  int alunoId,
                                  String nomeAluno,
                                  String matricula,
                                  String telefone,
                                  int Periodo,
                                  int pacienteId,
                                  String nomePaciente,
                                  String responsavel,
                                  String numeroResponsavel,
                                  String observacoes,
                                  Date dataConsulta,
                                  Double pontuacaoTotal,
                                  List<ItemAtividadeRealizado> atividades,
                                  Relatorio relatorio){}
