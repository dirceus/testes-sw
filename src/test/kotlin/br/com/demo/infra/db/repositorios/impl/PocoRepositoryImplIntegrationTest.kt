package br.com.demo.infra.db.repositorios.impl

import br.com.demo.business.domain.poco.PocoRepository
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class PocoRepositoryImplIntegrationTest(pocaPetroleRepository: PocoRepository) {

    @Test
    fun teste() {
    }



}