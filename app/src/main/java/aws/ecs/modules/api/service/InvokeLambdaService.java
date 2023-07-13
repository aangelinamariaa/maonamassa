package main.java.aws.ecs.modules.api.service;

import aws.ecs.modules.domain.dto.SolicitacaoDto;

public interface InvokeLambdaService {
    SolicitacaoDto gerarLotePorId(int solicitacaoId);
}
