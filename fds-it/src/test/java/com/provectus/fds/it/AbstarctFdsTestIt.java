package com.provectus.fds.it;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.provectus.fds.it.aws.CloudFormation;
import org.asynchttpclient.AsyncHttpClient;

import static org.asynchttpclient.Dsl.asyncHttpClient;
import static org.asynchttpclient.Dsl.config;

abstract class AbstarctFdsTestIt {

    static final String URL_FOR_API = "UrlForAPI";
    static final String URL_FOR_REPORTS = "UrlForReports";

    static CloudFormation cloudFormation;
    static String reportUrl;
    static String apiUrl;

    final AsyncHttpClient httpClient = asyncHttpClient(config());
    final ObjectMapper objectMapper = new ObjectMapper();

    SampleDataResult generateSampleData(int minBids, int maxBids) throws JsonProcessingException {
        return new SampleGenerator(minBids, maxBids, apiUrl, httpClient, objectMapper).generateSampleData();
    }
}
