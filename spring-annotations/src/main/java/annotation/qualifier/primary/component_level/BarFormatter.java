package annotation.qualifier.primary.component_level;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BarFormatter implements Formatter {

    @Override
    public String format() {
        return "bar";
    }
}
