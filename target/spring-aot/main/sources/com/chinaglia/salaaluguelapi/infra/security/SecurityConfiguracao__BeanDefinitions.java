package com.chinaglia.salaaluguelapi.infra.security;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Bean definitions for {@link SecurityConfiguracao}.
 */
@Generated
public class SecurityConfiguracao__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'securityConfiguracao'.
   */
  private static BeanInstanceSupplier<SecurityConfiguracao> getSecurityConfiguracaoInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SecurityConfiguracao>forConstructor(SecurityFilter.class)
            .withGenerator((registeredBean, args) -> new SecurityConfiguracao$$SpringCGLIB$$0(args.get(0)));
  }

  /**
   * Get the bean definition for 'securityConfiguracao'.
   */
  public static BeanDefinition getSecurityConfiguracaoBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SecurityConfiguracao.class);
    beanDefinition.setTargetType(SecurityConfiguracao.class);
    ConfigurationClassUtils.initializeConfigurationClass(SecurityConfiguracao.class);
    beanDefinition.setInstanceSupplier(getSecurityConfiguracaoInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'securityFilterChain'.
   */
  private static BeanInstanceSupplier<SecurityFilterChain> getSecurityFilterChainInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SecurityFilterChain>forFactoryMethod(SecurityConfiguracao$$SpringCGLIB$$0.class, "securityFilterChain", HttpSecurity.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("securityConfiguracao", SecurityConfiguracao.class).securityFilterChain(args.get(0)));
  }

  /**
   * Get the bean definition for 'securityFilterChain'.
   */
  public static BeanDefinition getSecurityFilterChainBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SecurityFilterChain.class);
    beanDefinition.setFactoryBeanName("securityConfiguracao");
    beanDefinition.setInstanceSupplier(getSecurityFilterChainInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'authManager'.
   */
  private static BeanInstanceSupplier<AuthenticationManager> getAuthManagerInstanceSupplier() {
    return BeanInstanceSupplier.<AuthenticationManager>forFactoryMethod(SecurityConfiguracao$$SpringCGLIB$$0.class, "authManager", AuthenticationConfiguration.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("securityConfiguracao", SecurityConfiguracao.class).authManager(args.get(0)));
  }

  /**
   * Get the bean definition for 'authManager'.
   */
  public static BeanDefinition getAuthManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthenticationManager.class);
    beanDefinition.setFactoryBeanName("securityConfiguracao");
    beanDefinition.setInstanceSupplier(getAuthManagerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'passwordEncoder'.
   */
  private static BeanInstanceSupplier<PasswordEncoder> getPasswordEncoderInstanceSupplier() {
    return BeanInstanceSupplier.<PasswordEncoder>forFactoryMethod(SecurityConfiguracao$$SpringCGLIB$$0.class, "passwordEncoder")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("securityConfiguracao", SecurityConfiguracao.class).passwordEncoder());
  }

  /**
   * Get the bean definition for 'passwordEncoder'.
   */
  public static BeanDefinition getPasswordEncoderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PasswordEncoder.class);
    beanDefinition.setFactoryBeanName("securityConfiguracao");
    beanDefinition.setInstanceSupplier(getPasswordEncoderInstanceSupplier());
    return beanDefinition;
  }
}
