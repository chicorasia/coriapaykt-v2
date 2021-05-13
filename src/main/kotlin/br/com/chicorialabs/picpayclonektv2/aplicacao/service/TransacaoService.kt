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

    fun listar(paginacao: Pageable, loginUsuario: String): Page<TransacaoDTO> = transacaoRepository
        .findByOrigem_LoginOrDestino_Login(loginUsuario, loginUsuario, paginacao).converterParaPageDTO()


    fun processar(transacaoDTO: TransacaoDTO): TransacaoDTO {
        val transacaoSalva = salvar(transacaoDTO)
//        cartaoDeCreditoService.salvar(transacaoDTO.cartaoDeCredito)
        usuarioService.atualizarSaldo(transacaoDTO.toEntidade(),
            isCartaoDeCredito = transacaoDTO.isCartaoCredito)
        return transacaoSalva.toDto()
    }

    fun salvar(transacaoDTO: TransacaoDTO) : Transacao {
        val usuarioOrigem = usuarioService.findByLogin(transacaoDTO.origem.login)
        val usuarioDestino = usuarioService.findByLogin(transacaoDTO.destino.login)
        val transacao = transacaoDTO.toEntidade()
        transacao.apply {
            origem = usuarioOrigem
            destino = usuarioDestino
        }
        usuarioService.validar(transacao.destino, transacao.origem)
        return transacaoRepository.save(transacao)
    }

    fun Page<Transacao>.converterParaPageDTO() : Page<TransacaoDTO> =
        this.map { it.toDto() }

}