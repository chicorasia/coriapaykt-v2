package br.com.chicorialabs.picpayclonektv2.aplicacao.resource

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.CartaoDeCreditoDTO
import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.UsuarioDTO
import br.com.chicorialabs.picpayclonektv2.aplicacao.resource.swagger.IUsuarioResource
import br.com.chicorialabs.picpayclonektv2.aplicacao.service.UsuarioService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.data.jpa.repository.Query
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*




@RestController
@RequestMapping("/usuarios")
class UsuarioResource(val service: UsuarioService) : ResourceBase<UsuarioDTO>(), IUsuarioResource {

    @GetMapping("/{login}")
    override fun consultar(@PathVariable login: String): ResponseEntity<UsuarioDTO> {
        val usuario: UsuarioDTO? = service.consultar(login)
        return usuario?.let { responderSuccessoComItem(it) } ?: responderItemNaoEncontrado()
    }


    @GetMapping("/{login}/saldo")
    override fun consultarSaldo(@PathVariable login: String): ResponseEntity<UsuarioDTO> {
        val usuario = service.consultar(login)
        return usuario?.let { responderSuccessoComItem(it) } ?: responderItemNaoEncontrado()
    }

    @GetMapping("/contatos")
    override fun listarTodos(@RequestParam login: String): ResponseEntity<List<UsuarioDTO>> {
        val usuarios: List<UsuarioDTO>? = service.listar(login)
        return usuarios?.let { responderListaDeItens(it) } ?: responderListaVazia()
    }

    // Métodos para teste da API:


    @PostMapping
    override fun post(@RequestBody usuario: br.com.chicorialabs.picpayclonektv2.modelo.Usuario) {
        if (service.findUsuarios()?.map {
                it.login
            }?.contains(usuario.login) == false
        ) service.postUsuario(usuario)
    }
}





