package br.com.demo.business.domain.poco

import br.com.demo.business.domain.instalacao.InstalacaoProducao
import java.time.LocalDate

data class VinculoInstalacaoPoco (
    val instalacao: InstalacaoProducao,
    val poco: Poco,
    var dataInicio: LocalDate,
    var dataFim: LocalDate?
)