package br.com.demo.business.features.poco

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.poco.PocoDTO
import br.com.demo.business.domain.poco.PocoFiltroDTO
import br.com.demo.business.domain.poco.PocoRepository
import org.springframework.stereotype.Service


@Service
class ConsultarPocos (private val pocoRepository: PocoRepository
    ) : FunciolidadeExecutavel<PocoFiltroDTO, ListaPaginada<PocoDTO>> {


    override fun executar(request: PocoFiltroDTO): ListaPaginada<PocoDTO> {
        val listaPaginadaPoco = pocoRepository.consultar(request)
        return ListaPaginada(
            listaPaginadaPoco.total,
            listaPaginadaPoco.tamanho,
            listaPaginadaPoco.pagina,
            listaPaginadaPoco.itens.map {
                PocoDTO(it.codigo,it.nome,it.unidadeNegocio.codigo!!,it.descricao, it.dataCriacao, it.status, it.unidadeNegocio.nome,it.instalacaoPoco?.codigo, it.instalacaoPoco?.nome)
            }
        )
    }

}