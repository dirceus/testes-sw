package br.com.dirceu.kotlinComSpringBoot.business.features.noSip

import br.com.dirceu.kotlinComSpringBoot.business.domain.noSip.NoProducaoSip
import br.com.dirceu.kotlinComSpringBoot.business.domain.noSip.NoSipRepository
import br.com.dirceu.kotlinComSpringBoot.commons.FunciolidadeExecutavel
import br.com.dirceu.kotlinComSpringBoot.commons.dto.noSip.NoProducaoSipDTO
import br.com.dirceu.kotlinComSpringBoot.commons.exceptions.BusinessException
import org.springframework.stereotype.Service

@Service
class InformarProducaoNoSip(private val noSipRepository: NoSipRepository):
    FunciolidadeExecutavel<NoProducaoSipDTO, Unit>

{
    override fun executar(request: NoProducaoSipDTO) {

        val noSip = noSipRepository.obterNoSip(request.codigoUn, request.codigoNoSip)
            ?: throw BusinessException("Codigo do Nó Sip ${request.codigoNoSip} é invalido para a UN ${request.codigoUn}")

        val noProducaoSip = NoProducaoSip(null,request.data,request.producao, noSip)
        noSipRepository.salvarProducaoNoSip(noProducaoSip)

    }


}