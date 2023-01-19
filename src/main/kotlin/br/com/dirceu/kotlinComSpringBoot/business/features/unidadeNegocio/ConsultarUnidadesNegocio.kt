package br.com.dirceu.kotlinComSpringBoot.business.features.unidadeNegocio

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocioRepository
import br.com.dirceu.kotlinComSpringBoot.business.commons.FunciolidadeExecutavel
import br.com.dirceu.kotlinComSpringBoot.business.commons.ListaPaginada
import br.com.dirceu.kotlinComSpringBoot.business.commons.dto.unidadeNegocio.UnidadeNegocioFiltroDTO
import org.springframework.stereotype.Service


@Service
class ConsultarUnidadesNegocio (private val unidadeNegocioRepository: UnidadeNegocioRepository
    ) : FunciolidadeExecutavel<UnidadeNegocioFiltroDTO, ListaPaginada<UnidadeNegocio>> {


    override fun executar(request: UnidadeNegocioFiltroDTO): ListaPaginada<UnidadeNegocio> {
        return unidadeNegocioRepository.findAllByFiltro(request)
    }

}