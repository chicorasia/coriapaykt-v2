package br.com.chicorialabs.picpayclonektv2.aplicacao.service

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.UsuarioDTO
import br.com.chicorialabs.picpayclonektv2.infraestrutura.UsuarioRepository
import br.com.chicorialabs.picpayclonektv2.modelo.Transacao
import br.com.chicorialabs.picpayclonektv2.modelo.Usuario
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class UsuarioService(val usuarioRepository: UsuarioRepository) {

	fun findUsuarios() : List<UsuarioDTO>? = usuarioRepository.findAll().stream().map {
		it.toDto()
	}.toList()

	fun postUsuario(usuario: Usuario) {
		usuarioRepository.save(usuario)
	}

	fun saldoDoUsuario(login: String): Double {
		val usuario : Usuario? = usuarioRepository.findByLogin(login)
		return usuario?.saldo ?: 0.0
	}

	fun findUsuario(id: Long): Usuario? = usuarioRepository.findByIdOrNull(id)

	fun validar(vararg usuario: Usuario?) {
		usuario.forEach {
			if(it == null){
				throw IllegalArgumentException("Usuário inválido")
			}
		}
	}

	fun atualizarSaldo(transacao: Transacao, isCartaoDeCredito: Boolean) {
		decrementarSaldo(transacao, isCartaoDeCredito)
		incrementarSaldo(transacao)
	}

	private fun incrementarSaldo(transacao: Transacao) {
		usuarioRepository.updateIncrementarSaldo(transacao.destino.login, transacao.valor)
	}

	private fun decrementarSaldo(transacao: Transacao, isCartaoDeCredito: Boolean) {
		if(!isCartaoDeCredito){
			usuarioRepository.updateDecrementarSaldo(transacao.origem.login, transacao.valor)
		}
	}

	fun consultar(login: String): UsuarioDTO? =
		usuarioRepository.findByLogin(login)?.toDto()

	fun listar(login: String) : List<UsuarioDTO>  =
		usuarioRepository.findAll().map {
			it.toDto()
		}



}