package br.com.demo.business.domain.boletimMedicaoDiaria

import br.com.demo.business.domain.instalacao.InstalacaoProducao
import java.time.LocalDate

data class BoletimMedicaoDiaria(
    val instalacaoProducao: InstalacaoProducao,
    val data: LocalDate,
    val producao: Double) {

    var codigo: Int? = null

}