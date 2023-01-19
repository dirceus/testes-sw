package br.com.dirceu.kotlinComSpringBoot.business.commons.dto.tanqueProducao

import br.com.dirceu.kotlinComSpringBoot.business.domain.PocaPetroleo.PocaPetroleo
import br.com.dirceu.kotlinComSpringBoot.business.domain.tanqueProducao.ProducaoDia

data class InfoRateioProducaoDTO(
    val producaoDia: ProducaoDia,
    val pocasPetroleo: List<PocaPetroleo>

    )