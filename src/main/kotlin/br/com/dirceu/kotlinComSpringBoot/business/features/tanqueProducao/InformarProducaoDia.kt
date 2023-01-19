package br.com.dirceu.kotlinComSpringBoot.business.features.tanqueProducao

import br.com.dirceu.kotlinComSpringBoot.business.commons.FunciolidadeExecutavel
import br.com.dirceu.kotlinComSpringBoot.business.commons.dto.tanqueProducao.ProducaoDiaDTO
import br.com.dirceu.kotlinComSpringBoot.business.commons.exceptions.BusinessException
import br.com.dirceu.kotlinComSpringBoot.business.domain.tanqueProducao.ProducaoDia
import br.com.dirceu.kotlinComSpringBoot.business.domain.tanqueProducao.TanqueProducaoRepository
import org.springframework.stereotype.Service

@Service
class InformarProducaoDia(private val tanqueProducaoRepository: TanqueProducaoRepository):
    FunciolidadeExecutavel<ProducaoDiaDTO, Unit>

{
    override fun executar(request: ProducaoDiaDTO) {

        val tanque = tanqueProducaoRepository.obterTanqueProducao(request.codigoUn, request.codigoTanqueProducao)
            ?: throw BusinessException("Codigo do Tanque ${request.codigoTanqueProducao} é invalido para a UN ${request.codigoUn}")

        val producaoDia = ProducaoDia(null, request.data, request.producao, tanque)
        tanqueProducaoRepository.salvarProducaoDiaPorTanque(producaoDia)

    }


}