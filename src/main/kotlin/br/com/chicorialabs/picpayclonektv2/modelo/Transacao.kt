package br.com.chicorialabs.picpayclonektv2.modelo

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.TransacaoDTO
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="TRANSACOES")
data class Transacao(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = -1,
    @Column val codigo: String = "",
    @ManyToOne(cascade = [CascadeType.MERGE])
    @JoinColumn(name = "TR_USUARIO_ORIGEM", nullable = false)
    var origem: Usuario = Usuario(),
    @ManyToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "TR_USUARIO_DESTINO", nullable = false)
    var destino: Usuario = Usuario(),
    @Column val dataHora: LocalDateTime = LocalDateTime.now(),
    @Column val valor: Double = 0.0

) {



    fun toDto() = TransacaoDTO(
//        id = id,
        codigo = codigo,
        origem = origem.toDto(),
        destino = destino.toDto(),
        dataHora = dataHora,
        valor = valor
    )

}
