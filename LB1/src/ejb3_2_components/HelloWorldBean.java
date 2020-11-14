package ejb3_2_components;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldBean implements IHelloWorld
{
	@Override
	public String sayHello(String name) {
     return String.format("Hello %s, welcome to EJB 3.2!", name);
 }
}
