package br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios.impl

import br.com.dirceu.kotlinComSpringBoot.business.domain.noSip.NoSip
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeControle.UnidadeControle
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeControle.UnidadeControleRepository
import br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios.UnidadeControleJpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class DbUnidadeControleRepositoryImpl(
    private val unidadeControleJpaRepository: UnidadeControleJpaRepository)
    : UnidadeControleRepository
{
    override fun obterUnidadesControleVigentes(): List<UnidadeControle> {
        TODO("Not yet implemented")
    }

    override fun obterUnidadesControleAtivasVinculadasNo(noSip: NoSip, data: Date): List<UnidadeControle> {
        var listaUC = obterUnidadesControleVinculadasNo(noSip)
        return listaUC.filter { it.vigenteNaData(data)}
    }

    override fun obterUnidadesControleVinculadasNo(noSip: NoSip): List<UnidadeControle> {
        val listEntities = unidadeControleJpaRepository.findByVinculoComNo(noSip.codigo!!)
        return listEntities.map { it.toUnidadeControle() }
    }

    override fun vincularUnidadeControleANoSip(noSip: NoSip, uc: UnidadeControle) {
        TODO("Not yet implemented")
    }

    override fun desvincularUnidadeCo(noSip: NoSip, uc: UnidadeControle) {
        TODO("Not yet implemented")
    }

}