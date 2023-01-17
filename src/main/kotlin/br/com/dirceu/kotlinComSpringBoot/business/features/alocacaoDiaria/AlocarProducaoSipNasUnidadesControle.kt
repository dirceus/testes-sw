package br.com.dirceu.kotlinComSpringBoot.business.features.alocacaoDiaria

import br.com.dirceu.kotlinComSpringBoot.business.domain.alocacaoDiaria.AlocacaoDiaria
import br.com.dirceu.kotlinComSpringBoot.business.domain.alocacaoDiaria.AlocacaoDiariaRepository
import br.com.dirceu.kotlinComSpringBoot.business.domain.noSip.NoSipRepository
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeControle.UnidadeControleRepository
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocioRepository
import br.com.dirceu.kotlinComSpringBoot.business.commons.FunciolidadeExecutavel
import br.com.dirceu.kotlinComSpringBoot.business.commons.dto.alocacaoDiaria.RequesicaoAlocacaoDiariaDTO
import br.com.dirceu.kotlinComSpringBoot.business.commons.dto.noSip.NoProducaoParaProcessamentoDTO
import br.com.dirceu.kotlinComSpringBoot.business.commons.exceptions.BusinessException
import org.springframework.stereotype.Service

@Service
class AlocarProducaoSipNasUnidadesControle (
    private val alocacaoDiariaRepository: AlocacaoDiariaRepository,
    private val noSipRepository: NoSipRepository,
    private val unidadeNegocioRepository: UnidadeNegocioRepository,
    private val unidadeControleRepository: UnidadeControleRepository,
) : FunciolidadeExecutavel<RequesicaoAlocacaoDiariaDTO, Unit> {

    override fun executar(request: RequesicaoAlocacaoDiariaDTO): Unit{

        //obter un
        val unidadeNegocio = unidadeNegocioRepository.findByCodigo(request.codigoUnidade)
            ?: throw BusinessException("O codigo ${request.codigoUnidade} da Unidade de Negócio é inválido")

        //obter nós de produção do sip
        val listaNos = noSipRepository.obterNosProducaoSipComProducaoNaData(unidadeNegocio, request.data)
        val alocacaoDiaria = AlocacaoDiaria(null, unidadeNegocio, request.data)
        val listaNoProducaoParaProcessamentoDTO =
            listaNos.map { NoProducaoParaProcessamentoDTO(it,
                unidadeControleRepository.obterUnidadesControleAtivasVinculadasNo(it.noSip,request.data) ) }
        alocacaoDiaria.processar(listaNoProducaoParaProcessamentoDTO)
        this.alocacaoDiariaRepository.salvar(alocacaoDiaria)


    }

}