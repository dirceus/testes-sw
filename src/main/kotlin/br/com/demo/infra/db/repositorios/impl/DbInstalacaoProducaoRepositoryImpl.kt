package br.com.demo.infra.db.repositorios.impl

import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.instalacao.InstalacaoProducao
import br.com.demo.business.domain.instalacao.InstalacaoProducaoFiltroDTO
import br.com.demo.business.domain.instalacao.InstalacaoProducaoRepository
import br.com.demo.infra.db.entities.InstalacaoProducaoEntity
import br.com.demo.infra.db.repositorios.BoletimMedicaoDiariaJpaRepository
import br.com.demo.infra.db.repositorios.InstalacaoProducaoJpaRepository
import br.com.demo.infra.db.specifcations.instalacao.InstalacaoSpecification
import org.springframework.stereotype.Repository
import java.time.LocalDate


@Repository
class DbInstalacaoProducaoRepositoryImpl(
    private val instalacaoProducaoJpaRepository: InstalacaoProducaoJpaRepository,
    private val boletimMedicaoDiariaJpaRepository: BoletimMedicaoDiariaJpaRepository
) :
    InstalacaoProducaoRepository {
    override fun consultarInstalacoes(filtroDTO: InstalacaoProducaoFiltroDTO): ListaPaginada<InstalacaoProducao> {
        val page = this.instalacaoProducaoJpaRepository.findAll(
            InstalacaoSpecification(filtroDTO.nome,
                                    filtroDTO.codigoUnidadeNegocio,
                                    filtroDTO.ativo).build()
            , filtroDTO.toPageable()
        )

        val entityList = page.content
        val modelList = entityList.map { it.toInstalacaoProducao() }
        return ListaPaginada(page.totalElements, page.size, page.number, itens = modelList)
    }

    override fun salvar(instalacao: InstalacaoProducao) {

        var instalacaoProducaoEntity = InstalacaoProducaoEntity()
        instalacaoProducaoEntity.fromInstalacaoProducao(instalacao)
        instalacaoProducaoJpaRepository.save(instalacaoProducaoEntity)
    }

    override fun listaInstalacoes(filtroDTO: InstalacaoProducaoFiltroDTO): List<InstalacaoProducao> {

        var listaInstalacaoEntity = this.instalacaoProducaoJpaRepository.findAll(
            InstalacaoSpecification(codigoUn = filtroDTO.codigoUnidadeNegocio, ativo = filtroDTO.ativo).build()
        )
        return listaInstalacaoEntity.map { it.toInstalacaoProducao() }

    }

    override fun quantidadeInstalacoesAtivas(codigoUn: Int): Int {
        val result =this.instalacaoProducaoJpaRepository.count(
            InstalacaoSpecification(codigoUn = codigoUn, ativo = true).build()
        )
        return result.toInt()
    }

    override fun obter(codInstalacao: Int): InstalacaoProducao? {
        val result = this.instalacaoProducaoJpaRepository.findById(codInstalacao)
        return if (result.isPresent){
            result.get().toInstalacaoProducao()
        }else{
            null
        }
    }

    override fun obterPeloVinculo(codPoco: Int, dataInicio: LocalDate, dataFim: LocalDate): InstalacaoProducao? {
        TODO("Not yet implemented")
    }






}