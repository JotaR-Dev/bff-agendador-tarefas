package com.junior.bffagendador.business;


import com.junior.bffagendador.business.dto.EnderecoDTO;
import com.junior.bffagendador.business.dto.TelefoneDTO;
import com.junior.bffagendador.business.dto.UsuarioDTO;
import com.junior.bffagendador.infrastructure.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioService {
    private final UsuarioClient client;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
       return client.salvaUsuario(usuarioDTO);
    }
    public String loginUsuario(UsuarioDTO usuarioDTO){
        return client.login(usuarioDTO);
    }

    public UsuarioDTO buscarUsuarioPorEmail(String email, String token){
       return client.buscaUsuarioPorEmail(email, token);
    }
    public void deletaUsuarioPorEmail(String email, String token){
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTO atualizaDadosUsuario(String token, UsuarioDTO dto) {
        return client.atualizaDadosUsuario(dto, token);
    }

    public EnderecoDTO atualizaEndereco(Long idEndereco, EnderecoDTO enderecoDTO, String token){
        return client.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTO atualizaTelefone(Long idTelefone, TelefoneDTO telefoneDTO, String token) {
        return client.atualizaTelefone(telefoneDTO, idTelefone, token);
    }
    public EnderecoDTO cadastroEndereco(String token, EnderecoDTO dto){
        return client.cadastroEndereco(dto, token);
    }
    public TelefoneDTO cadastroTelefone(String token, TelefoneDTO dto){
        return client.cadastroTelefone(dto, token);

    }

}
