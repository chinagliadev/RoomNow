package com.chinaglia.salaaluguelapi.service;

import com.chinaglia.salaaluguelapi.repository.UsuarioRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AuthorizationService}.
 */
@Generated
public class AuthorizationService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'authorizationService'.
   */
  private static BeanInstanceSupplier<AuthorizationService> getAuthorizationServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AuthorizationService>forConstructor(UsuarioRepository.class)
            .withGenerator((registeredBean, args) -> new AuthorizationService(args.get(0)));
  }

  /**
   * Get the bean definition for 'authorizationService'.
   */
  public static BeanDefinition getAuthorizationServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthorizationService.class);
    beanDefinition.setInstanceSupplier(getAuthorizationServiceInstanceSupplier());
    return beanDefinition;
  }
}
