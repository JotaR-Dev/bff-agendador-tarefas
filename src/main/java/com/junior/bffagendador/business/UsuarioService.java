package com.junior.bffagendador.business;


import com.junior.bffagendador.business.dto.in.EnderecoDTORequest;
import com.junior.bffagendador.business.dto.in.LoginRequestDTO;
import com.junior.bffagendador.business.dto.in.TelefoneDTORequest;
import com.junior.bffagendador.business.dto.in.UsuarioDTORequest;
import com.junior.bffagendador.business.dto.out.EnderecoDTOResponse;
import com.junior.bffagendador.business.dto.out.TelefoneDTOResponse;
import com.junior.bffagendador.business.dto.out.UsuarioDTOResponse;
import com.junior.bffagendador.infrastructure.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioService {
    private final UsuarioClient client;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO){
       return client.salvaUsuario(usuarioDTO);
    }
    public String loginUsuario(LoginRequestDTO usuarioDTO){
        return client.login(usuarioDTO);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token){
       return client.buscaUsuarioPorEmail(email, token);
    }
    public void deletaUsuarioPorEmail(String email, String token){
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto) {
        return client.atualizaDadosUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token){
        return client.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest telefoneDTO, String token) {
        return client.atualizaTelefone(telefoneDTO, idTelefone, token);
    }
    public EnderecoDTOResponse cadastroEndereco(String token, EnderecoDTORequest dto){
        return client.cadastroEndereco(dto, token);
    }
    public TelefoneDTOResponse cadastroTelefone(String token, TelefoneDTORequest dto){
        return client.cadastroTelefone(dto, token);

    }

}
