package br.com.demo.business.domain.poco

import java.time.LocalDate

data class HistoricoStatusPoco(
    val status : StatusPocoEnum,
    val dataInicio : LocalDate,
    var dataFim : LocalDate?){

    var codigo: Int? = null

}
