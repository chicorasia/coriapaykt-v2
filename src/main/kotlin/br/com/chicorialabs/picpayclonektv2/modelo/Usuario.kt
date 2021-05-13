package br.com.chicorialabs.picpayclonektv2.modelo


import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.UsuarioDTO
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import javax.persistence.*

@Entity
@Embeddable
@Table("USUARIOS")
data class Usuario(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = -1,
    @Column val login: String = "",
    @Column val senha: String = "",
    @Column val email: String = "",
    @Column val nomeCompleto: String = "",
    @Column val cpf: String = "",
    @Column val dataNascimento: String = "",
    @Column val numeroTelefone: String = "",
    @OneToMany val cartoesDeCredito: List<CartaoDeCredito> = arrayListOf(),
    @Column var ativo: Boolean = true,
    @Column var saldo: Double = 0.0
    )

{



    fun toDto() : UsuarioDTO = UsuarioDTO(
//        id = id,
        login = login,
        email = email,
        nomeCompleto = nomeCompleto,
        cpf = cpf,
        dataNascimento = dataNascimento,
        numeroTelefone = numeroTelefone,
        saldo = saldo
    )

}
