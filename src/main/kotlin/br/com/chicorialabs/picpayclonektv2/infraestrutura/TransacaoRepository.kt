package br.com.chicorialabs.picpayclonektv2.infraestrutura

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.TransacaoDTO
import br.com.chicorialabs.picpayclonektv2.modelo.Transacao
import br.com.chicorialabs.picpayclonektv2.modelo.Usuario
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface TransacaoRepository : PagingAndSortingRepository<Transacao, Long> {

    fun findByOrigem_LoginOrDestino_Login(
        loginUsuario: String,
        loginUsuario1: String,
        paginacao: Pageable
    ): Page<Transacao>


}
