# 팩토리 메서드 패턴



### 장점

#### 1. OCP(open - closed principle)  
 - 변경에 닫혀있다 : 기존 코드를 변경하지 않으면서  
 - 확장에 열려있다 : 새로운 기능을 확장할 수 있다.  
  -> product - creator(product - factory) 의 결합도를 낮게 가져가기 때문에 가능


#### 2. 코드를 간결하게 유지 가능


### 단점
#### 각자의 역할을 나누기 때문에 클래스가 많아짐



Client - class
Ship - class
whiteship - extends ship


ShipFactory - interface
```
 default Ship orderShip(String name, String email) {
        validate(name, email);
        prepareFor(name);
        Ship ship = createShip();
        sendEmailTo(email, ship);
        return ship;
    }
```

whiteshipFactory - extends DefaultShipFactory / implements ShipFactory
(DefaultShipFactory - abstract class - implements ShipFactory)


java8 :  default method, static method 구현 가능
(예전에는 추상 메서드만 정의할 수 있었으나 java8 부터는 interface도 기본 구현체를 만들 수 있게 됨)

추상클래스에서 하던 일을 인터페이스에 있는 default 메서드를 사용함.

* java9 : interface + private method 가능   



> 기본 지식

> ### extends  

 - 부모에서 선언/정의를 모두하며 자식은 메소드/변수를 그대로 사용할 수 있음  

> ### implements (interface 구현)  
 - 부모 객체는 선언만 하며 정의(내용)은 자식에서 오버라이딩 (재정의) 해서 사용해야함  

> ### abstract  
 - extends와 interface 혼합. extends하되 몇 개는 추상 메소드로 구현되어 있음



