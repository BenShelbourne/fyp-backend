package org.shelbourne.ben.scc300.service;

import lombok.RequiredArgsConstructor;
import org.shelbourne.ben.scc300.generated.lancaster.module.Assesments;
import org.shelbourne.ben.scc300.generated.lancaster.module.Module;


public interface LancasterUniService {

    Module getModule();

    Assesments getAssessments(String lusiYearId, String lusiCourseId, String lusiCohortId);

    String getCurrentYear();

}
