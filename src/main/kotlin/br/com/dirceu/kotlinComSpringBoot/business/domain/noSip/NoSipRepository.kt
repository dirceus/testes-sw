package br.com.dirceu.kotlinComSpringBoot.business.domain.noSip

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import java.util.*

interface NoSipRepository {
    abstract fun obterNosProducaoSipComProducaoNaData(unidadeNegocio: UnidadeNegocio, data: Date): List<NoProducaoSip>
    abstract fun salvarProducaoNoSip(noProducaoSip: NoProducaoSip) : Unit
    abstract fun obterNoSip(codigoUn: Int, codigoNo: Int) : NoSip?
}