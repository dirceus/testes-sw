package br.com.dirceu.kotlinComSpringBoot.business.features.relatorioProducaoDiaria

import br.com.dirceu.kotlinComSpringBoot.business.commons.FunciolidadeExecutavel
import br.com.dirceu.kotlinComSpringBoot.business.commons.dto.relatorioProducaoDiaria.RequesicaoRateioProducaoDTO
import br.com.dirceu.kotlinComSpringBoot.business.commons.dto.tanqueProducao.InfoRateioProducaoDTO
import br.com.dirceu.kotlinComSpringBoot.business.commons.exceptions.BusinessException
import br.com.dirceu.kotlinComSpringBoot.business.domain.PocaPetroleo.PocaPetroleRepository
import br.com.dirceu.kotlinComSpringBoot.business.domain.relatorioProducaoDiaria.RelatorioProducaoDiaria
import br.com.dirceu.kotlinComSpringBoot.business.domain.relatorioProducaoDiaria.RelatorioProducaoDiariaRepository
import br.com.dirceu.kotlinComSpringBoot.business.domain.tanqueProducao.TanqueProducaoRepository
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocioRepository
import org.springframework.stereotype.Service

@Service
class RatearProducaoUnidadeNegocioPorPocas (
    private val relatorioProducaoDiariaRepository: RelatorioProducaoDiariaRepository,
    private val tanqueProducaoRepository: TanqueProducaoRepository,
    private val unidadeNegocioRepository: UnidadeNegocioRepository,
    private val pocaPetroleRepository: PocaPetroleRepository,
) : FunciolidadeExecutavel<RequesicaoRateioProducaoDTO, Unit> {

    override fun executar(request: RequesicaoRateioProducaoDTO): Unit{

        //obter un
        val unidadeNegocio = unidadeNegocioRepository.findByCodigo(request.codigoUnidade)
            ?: throw BusinessException("O codigo ${request.codigoUnidade} da Unidade de Negócio é inválido")

        //obter os tanques
        val listaProducaoDiaPorTanque = tanqueProducaoRepository.obterTanquesComProducaoInformadaNaData(unidadeNegocio, request.data)
        val relatorioProducaoDiaria = RelatorioProducaoDiaria(null, unidadeNegocio, request.data)
        val listaInfoTanqueParaRateio =
                listaProducaoDiaPorTanque.map { InfoRateioProducaoDTO(it,
                    pocaPetroleRepository.obterPocasPetroleoAtivasVinculadasTanqueProducao(it.tanqueProducao,request.data) ) }
        relatorioProducaoDiaria.processar(listaInfoTanqueParaRateio)
        this.relatorioProducaoDiariaRepository.salvar(relatorioProducaoDiaria)


    }

}