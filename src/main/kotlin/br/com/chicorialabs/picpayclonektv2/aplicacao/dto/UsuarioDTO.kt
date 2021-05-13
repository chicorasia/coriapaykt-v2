package br.com.chicorialabs.picpayclonektv2.aplicacao.dto

import br.com.chicorialabs.picpayclonektv2.modelo.Usuario
import java.time.LocalDate
import javax.persistence.Entity

data class UsuarioDTO(
//    val id: Long = 0,
    val login: String = "",
    val email: String = "",
    val nomeCompleto: String ="",
    val cpf: String = "",
    val dataNascimento: String = "",
    val numeroTelefone: String = "",
    var saldo: Double = 0.0

) {

    fun toEntidade() : Usuario = Usuario(
//        id = id,
        login = login,
        email = email,
        nomeCompleto = nomeCompleto,
        cpf = cpf,
        dataNascimento = dataNascimento,
        numeroTelefone = numeroTelefone,
        saldo = saldo,
        cartoesDeCredito = arrayListOf(),
        ativo = true
    )
}



