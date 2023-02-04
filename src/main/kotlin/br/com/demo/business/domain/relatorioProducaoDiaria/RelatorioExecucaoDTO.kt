package br.com.demo.business.domain.relatorioProducaoDiaria

import java.time.LocalDate

class RelatorioExecucaoDTO {

    var resultado : MutableMap<LocalDate, StatusRelatorioDiarioEnum> = mutableMapOf()

    fun addResultaado(data : LocalDate, status: StatusRelatorioDiarioEnum){
        this.resultado[data] = status
    }

}