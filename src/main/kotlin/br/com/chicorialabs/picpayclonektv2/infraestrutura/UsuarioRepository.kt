package br.com.chicorialabs.picpayclonektv2.infraestrutura

import br.com.chicorialabs.picpayclonektv2.modelo.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long> {

    @Modifying
    @Query("update Usuario u set u.saldo = u.saldo + ?2 where u.login = ?1")
    fun updateIncrementarSaldo(login: String, valor: Double)

    @Modifying
    @Query("update Usuario u set u.saldo = u.saldo - ?2 where u.login = ?1")
    fun updateDecrementarSaldo(login: String, valor: Double)

    fun findByLogin(login: String) : Usuario?



}