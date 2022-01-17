package guru.springmk.springbootactuator.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ShutdownController {
    @ResponseBody
    @RequestMapping(path = "/shutdown")
    public String callActuatorShutdown() {
        // Actuator Shutdown Endpoint:
        String url = "http://localhost:8090/actuator/shutdown";

        // Http Headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        // Data attached to the request.
        HttpEntity<String> requestBody = new HttpEntity<>("", headers);
        // Send request with POST method.
        String e = restTemplate.postForObject(url, requestBody, String.class);
        return "Result: " + e;
    }
}
