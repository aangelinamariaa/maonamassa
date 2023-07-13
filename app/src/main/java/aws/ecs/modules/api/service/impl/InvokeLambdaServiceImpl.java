package main.java.aws.ecs.modules.api.service.impl;

import java.lang.System.Logger;
import aws.ecs.modules.domain.dto.SolicitacaoDto;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.InvokeRequest;
import software.amazon.awssdk.services.lambda.InvokeResponse;

public class InvokeLambdaServiceImpl implements InvokeLambdaService{
    
    public InvokeLambdaServiceImpl() {
    }

    private static final Logger logger = LoggerFactory.getLogger(SolicitacaoDetalhada.class);

    invokeFunctionGerarLote(solicitacaoId);
}

private void invokeFunctionGerarLote(int solicitacaoId){
    InvokeResponse response = null;
    try{
        var body = "{\"Records\": [{\"body\": \"" + solicitacaoId + "\"}]}";
        LambdaClient awsTrigger = LambdaClient.builder().region(Region.SA_EAST_1).build();

        InvokeRequest request = InvokeRequest.builder().functionName("api-gera-lote-function").payload(SdkBytes.fromUtfString(messageBody)).build();
        response = awsTrigger.invoke(request);
        logger.info("Invoke Successfull: " + response);
    }catch (Exception e){
        logger.error("Invoke Failed: " + e.getMessage());
        throw new InvokedLambdaFailedExeption(solicitacaoid);
    }
}

public static Logger getLogger() {
    return logger;
}