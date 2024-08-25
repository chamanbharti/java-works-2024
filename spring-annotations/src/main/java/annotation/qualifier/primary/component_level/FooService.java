package annotation.qualifier.primary.component_level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("fooService")
public class  FooService {

   @Autowired
   private Formatter formatter;
   public String getService(){
      return formatter.format();
   }


}
