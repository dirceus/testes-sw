package br.com.dirceu.kotlinComSpringBoot.api.rest

import br.com.dirceu.kotlinComSpringBoot.business.features.noSip.InformarProducaoNoSip
import br.com.dirceu.kotlinComSpringBoot.commons.ExecutorFuncionalidade
import br.com.dirceu.kotlinComSpringBoot.commons.dto.noSip.NoProducaoSipDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletionStage

@RestController
@RequestMapping("/api/no-sip")
class NoSipController(
    private val executorFuncionalidade: ExecutorFuncionalidade,
    private val informarProducaoNoSip: InformarProducaoNoSip)
{

    @PostMapping("/informar-producao")
    fun informarProducao(@RequestBody filtro: NoProducaoSipDTO) : CompletionStage<Unit> {
        return executorFuncionalidade(
            funcionalidade = informarProducaoNoSip,
            requestDto = filtro,
            requestConverter = {it}
        )
    }

}