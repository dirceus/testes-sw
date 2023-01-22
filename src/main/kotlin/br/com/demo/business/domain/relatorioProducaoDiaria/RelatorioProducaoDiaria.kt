package br.com.demo.business.domain.relatorioProducaoDiaria

import br.com.demo.business.domain.boletimMedicaoDiaria.BoletimMedicaoDiaria
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocio
import java.time.LocalDate

data class RelatorioProducaoDiaria(
    val unidadeNegocio : UnidadeNegocio,
    val data: LocalDate
){

    var codigo: Int? = null
    var totalVolume: Double? = null
    var producaoDiariaPorPoco: MutableList<ProducaoDiariaPorPoco> = mutableListOf()
    var status: StatusRelatorioDiarioEnum = StatusRelatorioDiarioEnum.NAO_PROCESSADA
    var erros: MutableList<String> = mutableListOf()

    fun processarDados(boletinsDiarios: List<BoletimMedicaoDiaria>) {

    }

    fun processarComFalha(erro : String){
        this.status = StatusRelatorioDiarioEnum.PROCESSADA_FALHA
        this.erros.add(erro)
    }


}

