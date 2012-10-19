package com.goldengekko.wbt.web;

import com.wadpam.open.json.JMonitor;
import com.wadpam.survey.json.JResponse;
import com.wadpam.survey.json.JSurvey;
import java.net.URI;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author os
 */
public class ResponseITest {

    static final String                  BASE_URL       = "http://localhost:8943/api/apidocs/survey/v10/4242/";

    RestTemplate                         template;
    public ResponseITest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        template = new RestTemplate();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreate() {
        
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
//        requestEntity.set("namespace", "MyNamespace");
        
        URI uri = template.postForLocation(BASE_URL + "response/v10", 
                requestEntity);
        assertNotNull("createResponse", uri);
        System.out.println("created response, URI is " + uri);
        
        JResponse actual = template.getForObject(uri, JResponse.class);
        assertNotNull("createdResponse", actual);
        assertEquals("surveyId", Long.valueOf(4242), actual.getSurveyId());
    }

}
