package com.chinaglia.salaaluguelapi.service;

import com.chinaglia.salaaluguelapi.repository.RecursoRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RecursoService}.
 */
@Generated
public class RecursoService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'recursoService'.
   */
  private static BeanInstanceSupplier<RecursoService> getRecursoServiceInstanceSupplier() {
    return BeanInstanceSupplier.<RecursoService>forConstructor(RecursoRepository.class)
            .withGenerator((registeredBean, args) -> new RecursoService(args.get(0)));
  }

  /**
   * Get the bean definition for 'recursoService'.
   */
  public static BeanDefinition getRecursoServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RecursoService.class);
    beanDefinition.setInstanceSupplier(getRecursoServiceInstanceSupplier());
    return beanDefinition;
  }
}
