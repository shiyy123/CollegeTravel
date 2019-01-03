package nju.edu.travel.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Cary on 19-1-3
 * Email: yangyangshi@smail.nju.edu.cn
 */

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories("nju.edu.travel.repository")
@EntityScan("nju.edu.travel.entity")
@EnableTransactionManagement
public class JpaConfig {
}
