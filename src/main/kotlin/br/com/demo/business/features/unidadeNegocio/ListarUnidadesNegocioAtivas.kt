package br.com.demo.business.features.unidadeNegocio

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioDTO
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioRepository
import org.springframework.stereotype.Service

@Service
class ListarUnidadesNegocioAtivas(
    private val unidadeNegocioRepository: UnidadeNegocioRepository
): FunciolidadeExecutavel<Unit, List<UnidadeNegocioDTO>> {

    override fun executar(request: Unit): List<UnidadeNegocioDTO>{
        var lista = unidadeNegocioRepository.obterTodas()
        return lista.filter { it.ativo }
    }
}
