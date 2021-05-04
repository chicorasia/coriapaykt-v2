package br.com.chicorialabs.picpayclonektv2.infraestrutura

import br.com.chicorialabs.picpayclonektv2.modelo.CartaoDeCredito
import org.springframework.data.jpa.repository.JpaRepository

interface CartaoDeCreditoRepository : JpaRepository<CartaoDeCredito, Long>{

}
