package org.shelbourne.ben.scc300.service.impl;


import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.shelbourne.ben.scc300.configuration.StudyTrackerConfiguration;
import org.shelbourne.ben.scc300.generated.lancaster.module.Assesments;
import org.shelbourne.ben.scc300.generated.lancaster.module.Module;
import org.shelbourne.ben.scc300.service.AuthenticationFacade;
import org.shelbourne.ben.scc300.service.LancasterUniService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Profile("!local")
@RequiredArgsConstructor
public class ProdLancasterService implements LancasterUniService {

    private final AuthenticationFacade authentication;
    private final RestTemplate restTemplate;
    private final StudyTrackerConfiguration studyTrackerConfiguration;
    private final HttpServletRequest request;
    @Override
    public Module getModule() {
        ResponseEntity<Module> response = restTemplate.exchange(
            studyTrackerConfiguration.getUrl(StudyTrackerConfiguration.MODULES),
            HttpMethod.GET,
            getHttpEntity(),
            Module.class);
        return response.getBody();
    }

    @Override
    public Assesments getAssessments(String lusiYearId, String lusiCourseId, String lusiCohortId) {
        // study.tracker.url.assesments=https://portal.lancaster.ac.uk/portal/api/modules/{lusiYearId}}/{lusiCourseId}}/{lusiCohortId}}/assessments
        return null;
    }



    @Override
    public String getCurrentYear() {
        final ResponseEntity<String> response = restTemplate.exchange(
            studyTrackerConfiguration.getUrl(StudyTrackerConfiguration.CURRENT_YEAR),
            HttpMethod.GET,
            getHttpEntity(),
            String.class);
        return response.getBody();
    }

    public HttpEntity<?> getHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        httpHeaders.add("Authorization", getToken());
        HttpEntity<?> requestHttpEntity = new HttpEntity(httpHeaders);
        return requestHttpEntity;
    }

    public String getToken() {
        String token =  request.getHeader("Authorization"); // "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJEU1AiLCJpYXQiOjE1ODQwMjkxMzQsImp0aSI6IjhhMmIzYWYwLTMxN2QtNDI1Zi1iZDk2LWI5NzQ2ZWEzZDM2YiIsInVzZXJuYW1lIjoic2hlbGJvdWIiLCJleHAiOjE1ODQwMzYzMzR9.S5Q6bvsj6D1LHG2xlTjBjsTTwBRC9cAiMEZ-LUUp6WQ";
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            token = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
//        }
        return token;
    }
}
