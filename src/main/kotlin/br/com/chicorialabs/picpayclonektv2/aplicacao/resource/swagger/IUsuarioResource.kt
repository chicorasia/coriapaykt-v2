package br.com.chicorialabs.picpayclonektv2.aplicacao.resource.swagger

import br.com.chicorialabs.picpayclonektv2.aplicacao.dto.UsuarioDTO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@Api(value = "/usuarios")
interface IUsuarioResource {


    @ApiOperation(value = "Retorna os dados do usuário cadastrado")
    @ApiResponses(
        ApiResponse(code = 200, message = "Usuário encontrado com sucesso"),
        ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes"),
        ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
        ApiResponse(code = 403, message = "Usuário sem permissão para acessar esse recurso"),
        ApiResponse(code = 404, message = "Recurso não encontrado"),
        ApiResponse(code = 500, message = "Ocorreu um erro no servidor"),
    )
    @GetMapping("/{login}")
    fun consultar(@PathVariable login: String): ResponseEntity<UsuarioDTO>

    @ApiOperation(value = "Retorna o saldo do usuário")
    @ApiResponses(
        ApiResponse(code = 200, message = "Saldo do usuário encontrado com sucesso"),
        ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes"),
        ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
        ApiResponse(code = 403, message = "Usuário sem permissão para acessar esse recurso"),
        ApiResponse(code = 404, message = "Recurso não encontrado"),
        ApiResponse(code = 500, message = "Ocorreu um erro no servidor"),
    )
    @GetMapping("/{login}/saldo")
    fun consultarSaldo(@PathVariable login: String): ResponseEntity<UsuarioDTO>

    @ApiOperation(value = "Retorna a lista de contatos do usuário")
    @ApiResponses(
        ApiResponse(code = 200, message = "Lista de contados obtida com sucesso"),
        ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes"),
        ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
        ApiResponse(code = 403, message = "Usuário sem permissão para acessar esse recurso"),
        ApiResponse(code = 404, message = "Recurso não encontrado"),
        ApiResponse(code = 500, message = "Ocorreu um erro no servidor"),
    )
    @GetMapping("/contatos")
    fun listarTodos(@RequestParam login: String): ResponseEntity<List<UsuarioDTO>>

    @ApiOperation(value = "Cadastrar um novo usuário no sistema")
    @ApiResponses(
        ApiResponse(code = 200, message = "Usuário cadastrado com sucesso"),
        ApiResponse(code = 201, message = "Usuário criado com sucesso"),
        ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes"),
        ApiResponse(code = 401, message = "Operação não autorizada"),
        ApiResponse(code = 403, message = "Usuário sem permissão para acessar esse recurso"),
        ApiResponse(code = 404, message = "Recurso não encontrado"),
        ApiResponse(code = 500, message = "Ocorreu um erro no servidor"),
    )
    @PostMapping
    fun post(@RequestBody usuario: br.com.chicorialabs.picpayclonektv2.modelo.Usuario)

}





