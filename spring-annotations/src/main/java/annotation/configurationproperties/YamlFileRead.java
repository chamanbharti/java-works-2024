package annotation.configurationproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration
@ConfigurationProperties(prefix = "myservice")
@PropertySource(value = "classpath:yamlFile.yml", factory = YamlPropertySourceFactory.class)
public class YamlFileRead {

    private ExternalServiceConfig centralServiceConfig = new ExternalServiceConfig();
    private SwaggerConfig swaggerConfig = new SwaggerConfig();
    private RedisConfig redisConfig = new RedisConfig();
    private RollbarConfig rollbarConfig = new RollbarConfig();
    private AwsConfig awsConfig = new AwsConfig();
    public static class ExternalServiceConfig {

        private String paymentUrl;
        private String authUrl;
        private String loginUrl;
        public String getPaymentUrl() {
            return paymentUrl;
        }
        public void setPaymentUrl(String paymentUrl) {
            this.paymentUrl = paymentUrl;
        }

        public String getAuthUrl() {
            return authUrl;
        }

        public void setAuthUrl(String authUrl) {
            this.authUrl = authUrl;
        }

        public String getLoginUrl() {
            return loginUrl;
        }

        public void setLoginUrl(String loginUrl) {
            this.loginUrl = loginUrl;
        }


    }
    public static class SwaggerConfig {

        private String title;
        private String description;
        private String version;
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }


    }
    public static class RedisConfig {

        private String host;
        private Integer port;
        public String getHost() {
            return host;
        }
        public void setHost(String host) {
            this.host = host;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }


    }
    public static class RollbarConfig {

        private String accessToken;
        private String environment;
        public String getAccessToken() {
            return accessToken;
        }
        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getEnvironment() {
            return environment;
        }

        public void setEnvironment(String environment) {
            this.environment = environment;
        }


    }
    public static class AwsConfig {

        private String accessKey;
        private String secretKey;
        private String bucketRegion;
        private String cloudFolder;
        public String getAccessKey() {
            return accessKey;
        }
        public void setAccessKey(String accessKey) {
            this.accessKey = accessKey;
        }

        public String getSecretKey() {
            return secretKey;
        }

        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }

        public String getBucketRegion() {
            return bucketRegion;
        }

        public void setBucketRegion(String bucketRegion) {
            this.bucketRegion = bucketRegion;
        }

        public String getCloudFolder() {
            return cloudFolder;
        }

        public void setCloudFolder(String cloudFolder) {
            this.cloudFolder = cloudFolder;
        }


    }

    public ExternalServiceConfig getCentralServiceConfig() {
        return centralServiceConfig;
    }

    public void setCentralServiceConfig(ExternalServiceConfig centralServiceConfig) {
        this.centralServiceConfig = centralServiceConfig;
    }

    public SwaggerConfig getSwaggerConfig() {
        return swaggerConfig;
    }

    public void setSwaggerConfig(SwaggerConfig swaggerConfig) {
        this.swaggerConfig = swaggerConfig;
    }

    public RedisConfig getRedisConfig() {
        return redisConfig;
    }

    public void setRedisConfig(RedisConfig redisConfig) {
        this.redisConfig = redisConfig;
    }

    public RollbarConfig getRollbarConfig() {
        return rollbarConfig;
    }

    public void setRollbarConfig(RollbarConfig rollbarConfig) {
        this.rollbarConfig = rollbarConfig;
    }

    public AwsConfig getAwsConfig() {
        return awsConfig;
    }

    public void setAwsConfig(AwsConfig awsConfig) {
        this.awsConfig = awsConfig;
    }
}
