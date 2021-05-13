package br.com.chicorialabs.picpayclonektv2.infraestrutura

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.CartaoDeCreditoDTO
import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.UsuarioDTO
import br.com.chicorialabs.picpayclonektv2.modelo.CartaoDeCredito
import br.com.chicorialabs.picpayclonektv2.modelo.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface CartaoDeCreditoRepository : JpaRepository<CartaoDeCredito, Long>{


}
