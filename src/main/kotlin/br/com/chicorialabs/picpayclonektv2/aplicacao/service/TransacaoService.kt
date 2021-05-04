package br.com.chicorialabs.picpayclonektv2.aplicacao.service

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.TransacaoDTO
import br.com.chicorialabs.picpayclonektv2.infraestrutura.TransacaoRepository
import br.com.chicorialabs.picpayclonektv2.modelo.Transacao
import org.springframework.stereotype.Service

@Service
class TransacaoService(
    val transacaoRepository: TransacaoRepository,
    val cartaoDeCreditoService: CartaoDeCreditoService,
    val usuarioService: UsuarioService
) {

    fun listar(): List<Transacao> = transacaoRepository.findAll()


    fun processar(transacaoDTO: TransacaoDTO) {
        cartaoDeCreditoService.salvar(transacaoDTO.cartaoDeCredito)
        usuarioService.atualizarSaldo(transacaoDTO.toEntidade(), transacaoDTO.isCartaoDeCredito)
    }

    fun salvar(transacaoDTO: TransacaoDTO) {
        val transacao = transacaoDTO.toEntidade()
        usuarioService.validar(transacao.destino, transacao.origem)
        transacaoRepository.save(transacao)
    }


}