/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.authentication.heroku.jersey.authentication.heroku.jersey;

 
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.ws.rs.NameBinding;

/**
 *
 * @author Softmasters
 */
@NameBinding
@Retention(RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE}) 
public @interface Secured {}
