package br.com.chicorialabs.picpayclonektv2.aplicacao.dto

import br.com.chicorialabs.picpayclonektv2.modelo.CartaoDeCredito
import br.com.chicorialabs.picpayclonektv2.modelo.Transacao
import java.time.LocalDateTime

data class TransacaoDTO(

    val id: Long,
    val codigo: String,
    val origem: UsuarioDTO,
    val destino: UsuarioDTO,
    val dataHora: LocalDateTime,
    val valor: Double,
    val cartaoDeCredito: CartaoDeCredito? = null,
    val isCartaoDeCredito: Boolean = false

) {

    fun toEntidade() = Transacao(
        id = id,
        codigo = codigo,
        origem = origem.toEntidade(),
        destino = destino.toEntidade(),
        dataHora = dataHora,
        valor = valor
    )
}

