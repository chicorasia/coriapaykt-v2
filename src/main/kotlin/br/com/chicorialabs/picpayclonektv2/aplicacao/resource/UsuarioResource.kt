package br.com.chicorialabs.picpayclonektv2.aplicacao.resource

import br.com.chicorialabs.picpayclonektv2.aplicacao.service.UsuarioService
import br.com.chicorialabs.picpayclonektv2.modelo.Usuario
import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.UsuarioDTO
import org.springframework.web.bind.annotation.*

@RestController
class UsuarioResource(val service: UsuarioService) {

	@GetMapping("/usuarios")
	fun listar() : List<UsuarioDTO>? = service.findUsuarios()

	@PostMapping("/usuarios")
	fun post(@RequestBody usuario: Usuario) {
		service.postUsuario(usuario)
	}

	@GetMapping("/usuarios/{id}")
	fun consultar(@PathVariable id: String) : Usuario? = service.findUsuario(id.toLong())

	@GetMapping("/usuarios/{id}/saldo")
	fun saldo(@PathVariable id: String) : Double? = service.saldoDoUsuario(id.toLong())
}