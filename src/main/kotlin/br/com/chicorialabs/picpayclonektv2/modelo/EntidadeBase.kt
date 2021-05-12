package br.com.chicorialabs.picpayclonektv2.modelo

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class EntidadeBase(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0

)