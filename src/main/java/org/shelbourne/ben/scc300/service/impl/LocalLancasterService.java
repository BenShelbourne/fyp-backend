package org.shelbourne.ben.scc300.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.shelbourne.ben.scc300.generated.lancaster.module.Assesments;
import org.shelbourne.ben.scc300.generated.lancaster.module.Module;
import org.shelbourne.ben.scc300.service.LancasterUniService;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
@RequiredArgsConstructor
public class LocalLancasterService implements LancasterUniService {

    private final ObjectMapper objectMapper;

    private Module module;
    private Assesments assesments;


    @Override
    @SneakyThrows
    public Module getModule() {
        if (module == null) {
            InputStream resource = new ClassPathResource("default-module-response.json").getInputStream();
            return objectMapper.readValue(resource, Module.class);
        }

        return module;
    }

    @Override
    @SneakyThrows
    public Assesments getAssessments(String lusiYearId, String lusiCourseId, String lusiCohortId) {
        if (assesments == null) {
            InputStream resource = new ClassPathResource("default-assesments-response.json").getInputStream();
            return objectMapper.readValue(resource, Assesments.class);
        }
        return assesments;
    }

    @Override
    public String getCurrentYear() {
        return "000119";
    }


}
