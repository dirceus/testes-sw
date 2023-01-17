package br.com.dirceu.kotlinComSpringBoot.business.domain.alocacaoDiaria

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.commons.dto.alocacaoDiaria.AlocacaoDiariaFiltroDTO
import java.util.*

interface AlocacaoDiariaRepository {
    abstract fun salvar(alocacaoDiaria: AlocacaoDiaria)
    abstract fun consultar(alocacaoDiariaFiltroDTO : AlocacaoDiariaFiltroDTO) : List<AlocacaoDiaria>
    abstract fun obter(un: UnidadeNegocio, data: Date) : AlocacaoDiaria?
    abstract fun excluir(un:UnidadeNegocio, data: Date) : Unit
}