package org.shelbourne.ben.scc300.configuration;

import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("study.tracker")
@Data
public class StudyTrackerConfiguration {

    public static final String MODULES="modules"; // https://portal.lancaster.ac.uk/portal/api/modules
    public static final String CURRENT_YEAR = "current-year"; //https://portal.lancaster.ac.uk/portal/api/session/currentyear
    public static final String ASSESMENTS = "assesments"; // https://portal.lancaster.ac.uk/portal/api/modules/{lusiYearId}}/{lusiCourseId}}/{lusiCohortId}}/assessments
    public static final String ICAL ="ical"; //https://timetabling.lancaster.ac.uk/iCalendar/Personal.aspx


    private String signingKey;
    private String issuer;
    private Map<String, String> url;

    public String getUrl(String key) {
        return url.get(key);
    }
}
