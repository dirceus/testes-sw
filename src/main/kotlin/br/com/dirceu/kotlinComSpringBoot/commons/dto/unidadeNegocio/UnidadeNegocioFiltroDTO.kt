package br.com.dirceu.kotlinComSpringBoot.commons.dto.unidadeNegocio

import br.com.dirceu.kotlinComSpringBoot.commons.QueryPaginavel

data class UnidadeNegocioFiltroDTO(

    var nome: String? = null,
    var descricao: String? = null,
    var ativo: Boolean? = null,
    override var pagina: Int = 0,
    override var tamanho: Int = 10,
    override var ordenacaoProp: String = "nome",
    override var ordenacaoAsc: Boolean = true

    ) : QueryPaginavel(pagina, tamanho, ordenacaoProp, ordenacaoAsc)