package br.com.demo.business.domain.poco

import java.time.LocalDate

data class VincularInstalacaoPocoDTO(
    val codInstalacao: Int,
    val codPoco: Int,
    val dataInicio: LocalDate,
    var dataFim: LocalDate,

)