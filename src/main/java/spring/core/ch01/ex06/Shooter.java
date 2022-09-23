package spring.core.ch01.ex06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component // IOC - @Component
public class Shooter {
	// DI - @Autowired
	@Autowired private Pistol pistol;
	@Autowired @Nullable private Rifle rifle;
	
	public void fire() {
		pistol.fire();
		if(rifle != null) rifle.fire();
	}
}