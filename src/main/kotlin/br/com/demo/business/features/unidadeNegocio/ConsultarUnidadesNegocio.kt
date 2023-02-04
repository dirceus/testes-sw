package br.com.demo.business.features.unidadeNegocio

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioDTO
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioFiltroDTO
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioRepository
import org.springframework.stereotype.Service


@Service
class ConsultarUnidadesNegocio (private val unidadeNegocioRepository: UnidadeNegocioRepository
    ) : FunciolidadeExecutavel<UnidadeNegocioFiltroDTO, ListaPaginada<UnidadeNegocioDTO>> {


    override fun executar(request: UnidadeNegocioFiltroDTO): ListaPaginada<UnidadeNegocioDTO> {
        val listaPaginadaUNs = unidadeNegocioRepository.consultar(request)
        return ListaPaginada(
            listaPaginadaUNs.total,
            listaPaginadaUNs.tamanho,
            listaPaginadaUNs.pagina,
            listaPaginadaUNs.itens.map {
                UnidadeNegocioDTO(it.codigo,it.nome,it.descricao,it.ativa)
            }
        )
    }

}