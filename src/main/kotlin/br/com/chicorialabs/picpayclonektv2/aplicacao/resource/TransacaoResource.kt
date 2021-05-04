package br.com.chicorialabs.picpayclonektv2.aplicacao.resource

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.TransacaoDTO
import br.com.chicorialabs.picpayclonektv2.aplicacao.service.TransacaoService
import br.com.chicorialabs.picpayclonektv2.modelo.Transacao
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transacoes")
class TransacaoResource(val transacaoService: TransacaoService) {

    @GetMapping
    fun listar() = transacaoService.listar()

    @PostMapping
    fun salvar(@RequestBody transacaoDTO: TransacaoDTO) {
        transacaoService.salvar(transacaoDTO)
    }

}