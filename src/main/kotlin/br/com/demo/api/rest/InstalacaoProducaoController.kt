package br.com.demo.api.rest

import br.com.demo.business.commons.ExecutorFuncionalidade
import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.instalacao.InstalacaoProducaoDTO
import br.com.demo.business.domain.instalacao.InstalacaoProducaoFiltroDTO
import br.com.demo.business.features.instalacao.AdicionarInstalacao
import br.com.demo.business.features.instalacao.ConsultarInstalacoes
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletionStage

@RestController
@RequestMapping("/api/instalacao")
class InstalacaoProducaoController(
    private val executorFuncionalidade: ExecutorFuncionalidade,
    private val consultarInstalacoes: ConsultarInstalacoes,
    private val adicionarInstalacao: AdicionarInstalacao,

    ) {

    @GetMapping("/listar")
    fun listarInstalacoes(filtro: InstalacaoProducaoFiltroDTO) : CompletionStage<ListaPaginada<InstalacaoProducaoDTO>> {
        return executorFuncionalidade(
            funcionalidade = consultarInstalacoes,
            requestDto = filtro,
            requestConverter = {it},
            responseConverter = {it}
        )
    }

    @PostMapping("/adicionar")
    fun adicionarUnidadesNegocio(@RequestBody instalacaoDto: InstalacaoProducaoDTO) : CompletionStage<Unit> {
        return executorFuncionalidade(
            funcionalidade = adicionarInstalacao,
            requestDto = instalacaoDto,
            requestConverter = {it}
        )
    }

}