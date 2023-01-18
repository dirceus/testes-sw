package br.com.dirceu.kotlinComSpringBoot.api.rest

import br.com.dirceu.kotlinComSpringBoot.business.features.relatorioProducaoDiaria.RatearProducaoUnidadeNegocioPorPocas
import br.com.dirceu.kotlinComSpringBoot.business.commons.ExecutorFuncionalidade
import br.com.dirceu.kotlinComSpringBoot.business.commons.dto.relatorioProducaoDiaria.RequesicaoRateioProducaoDTO
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletionStage

@RestController
@RequestMapping("/api/alocacao-diara")
class AlocacaoDiariaController(
    private val executorFuncionalidade: ExecutorFuncionalidade,
    private val ratearProducaoUnidadeNegocioPorPocas: RatearProducaoUnidadeNegocioPorPocas
) {

    @PostMapping("/alocar")
    fun adicionarUnidadesNegocio(@RequestBody filtro: RequesicaoRateioProducaoDTO) : CompletionStage<Unit> {
        return executorFuncionalidade(
            funcionalidade = ratearProducaoUnidadeNegocioPorPocas,
            requestDto = filtro,
            requestConverter = {it}
        )
    }



}