package org.example.Dynamo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class AmazonDynamoDBConfiguration {

    @Value("${aws.dynamodb.endpoint}")
    private String dynamoDbEndpoint;
    @Value("${aws.region}")
    private Region awsRegion;
    @Value("${aws.dynamodb.accessKey}")
    private String dynamoDbAccessKey;
    @Value("${aws.dynamodb.secretKey}")
    private String dynamoDbSecretKey;
    @Value("${aws.dynamo.sessionToken}")
    private String dynamoDbSessionToken;

    DynamoDbClient dynamoDbClient = DynamoDbClient
            .builder()
            .region(awsRegion)
            .build();
    DynamoDbEnhancedClient dynamoDbEnhancedClient = DynamoDbEnhancedClient
            .builder()
            .dynamoDbClient(dynamoDbClient)
            .build();
}
