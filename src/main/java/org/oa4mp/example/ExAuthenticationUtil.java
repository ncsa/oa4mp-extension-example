package org.oa4mp.example;

import org.oa4mp.server.api.ServiceEnvironment;
import org.oa4mp.server.api.storage.servlet.AbstractAuthenticationServlet.UserLoginException;
import org.oa4mp.server.api.storage.servlet.AuthenticationUtil;

import java.security.GeneralSecurityException;

/**
 * Example of overriding the {@link AuthenticationUtil} for OA4MP. It supports exactly one
 * user, <b>me</b> with password <b>1234567890</b>. It is intended to illustrate how
 * to set up such a system and is not intended to be production ready.
 */
public class ExAuthenticationUtil extends AuthenticationUtil {
    @Override
    public void checkUser(ServiceEnvironment serviceEnvironment, String username, String password) throws GeneralSecurityException {
        if(username.equals("me") && password.equals("1234567890")) {return;}
        throw new UserLoginException("unknown user", username, password);
    }
}
