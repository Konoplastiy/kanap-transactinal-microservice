package com.konoplastiy.kanap;

import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
@SpringBootTest
public class ConfigurationIT {

    @Container
    public static LocalStackContainer localStack = new LocalStackContainer(
            DockerImageName.parse("localstack/localstack:2.2.0"))
            .withServices(LocalStackContainer.Service.DYNAMODB)
            .withEnv("AWS_ACCESS_KEY_ID", "fake-secret-key")
            .withEnv("AWS_SECRET_ACCESS_KEY", "fake-secret-key")
            .withEnv("AWS_DEFAULT_REGION", "us-west-2");

}