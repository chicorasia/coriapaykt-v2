package br.com.chicorialabs.picpayclonektv2.aplicacao.resource

import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.util.UriComponentsBuilder

abstract class ResourceBase<T> {

    protected fun responderItemCriado(objeto: T) : ResponseEntity<T> =
        ResponseEntity.status(HttpStatus.CREATED).body(objeto)

    protected fun responderItemCriadoComURI(
        objeto: T,
        uriBuilder: UriComponentsBuilder,
        path: String,
        codigo: String
    ) : ResponseEntity<T> {
        val uri = uriBuilder.path(path).buildAndExpand(codigo).toUri()
        return ResponseEntity.created(uri).body(objeto)
    }

    protected fun responderItemNaoEncontrado() : ResponseEntity<T> =
        ResponseEntity.status(HttpStatus.NOT_FOUND).build()

    protected fun responderSucesso() : ResponseEntity<T> =
        ResponseEntity.status(HttpStatus.OK).build()

    protected fun responderSuccessoComItem(objeto: T) : ResponseEntity<T> =
        ResponseEntity.status(HttpStatus.OK).body(objeto)

    protected fun responderListaVazia() : ResponseEntity<List<T>> =
        ResponseEntity.status(HttpStatus.OK).body(arrayListOf<T>())

    protected fun responderListaDeItens(itens: List<T>) : ResponseEntity<List<T>> =
        ResponseEntity.status(HttpStatus.OK).body(itens)

    protected fun responderRequisicaoMalSucedida() : ResponseEntity<T> =
        ResponseEntity.badRequest().build()

    protected fun responderListaDeItensPaginada(itens: Page<T>) : ResponseEntity<Page<T>> =
        ResponseEntity.status(HttpStatus.OK).body(itens)
}