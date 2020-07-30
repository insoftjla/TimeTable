// This is an independent project of an individual developer. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++ and C#: http://www.viva64.com

package ru.sd.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.sd")
public class WebConfig implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public WebConfig(){
        super();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    /* **************************************************************** */
    /*  THYMELEAF-SPECIFIC ARTIFACTS                                    */
    /*  TemplateResolver <- TemplateEngine <- ViewResolver              */
    /* **************************************************************** */

    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        // SpringResourceTemplateResolver автоматически интегрируется с собственной инфраструктурой
        // разрешения ресурсов Spring, что настоятельно рекомендуется.
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("WEB-INF/pages/");
        templateResolver.setSuffix(".html");
        // HTML - это значение по умолчанию, добавленное здесь для ясности.
        templateResolver.setTemplateMode(TemplateMode.HTML);
        // Шаблонный кеш имеет значение true по умолчанию. Установите в false, если хотите
        // шаблоны будут автоматически обновляться при изменении
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(){
        // SpringTemplateEngine автоматически применяет SpringStandardDialect и
        // включает собственные механизмы разрешения сообщений MessageSource в Spring.
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        // Включение компилятора SpringEL в Spring 4.2.4 или новее может
        // ускорить выполнение в большинстве сценариев, но может быть несовместимо
        // с конкретными случаями, когда выражения в одном шаблоне используются повторно
        // для разных типов данных, поэтому этот флаг по умолчанию имеет значение «false»
        // для более безопасной обратной совместимости.
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("Windows-1251");
        // ПРИМЕЧАНИЕ. 'Order' и 'viewNames' являются необязательными.
        //viewResolver.setOrder(1);
        //viewResolver.setViewNames(new String[]{".html", ".xhtml"});
        return viewResolver;
    }

    @Bean
    public MessageSource messageSource() {

        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("/messages");
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setCacheSeconds(0);
        messageSource.setDefaultEncoding("Windows-1251");

        return messageSource;
    }

}
