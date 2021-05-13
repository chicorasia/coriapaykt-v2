package br.com.chicorialabs.picpayclonektv2.aplicacao.dto

import br.com.chicorialabs.picpayclonektv2.modelo.CartaoDeCredito
import br.com.chicorialabs.picpayclonektv2.modelo.Transacao
import br.com.chicorialabs.picpayclonektv2.modelo.Usuario
import java.time.LocalDateTime
import javax.persistence.Entity

data class TransacaoDTO(

    val codigo: String = "",
    var origem: UsuarioDTO = UsuarioDTO(),
    var destino: UsuarioDTO = UsuarioDTO(),
    val dataHora: LocalDateTime = LocalDateTime.now(),
    val valor: Double = 0.0,
    val isCartaoCredito: Boolean = false,
    val cartaoDeCredito: CartaoDeCredito? = null

) {

    fun toEntidade() = Transacao(
        codigo = codigo,
        origem = origem.toEntidade(),
        destino = destino.toEntidade(),
        dataHora = dataHora,
        valor = valor
    )
}

