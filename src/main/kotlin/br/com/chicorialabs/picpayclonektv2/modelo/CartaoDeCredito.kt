package br.com.chicorialabs.picpayclonektv2.modelo

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class CartaoDeCredito(
    @Id @GeneratedValue val id: Long,

    val numero: String) {

}
