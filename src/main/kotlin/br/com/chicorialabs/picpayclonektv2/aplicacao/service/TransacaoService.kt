package br.com.chicorialabs.picpayclonektv2.aplicacao.service

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.TransacaoDTO
import br.com.chicorialabs.picpayclonektv2.infraestrutura.TransacaoRepository
import br.com.chicorialabs.picpayclonektv2.modelo.Transacao
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TransacaoService(
    val transacaoRepository: TransacaoRepository,
    val cartaoDeCreditoService: CartaoDeCreditoService,
    val usuarioService: UsuarioService
) {

    fun listar(paginacao: Pageable): Page<TransacaoDTO> = transacaoRepository
        .findAll(paginacao).converterParaPageDTO()


    fun processar(transacaoDTO: TransacaoDTO) {
        cartaoDeCreditoService.salvar(transacaoDTO.cartaoDeCredito)
        usuarioService.atualizarSaldo(transacaoDTO.toEntidade(), transacaoDTO.isCartaoDeCredito)
    }

    fun salvar(transacaoDTO: TransacaoDTO) {
        val transacao = transacaoDTO.toEntidade()
        usuarioService.validar(transacao.destino, transacao.origem)
        transacaoRepository.save(transacao)
    }

    fun Page<Transacao>.converterParaPageDTO() : Page<TransacaoDTO> {
        return this.map {
            it.toDto()
        }
    }

}