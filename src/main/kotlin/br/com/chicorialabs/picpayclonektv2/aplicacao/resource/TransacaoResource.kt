package br.com.chicorialabs.picpayclonektv2.aplicacao.resource

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.TransacaoDTO
import br.com.chicorialabs.picpayclonektv2.aplicacao.resource.swagger.ITransacaoResource
import br.com.chicorialabs.picpayclonektv2.aplicacao.service.TransacaoService
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
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
) : ResourceBase<TransacaoDTO>(), ITransacaoResource {

    @GetMapping
    override fun listar(@PageableDefault(page = 0, size = 20) paginacao: Pageable, @RequestParam login: String)
            : ResponseEntity<Page<TransacaoDTO>>? {
        val transacoes: Page<TransacaoDTO>? = service.listar(paginacao, login)
        return transacoes?.let { responderListaDeItensPaginada(transacoes) }
    }


    @PostMapping
    override fun salvar(@RequestBody transacaoDTO: TransacaoDTO,
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
}