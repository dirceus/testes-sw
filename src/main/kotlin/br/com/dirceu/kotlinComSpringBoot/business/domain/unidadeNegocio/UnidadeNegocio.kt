package br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio

import java.util.*


data class UnidadeNegocio(
    val codigo: Int?,
    val nome: String,
    val descricao: String? = null,
    val inicioVigencia: Date,
    val fimVigencia: Date?

) {

    fun emVigencia(): Boolean {
        return emVigenciaNaData(Date())
    }

    fun emVigenciaNaData(data : Date): Boolean {
        return this.inicioVigencia.before(data) && (this.fimVigencia == null || this.fimVigencia.after(data))
    }

    fun emVigenciaNoPeriodo(dataInicio: Date, dataFim : Date?): Boolean{
        if(dataFim == null && this.fimVigencia == null){
                return true
        }else if(dataFim == null && this.fimVigencia != null && this.fimVigencia.after(dataInicio)){
                return true
        }else if(dataFim != null && this.fimVigencia == null && dataFim.after(this.inicioVigencia)){
                return true
        }else if(dataInicio.after(inicioVigencia) && dataInicio.before(this.fimVigencia)){
                return true
         }else if(dataFim != null && dataFim.after(inicioVigencia) && dataFim.before(this.fimVigencia)){
                return true
        }
        return false
    }


}
