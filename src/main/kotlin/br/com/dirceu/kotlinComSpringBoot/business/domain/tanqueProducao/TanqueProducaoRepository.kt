package br.com.dirceu.kotlinComSpringBoot.business.domain.tanqueProducao

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import java.util.*

interface TanqueProducaoRepository {
    abstract fun obterTanquesComProducaoInformadaNaData(unidadeNegocio: UnidadeNegocio, data: Date): List<ProducaoDia>
    abstract fun salvarProducaoDiaPorTanque(producaoDia: ProducaoDia) : Unit
    abstract fun obterTanqueProducao(codigoUn: Int, codigoAreaProducao: Int) : TanqueProducao?
}