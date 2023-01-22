package br.com.demo.business.domain.unidadeNegocio

import br.com.demo.business.commons.ListaPaginada

interface UnidadeNegocioRepository {

    fun obterPorCodigo(codigo: Int) : UnidadeNegocio?
    fun obterPorNome(nome: String) : UnidadeNegocio?
    fun obterTodas(ativas : Boolean): List<UnidadeNegocioDTO>
    fun consultar(filtro: UnidadeNegocioFiltroDTO) : ListaPaginada<UnidadeNegocio>
    fun salvar(un: UnidadeNegocio)



}