package es.neesis.annotations;

import es.neesis.annotations.applications.AhorcadoApplication;
import es.neesis.annotations.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);

    AhorcadoApplication application = context.getBean(AhorcadoApplication.class);
    application.execute();
  }
}
