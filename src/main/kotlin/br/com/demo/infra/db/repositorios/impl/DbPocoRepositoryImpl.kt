package br.com.demo.infra.db.repositorios.impl

import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.poco.*
import br.com.demo.infra.db.entities.PocoEntity
import br.com.demo.infra.db.repositorios.PocoHistoricoStatusJpaRepository
import br.com.demo.infra.db.repositorios.PocoJpaRepository
import br.com.demo.infra.db.specifcations.poco.PocoSpecification
import org.springframework.stereotype.Repository

@Repository
class DbPocoRepositoryImpl(
    private val pocoJpaRepository: PocoJpaRepository,
    private val pocoHistoricoStatusJpaRepository: PocoHistoricoStatusJpaRepository)
    : PocoRepository
{
    override fun consultar(filtroDTO: PocoFiltroDTO): ListaPaginada<Poco> {
        val page = this.pocoJpaRepository.findAll(
            PocoSpecification(filtroDTO.nome,
                filtroDTO.codigoUnidadeNegocio,
                filtroDTO.codigoInstalacao,
                filtroDTO.status).build()
            , filtroDTO.toPageable()
        )

        val entityList = page.content
        val modelList = entityList.map { it.toPoco() }
        return ListaPaginada(page.totalElements, page.size, page.number, itens = modelList)
    }

    override fun obter(id: Int): Poco? {
        val result = pocoJpaRepository.findById(id)
        return if(result.isPresent){
            //obter historico completo do poco
            val historico = pocoHistoricoStatusJpaRepository.obterHistoricoPoco(id)
            //obter instalacao que o poco está vinculado
            //TODO
            result.get().toPoco(listaHistoricoEntity = historico)
        }else{
            null
        }
    }

    override fun salvar(poco: Poco) {
        var pocoEntity = PocoEntity()
        pocoEntity.fromPoco(poco)
        pocoJpaRepository.save(pocoEntity)
    }

    override fun alterarStatusPoco(poco: Poco, statusNovo: StatusPocoEnum) {
        TODO("Not yet implemented")
    }

    override fun salvarVinculo(vinculoInstalacaoPoco: VinculoInstalacaoPoco) {
        TODO("Not yet implemented")
    }

}