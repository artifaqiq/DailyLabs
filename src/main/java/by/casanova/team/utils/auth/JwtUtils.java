package by.casanova.team.utils.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.UnsupportedEncodingException;

/**
 * Created by artifaqiq on 3/5/17.
 */
public class JwtGenerator {
    private static final String JWT_SECRET = "12345678";

    public static JWT createJwt(long id, String username, long jwtId) {

        String token;
        try {
            token = JWT.create()
                    .withClaim("user)id", String.valueOf(id))
                    .withSubject(username)
                    .withJWTId(String.valueOf(jwtId))
                    .sign(Algorithm.HMAC256(JWT_SECRET));
        } catch (UnsupportedEncodingException) {}

        
    }
}
