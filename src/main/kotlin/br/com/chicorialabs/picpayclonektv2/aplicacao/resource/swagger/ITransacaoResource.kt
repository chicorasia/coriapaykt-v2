package br.com.chicorialabs.picpayclonektv2.aplicacao.resource.swagger

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.TransacaoDTO
import br.com.chicorialabs.picpayclonektv2.aplicacao.service.TransacaoService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@Api("/transacoes")
interface ITransacaoResource {

    @ApiOperation(value = "Retorna uma lista de transações do usuário")
    @ApiResponses(
        ApiResponse(code = 200, message = "Lista de transações obtida com sucesso"),
        ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes"),
        ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
        ApiResponse(code = 403, message = "Usuário sem permissão para acessar esse recurso"),
        ApiResponse(code = 404, message = "Recurso não encontrado"),
        ApiResponse(code = 500, message = "Ocorreu um erro no servidor"),
    )
    @GetMapping
    fun listar(@PageableDefault(page = 0, size = 20) paginacao: Pageable, @RequestParam login: String)
            : ResponseEntity<Page<TransacaoDTO>>?

    @ApiOperation(value = "Grava uma nova transação no servidor")
    @ApiResponses(
        ApiResponse(code = 200, message = "Transação criada com sucesso"),
        ApiResponse(code = 201, message = "Transação criada com sucesso"),
        ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes"),
        ApiResponse(code = 401, message = "Operação não autorizada"),
        ApiResponse(code = 403, message = "Usuário sem permissão para acessar esse recurso"),
        ApiResponse(code = 404, message = "Recurso não encontrado"),
        ApiResponse(code = 500, message = "Ocorreu um erro no servidor"),
    )
    @PostMapping
    fun salvar(@RequestBody transacaoDTO: TransacaoDTO,
               builder: UriComponentsBuilder): ResponseEntity<TransacaoDTO>

}