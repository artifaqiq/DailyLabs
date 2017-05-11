package by.casanova.team.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by artifaqiq on 2/21/17.
 */

@Configuration
@ComponentScan("by.casanova.team")
@EnableAspectJAutoProxy
public class ApplicationConfig {
}
