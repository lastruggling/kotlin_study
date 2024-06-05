# Hello, World
やる必要もないコードだけど、なんかこだわってしまうよな「Hello, World」って

「これできたから、俺様すごい」の気持ち味わうために一旦やってみましょう

## Code
[Hello World](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMi4wLjAiLCJwbGF0Zm9ybSI6ImphdmEiLCJhcmdzIjoiIiwibm9uZU1hcmtlcnMiOnRydWUsInRoZW1lIjoiaWRlYSIsImNvZGUiOiIvKipcbiAqIFlvdSBjYW4gZWRpdCwgcnVuLCBhbmQgc2hhcmUgdGhpcyBjb2RlLlxuICogcGxheS5rb3RsaW5sYW5nLm9yZ1xuICovXG5mdW4gbWFpbigpIHtcbiAgICBwcmludGxuKFwiSGVsbG8sIHdvcmxkISEhXCIpXG59In0=)

```kotlin
fun main() {
    println("Hello, world!!!")
}
```

Playgroundで見たらわかると思うけど、案の定
```
Hello, world!!!
```
が出力される。やったー

# 自分でも知らないし、多分これからは話さない話
うん、その結果はだるいよね

個人的に、「KotlinはJavaのことをよりわかりやすくする言語」で、

強いて言ったら「巨大なSyntax Sugar」的に考えてるんだ。

興味ある人はすでにわかってるかもしれないが、KotlinもCompileしたらJVMになり、Bytecodeになる。

つまり、Compile時の結果物がJavaのコードとKotlinと一緒ではないか？

もっと複雑なコードになる前に本当そうか除いて見たくなった。

## .class file from .kt
```kotlin
fun main() {
    println("Hello, world!!!")
}
```
これをCompileして、JavaコードDisassembleしてみよう

```bash
$ kotlinc helloworld.kt
$ javap -c HelloworldKt.class
Compiled from "helloworld.kt"
public final class HelloworldKt {
  public static final void main();
    Code:
       0: ldc           #8                  // String Hello, world!!!
       2: getstatic     #14                 // Field java/lang/System.out:Ljava/io/PrintStream;
       5: swap
       6: invokevirtual #20                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
       9: return

  public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #23                 // Method main:()V
       3: return
}
```
????????の気持ちわかるけど、大体
- ldcたるもので"Hello, World"って文字列を格納する(だろー)
- getstaticで、PrintStreamたる関数を呼ぶ(だろー)
- invokestaticで、main関数を呼ぶ(だろー)

Assemblyコード見たことないとわかりにくいかもしれないが、

いまいま確認したいのは「Kotlinのコードって、CompileしたらJavaのコードとCompile結果物とにてるよねー」ぐらい(だろー)

## .class file from .java
helloworld.javaの中身は
```java
class helloworld{
    public static void main(String args[]){
     System.out.println("Hello, world!!!");
    }
}
```

Compileして、Classの中身を見ると

```bash
$ javap -c helloworld.class
Compiled from "helloworld.java"
class helloworld {
  helloworld();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #13                 // String Hello, world!!!
       5: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}
```
ちょーーーっと違うけど、Memoryに「Hello, world!!!」って固定文字列を入れて

それをPrintStreamを利用して出力するのは一緒なのがなんとなくわかる。

(ldcとか、invoke云々見たら結局やることは一緒。)

妄想レベルの分析だけど、Javaの場合
- Entry pointになるClassはfinal staticにする
- 一つのクラスで一つのクラス
- main関数の定義はstatic void mainに固定される

の制限があったけど、Kotlinはそれをなくす代わりに

**Compile対象になるClassをfinal classに置換する**ように見える。

# 結論と考察
Bytecodeが完全一致してるわけではないが、

KotlinはJavaの制限から脱獄するようなCompileをしてるのように見える。

(Assemblyをちょっと舐めた感じではそう見える。そう信じてる。うん。)

# 今後もこんなのやるの？
めんどい。我々よりもっと頭いい人たちが作ったから問題ないし、

我々より頭いい人たちが使ってるから、何かしら問題あれば直してる。

Javaを知ってる想定で書いてるから、
- **Javaでめんどかったの、こんなにできるよ**
- **Javaのこの機能、Kotlinでもできるよ**
- **Javaのこの機能、あるんだっけ**

の観点で話し合いながらいきましょう！がいいたかっただけ。
