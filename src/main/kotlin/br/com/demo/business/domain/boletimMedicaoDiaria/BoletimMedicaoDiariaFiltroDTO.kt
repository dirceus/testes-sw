package br.com.demo.business.domain.boletimMedicaoDiaria

import java.time.LocalDate

class BoletimMedicaoDiariaFiltroDTO(
    val codUnidadeNegocio: Int,
    val instalacoes: List<Int>?,
    val dataInicio: LocalDate,
    val dataFim: LocalDate?
)
