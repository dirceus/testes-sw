package br.com.demo.business.features.instalacao

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.exceptions.BusinessException
import br.com.demo.business.domain.instalacao.InstalacaoProducao
import br.com.demo.business.domain.instalacao.InstalacaoProducaoDTO
import br.com.demo.business.domain.instalacao.InstalacaoProducaoRepository
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioRepository
import org.springframework.stereotype.Service

@Service
class AdicionarInstalacao (
    private val instalacaoProducaoRepository: InstalacaoProducaoRepository,
    private val unidadeNegocioRepository: UnidadeNegocioRepository
) : FunciolidadeExecutavel<InstalacaoProducaoDTO, Unit> {

    override fun executar(request: InstalacaoProducaoDTO){

        val un = unidadeNegocioRepository.obterPorCodigo(request.codigoUnidadeNegocio)
            ?: throw BusinessException("Código da Unidade de negócio inválido")

        val instalacao = InstalacaoProducao(request.codigo,un,request.nome,request.ativa)

        instalacaoProducaoRepository.salvar(instalacao)
        return
    }

}