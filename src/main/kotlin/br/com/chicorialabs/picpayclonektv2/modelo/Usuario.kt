package br.com.chicorialabs.picpayclonektv2.modelo


import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.UsuarioDTO
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table("USUARIOS")
data class Usuario(
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
    ) : EntidadeBase()

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
