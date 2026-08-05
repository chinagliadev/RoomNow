package com.chinaglia.salaaluguelapi.controller;

import com.chinaglia.salaaluguelapi.infra.security.TokenService;
import com.chinaglia.salaaluguelapi.service.UsuarioService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.authentication.AuthenticationManager;

/**
 * Bean definitions for {@link AutheticationController}.
 */
@Generated
public class AutheticationController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'autheticationController'.
   */
  private static BeanInstanceSupplier<AutheticationController> getAutheticationControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AutheticationController>forConstructor(AuthenticationManager.class, TokenService.class, UsuarioService.class)
            .withGenerator((registeredBean, args) -> new AutheticationController(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'autheticationController'.
   */
  public static BeanDefinition getAutheticationControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AutheticationController.class);
    beanDefinition.setInstanceSupplier(getAutheticationControllerInstanceSupplier());
    return beanDefinition;
  }
}
