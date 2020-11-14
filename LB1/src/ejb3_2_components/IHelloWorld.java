package ejb3_2_components;

import javax.ejb.Local;

@Local
public interface IHelloWorld
{
    public String sayHello(String name);
}
