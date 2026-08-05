package com.chinaglia.salaaluguelapi.service;

import com.chinaglia.salaaluguelapi.repository.RecursoRepository;
import com.chinaglia.salaaluguelapi.repository.SalaRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SalaService}.
 */
@Generated
public class SalaService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'salaService'.
   */
  private static BeanInstanceSupplier<SalaService> getSalaServiceInstanceSupplier() {
    return BeanInstanceSupplier.<SalaService>forConstructor(SalaRepository.class, RecursoRepository.class)
            .withGenerator((registeredBean, args) -> new SalaService(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'salaService'.
   */
  public static BeanDefinition getSalaServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SalaService.class);
    beanDefinition.setInstanceSupplier(getSalaServiceInstanceSupplier());
    return beanDefinition;
  }
}
