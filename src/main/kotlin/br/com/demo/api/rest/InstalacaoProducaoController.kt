package br.com.demo.api.rest

import br.com.demo.business.commons.ExecutorFuncionalidade
import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.instalacao.InstalacaoProducaoDTO
import br.com.demo.business.domain.instalacao.InstalacaoProducaoFiltroDTO
import br.com.demo.business.features.instalacao.AdicionarInstalacao
import br.com.demo.business.features.instalacao.ConsultarInstalacoes
import br.com.demo.business.features.instalacao.ListarInstalacoes
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletionStage

@RestController
@RequestMapping("/api/instalacao")
class InstalacaoProducaoController(
    private val executorFuncionalidade: ExecutorFuncionalidade,
    private val consultarInstalacoes: ConsultarInstalacoes,
    private val adicionarInstalacao: AdicionarInstalacao,
    private val listarInstalacoes: ListarInstalacoes,

    ) {

    @GetMapping("/consultar")
    fun consultarInstalacoes(filtro: InstalacaoProducaoFiltroDTO) : CompletionStage<ListaPaginada<InstalacaoProducaoDTO>> {
        return executorFuncionalidade(
            funcionalidade = consultarInstalacoes,
            requestDto = filtro,
            requestConverter = {it},
            responseConverter = {it}
        )
    }

    @PostMapping("/adicionar")
    fun adicionarInstalacao(@RequestBody instalacaoDto: InstalacaoProducaoDTO) : CompletionStage<Unit> {
        return executorFuncionalidade(
            funcionalidade = adicionarInstalacao,
            requestDto = instalacaoDto,
            requestConverter = {it}
        )
    }

    @GetMapping("/listar-ativas")
    fun listarInstalacoesAtivas(codUn: Int) : CompletionStage<List<InstalacaoProducaoDTO>> {
        return executorFuncionalidade(
            funcionalidade = listarInstalacoes,
            requestDto = InstalacaoProducaoFiltroDTO(codigoUnidadeNegocio = codUn,ativo = true, nome = null),
            requestConverter = {it},
            responseConverter = {it}
        )
    }


}