package br.com.chicorialabs.picpayclonektv2.modelo

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.CartaoDeCreditoDTO
import javax.persistence.*

@Entity
data class CartaoDeCredito(

    @Id @GeneratedValue val id: Long,
    @Enumerated(EnumType.STRING)
    @Column val bandeira: BandeiraCartao = BandeiraCartao.VISA,
    @Column val numeroToken: String = "",
    @ManyToOne val usuario: Usuario = Usuario()
) {

    fun toDto() : CartaoDeCreditoDTO = CartaoDeCreditoDTO(
        id = id,
        usuarioDTO = usuario.toDto(),
        bandeira = bandeira,
        numeroToken = numeroToken
    )

}
