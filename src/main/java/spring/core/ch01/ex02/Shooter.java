package spring.core.ch01.ex02;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.core.ch01.ex01.Gun;

@Setter				//setter 자동생성
@NoArgsConstructor	//파라미터가 없는 기본 생성자 자동생성
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 자동생성
public class Shooter {
	private String name;
	private Gun gun;
	
	public void fire() {
		System.out.print(name + ": ");
		gun.fire();
	}
}

/* @Data 끝판왕 !!

	@Getter @Setter @RequiredArgsConstructor @ToString,
	@EqualsAndHashCode 를 한꺼번에 만들어주는 어노테이션
	
	클래스 레벨에서 @Data 어노테이션을 붙여주면,
	모든 필드를 대상으로 접근자와 설정자가 자동생성되고,
	final or @NonNull 필드값을 파라미터로 받는 생성자가 만들어지며,
	toString, equals, hashCode 메소드가 자동으로 생성된다.
	 

*/