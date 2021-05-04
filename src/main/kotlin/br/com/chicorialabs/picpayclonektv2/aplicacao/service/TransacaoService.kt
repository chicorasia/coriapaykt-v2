package br.com.chicorialabs.picpayclonektv2.aplicacao.service

import br.com.chicorialabs.picpayclonektv2.infraestrutura.TransacaoRepository
import br.com.chicorialabs.picpayclonektv2.modelo.Transacao
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class TransacaoService(val transacaoRepository: TransacaoRepository) {

    fun listar() : List<Transacao> = transacaoRepository.findAll()

    fun salvar(transacao: Transacao) {
        transacaoRepository.save(transacao)
    }
}