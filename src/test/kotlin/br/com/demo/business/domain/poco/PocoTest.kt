package br.com.demo.business.domain.poco

import br.com.demo.business.domain.instalacao.InstalacaoProducao
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocio
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate

class PocoTest {

    @Test
    fun `Quando crio um poco Então ele deve conter apenas item no historico sem data fim`(){
           val un = UnidadeNegocio("UN-XX")
           val instalacaoProducao = InstalacaoProducao(null,un,"Insta XX",true)
           val poco = Poco("Poço 1", "Poco 1", instalacaoProducao, LocalDate.of(2023,1,1))

           Assertions.assertEquals(1,poco.historicoStatus.size)
           Assertions.assertEquals(LocalDate.of(2023,1,1), poco.historicoStatus[0].dataInicio)
           Assertions.assertNull(poco.historicoStatus[0].dataFim)
    }
    @Test
    fun `Quando adiciono um novo status igual ao status atual Então a alteração deve gerar um erro`() {
    }

    @Test
    fun `Quando adiciono um novo status diferente do atual e com data de inicio anterior a do último status Então o sistema deve informar que a data não é permitida`() {
    }
    @Test
    fun `Quando adiciono um novo status diferente do atual e com data de inicio maior do que a do ultimo status Então o sistema deve atualizar o status, adicionar data fim no status anterior`(){

    }


}