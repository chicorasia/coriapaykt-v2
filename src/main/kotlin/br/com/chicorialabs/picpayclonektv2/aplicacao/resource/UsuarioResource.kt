package br.com.chicorialabs.picpayclonektv2.aplicacao.resource

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.UsuarioDTO
import br.com.chicorialabs.picpayclonektv2.aplicacao.service.UsuarioService
import org.springframework.data.jpa.repository.Query
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioResource(val service: UsuarioService) : ResourceBase<UsuarioDTO>() {

    @GetMapping("/{login}")
    fun consultar(@PathVariable login: String): ResponseEntity<UsuarioDTO> {
        val usuario: UsuarioDTO? = service.consultar(login)
        return usuario?.let { responderSuccessoComItem(it) } ?: responderItemNaoEncontrado()
    }


    @GetMapping("/{login}/saldo")
    fun consultarSaldo(@PathVariable login: String): ResponseEntity<UsuarioDTO> {
        val usuario = service.consultar(login)
        return usuario?.let { responderSuccessoComItem(it) } ?: responderItemNaoEncontrado()
    }

    @GetMapping("/contatos")
    fun listarTodos(@RequestParam login: String): ResponseEntity<List<UsuarioDTO>> {
        val usuarios: List<UsuarioDTO>? = service.listar(login)
        return usuarios?.let { responderListaDeItens(it) } ?: responderListaVazia()
    }


    // Métodos para teste da API:


    @PostMapping
    fun post(@RequestBody usuario: br.com.chicorialabs.picpayclonektv2.modelo.Usuario) {
        if (service.findUsuarios()?.map {
                it.login
            }?.contains(usuario.login) == false
        ) service.postUsuario(usuario)
    }
}





