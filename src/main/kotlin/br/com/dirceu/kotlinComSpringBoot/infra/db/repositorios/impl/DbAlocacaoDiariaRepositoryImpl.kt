package br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios.impl

import br.com.dirceu.kotlinComSpringBoot.business.domain.alocacaoDiaria.AlocacaoDiaria
import br.com.dirceu.kotlinComSpringBoot.business.domain.alocacaoDiaria.AlocacaoDiariaRepository
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.commons.dto.alocacaoDiaria.AlocacaoDiariaFiltroDTO
import br.com.dirceu.kotlinComSpringBoot.infra.db.entities.AlocacaoDiariaEntity
import br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios.AlocacaoDiariaJpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class DbAlocacaoDiariaRepositoryImpl(private val alocacaoDiariaJpaRepository: AlocacaoDiariaJpaRepository) :
    AlocacaoDiariaRepository {

    override fun salvar(alocacaoDiaria: AlocacaoDiaria) {
        var entity = AlocacaoDiariaEntity()
        entity.fromAlocacaoDiaria(alocacaoDiaria)
        var listaUc = entity.alocacoesPorUC
        entity.alocacoesPorUC = mutableListOf()
        entity = alocacaoDiariaJpaRepository.save(entity)
        if(!listaUc.isNullOrEmpty()){
            for(item in listaUc){
                item.alocacaoDiariaEntity.id = entity.id
            }
            entity.alocacoesPorUC = listaUc
            entity = alocacaoDiariaJpaRepository.save(entity)
        }
    }

    override fun consultar(alocacaoDiariaFiltroDTO: AlocacaoDiariaFiltroDTO): List<AlocacaoDiaria> {
        TODO("Not yet implemented")
    }

    override fun obter(un: UnidadeNegocio, data: Date): AlocacaoDiaria? {
        TODO("Not yet implemented")
    }

    override fun excluir(un: UnidadeNegocio, data: Date) {
        TODO("Not yet implemented")
    }


}