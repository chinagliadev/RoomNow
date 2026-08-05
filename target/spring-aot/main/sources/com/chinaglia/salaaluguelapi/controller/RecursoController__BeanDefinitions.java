package com.chinaglia.salaaluguelapi.controller;

import com.chinaglia.salaaluguelapi.service.RecursoService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RecursoController}.
 */
@Generated
public class RecursoController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'recursoController'.
   */
  private static BeanInstanceSupplier<RecursoController> getRecursoControllerInstanceSupplier() {
    return BeanInstanceSupplier.<RecursoController>forConstructor(RecursoService.class)
            .withGenerator((registeredBean, args) -> new RecursoController(args.get(0)));
  }

  /**
   * Get the bean definition for 'recursoController'.
   */
  public static BeanDefinition getRecursoControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RecursoController.class);
    beanDefinition.setInstanceSupplier(getRecursoControllerInstanceSupplier());
    return beanDefinition;
  }
}
