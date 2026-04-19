package com.junior.bffagendador.infrastructure;

import com.junior.bffagendador.business.dto.in.EnderecoDTORequest;
import com.junior.bffagendador.business.dto.in.LoginRequestDTO;
import com.junior.bffagendador.business.dto.in.TelefoneDTORequest;
import com.junior.bffagendador.business.dto.in.UsuarioDTORequest;
import com.junior.bffagendador.business.dto.out.EnderecoDTOResponse;
import com.junior.bffagendador.business.dto.out.TarefasDTOResponse;
import com.junior.bffagendador.business.dto.out.TelefoneDTOResponse;
import com.junior.bffagendador.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {
    @PostMapping
    void enviarEmail(@RequestBody TarefasDTOResponse dto);

}