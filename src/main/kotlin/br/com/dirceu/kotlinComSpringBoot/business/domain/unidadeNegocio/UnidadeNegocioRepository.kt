package br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio

import br.com.dirceu.kotlinComSpringBoot.business.commons.ListaPaginada
import br.com.dirceu.kotlinComSpringBoot.business.commons.dto.unidadeNegocio.UnidadeNegocioFiltroDTO
import java.util.*

interface UnidadeNegocioRepository {

    fun findByCodigo(codigo: Int) : UnidadeNegocio?
    fun findByNome(nome: String) : List<UnidadeNegocio>
    fun findAll(): List<UnidadeNegocio>
    fun findVigentesNoPeriodo(dataInicio: Date, dataFim: Date): List<UnidadeNegocio>
    fun findAllByFiltro(filtro: UnidadeNegocioFiltroDTO) : ListaPaginada<UnidadeNegocio>
    fun salvar(un: UnidadeNegocio)



}