package br.com.demo.business.domain.poco

import br.com.demo.business.commons.QueryPaginavel

data class PocoFiltroDTO(
    val nome: String?,
    val codigoUnidadeNegocio: Int?,
    val codigoInstalacao: Int?,
    val status: StatusPocoEnum?,
    override var pagina: Int = 0,
    override var tamanho: Int = 10,
    override var ordenacaoProp: String = "nome",
    override var ordenacaoAsc: Boolean = true

) : QueryPaginavel(pagina, tamanho, ordenacaoProp, ordenacaoAsc)