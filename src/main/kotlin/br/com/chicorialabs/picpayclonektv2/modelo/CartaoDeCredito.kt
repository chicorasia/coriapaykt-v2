package br.com.chicorialabs.picpayclonektv2.modelo

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.CartaoDeCreditoDTO
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class CartaoDeCredito(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = -1,
    @Enumerated(EnumType.STRING)
    @Column val bandeira: BandeiraCartao = BandeiraCartao.VISA,
    @Column val numeroToken: String = "",
    @ManyToOne val usuario: Usuario = Usuario()
) {

    fun toDto() : CartaoDeCreditoDTO = CartaoDeCreditoDTO(
        usuarioDTO = usuario.toDto(),
        bandeira = bandeira,
        numeroToken = numeroToken
    )

}
