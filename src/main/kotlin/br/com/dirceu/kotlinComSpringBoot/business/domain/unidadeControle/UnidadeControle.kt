package br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeControle

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.business.commons.exceptions.BusinessException
import java.util.*

data class UnidadeControle(
    val codigo: Int?,
    val nome: String,
    var descricao: String? = null,
    val unidadeNegocio: UnidadeNegocio,
    val inicioVigencia: Date,
    var fimVigencia: Date? = null,
    var justificativa: String? = null,
    var dataFimRetroativa: Boolean = false
){


    fun programarDestivacao(dataDesativacao : Date){
        if(dataDesativacao > Date()) {
            this.fimVigencia = dataDesativacao
        }else{
            throw BusinessException("Não é possível programa uma desativação em data passada")
        }
    }

    fun desativacaoRetroativa(dataDesativacao : Date, justificativa : String){
        if(dataDesativacao < Date()) {
            this.fimVigencia = dataDesativacao
            this.justificativa = justificativa
            this.dataFimRetroativa = true
        }else{
            programarDestivacao(dataDesativacao)
        }
    }

    fun vigenteNaData(data: Date) : Boolean{
        return this.inicioVigencia.before(data) && (this.fimVigencia == null || this.fimVigencia!!.after(data))
    }
}