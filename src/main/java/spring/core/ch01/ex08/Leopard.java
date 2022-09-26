package spring.core.ch01.ex08;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // IOC
@Scope("singleton") // bean의 scope 지정. ( 기본값 - singleton )
public class Leopard {

}
