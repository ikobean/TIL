# 자바스크립트 튜토리얼 
[형변환](#형변환)   
[반복문](#반복문)    
[let, const, var](#let-const-var)  
[함수 선언식](#함수-선언식)  
[함수 표현식](#함수-표현식)  
[화살표 함수](#화살표-함수)  
[nullish](#nullish)  
[테스트 자동화](#테스트-자동화)  
[객체](#객체)  
[this](#this)  
[심볼형](#심볼형)  
[참조에 의한 객체 복사](#참조에-의한-객체-복사)  
[new 연산자와 생성자 함수](#new-연산자와-생성자-함수)  
[폴리필](#폴리필)  
[옵셔널 체이닝](#옵셔널-체이닝)  
### 형변환
문자형 변환

String(value)

숫자형 변환
Number(str)

|전달받은 값|	형 변환 후|
|----------|-----------|
|undefined|	NaN|
|null |	0|
|true and false |	1 과 0|  


string	문자열의 처음과 끝 공백이 제거됩니다. 공백 제거 후 남아있는 문자열이 없다면 0, 그렇지 않다면 문자열에서 숫자를 읽습니다. 변환에 실패하면 NaN이 됩니다.


string	문자열의 처음과 끝 공백이 제거됩니다. 공백 제거 후 남아있는 문자열이 없다면 0, 그렇지 않다면 문자열에서 숫자를 읽습니다. 변환에 실패하면 NaN이 됩니다.

|전달받은 값	|형 변환 후|
|--------|--------|
|undefined	|NaN|
|null|	0|
|true / false|	1 / 0|

string	전달받은 문자열을 “그대로” 읽되, 처음과 끝의 공백을 무시합니다. 문자열이 비어있다면 0이 되고, 오류 발생 시 NaN이 됩니다.

### 반복문
do...while
for

break;
contine;
break label;
```javascript
switch(x) {
  case 'value1':  // if (x === 'value1')
    ...
    [break]

  case 'value2':  // if (x === 'value2')
    ...
    [break]

  default:
    ...
    [break]
}
```
* break가 없으면 다음 case문 실행


"use strict"
>  활성화 했을 때 ES5 이상의 변경사항이 활성화 된다.

브라우저 콘솔에서는 작동하지 않음.
'use strict' + 줄바꿈 + 코드 로 테스트 가능
코드 클래스와 모듈을 사용하면 자동 저굥 됨.

### let, const, var
let: 변수
const: 상수
```js
let result = condition ? value1 : value2;
```


undefined는 '값이 할당되지 않은 상태’를 나타낼 때 사용합니다.

### 함수 선언식
```js
function sum(a, b) {
  return a + b;
};

```
### 함수 표현식
```js
let sum = function(a, b) {
  return a + b;
};
```
### 화살표 함수
```js
let sum = (a, b) => a + b;

/* 위 화살표 함수는 아래 함수의 축약 버전입니다.

let sum = function(a, b) {
  return a + b;
};
*/

alert( sum(1, 2) ); // 3
```

### nullish 
??
nullish 병합 연산자 ??는 피연산자 중 실제 값이 정의된 피연산자를 찾는 데 쓰입니다. a가 null이나 undefined가 아니면 a ?? b의 평가 결과는 a이고, a가 null이나 undefined이면 a ?? b의 평가 결과는 b가 됩니다.


### 테스트 자동화

### 객체
```js
let user = new Object(); // '객체 생성자' 문법
let user = {};  // '객체 리터럴' 문법

let member = {
    name: "iko"
    age: 33
}

// 프로퍼티 추가
member.isAdmin = true;

// 프로퍼티 삭제
delete member.isAdmin;

// 여러 단어를 조합해 프로퍼티 이름을 만든 경우엔 프로퍼티 이름을 따옴표로 묶어줘야 합니다.
let member = {
    name: "iko",
    age: 33,
    "favorite animal": cat,
}

/* 대괄호 표기법
대괄호 표기법을 사용하면 아래 예시에서 변수를 키로 사용한 것과 같이 문자열뿐만 아니라 모든 표현식의 평가 결과를 프로퍼티 키로 사용할 수 있습니다.*/

// set
member["favorite animal"]

// del
delete member["favorite animal"]


//const는 member의 값을 고정하지만, 그 내용은 고정하지 않습니다.
const member = {
    name: "iko"
};

member.name ="hhy";
alert(member.name); //hhy

// 프로퍼티 존재여부 확인
"key" in object
alert("age" in member); //true
```

### this
this 값은 런타임에 결정됨
 함수(메서드)를 하나만 만들어 여러 객체에서 재사용할 수 있다는 것은 장점이지만, 이런 유연함이 실수로 이어질 수 있다는 것은 단점입니다.

화살표 함수는 자신만의 this를 가지지 않는다는 점에서 독특합니다. 화살표 함수 안에서 this를 사용하면, 외부에서 this 값을 가져옵니다.

### 심볼형
객체프로퍼티 키로 문자형, 심볼형을 가질 수 있음.
unique identifier

```js
let id = Symbol();

// ("id") => 심볼 이름 (디버깅시 유용)
let id = Symbol("id");
alert(id.toString()); // Symbol(id)가 얼럿 창에 출력됨
alert(id.description); // id

```
문자형으로 자동 형변환 되지 않음

```js
// 객체 리터럴{...}을 사용해서 객체를 만든 경우 대괄호로 심볼형 키 만듦
let id = Symbol("id");

let user = {
  name: "John",
  [id]: 123 // "id": 123은 안됨
};
```

for...in에서 배제됨
Object.keys(user)에서도 키가 심볼인 프로퍼티는 배제


리터럴은 일반적으로 개발 언어에서 문자열 자체, 즉 고정된 값을 가리키는 용어이다.


```js
// 전역 레지스트리에서 심볼을 읽습니다.
let id = Symbol.for("id"); // 심볼이 존재하지 않으면 새로운 심볼을 만듭니다.

// 동일한 이름을 이용해 심볼을 다시 읽습니다(좀 더 멀리 떨어진 코드에서도 가능합니다).
let idAgain = Symbol.for("id");

// 두 심볼은 같습니다.
alert( id === idAgain ); // true
```
#### 숨김프로퍼티
???
 외부 코드에서 접근이 불가능
 값도 덮어쓸 수 없는 프로퍼티
서드파티 코드에서 가지고 온 user라는 객체가 여러 개 있고, user를 이용해 어떤 작업을 해야 하는 상황이라고 가정해 봅시다. user에 식별자를 붙여주도록 합시다.

식별자는 심볼을 이용해 만들도록 하겠습니다.
```js
let user = { // 서드파티 코드에서 가져온 객체
  name: "John"
};

let id = Symbol("id");

user[id] = 1;

alert( user[id] ); // 심볼을 키로 사용해 데이터에 접근할 수 있습니다.
```

user는 서드파티 코드에서 가지고 온 객체이므로 함부로 새로운 프로퍼티를 추가할 수 없습니다. 그런데 심볼은 서드파티 코드에서 접근할 수 없기 때문에, 심볼을 사용하면 서드파티 코드가 모르게 user에 식별자를 부여할 수 있습니다.

심볼의 주요 유스 케이스는 다음과 같습니다.

1. 객체의 ‘숨김’ 프로퍼티 – 외부 스크립트나 라이브러리에 ‘속한’ 객체에 새로운 프로퍼티를 추가해 주고 싶다면 심볼을 만들고, 이를 프로퍼티 키로 사용하면 됩니다. 키가 심볼인 경우엔 for..in의 대상이 되지 않아서 의도치 않게 프로퍼티가 수정되는 것을 예방할 수 있습니다. 외부 스크립트나 라이브러리는 심볼 정보를 갖고 있지 않아서 프로퍼티에 직접 접근하는 것도 불가능합니다. 심볼형 키를 사용하면 프로퍼티가 우연히라도 사용되거나 덮어씌워 지는 걸 예방할 수 있습니다.  
이런 특징을 이용하면 원하는 것을 객체 안에 ‘은밀하게’ 숨길 수 있습니다. 외부 스크립트에선 우리가 숨긴 것을 절대 볼 수 없습니다.

2. 자바스크립트 내부에서 사용되는 시스템 심볼은 Symbol.*로 접근할 수 있습니다. 시스템 심볼을 이용하면 내장 메서드 등의 기본 동작을 입맛대로 변경할 수 있습니다. iterable 객체에선 Symbol.iterator를, 객체를 원시형으로 변환하기에선 Symbol.toPrimitive이 어떻게 사용되는지 알아보겠습니다.

### 참조에 의한 객체 복사
참조값 == 객체가 저장된 메모리 주소
변수에 객체 자체가 아닌 메무리 주소인 참조가 저장 됨!

```js
let user = { name: "John" };

let permissions1 = { canView: true };
let permissions2 = { canEdit: true };

// permissions1과 permissions2의 프로퍼티를 user로 복사합니다.
Object.assign(user, permissions1, permissions2);
```
목표 객체(user)에 동일한 이름을 가진 프로퍼티가 있는 경우엔 기존 값이 덮어씌워 집니다.

### new 연산자와 생성자 함수
. 재사용할 수 있는 객체 생성 코드를 구현
```js
function User(name) {
  this.name = name;
  this.isAdmin = false;
}

let user = new User("보라");
```


재사용 할 필요 없는 객체 생성
익명 함수로 생성, 재사용 불가(코드 캡슐화)
```js
let user = new function() {
  this.name = "John";
  this.isAdmin = false;

  // 사용자 객체를 만들기 위한 여러 코드.
  // 지역 변수, 복잡한 로직, 구문 등의
  // 다양한 코드가 여기에 들어갑니다.
};
```


### 폴리필
> 변경된 표준을 준수할 수 있게 기존 함수의 동작 방식을 수정하거나, 새롭게 구현한 함수의 스크립트를 "폴리필(polyfill)"이라 부릅니다. 폴리필(polyfill)은 말 그대로 구현이 누락된 새로운 기능을 메꿔주는(fill in) 역할을 합니다.

### 옵셔널 체이닝
null이 반환되어 에러 발생하는 것을 막기 위해 등장
?. 앞의 평가대상이 undefined 이거나 null 일 경우 undefined 반환
 존재하지 않아도 괜찮은 대상에만 사용해야 함
 ```js
// obj?.prop – obj가 존재하면 obj.prop을 반환하고, 그렇지 않으면 undefined를 반환함
user?.address;
//obj?.[prop] – obj가 존재하면 obj[prop]을 반환하고, 그렇지 않으면 undefined를 반환함
user1?.[key] 
//obj?.method() – obj가 존재하면 obj.method()를 호출하고, 그렇지 않으면 undefined를 반환함
user1.admin?.(); 
```
