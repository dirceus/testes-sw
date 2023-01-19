package br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios.impl

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocioRepository
import br.com.dirceu.kotlinComSpringBoot.business.commons.ListaPaginada
import br.com.dirceu.kotlinComSpringBoot.business.commons.dto.unidadeNegocio.UnidadeNegocioFiltroDTO
import br.com.dirceu.kotlinComSpringBoot.infra.db.entities.UnidadeNegocioEntity
import br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios.UnidadeNegocioJpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class DbUnidadeNegocioRepositoryImpl(private val unidadaNegocioJpaRepository: UnidadeNegocioJpaRepository) :
    UnidadeNegocioRepository {


    override fun findByCodigo(codigo: Int): UnidadeNegocio? {
        val result = unidadaNegocioJpaRepository.findById(codigo)
        if(result.isPresent){
            val entity = result.get()
            return entity.toUnidadeNegocio()
        }
        return null
    }

    override fun findByNome(nome: String): List<UnidadeNegocio> {
        val entityList =  this.unidadaNegocioJpaRepository.findByNome(nome)
        return entityList.map { it.toUnidadeNegocio() }
    }

    override fun findAll(): List<UnidadeNegocio>{
        val entityList =  this.unidadaNegocioJpaRepository.findAll()
        return entityList.map { it.toUnidadeNegocio() }
    }

    override fun findVigentesNoPeriodo(dataInicio: Date, dataFim: Date): List<UnidadeNegocio> {
        TODO("Not yet implemented")
    }

    override fun findAllByFiltro(filtro: UnidadeNegocioFiltroDTO): ListaPaginada<UnidadeNegocio> {
        val pageable =  filtro.toPageable()
        val page = this.unidadaNegocioJpaRepository.findByFiltro(filtro.nome?: "" , filtro.descricao?: "", pageable)
        val entityList = page.content
        val modelList = entityList.map { it.toUnidadeNegocio() }
        return ListaPaginada(page.totalElements, page.size, page.number, itens = modelList)
    }

    override fun salvar(un: UnidadeNegocio) {
        val entity = UnidadeNegocioEntity()
        entity.fromUnidadeNegocio(un)
        this.unidadaNegocioJpaRepository.save(entity)
    }


}