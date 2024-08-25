package annotation.stereotype;

import org.springframework.stereotype.Service;

@Service
public class ServiceTest {
    public String hello(){
        return "Hello ServiceTest";
    }
}
