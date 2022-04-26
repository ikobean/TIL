### java String 

boolean 타입.
시작하는 글자와 끝나는 글자를 체크해서
true/false로 반환

```
String word = "Hello World";

// true
word.startsWith("H");
// false (두 칸의 공백 때문에) 
word.startsWith("Hello  "); 

// true
word.endsWith("ld");
// false 뒤 칸 공백
word.endsWith("ld ");



```
