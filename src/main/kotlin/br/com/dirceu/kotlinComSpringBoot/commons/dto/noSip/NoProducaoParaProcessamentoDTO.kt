package br.com.dirceu.kotlinComSpringBoot.commons.dto.noSip

import br.com.dirceu.kotlinComSpringBoot.business.domain.noSip.NoProducaoSip
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeControle.UnidadeControle

data class NoProducaoParaProcessamentoDTO(
    val noProducaoSip: NoProducaoSip,
    val ucsDestino: List<UnidadeControle>

    )