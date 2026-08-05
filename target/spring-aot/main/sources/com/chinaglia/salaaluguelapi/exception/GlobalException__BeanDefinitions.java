package com.chinaglia.salaaluguelapi.exception;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GlobalException}.
 */
@Generated
public class GlobalException__BeanDefinitions {
  /**
   * Get the bean definition for 'globalException'.
   */
  public static BeanDefinition getGlobalExceptionBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GlobalException.class);
    beanDefinition.setInstanceSupplier(GlobalException::new);
    return beanDefinition;
  }
}
