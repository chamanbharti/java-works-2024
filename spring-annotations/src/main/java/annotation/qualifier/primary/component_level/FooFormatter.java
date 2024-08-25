package annotation.qualifier.primary.component_level;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
/**
 If we try to load FooService into our context,
 the Spring framework will throw a NoUniqueBeanDefinitionException.
 This is because Spring doesn’t know which bean to inject.
 To avoid this problem, there are several solutions;
 the @Qualifier annotation is one of them.
 */
@Component
public class FooFormatter implements Formatter {

    @Override
    public String format() {
        return "foo";
    }
}
