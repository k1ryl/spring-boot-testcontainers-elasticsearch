package kval.springboottestcontainerselasticsearch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("elasticsearch-integration-test")
public class ElasticsearchContainerConfig {

  @Bean
  public SharedElasticsearchContainer sharedElasticsearchContainer() {
    SharedElasticsearchContainer elasticsearchContainer =
        SharedElasticsearchContainer.getInstance();
    elasticsearchContainer.start();
    return elasticsearchContainer;
  }
}
