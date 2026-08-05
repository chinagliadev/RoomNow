package com.chinaglia.salaaluguelapi.controller;

import com.chinaglia.salaaluguelapi.service.SalaService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SalaController}.
 */
@Generated
public class SalaController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'salaController'.
   */
  private static BeanInstanceSupplier<SalaController> getSalaControllerInstanceSupplier() {
    return BeanInstanceSupplier.<SalaController>forConstructor(SalaService.class)
            .withGenerator((registeredBean, args) -> new SalaController(args.get(0)));
  }

  /**
   * Get the bean definition for 'salaController'.
   */
  public static BeanDefinition getSalaControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SalaController.class);
    beanDefinition.setInstanceSupplier(getSalaControllerInstanceSupplier());
    return beanDefinition;
  }
}
