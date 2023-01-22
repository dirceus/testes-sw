package br.com.demo.business.features.unidadeNegocio

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioFiltroDTO
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioRepository
import org.springframework.stereotype.Service


@Service
class ConsultarUnidadesNegocio (private val unidadeNegocioRepository: UnidadeNegocioRepository
    ) : FunciolidadeExecutavel<UnidadeNegocioFiltroDTO, ListaPaginada<UnidadeNegocio>> {


    override fun executar(request: UnidadeNegocioFiltroDTO): ListaPaginada<UnidadeNegocio> {
        return unidadeNegocioRepository.consultar(request)
    }

}