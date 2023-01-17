package br.com.dirceu.kotlinComSpringBoot.api.rest

import br.com.dirceu.kotlinComSpringBoot.business.features.alocacaoDiaria.AlocarProducaoSipNasUnidadesControle
import br.com.dirceu.kotlinComSpringBoot.commons.ExecutorFuncionalidade
import br.com.dirceu.kotlinComSpringBoot.commons.dto.alocacaoDiaria.RequesicaoAlocacaoDiariaDTO
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletionStage

@RestController
@RequestMapping("/api/alocacao-diara")
class AlocacaoDiariaController(
    private val executorFuncionalidade: ExecutorFuncionalidade,
    private val alocarProducaoSipNasUnidadesControle: AlocarProducaoSipNasUnidadesControle
) {

    @PostMapping("/alocar")
    fun adicionarUnidadesNegocio(@RequestBody filtro: RequesicaoAlocacaoDiariaDTO) : CompletionStage<Unit> {
        return executorFuncionalidade(
            funcionalidade = alocarProducaoSipNasUnidadesControle,
            requestDto = filtro,
            requestConverter = {it}
        )
    }



}