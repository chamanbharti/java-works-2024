package annotation;

import annotation.configurationproperties.AppPropertiesDemo;
import annotation.configurationproperties.YamlFileRead;
import annotation.controller.ComponentAndAutowired;
import annotation.controller.QualifierTester;
import annotation.lazy.LazyLoader;
import annotation.propertysource.PropertySourceDemo;
import annotation.qualifier.primary.bean_level.Employee;
import annotation.qualifier.primary.bean_level.HDFC;
import annotation.qualifier.primary.bean_level.SBI;
import annotation.qualifier.primary.component_level.FooService;
import annotation.scope.PrototypeBean;
import annotation.scope.SingletonBean;
import annotation.service.VegPizza;
import annotation.stereotype.*;
import annotation.value.ValueAnnotationDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
//@EnableConfigurationProperties(YamlFileRead.class)//to read yaml file
public class SpringAnnotationsApplication {

    public static void main(String[] args) {
        //var context = SpringApplication.run(SpringAnnotationsApplication.class, args);
		/*
		System.out.println("Component");
		//ComponentAndAutowired pizzaController = context.getBean(ComponentAndAutowired.class);
		//ComponentAndAutowired pizzaController = (ComponentAndAutowired) context.getBean("ComponentAndAutowired");
		// ComponentAndAutowired pizzaController = (PizzaController) context.getBean("demoPizza");
		//System.out.println(pizzaController.getPizza());
		*/
		/*
		System.out.println("Autowired");
		ComponentAndAutowired pizzaController = context.getBean(ComponentAndAutowired.class);
		System.out.println(pizzaController.getPizza());
		*/

		/*
		System.out.println("Autowired");
		ComponentAndAutowired pizzaController = context.getBean(ComponentAndAutowired.class);
		System.out.println(pizzaController.getPizza());
		*/

		/*
		System.out.println("Qualifier");
		QualifierTester qualifier = context.getBean(QualifierTester.class);
		System.out.println(qualifier.getPizza());

		System.out.println("Primary");
		FooService fooService = context.getBean(FooService.class);
		System.out.println(fooService.getService());

		Employee employee = context.getBean(Employee.class);
		System.out.println("employee name:"+employee);
		*/

		/*
		System.out.println("Bean");
		SBI sbi = context.getBean(SBI.class);
		System.out.println(sbi.getROI());
		HDFC hdfc = context.getBean(HDFC.class);
		System.out.println(hdfc.getROI());

		ComponentAndAutowired componentAndAutowired = context.getBean(ComponentAndAutowired.class);
		System.out.println(componentAndAutowired.getPizza());
		*/

		/*
		System.out.println("Stereotype");
		ComponentTest componentTest = context.getBean(ComponentTest.class);
		System.out.println(componentTest.hello());
		ControllerTest controllerTest = context.getBean(ControllerTest.class);
		System.out.println(controllerTest.hello());
		ServiceTest serviceTest = context.getBean(ServiceTest.class);
		System.out.println(serviceTest.hello());
		RepositoryTest repositoryTest = context.getBean(RepositoryTest.class);
		System.out.println(repositoryTest.hello());
		RestControllerTest restControllerTest = context.getBean(RestControllerTest.class);
		System.out.println(restControllerTest.hello());
		*/

		/*

		System.out.println("Lazy & Eager Loading");
		var lazyLoader = context.getBean(LazyLoader.class);
		System.out.println(lazyLoader);
		*/

		/*
		System.out.println("Scope Demo");
		System.out.println("Scope -> Singleton");
		SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
		System.out.println(singletonBean1.hashCode());
		SingletonBean singletonBean2 = context.getBean(SingletonBean.class);
		System.out.println(singletonBean2.hashCode());
		SingletonBean singletonBean3 = context.getBean(SingletonBean.class);
		System.out.println(singletonBean3.hashCode());

		System.out.println("Scope -> Prototype");
		PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.hashCode());
		PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.hashCode());
		PrototypeBean prototypeBean3 = context.getBean(PrototypeBean.class);
		System.out.println(prototypeBean3.hashCode());
		*/

       /* System.out.println("@Value annotation");
        ValueAnnotationDemo value = context.getBean(ValueAnnotationDemo.class);
        System.out.println(value.getDefaultValue());
        System.out.println(value.getHost());
        System.out.println(value.getEmail());
        System.out.println(value.getPassword());
        System.out.println(value.getJavaHome());
        System.out.println(value.getHomeDir());*/

       /* System.out.println("PropertySource");
        PropertySourceDemo value = context.getBean(PropertySourceDemo.class);
        System.out.println(value.getHost());
        System.out.println(value.getEmail());
        System.out.println(value.getPassword());
        System.out.println(value.getAppName());
        System.out.println(value.getAppDescription());*/

//        System.out.println("@ConfigurationProperties");
//        AppPropertiesDemo value = context.getBean(AppPropertiesDemo.class);
//        value.display();
//        System.out.println();



    }

}
