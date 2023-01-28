package br.com.demo.business.features.poco;

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.exceptions.BusinessException
import br.com.demo.business.domain.instalacao.InstalacaoProducaoRepository
import br.com.demo.business.domain.poco.PocoRepository
import br.com.demo.business.domain.poco.VincularInstalacaoPocoDTO
import br.com.demo.business.domain.poco.VinculoInstalacaoPoco

public class VincularPocoInstalacao (private val instalacaoRepository: InstalacaoProducaoRepository,
                                     private val pocoRepository: PocoRepository
) : FunciolidadeExecutavel<VincularInstalacaoPocoDTO, Unit> {
    override fun executar(request: VincularInstalacaoPocoDTO) {
        //verifica se a instalacao é valida
        val instalacao = instalacaoRepository.obter(request.codInstalacao)
            ?: throw BusinessException("Código da Instalação é inválido")

        val poco = pocoRepository.obterPoco(request.codPoco)
            ?: throw BusinessException("Código do Poço é inválido")

        if(poco.unidadeNegocio.codigo != instalacao.unidadeNegocio.codigo){
            throw BusinessException("Não é possível vincular poço com instalação de unidade de negócio diferente")
        }
        //verifica se o poço está vinculado a alguma instalação durante o periodo
        val instalacaoVinculadaAoPoco = instalacaoRepository.obterPeloVinculo(request.codPoco, request.dataInicio,request.dataFim)
        if(instalacaoVinculadaAoPoco != null){
            throw BusinessException("Poço já possui vínculo com uma instalação ${instalacaoVinculadaAoPoco.nome} no periodo entre ${request.dataInicio} e ${request.dataFim}")
        }
        val vinculoInstalacaoPoco = VinculoInstalacaoPoco(instalacao,poco,request.dataInicio, request.dataFim)
        pocoRepository.salvarVinculo(vinculoInstalacaoPoco)

    }

}