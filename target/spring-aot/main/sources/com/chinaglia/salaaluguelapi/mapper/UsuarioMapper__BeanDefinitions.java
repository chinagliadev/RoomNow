package com.chinaglia.salaaluguelapi.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UsuarioMapper}.
 */
@Generated
public class UsuarioMapper__BeanDefinitions {
  /**
   * Get the bean definition for 'usuarioMapper'.
   */
  public static BeanDefinition getUsuarioMapperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UsuarioMapper.class);
    beanDefinition.setInstanceSupplier(UsuarioMapper::new);
    return beanDefinition;
  }
}
