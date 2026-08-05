package org.springframework.boot.security.oauth2.server.resource.autoconfigure;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JwtDecoderConfiguration}.
 */
@Generated
public class JwtDecoderConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.security.oauth2.server.resource.autoconfigure.JwtDecoderConfiguration'.
   */
  private static BeanInstanceSupplier<JwtDecoderConfiguration> getJwtDecoderConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<JwtDecoderConfiguration>forConstructor(OAuth2ResourceServerProperties.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> new JwtDecoderConfiguration(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'jwtDecoderConfiguration'.
   */
  public static BeanDefinition getJwtDecoderConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JwtDecoderConfiguration.class);
    beanDefinition.setInstanceSupplier(getJwtDecoderConfigurationInstanceSupplier());
    return beanDefinition;
  }
}
