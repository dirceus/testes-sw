package br.com.demo.api.rest

import br.com.demo.business.commons.ExecutorFuncionalidade
import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioDTO
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioFiltroDTO
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.demo.business.features.unidadeNegocio.AdicionarUnidadeNegocio
import br.com.demo.business.features.unidadeNegocio.ConsultarUnidadesNegocio
import br.com.demo.business.features.unidadeNegocio.EditarUnidadeNegocio
import br.com.demo.business.features.unidadeNegocio.ListarUnidadesNegocioAtivas
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
        TODO()
    }

    @GetMapping("/listar")
    fun listarUnidadesNegocio(filtro: UnidadeNegocioFiltroDTO) : CompletionStage<ListaPaginada<UnidadeNegocio>> {
        TODO()
    }

    @PostMapping("/adicionar")
    fun adicionarUnidadesNegocio(@RequestBody filtro: UnidadeNegocioDTO) : CompletionStage<Unit> {
        TODO()
    }

    @PostMapping("/editar")
    fun editarUnidadesNegocio(@RequestBody filtro: UnidadeNegocioDTO) : CompletionStage<Unit> {
        TODO()
    }


}