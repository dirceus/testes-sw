package br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeControle

import br.com.dirceu.kotlinComSpringBoot.business.domain.noSip.NoSip
import java.util.*

interface UnidadeControleRepository {

    abstract fun obterUnidadesControleVigentes(): List<UnidadeControle>
    abstract fun obterUnidadesControleAtivasVinculadasNo(noSip : NoSip, data: Date): List<UnidadeControle>
    abstract fun obterUnidadesControleVinculadasNo(noSip: NoSip): List<UnidadeControle>
    abstract fun vincularUnidadeControleANoSip(noSip : NoSip, uc : UnidadeControle)
    abstract fun desvincularUnidadeCo(noSip : NoSip, uc: UnidadeControle)

}