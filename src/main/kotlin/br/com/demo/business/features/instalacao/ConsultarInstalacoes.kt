package br.com.demo.business.features.instalacao

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.instalacao.InstalacaoProducaoDTO
import br.com.demo.business.domain.instalacao.InstalacaoProducaoFiltroDTO
import br.com.demo.business.domain.instalacao.InstalacaoProducaoRepository

class ConsultarInstalacoes (private val instalacaoRepository: InstalacaoProducaoRepository
) : FunciolidadeExecutavel<InstalacaoProducaoFiltroDTO, ListaPaginada<InstalacaoProducaoDTO>> {

    override fun executar(filtro: InstalacaoProducaoFiltroDTO): ListaPaginada<InstalacaoProducaoDTO> {
        val listaPaginada = instalacaoRepository.consultarInstalacoes(filtro)
        //instancia uma nova lista paginada convertendo modelo em dto
        return ListaPaginada<InstalacaoProducaoDTO>(listaPaginada.total,
                        listaPaginada.tamanho,
                        listaPaginada.pagina,
                        listaPaginada.itens.map { InstalacaoProducaoDTO(it) })
    }

}