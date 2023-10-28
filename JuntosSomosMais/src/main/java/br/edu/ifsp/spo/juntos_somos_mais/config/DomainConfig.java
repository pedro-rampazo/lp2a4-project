package br.edu.ifsp.spo.juntos_somos_mais.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("br.edu.ifsp.spo.juntos_somos_mais")
@EnableJpaRepositories("br.edu.ifsp.spo.juntos_somos_mais")
@EnableTransactionManagement
public class DomainConfig {
}
