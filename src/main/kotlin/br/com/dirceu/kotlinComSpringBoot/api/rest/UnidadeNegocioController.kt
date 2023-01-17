package br.com.dirceu.kotlinComSpringBoot.api.rest

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.business.features.unidadeNegocio.AdicionarUnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.business.features.unidadeNegocio.ConsultarUnidadesNegocio
import br.com.dirceu.kotlinComSpringBoot.business.features.unidadeNegocio.EditarUnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.business.features.unidadeNegocio.ListarUnidadesNegocioAtivas
import br.com.dirceu.kotlinComSpringBoot.business.commons.ExecutorFuncionalidade
import br.com.dirceu.kotlinComSpringBoot.business.commons.ListaPaginada
import br.com.dirceu.kotlinComSpringBoot.business.commons.dto.unidadeNegocio.UnidadeNegocioCompletoDTO
import br.com.dirceu.kotlinComSpringBoot.business.commons.dto.unidadeNegocio.UnidadeNegocioDTO
import br.com.dirceu.kotlinComSpringBoot.business.commons.dto.unidadeNegocio.UnidadeNegocioFiltroDTO
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletionStage

@RestController
@RequestMapping("/api/unidade-negocio")
class UnidadeNegocioController(
    private val executorFuncionalidade: ExecutorFuncionalidade,
    private val listarUnidadesNegocioAtivas: ListarUnidadesNegocioAtivas,
    private val consultarUnidadesNegocio: ConsultarUnidadesNegocio,
    private val adicionarUnidadeNegocio: AdicionarUnidadeNegocio,
    private val editarUnidadeNegocio: EditarUnidadeNegocio
) {

    @GetMapping("/listar/un-ativas")
    fun listarUnidadesNegocioAtivas() : CompletionStage<List<UnidadeNegocioDTO>> {
        return executorFuncionalidade(
            funcionalidade = listarUnidadesNegocioAtivas,
            responseConverter = { it.map { un -> UnidadeNegocioDTO(un) } }
        )
    }

    @GetMapping("/listar")
    fun listarUnidadesNegocio(filtro: UnidadeNegocioFiltroDTO) : CompletionStage<ListaPaginada<UnidadeNegocio>> {
        return executorFuncionalidade(
            funcionalidade = consultarUnidadesNegocio,
            requestDto = filtro,
            requestConverter = {it},
            responseConverter = {it}
        )
    }

    @PostMapping("/adicionar")
    fun adicionarUnidadesNegocio(@RequestBody filtro: UnidadeNegocioCompletoDTO) : CompletionStage<Unit> {
        return executorFuncionalidade(
            funcionalidade = adicionarUnidadeNegocio,
            requestDto = filtro,
            requestConverter = {it.toUnidadeNegocio()}
        )
    }

    @PostMapping("/editar")
    fun editarUnidadesNegocio(@RequestBody filtro: UnidadeNegocioCompletoDTO) : CompletionStage<Unit> {
        return executorFuncionalidade(
            funcionalidade = editarUnidadeNegocio,
            requestDto = filtro,
            requestConverter = {it.toUnidadeNegocio()}
        )
    }


}