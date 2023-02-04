package br.com.demo.business.features.instalacao

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.instalacao.InstalacaoProducaoDTO
import br.com.demo.business.domain.instalacao.InstalacaoProducaoFiltroDTO
import br.com.demo.business.domain.instalacao.InstalacaoProducaoRepository
import org.springframework.stereotype.Service


@Service
class ConsultarInstalacoes (private val instalacaoProducaoRepository: InstalacaoProducaoRepository
    ) : FunciolidadeExecutavel<InstalacaoProducaoFiltroDTO, ListaPaginada<InstalacaoProducaoDTO>> {


    override fun executar(request: InstalacaoProducaoFiltroDTO): ListaPaginada<InstalacaoProducaoDTO> {
        val listaPaginadaInstalacoes = instalacaoProducaoRepository.consultarInstalacoes(request)
        return ListaPaginada(
            listaPaginadaInstalacoes.total,
            listaPaginadaInstalacoes.tamanho,
            listaPaginadaInstalacoes.pagina,
            listaPaginadaInstalacoes.itens.map {
                InstalacaoProducaoDTO(it.codigo,it.nome,it.unidadeNegocio.codigo!!, it.unidadeNegocio.nome,it.ativo)
            }
        )
    }

}