package br.com.demo.business.features.poco

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.poco.PocoDTO
import br.com.demo.business.domain.poco.PocoFiltroDTO
import br.com.demo.business.domain.poco.PocoRepository

class ConsultarPocos (private val pocoRepository: PocoRepository
) : FunciolidadeExecutavel<PocoFiltroDTO, ListaPaginada<PocoDTO>> {

    override fun executar(filtro: PocoFiltroDTO): ListaPaginada<PocoDTO> {
        val listaPaginada = pocoRepository.consultar(filtro)
        //instancia uma nova lista paginada convertendo modelo em dto
        return ListaPaginada<PocoDTO>(listaPaginada.total,
            listaPaginada.tamanho,
            listaPaginada.pagina,
            listaPaginada.itens.map { PocoDTO(it) })
    }

}