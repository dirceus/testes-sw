package br.com.dirceu.kotlinComSpringBoot.business.features.unidadeNegocio

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocioRepository
import br.com.dirceu.kotlinComSpringBoot.business.commons.FunciolidadeExecutavel
import org.springframework.stereotype.Service

@Service
class ListarUnidadesNegocioAtivas(
    private val unidadeNegocioRepository: UnidadeNegocioRepository
): FunciolidadeExecutavel<Unit, List<UnidadeNegocio>> {

    override fun executar(request: Unit): List<UnidadeNegocio>{
        val todasUnidades = unidadeNegocioRepository.findAll()
        return todasUnidades.filter { it.emVigencia() }
    }
}
