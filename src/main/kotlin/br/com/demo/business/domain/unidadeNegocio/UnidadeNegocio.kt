package br.com.demo.business.domain.unidadeNegocio


data class UnidadeNegocio(

    var nome: String,
    var descricao: String? = null,
    var ativa: Boolean = true
){

    var codigo: Int? = null
    fun desativar(){
        this.ativa = false
    }
}
