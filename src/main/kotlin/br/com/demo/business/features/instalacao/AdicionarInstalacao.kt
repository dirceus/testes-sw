package br.com.demo.business.features.instalacao

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.exceptions.BusinessException
import br.com.demo.business.domain.instalacao.InstalacaoProducao
import br.com.demo.business.domain.instalacao.InstalacaoProducaoDTO
import br.com.demo.business.domain.instalacao.InstalacaoProducaoRepository
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioRepository

class AdicionarInstalacao (private val instalacaoRepository: InstalacaoProducaoRepository,
                           private val unidadeNegocioRepository: UnidadeNegocioRepository
) : FunciolidadeExecutavel<InstalacaoProducaoDTO, Unit>{
    override fun executar(request: InstalacaoProducaoDTO) {
        //verifica se a unidade de negocio é valida
        val unidadeNegocio = unidadeNegocioRepository.obterPorCodigo(request.codigoUnidadeNegocio)
            ?: throw BusinessException("Código da Unidade de Negócio é inválido")

        val instalacaoProducao = InstalacaoProducao(null,unidadeNegocio,request.nome,request.ativa)
        instalacaoRepository.salvar(instalacaoProducao)
    }

}