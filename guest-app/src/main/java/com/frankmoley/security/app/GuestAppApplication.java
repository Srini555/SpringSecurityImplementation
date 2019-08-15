package com.frankmoley.security.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.ArrayList;

import static com.sun.tools.internal.xjc.reader.Ring.add;

@SpringBootApplication
@EnableOAuth2Client
public class GuestAppApplication {

	private static final String AUTH_TOKEN_URL="/oauth/token";
	@Value("${landon.guest.service.url}")
	private String serviceUrl;

	public static void main(String[] args) {
		SpringApplication.run(GuestAppApplication.class, args);
	}

	@Bean
	public OAuth2RestTemplate restTemplate(){
		ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
		resourceDetails.setAccessTokenUri(serviceUrl + AUTH_TOKEN_URL);
		resourceDetails.setClientId("guest-app");
		resourceDetails.setClientSecret("secret");
		resourceDetails.setGrantType("client_credentials");
		resourceDetails.setScope(new ArrayList<String>(){{add("READ_ALL_GUESTS");add("WRITE_GUESTS");add("UPDATE_GUESTS");}});
		resourceDetails.setAuthenticationScheme(AuthenticationScheme.form);
		AccessTokenRequest request = new DefaultAccessTokenRequest();
		return new OAuth2RestTemplate(resourceDetails,new DefaultOAuth2ClientContext(request));

	}
}
