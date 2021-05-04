package br.com.chicorialabs.picpayclonektv2.aplicacao.service

import br.com.chicorialabs.picpayclonektv2.infraestrutura.CartaoDeCreditoRepository
import br.com.chicorialabs.picpayclonektv2.modelo.CartaoDeCredito
import org.springframework.stereotype.Service

@Service
class CartaoDeCreditoService(val cartaoDeCreditoRepository: CartaoDeCreditoRepository) {

    fun salvar(cartaoDeCredito: CartaoDeCredito?) : CartaoDeCredito? =
        cartaoDeCredito?.let { cartaoDeCreditoRepository.save(it) }

}