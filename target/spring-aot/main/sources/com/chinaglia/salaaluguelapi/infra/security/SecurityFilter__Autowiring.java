package com.chinaglia.salaaluguelapi.infra.security;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SecurityFilter}.
 */
@Generated
public class SecurityFilter__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SecurityFilter apply(RegisteredBean registeredBean, SecurityFilter instance) {
    AutowiredFieldValueResolver.forRequiredField("tokenService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("usuarioRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
