package com.kaikeventura.dynamodb.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AwsStsCredentialConfig {

    @Value("${aws.region}")
    private String awsRegion;

    private static final String SESSION_NAME = "TestMeetup1";

    @Bean
    @Primary
    public AWSCredentialsProvider credentialsProvider(
            @Value("${aws.accesskey}") String accessKey,
            @Value("${aws.secretkey}") String secretKey,
            @Value("${aws.role}") String role ) {

        var stsClient = AWSSecurityTokenServiceClientBuilder.standard()
                .withRegion(awsRegion)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .build();

        return new STSAssumeRoleSessionCredentialsProvider
                .Builder(role, SESSION_NAME)
                .withStsClient(stsClient)
                .build();
    }
}
