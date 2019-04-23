package br.ufg.cercomp.cas.auth;

import java.security.GeneralSecurityException;

import javax.security.auth.login.FailedLoginException;

import org.apereo.cas.authentication.AuthenticationHandlerExecutionResult;
import org.apereo.cas.authentication.PreventedException;
import org.apereo.cas.authentication.credential.UsernamePasswordCredential;
import org.apereo.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.apereo.cas.authentication.principal.DefaultPrincipalFactory;
import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.services.ServicesManager;

public class MyAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {

	public MyAuthenticationHandler() {
		this(null, null, new DefaultPrincipalFactory(), Integer.MAX_VALUE);
	}
	
	public MyAuthenticationHandler(String name, ServicesManager servicesManager, PrincipalFactory principalFactory,
			Integer order) {
		super(name, servicesManager, principalFactory, order);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AuthenticationHandlerExecutionResult authenticateUsernamePasswordInternal(
			UsernamePasswordCredential credential, String originalPassword)
			throws GeneralSecurityException, PreventedException {
		System.out.println("Teste");
		System.err.println("Teste erro");
		if (true) {
            return createHandlerResult(credential, this.principalFactory.createPrincipal(credential.getUsername()), null);
        }
        throw new FailedLoginException("Sorry, you are a failure!");
	}

}
