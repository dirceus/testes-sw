package br.com.demo.business.domain.boletimMedicaoDiaria

import java.time.LocalDate

class BoletimMedicaoDiariaDTO(
    val codUnidadeNegocio: Int?,
    val nomeUnidadeNegocio: String?,
    val codInstalacaoProducao: Int?,
    val nomeInstalacaoProducao: String?,
    val data: LocalDate?,
    val producao: Double?
)
