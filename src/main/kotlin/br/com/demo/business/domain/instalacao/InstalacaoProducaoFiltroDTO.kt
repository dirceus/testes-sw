package br.com.demo.business.domain.instalacao

import br.com.demo.business.commons.QueryPaginavel

data class InstalacaoProducaoFiltroDTO(
    val codigoUnidadeNegocio: Int?,
    val nome: String?,
    val ativo: Boolean?,
    override var pagina: Int = 0,
    override var tamanho: Int = 10,
    override var ordenacaoProp: String = "nome",
    override var ordenacaoAsc: Boolean = true

) : QueryPaginavel(pagina, tamanho, ordenacaoProp, ordenacaoAsc)