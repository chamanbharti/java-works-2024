package annotation.stereotype;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryTest {
    public String hello(){
        return "Hello RepositoryTest";
    }
}
