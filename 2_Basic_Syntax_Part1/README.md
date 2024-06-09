# 基礎文法
[基礎文法](https://kotlinlang.org/docs/basic-syntax.html)

これ読んで和訳してるだけ。

普段ぶっ飛ばすところだけど、CやJavaの経験だけなら癖あるかもしれないところ。
# Function
関数に関しては、むしろFrontendなら違和感ないかもしれないね。

基本的にはこんな形
```
fun {関数名}(パラメータ) : {返し形} {
    ごにょごにょ
}
```

例えば、馴染の「２つの整数をもらって、合計を返す」の場合

Javaだと
```java
int sum(int a, int b) {
    return a + b;
}
```

だけど、Kotlinは**形が後ろに来る**
Parameterでも、返り値も！
```kotlin
fun sum(a: Int, b: Int): Int {
    return a + b
}
```

おそらくだが、FrontendでKotlin使ってるのもTypescriptと似てるから違和感ないのかなーと思ってるね。

# Variables
最近の言語のトレンドというかあるあるは**変数は返さないように**とも言えるね。

(この辺興味あれば、RustのOwnershipとか、MutableとImmutableとか一読おすすめ)

Kotlinの場合、上で言及したように肩は後ろに書いてる。

前には2つがあると思えばいい
- val
    - immutable
    - 一回定義したら、直せない
- var
    - mutable
    - 定義しても、直せる

[Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMi4wLjAiLCJwbGF0Zm9ybSI6ImphdmEiLCJhcmdzIjoiIiwibm9uZU1hcmtlcnMiOnRydWUsInRoZW1lIjoiaWRlYSIsImNvZGUiOiIvKipcbiAqIFlvdSBjYW4gZWRpdCwgcnVuLCBhbmQgc2hhcmUgdGhpcyBjb2RlLlxuICogcGxheS5rb3RsaW5sYW5nLm9yZ1xuICovXG5mdW4gbWFpbigpIHtcbiAgICB2YWwgaW1tdXRhYmxlVmFyaWFibGU6IEludCA9IDBcbiAgICB2YXIgbXV0YWJsZVZhcmlhYmxlOiBJbnQgPSAwXG4gICAgXG4gICAgaW1tdXRhYmxlVmFyaWFibGUgPSAxXG4gICAgbXV0YWJsZVZhcmlhYmxlID0gMVxuICAgIFxuICAgIHByaW50bG4oaW1tdXRhYmxlVmFyaWFibGUpXG4gICAgcHJpbnRsbihtdXRhYmxlVmFyaWFibGUpXG59In0=)で確認したら分かる
```kotlin
fun main() {
  fun main() {
    val immutableVariable: Int = 0
    var mutableVariable: Int = 0

    // Compile error here
    immutableVariable = 1
    mutableVariable = 1

    println(immutableVariable)
    println(mutableVariable)
    println(add(100, 100))
  }

  fun add(lvalue: Int, rvalue: Int) : Int {
    return lvalue + rvalue
  }
}

// 'val' cannot be reassigned.
```

`val`はValueのことで、「(変わらない)値」と受け入れて

`var`はVariableで、「色々」と受け入れたらいいね。

mutable, immutableとかの変数名にしたのは

今後出るCollection(Listとか、Mapとか)で「変数って変わるもんだろう？なんで？」と思ってて

おや？となった経験あるからあえて使ったのよ。

Mutableって言葉に目をなじませましょう

> mutable : 外見または品質または本質が変化できる、あるいは、外見または品質または本質が変化する傾向がある

**Javaだと、固定したい変数に「static」とか「final」とか書いたのと逆発想だね？**

# 宿題
## 1番
上のコードがなんでエラーになるか考えてみよう

## 2番
例としては整数系を合わせるぐらいにしてるけど、

文字列になってる数字を足し算して、整数系にする関数を作ってみましょう

[Hint](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-int.html)
```kotlin
fun add(lvalue: String, rvalue: String): Int { 
    // いちゃいちゃ
}
```

## 3番
2番のlvalue, rvalueが数字の文字列かの判断も入れて見ましょう
[Hint](https://www.baeldung.com/kotlin/check-if-string-is-numeric)


# 正直無視していいけど基本だから言及する項目
## Package, Import
Javaの本だと、Chapter 7とかに出るやつだね？

俺もSpringをKotlinで書くから入ったらそこまで気にしてなかったけど、

まぁまぁJava経験者なら分かるでしょう

## Entry point
格好つけてEntry pointとか言うけど、

結局「何かしらのアプリケーションを起動すると、ここから始まるよ」のことね。

現実的に、Kotlinでプログラミング始まることはまだないと思うし、

何かしらのFramework(Springとか)の言語として使うのが多いと多いと思うから

「Kotlinのアプリはmain関数から」ぐらいわたったらいいよね

## print, println
どんな言語でも、何かしらを出力したいときはこれ使うよね

でもEntry pointで話したように、実例では何かしらLoggerを使うはずだし

「printlnなら改行もしてくれる」ぐらいの認識でいいかな？

## その他
Loopとかで使えるRangeとか、色々あるけど

ぶっちゃけてそこまで使う場面ないし、好みで検索したりするものだからパス