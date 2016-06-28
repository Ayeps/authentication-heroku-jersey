/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.authentication.heroku.jersey.authentication.heroku.jersey;

import java.io.IOException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 *
 * @author Softmasters
 */
public class AuthenticationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Check if the HTTP Authorization header is present and formatted correctly 
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer")) {
            throw new NotAuthorizedException("Authorization header must be provided");
        }

        // Extract the token from the HTTP Authorization header
        String token = authorizationHeader.substring("Bearer".length()).trim();

        try {
            // Validate the token
            validateToken(token);

        } catch (Exception e) {
            requestContext.abortWith(
                    Response.status(Response.Status.UNAUTHORIZED).build());
        }

    }

    private void validateToken(String token) throws Exception {
        // Check if it was issued by the server and if it's not expired
        // Throw an Exception if the token is invalid
    }

//    requestContext.setSecurityContext(new SecurityContext() {
//
//        @Override
//        public Principal getUserPrincipal() {
//
//            return new Principal() {
//
//                @Override
//                public String getName() {
//                    return username;
//                }
//            };
//        }
//
//        @Override
//        public boolean isUserInRole(String role) {
//            return true;
//        }
//
//        @Override
//        public boolean isSecure() {
//            return false;
//        }
//
//        @Override
//        public String getAuthenticationScheme() {
//            return null;
//        }
//    });
}
