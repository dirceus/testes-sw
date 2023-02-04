package br.com.demo.api.rest

import br.com.demo.business.commons.ExecutorFuncionalidade
import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.poco.NovoStatusDTO
import br.com.demo.business.domain.poco.PocoCompletoDTO
import br.com.demo.business.domain.poco.PocoDTO
import br.com.demo.business.domain.poco.PocoFiltroDTO
import br.com.demo.business.features.poco.AdicionarPoco
import br.com.demo.business.features.poco.AlterarStatusPoco
import br.com.demo.business.features.poco.ConsultarPocos
import br.com.demo.business.features.poco.ObterPoco
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletionStage

@RestController
@RequestMapping("/api/poco")
class PocoController(
    private val executorFuncionalidade: ExecutorFuncionalidade,
    private val consultarPocos: ConsultarPocos,
    private val adicionarPoco: AdicionarPoco,
    private val obterPoco: ObterPoco,
    private val alterarStatusPoco: AlterarStatusPoco

    ) {

    @GetMapping("/consultar")
    fun consultarPocos(filtro: PocoFiltroDTO) : CompletionStage<ListaPaginada<PocoDTO>> {
        return executorFuncionalidade(
            funcionalidade = consultarPocos,
            requestDto = filtro,
            requestConverter = {it},
            responseConverter = {it}
        )
    }

    @PostMapping("/adicionar")
    fun adicionarPoco(@RequestBody pocoDTO: PocoDTO) : CompletionStage<Unit> {
        return executorFuncionalidade(
            funcionalidade = adicionarPoco,
            requestDto = pocoDTO,
            requestConverter = {it}
        )
    }

    @PostMapping("/novo-status-poco")
    fun alterarStatus(@RequestBody novoStatusDTO: NovoStatusDTO) : CompletionStage<Unit> {
        return executorFuncionalidade(
            funcionalidade = alterarStatusPoco,
            requestDto = novoStatusDTO,
            requestConverter = {it}
        )
    }


    @GetMapping("/obter/{codPoco}")
    fun obter(@PathVariable codPoco: Int) : CompletionStage<PocoCompletoDTO> {
        return executorFuncionalidade(
            funcionalidade = obterPoco,
            requestDto = codPoco,
            requestConverter = {it},
            responseConverter = { PocoCompletoDTO(it) }
        )
    }


}