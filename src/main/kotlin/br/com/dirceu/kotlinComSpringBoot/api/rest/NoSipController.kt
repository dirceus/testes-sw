package br.com.dirceu.kotlinComSpringBoot.api.rest

import br.com.dirceu.kotlinComSpringBoot.business.features.tanqueProducao.InformarProducaoDia
import br.com.dirceu.kotlinComSpringBoot.business.commons.ExecutorFuncionalidade
import br.com.dirceu.kotlinComSpringBoot.business.commons.dto.tanqueProducao.ProducaoDiaDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletionStage

@RestController
@RequestMapping("/api/no-sip")
class NoSipController(
    private val executorFuncionalidade: ExecutorFuncionalidade,
    private val informarProducaoDia: InformarProducaoDia)
{

    @PostMapping("/informar-producao")
    fun informarProducao(@RequestBody filtro: ProducaoDiaDTO) : CompletionStage<Unit> {
        return executorFuncionalidade(
            funcionalidade = informarProducaoDia,
            requestDto = filtro,
            requestConverter = {it}
        )
    }

}