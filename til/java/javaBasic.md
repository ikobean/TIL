static
main메소드에서 사용하기
같은 클래스 안에 있는데 globalScope 변수를 사용 할 수 없다.
main은 static한 메소드이다. static한 메서드에서는 static 하지 않은 필드를 사용 할 수 없다.
같은 클래스 내에 있음에도 해당 변수들을 사용할 수 없다.
main 메소드는 static 이라는 키워드로 메소드가 정의되어 있다. 이런 메서드를 static 한 메소드 라고 한다.
static한 필드(필드 앞에 static 키워드를 붙힘)나, static한 메소드는 Class가 인스턴스화 되지 않아도 사용할 수 있다.
static한 변수는 공유된다.
static하게 선언된 변수는 값을 저장할 수 있는 공간이 하나만 생성된다. 그러므로, 인스턴스가 여러개 생성되도 static한 변수는 하나다.

Throws & Throw
divide 메소드 뒤에 throws IllegalArgumentException 은 해당 오류는 divide를 호출한 쪽에서 처리를 해야한다는 것을 의미한다.

public class ExceptionExam3 {   
        public static void main(String[] args) {
            int i = 10;
            int j = 0;
            try{
                int k = divide(i, j);
                System.out.println(k);
            }catch(IllegalArgumentException e){
                System.out.println("0으로 나누면 안됩니다.");
            }           
        }

        public static int divide(int i, int j) throws IllegalArgumentException{
            if(j == 0){
                throw new IllegalArgumentException("0으로 나눌 수 없어요.");
            }
            int k = i / j;
            return k;
        }   
    }
java8에서 interface에 default method 추가 가능
why? 인터페이스가 변경이 되면, 인터페이스를 구현하는 모든 클래스들이 해당 메소드를 구현해야 하는 문제가 있다. 이런 문제를 해결하기 위하여 인터페이스에 메소드를 구현해 놓을 수 있도록 하였다.

람다식
메소드만 전달할 수 있다면, 좀더 편리하게 프로그래밍할 수 있을텐데,자바는 메소드만 전달할 수 있는 방법은 없었기 기때문에 매번 객체를 생성해서 매개변수로 전달해야 했다. 이런 부분을 해결한 것이 람다표현식이다.

 public class LambdaExam1 {  
        public static void main(String[] args) {
            new Thread(()->{
                for(int i = 0; i < 10; i++){
                    System.out.println("hello");
                }
            }).start();
        }   
    }
()->{ ..... } 부분이 람다식, 다른말로 익명 메소드

JVM은 Thread생성자를 보고 ()->{} 이 무엇인지 대상을 추론한다.

Thread생성자 api를 보면 Runnable인터페이스를 받아들이는 것을 알 수 있다.

JVM은 Thread생성자가 Runnable인터페이스를 구현한 것이 와야 하는 것을 알게 되고 람다식을 Runnable을 구현하는 객체로 자동으로 만들어서 매개변수로 넣어준다.


