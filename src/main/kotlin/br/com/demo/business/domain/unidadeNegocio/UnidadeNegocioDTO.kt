package br.com.demo.business.domain.unidadeNegocio

data class UnidadeNegocioDTO(
    val id: Int? = null,
    var nome: String? = null,
    var descricao: String? = null,
    var ativo: Boolean? = null
){

}