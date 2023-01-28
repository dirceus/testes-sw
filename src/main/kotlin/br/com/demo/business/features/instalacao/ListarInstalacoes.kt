package br.com.demo.business.features.instalacao

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.domain.instalacao.InstalacaoProducaoDTO
import br.com.demo.business.domain.instalacao.InstalacaoProducaoRepository

class ListarInstalacoes(private val instalacaoRepository: InstalacaoProducaoRepository
) : FunciolidadeExecutavel<Int, List<InstalacaoProducaoDTO>> {

    override fun executar(codUn: Int): List<InstalacaoProducaoDTO> {
        val lista = instalacaoRepository.listaInstalacoesPorUn(codUn)
        return  lista.map { InstalacaoProducaoDTO(it) }
    }

}