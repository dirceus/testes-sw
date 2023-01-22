package br.com.demo.infra.db.repositorios.impl

import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.instalacao.InstalacaoProducao
import br.com.demo.business.domain.instalacao.InstalacaoProducaoDTO
import br.com.demo.business.domain.instalacao.InstalacaoProducaoFiltroDTO
import br.com.demo.business.domain.instalacao.InstalacaoProducaoRepository
import br.com.demo.infra.db.repositorios.InstalacaoProducaoJpaRepository
import br.com.demo.infra.db.repositorios.BoletimMedicaoDiariaJpaRepository
import org.springframework.stereotype.Repository


@Repository
class DbInstalacaoProducaoRepositoryImpl(
    private val instalacaoProducaoJpaRepository: InstalacaoProducaoJpaRepository,
    private val boletimMedicaoDiariaJpaRepository: BoletimMedicaoDiariaJpaRepository
) :
    InstalacaoProducaoRepository {
    override fun consultarInstalacoes(filtroDTO: InstalacaoProducaoFiltroDTO): ListaPaginada<InstalacaoProducao> {
        TODO("Not yet implemented")
    }

    override fun salvar(instalcao: InstalacaoProducao): InstalacaoProducao {
        TODO("Not yet implemented")
    }

    override fun listaInstalacoesPorUn(codigoUn: Int): List<InstalacaoProducaoDTO> {
        TODO("Not yet implemented")
    }

    override fun quantidadeInstalacoesAtivas(codigoUn: Int): Int {
        TODO("Not yet implemented")
    }


}