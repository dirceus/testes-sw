package br.com.dirceu.kotlinComSpringBoot.business.domain.PocaPetroleo

import br.com.dirceu.kotlinComSpringBoot.business.domain.tanqueProducao.TanqueProducao
import java.util.*

interface PocaPetroleRepository {

    abstract fun obterPocasPetroleoVigentes(): List<PocaPetroleo>
    abstract fun obterPocasPetroleoAtivasVinculadasTanqueProducao(tanqueProducao : TanqueProducao, data: Date): List<PocaPetroleo>
    abstract fun obterTodasPocasPetroleoVinculadasAreaProducao(tanqueProducao: TanqueProducao): List<PocaPetroleo>
    abstract fun vincularPocaPetroleoComAreaProducao(tanqueProducao : TanqueProducao, uc : PocaPetroleo)
    abstract fun desvincularPocaPetroleoDeArea(tanqueProducao : TanqueProducao, uc: PocaPetroleo)

}