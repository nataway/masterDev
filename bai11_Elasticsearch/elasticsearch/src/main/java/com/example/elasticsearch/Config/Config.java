package com.example.elasticsearch.Config;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;


@Configuration
public class Config extends AbstractElasticsearchConfiguration {
    @Value("${elasticsearch.url}")
    public String elasticsearchUrl;
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration config = ClientConfiguration.builder()
                .connectedTo(elasticsearchUrl)
                .build();
        return RestClients.create(config).rest();
    }
}