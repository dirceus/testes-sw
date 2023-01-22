package br.com.demo.business.domain.relatorioProducaoDiaria

import java.time.LocalDate

class RequisicaoProcessarRelatoriosDTO(
    val codUn: Int,
    val dataInicio: LocalDate,
    val dataTermino: LocalDate?
)