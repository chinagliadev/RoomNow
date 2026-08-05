package com.chinaglia.salaaluguelapi;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SalaAluguelApiApplication}.
 */
@Generated
public class SalaAluguelApiApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'salaAluguelApiApplication'.
   */
  public static BeanDefinition getSalaAluguelApiApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SalaAluguelApiApplication.class);
    beanDefinition.setInstanceSupplier(SalaAluguelApiApplication::new);
    return beanDefinition;
  }
}
