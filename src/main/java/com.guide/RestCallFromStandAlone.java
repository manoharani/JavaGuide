package com.guide;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RestCallFromStandAlone {

    public static String API_END_POINT = "http://localhost:9098/api/demo/home";
    private static final Logger LOG = LoggerFactory.getLogger(RestCallFromStandAlone.class.getName());


    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.add("Content-Type", "application/json");
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<JsonNode> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(API_END_POINT,
                    HttpMethod.GET,
                    entity,
                    String.class);
            LOG.info("Data "+response.getBody());

        } catch (Exception e) {
            LOG.error(e.getMessage());
        }

    }
}
