package kval.springboottestcontainerselasticsearch.config;

import java.util.AbstractMap;
import java.util.Map;
import org.testcontainers.elasticsearch.ElasticsearchContainer;

public class SharedElasticsearchContainer extends ElasticsearchContainer {

  private static final String IMAGE_VERSION =
      "docker.elastic.co/elasticsearch/elasticsearch:7.16.3";
  private static final Map<String, String> ENV_VARIABLES =
      Map.ofEntries(
          new AbstractMap.SimpleEntry<>("xpack.security.enabled", "false"), // turn off security
          new AbstractMap.SimpleEntry<>("ES_JAVA_OPTS", "-Xms512m -Xmx512m") // reduce memory
          );
  private static SharedElasticsearchContainer container;

  private SharedElasticsearchContainer() {
    super(IMAGE_VERSION);
  }

  public static SharedElasticsearchContainer getInstance() {
    if (container == null) {
      container = new SharedElasticsearchContainer();
      container.withEnv(ENV_VARIABLES);
    }
    return container;
  }

  @Override
  public void start() {
    super.start();
  }

  @Override
  public void stop() {
    // do nothing, JVM handles shut down
  }
}
