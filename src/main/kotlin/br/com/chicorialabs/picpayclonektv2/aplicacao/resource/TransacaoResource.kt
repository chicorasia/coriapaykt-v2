package br.com.chicorialabs.picpayclonektv2.aplicacao.resource

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.TransacaoDTO
import br.com.chicorialabs.picpayclonektv2.aplicacao.service.TransacaoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/transacoes")
class TransacaoResource(
    val service: TransacaoService
) : ResourceBase<TransacaoDTO>() {


//    TODO: adicionar o login como filtro das transações
    @GetMapping
    fun listar(@PageableDefault(page = 0, size = 20) paginacao: Pageable, @RequestParam login: String)
            : ResponseEntity<Page<TransacaoDTO>>? {
        val transacoes: Page<TransacaoDTO>? = service.listar(paginacao, login)
        return transacoes?.let { responderListaDeItensPaginada(transacoes) }
    }


    @PostMapping
    fun salvar(@RequestBody transacaoDTO: TransacaoDTO,
               builder: UriComponentsBuilder): ResponseEntity<TransacaoDTO> {
        val transacaoRetornoDto : TransacaoDTO = service.processar(transacaoDTO)
        val path = "/transacoes/{codigo}"
        return responderItemCriadoComURI(
            transacaoDTO,
            builder,
            path,
            transacaoRetornoDto.codigo
        )
    }


//    @PostMapping
//    fun salvar(@RequestBody transacaoDTO: TransacaoDTO) {
//        transacaoService.salvar(transacaoDTO)
//    }

}