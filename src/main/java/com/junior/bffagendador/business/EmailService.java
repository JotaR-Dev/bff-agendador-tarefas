package com.junior.bffagendador.business;


import com.junior.bffagendador.business.dto.out.TarefasDTOResponse;
import com.junior.bffagendador.infrastructure.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse dto){
        emailClient.enviarEmail(dto);
    }
}
