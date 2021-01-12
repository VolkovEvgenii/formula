package ru.volkov.formula.circuit;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.apache.http.client.methods.HttpUriRequest;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class CircuitLiveTest {

    @Test
    public void givenRequestWithNoAcceptHeader_whenRequestIsExecuted_then200IsRecieved() throws IOException {

        HttpUriRequest request = new HttpGet("http://ergast.com/api/f1/circuits.json");
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void givenRequestWithNoAcceptHeader_whenRequestIsExecuted_thenDefaultResponseContentTypeIsJson() throws IOException {

        final String jsonMimeType = "application/json";
        HttpUriRequest request = new HttpGet("http://ergast.com/api/f1/circuits.json");
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        final String responseMimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals(jsonMimeType, responseMimeType);
    }
}
