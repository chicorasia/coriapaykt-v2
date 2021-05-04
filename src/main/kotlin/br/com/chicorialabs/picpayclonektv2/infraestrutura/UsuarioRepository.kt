package br.com.chicorialabs.picpayclonektv2.infraestrutura

import br.com.chicorialabs.picpayclonektv2.modelo.Usuario
import br.com.chicorialabs.picpayclonektv2.modelo.UsuarioDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.stream.Stream
import kotlin.streams.toList

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long> {


}