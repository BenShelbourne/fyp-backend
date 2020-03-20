package org.shelbourne.ben.scc300.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.shelbourne.ben.scc300.configuration.StudyTrackerConfiguration;
import org.shelbourne.ben.scc300.generated.model.Student;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TokenVerificationServiceImpl {
    private final StudyTrackerConfiguration studyTrackerConfiguration;
    @Setter
    private Algorithm algorithm;
    private JWTVerifier verifier;

    public Student verifyToken(String token, String role) {
        DecodedJWT jwt = getVerifier().verify(token);
        return new Student().id(jwt.getHeaderClaim("username").asString());
    }

    protected Algorithm getAlgorithm() {
        if (algorithm == null) {
            algorithm = Algorithm.HMAC256(studyTrackerConfiguration.getSigningKey());
        }
        return algorithm;
    }

    protected JWTVerifier getVerifier() {
        if (verifier == null) {
            verifier = JWT.require(getAlgorithm())
                    .withIssuer(studyTrackerConfiguration.getIssuer())
                    // .withArrayClaim("role", role) <-- Add claims for roles in at a later date...
                    .build(); //Reusable verifier instance
        }
        return verifier;
    }
}

