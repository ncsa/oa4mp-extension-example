package org.oa4mp.example;

import org.oa4mp.server.api.storage.servlet.AuthenticationUtil;
import org.oa4mp.server.proxy.RFC8628AuthenticationServer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class ExRFC8628AuthenticationServer extends RFC8628AuthenticationServer {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        AuthenticationUtil.setInstance(new ExAuthenticationUtil());
    }
}
