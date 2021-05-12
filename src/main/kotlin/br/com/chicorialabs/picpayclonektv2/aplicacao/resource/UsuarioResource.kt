package br.com.chicorialabs.picpayclonektv2.aplicacao.resource

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.UsuarioDTO
import br.com.chicorialabs.picpayclonektv2.aplicacao.service.UsuarioService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioResource(val service: UsuarioService) : ResourceBase<UsuarioDTO>() {

	@GetMapping("/{login}")
	fun consultar(@PathVariable login: String) : ResponseEntity<UsuarioDTO> {
		val usuario: UsuarioDTO? = service.consultar(login)
		return usuario?.let { responderSuccessoComItem(it) } ?: responderItemNaoEncontrado()
	}


	@GetMapping("/{login}/saldo")
	fun consultarSaldo(@PathVariable login: String) : ResponseEntity<UsuarioDTO> {
		val usuario = service.consultar(login)
		return usuario?.let { responderSuccessoComItem(it) } ?: responderItemNaoEncontrado()
	}


	// Métodos para teste da API:

	@GetMapping("/contatos")
	fun listarTodos() : ResponseEntity<List<UsuarioDTO>> {
		val usuarios: List<UsuarioDTO>? = service.findUsuarios()
		return usuarios?.let { responderListaDeItens(it) } ?: responderListaVazia()
	}


	@PostMapping
	fun post(@RequestBody usuario: br.com.chicorialabs.picpayclonektv2.modelo.Usuario) {
		service.postUsuario(usuario)
	}

//	@GetMapping("/usuarios/{id}")
//	fun consultar(@PathVariable id: String) : Usuario? = service.findUsuario(id.toLong())



}