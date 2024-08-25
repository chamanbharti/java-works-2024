package annotation.qualifier.primary.bean_level;

public class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
        System.out.println("Name:"+name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
