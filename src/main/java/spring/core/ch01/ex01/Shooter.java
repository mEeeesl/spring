package spring.core.ch01.ex01;

public class Shooter {
	private Gun gun;
	
	public Shooter(Gun gun) { // DI - 1 생성자
		this.gun = gun;
	}
	
	public void setGun(Gun gun) { // DI - 2 Setter
		this.gun = gun;
	}
	
	public void fire() {
		gun.fire();
	}
}
