package br.com.chicorialabs.picpayclonektv2.modelo

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.TransacaoDTO
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="TRANSACOES")
data class Transacao(

    @Column val codigo: String = "",
    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "TR_USUARIO_ORIGEM")
    val origem: Usuario = Usuario(),
    @ManyToOne(cascade = [CascadeType.PERSIST], fetch = FetchType.EAGER)
    @JoinColumn(name = "TR_USUARIO_DESTINO")
    val destino: Usuario = Usuario(),
    @Column val dataHora: LocalDateTime = LocalDateTime.now(),
    @Column val valor: Double = 0.0

) : EntidadeBase() {

    fun toDto() = TransacaoDTO(
//        id = id,
        codigo = codigo,
        origem = origem.toDto(),
        destino = destino.toDto(),
        dataHora = dataHora,
        valor = valor
    )

}
