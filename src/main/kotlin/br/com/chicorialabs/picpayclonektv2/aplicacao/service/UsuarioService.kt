package br.com.chicorialabs.picpayclonektv2.aplicacao.service

import br.com.chicorialabs.picpayclonektv2.infraestrutura.UsuarioRepository
import br.com.chicorialabs.picpayclonektv2.modelo.Usuario
import br.com.chicorialabs.picpayclonektv2.modelo.UsuarioDTO
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import kotlin.streams.toList

@Service
class UsuarioService(val usuarioRepository: UsuarioRepository) {

	fun findUsuarios() : List<UsuarioDTO>? = usuarioRepository.findAll().stream().map {
		it.toDto()
	}.toList()

	fun postUsuario(usuario: Usuario) {
		usuarioRepository.save(usuario)
	}

	fun saldoDoUsuario(id: Long): Double? {
		val usuario : Usuario? = usuarioRepository.findByIdOrNull(id)
		return usuario?.saldo
	}

	fun findUsuario(id: Long): Usuario? = usuarioRepository.findByIdOrNull(id)

}