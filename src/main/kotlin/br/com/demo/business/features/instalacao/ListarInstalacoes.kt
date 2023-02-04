package br.com.demo.business.features.instalacao

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.domain.instalacao.InstalacaoProducaoDTO
import br.com.demo.business.domain.instalacao.InstalacaoProducaoFiltroDTO
import br.com.demo.business.domain.instalacao.InstalacaoProducaoRepository
import org.springframework.stereotype.Service

@Service
class ListarInstalacoes (private val instalacaoProducaoRepository: InstalacaoProducaoRepository
) : FunciolidadeExecutavel<InstalacaoProducaoFiltroDTO, List<InstalacaoProducaoDTO>> {
    override fun executar(request: InstalacaoProducaoFiltroDTO): List<InstalacaoProducaoDTO> {
        return instalacaoProducaoRepository.listaInstalacoes(request).map {
            InstalacaoProducaoDTO(it.codigo, it.nome,it.unidadeNegocio.codigo!!,it.unidadeNegocio.nome,it.ativo) }
    }


}