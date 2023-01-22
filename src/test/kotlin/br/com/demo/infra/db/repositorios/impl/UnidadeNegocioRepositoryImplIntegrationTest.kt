package br.com.demo.infra.db.repositorios.impl

import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.annotation.DirtiesContext

@DataJpaTest
@ComponentScan
class UnidadeNegocioRepositoryImplIntegrationTest(
            @Autowired val unidadeNegocioRepository: UnidadeNegocioRepository
){

    @Test
    @DirtiesContext
    fun `Quando pesquiso por codigo valido Entao retorna uma UN`(){
        //Dado que existe uma unidade de negócio de código 1
        val un = UnidadeNegocio("UN-XX","UN de teste", true )
        unidadeNegocioRepository.salvar(un)

        //quando pesquiso pelo codigo válido
        val resultado = unidadeNegocioRepository.obterPorCodigo(1)

        //Então o resultado deve ser uma UN com o codigo 1
        Assertions.assertEquals(1, resultado!!.codigo)
        Assertions.assertEquals("UN-XX", resultado.nome)
    }

    @Test
    @DirtiesContext
    fun `Quando pesquiso com um código inexistente Então retorna null`(){
        //Dado que existe uma unidade de negócio de código 1
        val un = UnidadeNegocio("UN-XX","UN de teste", true )
        unidadeNegocioRepository.salvar(un)

        //Quando pesquiso pelo codigo 2
        val resultado = unidadeNegocioRepository.obterPorCodigo(2)

        //Então o resultado deve ser nulo
        Assertions.assertEquals(null, resultado)
    }


}