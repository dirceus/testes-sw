package br.com.demo.infra.db.repositorios.impl

import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioDTO
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioFiltroDTO
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioRepository
import br.com.demo.infra.db.entities.UnidadeNegocioEntity
import br.com.demo.infra.db.repositorios.UnidadeNegocioJpaRepository
import org.springframework.stereotype.Repository


@Repository
class DbUnidadeNegocioRepositoryImpl
    (private val unidadaNegocioJpaRepository: UnidadeNegocioJpaRepository) :
    UnidadeNegocioRepository {


    override fun obterPorCodigo(codigo: Int): UnidadeNegocio? {
        val result = unidadaNegocioJpaRepository.findById(codigo)
        if(result.isPresent){
            val entity = result.get()
            return entity.toUnidadeNegocio()
        }
        return null
    }

    override fun obterPorNome(nome: String): UnidadeNegocio? {
        return unidadaNegocioJpaRepository.findByNome(nome)?.toUnidadeNegocio()
    }

    override fun obterTodas(ativas: Boolean): List<UnidadeNegocioDTO> {
        val entityList =  this.unidadaNegocioJpaRepository.findAll().filter { it.ativo == true }
        return entityList.map { UnidadeNegocioDTO(it.id, it.nome,it.descricao,it.ativo) }
    }

    override fun consultar(filtro: UnidadeNegocioFiltroDTO): ListaPaginada<UnidadeNegocio> {
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