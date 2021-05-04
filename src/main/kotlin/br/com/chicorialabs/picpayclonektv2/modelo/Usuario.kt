package br.com.chicorialabs.picpayclonektv2.modelo


import org.hibernate.annotations.GeneratorType
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import javax.annotation.Generated
import javax.persistence.*

@Entity
@Table("USUARIOS")
data class Usuario(
    @Id @GeneratedValue (strategy=GenerationType.IDENTITY) var id: Long = 0,
    @Column val login: String = "",
    @Column val senha: String = "",
    @Column val email: String = "",
    @Column val nomeCompleto: String = "",
    @Column val cpf: String = "",
    @Column val dataNascimento: LocalDate = LocalDate.now(),
    @Column val numeroTelefone: String = "",
    @OneToMany val cartoesDeCredito: List<CartaoDeCredito> = arrayListOf(),
    @Column var ativo: Boolean = true,
    @Column var saldo: Double = 0.0
    )

{
    fun toDto() : UsuarioDTO = UsuarioDTO(
        id = id,
        login = login,
        email = email,
        nomeCompleto = nomeCompleto,
        cpf = cpf,
        dataNascimento = dataNascimento,
        numeroTelefone = numeroTelefone,
        saldo = saldo
    )

}
