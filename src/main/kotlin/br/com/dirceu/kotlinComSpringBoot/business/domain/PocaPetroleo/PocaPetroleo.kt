package br.com.dirceu.kotlinComSpringBoot.business.domain.PocaPetroleo

import br.com.dirceu.kotlinComSpringBoot.business.commons.exceptions.BusinessException
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import java.util.*

data class PocaPetroleo(
    val codigo: Int?,
    val nome: String,
    var descricao: String? = null,
    val unidadeNegocio: UnidadeNegocio,
    val inicioVigencia: Date,
    var fimVigencia: Date? = null,
    var justificativa: String? = null,
    var dataFimRetroativa: Boolean = false
){


    fun programarFimVigencia(dataDesativacao : Date){
        if(dataDesativacao > Date()) {
            this.fimVigencia = dataDesativacao
        }else{
            throw BusinessException("Não é possível programar a desativação da poça em uma data passada")
        }
    }

    fun finalizarVigenciaRetroativamente(dataDesativacao : Date, justificativa : String){
        if(dataDesativacao < Date()) {
            this.fimVigencia = dataDesativacao
            this.justificativa = justificativa
            this.dataFimRetroativa = true
        }else{
            programarFimVigencia(dataDesativacao)
        }
    }

    fun vigenteNaData(data: Date) : Boolean{
        return this.inicioVigencia.before(data) && (this.fimVigencia == null || this.fimVigencia!!.after(data))
    }
}