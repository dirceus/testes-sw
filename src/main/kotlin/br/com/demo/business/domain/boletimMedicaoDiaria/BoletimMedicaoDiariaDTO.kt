package br.com.demo.business.domain.boletimMedicaoDiaria

import java.time.LocalDate

data class BoletimMedicaoDiariaDTO(
    val codInstalacao: Int,
    val data: LocalDate,
    val producao: Double
){

    var nomeInstalacao: String? = null

    constructor(boletim: BoletimMedicaoDiaria) :
            this(boletim.instalacaoProducao.codigo!!, boletim.data, boletim.producao){
                this.nomeInstalacao = boletim.instalacaoProducao.nome
            }

}