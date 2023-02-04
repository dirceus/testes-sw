package br.com.demo.business.domain.instalacao

data class InstalacaoProducaoDTO(
    val codigo: Int?,
    val nome: String,
    val codigoUnidadeNegocio : Int,
    val nomeUnidadeNegocio : String?,
    val ativa: Boolean
    )
{
    constructor(it: InstalacaoProducao) :
            this(it.codigo, it.nome,it.unidadeNegocio.codigo!!,it.unidadeNegocio.nome,it.ativo)

}