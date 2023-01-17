package br.com.dirceu.kotlinComSpringBoot.business.commons.dto.unidadeNegocio

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.business.commons.exceptions.ValidationException
import java.util.*

data class UnidadeNegocioCompletoDTO(
    val id: Int? = null,
    val nome: String? = null,
    val descricao: String? = null,
    val inicioVigencia: Date? = null,
    val fimVigencia: Date? = null,
    val ativo: Boolean? = null
){

    constructor(un : UnidadeNegocio) :
            this(un.codigo, un.nome, un.descricao, un.inicioVigencia, un.fimVigencia, un.emVigencia())

    fun toUnidadeNegocio() : UnidadeNegocio{
        if(this.nome == null || this.inicioVigencia == null){
            throw ValidationException("Nome e Início de Vigência são obrigatórios")
        }
        return UnidadeNegocio(this.id, this.nome, this.descricao, this.inicioVigencia, this.fimVigencia )


    }

}