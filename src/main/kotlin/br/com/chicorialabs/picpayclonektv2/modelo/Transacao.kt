package br.com.chicorialabs.picpayclonektv2.modelo

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.TransacaoDTO
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="TRANSACOES")
data class Transacao(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @Column val codigo: String = "",
    @ManyToOne val origem: Usuario = Usuario(),
    @ManyToOne val destino: Usuario = Usuario(),
    @Column(nullable = false) val dataHora: LocalDateTime = LocalDateTime.now(),
    @Column(nullable = false) val valor: Double = 0.0

) {

    fun toDto() = TransacaoDTO(
        id = id,
        codigo = codigo,
        origem = origem.toDto(),
        destino = destino.toDto(),
        dataHora = dataHora,
        valor = valor
    )

}
