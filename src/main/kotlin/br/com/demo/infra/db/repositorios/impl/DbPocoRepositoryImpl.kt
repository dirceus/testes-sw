package br.com.demo.infra.db.repositorios.impl

import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.poco.Poco
import br.com.demo.business.domain.poco.PocoFiltroDTO
import br.com.demo.business.domain.poco.PocoRepository
import br.com.demo.business.domain.poco.StatusPocoEnum
import br.com.demo.infra.db.repositorios.PocoJpaRepository
import org.springframework.stereotype.Repository

@Repository
class DbPocoRepositoryImpl(
    private val pocoJpaRepository: PocoJpaRepository)
    : PocoRepository
{
    override fun obterPocos(filtroDTO: PocoFiltroDTO): ListaPaginada<Poco> {
        TODO("Not yet implemented")
    }

    override fun obterPoco(id: Int): Poco {
        TODO("Not yet implemented")
    }

    override fun salvarPoco(poco: Poco): Poco {
        TODO("Not yet implemented")
    }

    override fun alterarStatusPoco(poco: Poco, statusNovo: StatusPocoEnum) {
        TODO("Not yet implemented")
    }

}