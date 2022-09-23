package spring.core.ch01.ex05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component	// Shooter IOC
public class Shooter {
	@Autowired @Nullable private Gun pistol;
	@Autowired @Nullable private Gun rifleGun;
	
	public void fire() {
		try {
			pistol.fire();
			rifleGun.fire();
		} catch(Exception e) {}
	}
}

/* IOC - @Component
 * DI  - @Autowired
 * 
 * Gun type이 Bean인게 여러개 있을 경우, 
 * 변수랑 ID랑 일치한걸 찾아서 넣음.
 * 
 * type이 Gun이면서 pistol, rifle ID를 갖는 녀석을 집어 넣는거임.
 * 
 * @Autowired란, 스프링 DI(Dependency Injection)에서 사용되는 어노테이션입니다.  
 * 
 * 1. 해당하는 Component를 찾아서 DI 시키고
 * 2. 그게 안되면 변수명과 ID가 일치하는 Component를 DI 시킴
 * 
 * @Nullable-> Component 못찾아도 괜찮아 실행은 해라
 * */

