package br.com.demo.business.domain.poco

import java.time.LocalDate

data class NovoStatusDTO (
    val codigoPoco: Int,
    var codigoStatus: String,
    var dataInicio: LocalDate
)