package br.ufg.cercomp.cas.configuration;

import org.apereo.cas.authentication.AuthenticationEventExecutionPlan;
import org.apereo.cas.authentication.AuthenticationEventExecutionPlanConfigurer;
import org.apereo.cas.authentication.AuthenticationHandler;
import org.apereo.cas.configuration.CasConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.ufg.cercomp.cas.auth.MyAuthenticationHandler;

@Configuration("MyAuthenticationEventExecutionPlanConfiguration")
@EnableConfigurationProperties(CasConfigurationProperties.class)
public class MyAuthenticationEventExecutionPlanConfiguration implements AuthenticationEventExecutionPlanConfigurer {

	@Autowired
    private CasConfigurationProperties casProperties;

    @Bean
    public AuthenticationHandler myAuthenticationHandler() {
        final MyAuthenticationHandler handler = new MyAuthenticationHandler();
        /*
            Configure the handler by invoking various setter methods.
            Note that you also have full access to the collection of resolved CAS settings.
            Note that each authentication handler may optionally qualify for an 'order`
            as well as a unique name.
        */
        return handler;
    }
	
	@Override
	public void configureAuthenticationExecutionPlan(AuthenticationEventExecutionPlan plan) {
//		if (feelingGoodOnAMondayMorning()) {
            plan.registerAuthenticationHandler(myAuthenticationHandler());
//        }
	}

}
