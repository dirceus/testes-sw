package br.com.demo.api.rest

import br.com.demo.business.commons.ExecutorFuncionalidade
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/no-sip")
class BoletimMedicaoController(
    private val executorFuncionalidade: ExecutorFuncionalidade)
{


}