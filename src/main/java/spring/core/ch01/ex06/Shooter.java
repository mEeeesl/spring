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

//과제: rifle이 있으면 rifle을 사용하고, 없으면 사용치 않도록 하라.