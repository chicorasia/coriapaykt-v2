package br.com.chicorialabs.picpayclonektv2.aplicacao.resource

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.TransacaoDTO
import br.com.chicorialabs.picpayclonektv2.aplicacao.service.TransacaoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transacoes")
class TransacaoResource(
    val transacaoService: TransacaoService
    ) : ResourceBase<TransacaoDTO>() {



    @GetMapping
    fun listar(@PageableDefault(page = 0, size = 20) paginacao: Pageable) : ResponseEntity<Page<TransacaoDTO>>? {
        val transacoes: Page<TransacaoDTO>? = transacaoService.listar(paginacao)
        return transacoes?.let { responderListaDeItensPaginada(transacoes) }
    }



    @PostMapping
    fun salvar(@RequestBody transacaoDTO: TransacaoDTO) {
        transacaoService.salvar(transacaoDTO)
    }

}