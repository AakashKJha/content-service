package com.x.blog.config;

import com.couchbase.client.core.retry.BestEffortRetryStrategy;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.env.ClusterEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;

import java.time.Duration;

@Configuration
@EnableReactiveCouchbaseRepositories
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Value("${couchbase.bucket.name}")
    private String bucketName;

    @Value("${couchbase.bucket.password}")
    private String password;

    @Value("${couchbase.bootstrap-hosts}")
    private String bootstrapHost;

    @Value("${couchbase.env.timeouts.connect}")
    private Long connectionTimeout;

    @Value("${couchbase.env.timeouts.query}")
    private Long queryTimeout;

    @Value("${couchbase.env.timeouts.view}")
    private Long viewTimeout;

    @Value("${couchbase.env.timeouts.key-value}")
    private Long keyValueTimeout;

    @Value("${couchbase.env.timeouts.max-request-lifetime}")
    private Long maxRequestLifetime;

    @Value("${couchbase.env.timeouts.auto-release-after}")
    private Long autoReleaseAfter;

    @Bean
    public ClusterEnvironment couchbaseClusterEnvironment() {
        return ClusterEnvironment.builder()
                .timeoutConfig(timeoutConfig -> timeoutConfig
                        .connectTimeout(Duration.ofMillis(connectionTimeout))
                        .queryTimeout(Duration.ofMillis(queryTimeout))
                        .viewTimeout(Duration.ofMillis(viewTimeout))
                        .kvTimeout(Duration.ofMillis(keyValueTimeout))
                ).retryStrategy(BestEffortRetryStrategy.INSTANCE)
                .build();
    }

    @Override
    public String getConnectionString() {
        return bootstrapHost;
    }

    @Override
    public String getUserName() {
        return bucketName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getBucketName() {
        return bucketName;
    }

    @Bean
    public Bucket bucket() {
        return couchbaseCluster(couchbaseClusterEnvironment()).bucket(bucketName);
    }
}
