package lesson31.ejb;

import javax.ejb.Remote;

@Remote
public interface Greeting {
	public String sayHello();
}
