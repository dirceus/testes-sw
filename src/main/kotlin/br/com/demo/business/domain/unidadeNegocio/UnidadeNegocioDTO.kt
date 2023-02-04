package br.com.demo.business.domain.unidadeNegocio

data class UnidadeNegocioDTO(
    val id: Int? = null,
    var nome: String,
    var descricao: String? = null,
    var ativo: Boolean
){
    fun toModel(): UnidadeNegocio {
        var un = UnidadeNegocio(this.nome,this.descricao,this.ativo)
        un.codigo = this.id
        return un
    }

}