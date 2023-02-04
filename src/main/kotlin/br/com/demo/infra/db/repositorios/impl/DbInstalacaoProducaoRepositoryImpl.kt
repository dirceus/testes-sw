package br.com.demo.infra.db.repositorios.impl

import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.instalacao.InstalacaoProducao
import br.com.demo.business.domain.instalacao.InstalacaoProducaoFiltroDTO
import br.com.demo.business.domain.instalacao.InstalacaoProducaoRepository
import br.com.demo.infra.db.entities.InstalacaoProducaoEntity
import br.com.demo.infra.db.repositorios.BoletimMedicaoDiariaJpaRepository
import br.com.demo.infra.db.repositorios.InstalacaoProducaoJpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate


@Repository
class DbInstalacaoProducaoRepositoryImpl(
    private val instalacaoProducaoJpaRepository: InstalacaoProducaoJpaRepository,
    private val boletimMedicaoDiariaJpaRepository: BoletimMedicaoDiariaJpaRepository
) :
    InstalacaoProducaoRepository {
    override fun consultarInstalacoes(filtroDTO: InstalacaoProducaoFiltroDTO): ListaPaginada<InstalacaoProducao> {
        TODO("Not yet implemented")
    }

    override fun salvar(instalcao: InstalacaoProducao): Unit {

        var instalacaoProducaoEntity = InstalacaoProducaoEntity()
        instalacaoProducaoEntity.fromInstalacaoProducao(instalcao)
        instalacaoProducaoJpaRepository.save(instalacaoProducaoEntity)
    }

    override fun listaInstalacoesPorUn(codigoUn: Int): List<InstalacaoProducao> {
        TODO("Not yet implemented")
    }

    override fun quantidadeInstalacoesAtivas(codigoUn: Int): Int {
        TODO("Not yet implemented")
    }

    override fun obter(codInstalacao: Int): InstalacaoProducao? {
        TODO("Not yet implemented")
    }

    override fun obterPeloVinculo(codPoco: Int, dataInicio: LocalDate, dataFim: LocalDate): InstalacaoProducao? {
        TODO("Not yet implemented")
    }


}