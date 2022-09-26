package spring.core.ch01.ex08;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // IOC
@Scope("prototype") // bean의 scope 지정 -> n개의 bean 생성 
public class Lapin {

}
