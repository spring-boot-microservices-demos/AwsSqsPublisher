package com.aws.sqs.client;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

import lombok.Getter;

@Component
@Scope("singleton")
public final class AwsDemoSqsClient {

	@Value("${cloud.aws.region.static}")
	@Getter
	private String awsRegion;
	
	@Value("${cloud.aws.sqs.url}")
	@Getter
	private String awsSqsUrl;
	
	@Getter
	private AmazonSQS basicSqsClient;
	
	@PostConstruct
	private void init() {
		basicSqsClient =  AmazonSQSClientBuilder.standard().withRegion(awsRegion).build();
	}	
}
