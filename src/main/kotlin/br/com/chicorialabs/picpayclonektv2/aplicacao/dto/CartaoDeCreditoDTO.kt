package br.com.chicorialabs.picpayclonektv2.aplicacao.dto

import br.com.chicorialabs.picpayclonektv2.modelo.BandeiraCartao
import br.com.chicorialabs.picpayclonektv2.modelo.CartaoDeCredito

data class CartaoDeCreditoDTO(

    val bandeira: BandeiraCartao = BandeiraCartao.VISA,
    val codigoDeSeguranca: String? = null,
    val dataExpiracao: String? = null,
    val nomeTitular: String? = null,
    val numero: String = "null",
    val numeroToken: String = "",
    val usuarioDTO: UsuarioDTO = UsuarioDTO(),
    val isSalva: Boolean = false

) {

    fun toEntidade() : CartaoDeCredito = CartaoDeCredito(
        bandeira = bandeira,
        numeroToken = numeroToken,
        usuario = usuarioDTO.toEntidade()
    )
}
