package br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios.impl

import br.com.dirceu.kotlinComSpringBoot.business.domain.PocaPetroleo.PocaPetroleRepository
import br.com.dirceu.kotlinComSpringBoot.business.domain.PocaPetroleo.PocaPetroleo
import br.com.dirceu.kotlinComSpringBoot.business.domain.tanqueProducao.TanqueProducao
import br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios.PocaPetroleoJpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class DbPocaPetroleRepositoryImpl(
    private val pocaPetroleoJpaRepository: PocaPetroleoJpaRepository)
    : PocaPetroleRepository
{
    override fun obterPocasPetroleoVigentes(): List<PocaPetroleo> {
        TODO("Not yet implemented")
    }

    override fun obterPocasPetroleoAtivasVinculadasTanqueProducao(tanqueProducao: TanqueProducao, data: Date): List<PocaPetroleo> {
        var listaUC = obterTodasPocasPetroleoVinculadasAreaProducao(tanqueProducao)
        return listaUC.filter { it.vigenteNaData(data)}
    }

    override fun obterTodasPocasPetroleoVinculadasAreaProducao(tanqueProducao: TanqueProducao): List<PocaPetroleo> {
        val listEntities = pocaPetroleoJpaRepository.findByVinculoComTanque(tanqueProducao.codigo!!)
        return listEntities.map { it.toUnidadeControle() }
    }

    override fun vincularPocaPetroleoComAreaProducao(tanqueProducao: TanqueProducao, uc: PocaPetroleo) {
        TODO("Not yet implemented")
    }

    override fun desvincularPocaPetroleoDeArea(tanqueProducao: TanqueProducao, uc: PocaPetroleo) {
        TODO("Not yet implemented")
    }

}