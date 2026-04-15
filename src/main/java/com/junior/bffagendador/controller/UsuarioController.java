package com.junior.bffagendador.controller;

import com.junior.bffagendador.business.UsuarioService;
import com.junior.bffagendador.business.dto.EnderecoDTO;
import com.junior.bffagendador.business.dto.TelefoneDTO;
import com.junior.bffagendador.business.dto.UsuarioDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name = "Usuario", description = "Cadastro e login de usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Salvar usuarios", description = "Cria um novo usuario")
    @ApiResponse(responseCode = "200", description = "Usuario salvo com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuario ja cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTO> salvaUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuarioDTO));
    }

    @PostMapping("/login")
    @Operation(summary = "login usuarios", description = "Faz o login do usuario")
    @ApiResponse(responseCode = "200", description = "Usuario logado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public String login(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.loginUsuario(usuarioDTO);
    }

    @GetMapping
    @Operation(summary = "Busca usuario por email", description = "Busca o usuario pelo email")
    @ApiResponse(responseCode = "200", description = "Usuario encontrado sucesso")
    @ApiResponse(responseCode = "404", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTO> buscaUsuarioPorEmail(@RequestParam("email") String email,
                                                           @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email, token));
    }
    @DeleteMapping("/{email}")
    @Operation(summary = "Deleta usuarios", description = "Deleta usuario")
    @ApiResponse(responseCode = "200", description = "Usuario deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletaUsuarioPorEmail(@PathVariable String email,
                                                      @RequestHeader("Authorization") String token){
        usuarioService.deletaUsuarioPorEmail(email, token);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    @Operation(summary = "Atualizar dados", description = "Atualiza os dados do usuario")
    @ApiResponse(responseCode = "200", description = "Usuario atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTO> atualizaDadosUsuario(@RequestBody UsuarioDTO dto,
                                                           @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.atualizaDadosUsuario(token,dto));
    }
    @PutMapping("/endereco")
    @Operation(summary = "Atualiza endereço", description = "Atualiza o endereço do usuario")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDTO> atualizaEndereco(@RequestBody EnderecoDTO dto,
                                                        @RequestParam("id") Long id,
                                                        @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.atualizaEndereco(id, dto, token));
    }
    @PutMapping("/telefone")
    @Operation(summary = "Atualiza telefone", description = "Atualiza o telefone do usuario")
    @ApiResponse(responseCode = "200", description = "Telefone atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TelefoneDTO> atualizaTelefone(@RequestBody TelefoneDTO dto,
                                                        @RequestParam("id") Long id,
                                                        @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.atualizaTelefone(id, dto, token));
    }
    @PostMapping("/endereco")
    @Operation(summary = "Cadastro endereço", description = "Cadastra o endereço do usuario")
    @ApiResponse(responseCode = "200", description = "Endereço cadastrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDTO> cadastroEndereco(@RequestBody EnderecoDTO dto,
                                                        @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.cadastroEndereco(token, dto));
    }
    @PostMapping("/telefone")
    @Operation(summary = "Cadastra telefone", description = "Cadastra telefone do usuario")
    @ApiResponse(responseCode = "200", description = "Telefone cadastrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TelefoneDTO> cadastroTelefone(@RequestBody TelefoneDTO dto,
                                                        @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.cadastroTelefone(token, dto));
    }


}
