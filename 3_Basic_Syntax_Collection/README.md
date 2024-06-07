# 基本の巻、その2
[基礎文法](https://kotlinlang.org/docs/basic-syntax.html)

ここの内容の一部の和訳と余談を入れた感じ。

Collectionって何？となる人はまずググって。

# Collection
と名付けたけど、Loopとかもいじると思う。

基本書にあるあるの「1から100まで足し算」をLoopでやってる原始人はないだろう。

(i(i+1)/2 って公式は10歳で学ぶでしょう)

実務でLoopは何かしらのCollectionだろうしね

## List
経験上、大体はListで何度ができた。

Javaと一緒で、「同じType(もしくはClass)をリスト」のことだよね。

Kotlinの哲学(？)というか、特徴を見るためにListを使いましょう。

### とりあえず
Basic Syntax Part 1を見たら分かると思うけど、

immutable, mutableの概念ができて、Java経験者からは違和感を感じるかもね。

Javaではこれで行けたと思うね

```java
List<String> baka = new ArrayList<>(Arrays.asList("Harada", "Yuuki", "ManaminoDanna"));
System.out.println(baka);
baka.add("Koo");
System.out.println(baka);

// 出力
// [Harada, Yuuki, ManaminoDanna]
// [Harada, Yuuki, ManaminoDanna, Koo]
```

Javaの場合、ListはInterfaceらしく、そのタイプ自体ではなく、

ArrayList, LinkedList, Vectorしかできないらしいね。めんど！

KotlinはListのままで使えるよ～

```kotlin
var baka = mutableListOf("Harada", "Yuuki", "ManaminoDanna")
baka.add("Koo")
println(baka)

// 出力
// [Harada, Yuuki, ManaminoDanna, Koo]
```

### What the Fxxk is MutableList?
Basic Syntax Part 1で話したけど、最新の言語のトレンドかはわからないが

「基本的に、変数は可変にしないように」の考え方が多いよね。

実務経験あればめっちゃ共感できると思う。

### 通常のList
```kotlin
var hueruBaka = mutableListOf("Harada", "Yuuki", "ManaminoDanna")
var huenaiBaka = listOf("Harada", "Yuuki", "ManaminoDanna")

println(hueruBaka)
println(huenaiBaka)

hueruBaka.add("Koo")

// Compile error here
// huenaiBaka.add("Koo")
println(hueruBaka)
```
[Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMi4wLjAiLCJwbGF0Zm9ybSI6ImphdmEiLCJhcmdzIjoiIiwibm9uZU1hcmtlcnMiOnRydWUsInRoZW1lIjoiaWRlYSIsImNvZGUiOiIvKipcbiAqIFlvdSBjYW4gZWRpdCwgcnVuLCBhbmQgc2hhcmUgdGhpcyBjb2RlLlxuICogcGxheS5rb3RsaW5sYW5nLm9yZ1xuICovXG5mdW4gbWFpbigpIHtcbiAgICB2YXIgaHVlcnVCYWthID0gbXV0YWJsZUxpc3RPZihcIkhhcmFkYVwiLCBcIll1dWtpXCIsIFwiTWFuYW1pbm9EYW5uYVwiKVxuICAgIHZhciBodWVuYWlCYWthID0gbGlzdE9mKFwiSGFyYWRhXCIsIFwiWXV1a2lcIiwgXCJNYW5hbWlub0Rhbm5hXCIpXG5cbiAgICBwcmludGxuKGh1ZXJ1QmFrYSlcbiAgICBwcmludGxuKGh1ZW5haUJha2EpXG5cbiAgICBodWVydUJha2EuYWRkKFwiS29vXCIpXG4gICAgaHVlbmFpQmFrYS5hZGQoXCJLb29cIilcblx0cHJpbnRsbihodWVydUJha2EpXG59In0=)で見たら

`Unresolved reference 'add'.`が出る。

addができません、とかでもなく「そもそもadd()なんかねーよ」の状態だね。

KotlinのCollectionの定義を見ると

```kotlin
@kotlin.SinceKotlin @kotlin.internal.InlineOnly public inline fun <T> List(size: kotlin.Int, init: (kotlin.Int) -> T): kotlin.collections.List<T>

@kotlin.SinceKotlin @kotlin.internal.InlineOnly public inline fun <T> MutableList(size: kotlin.Int, init: (kotlin.Int) -> T): kotlin.collections.MutableList<T
```
そもそも最初から「可変のList」と、「固定List」が分かれて、Listならadd()自体がないのが分かるよね。

## Set
数学に興味があれば一発でぐっと来るけど、そんな変態俺しかないよね

**Set stores unique elements** 

公式文書で、こう話してる。

```kotlin
fun main() {
	val baka = setOf("Matsuken", "Yuuki", "Koo", "Katano", "Katano", "Katano", "Katano")
    println(baka)
}

// 出力
// [Matsuken, Yuuki, Koo, Katano]
```

説明どおり、重複してるのは1個にしとく感じだよね。

重目すべきなのは、「重複要素を入れても、エラーとかにはならない」ことね。

実務では、定義してる対象をリストアップして、重複したらまずいとき

Setにしちゃえばバグらないことだよね。

### 宿題
事例では、Katanoさんがどんだけ馬鹿でも1回だけ馬鹿として格納されるね(やさしいね～)。

でも、Setの中身がClassでもちゃんと比較してくれるかな？

[Hint](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMi4wLjAiLCJwbGF0Zm9ybSI6ImphdmEiLCJhcmdzIjoiIiwibm9uZU1hcmtlcnMiOnRydWUsInRoZW1lIjoiaWRlYSIsImNvZGUiOiIvKipcbiAqIFlvdSBjYW4gZWRpdCwgcnVuLCBhbmQgc2hhcmUgdGhpcyBjb2RlLlxuICogcGxheS5rb3RsaW5sYW5nLm9yZ1xuICovXG5mdW4gbWFpbigpIHtcblx0dmFsIGJha2EgPSBzZXRPZihCYWthKFwiTWF0c3VrZW5cIiksIEJha2EoXCJZdXVraVwiKSwgQmFrYShcIktvb1wiKSwgQmFrYShcIkthdGFub1wiKSwgXG4gICAgICAgICAgICAgICAgICAgICBCYWthKFwiS2F0YW5vXCIpLCBCYWthKFwiS2F0YW5vXCIpLCBCYWthKFwiS2F0YW5vXCIpKVxuICAgIGJha2EuZm9yRWFjaHtcbiAgICAgICAgcHJpbnRsbihpdClcbiAgICB9XG59XG5cbmNsYXNzIEJha2EodmFsIG5hbWU6IFN0cmluZykge1xuICAgIG92ZXJyaWRlIGZ1biB0b1N0cmluZygpOiBTdHJpbmcge1xuICAgICAgICByZXR1cm4gbmFtZVxuICAgIH1cbn0ifQ==)

## Map
Collectionクラスを継承してるわけではないやつだけど、

Kotlinで色々やったら結構遭遇するやつだよね。

Key-Value組み合わせなにかをしたいとき、これが一番。

JavaのHashMapみたいな感じかな？

```kotlin
fun main() {
    val baka: Map<String, String> = mapOf(
        "matuken" to "社長",
        "koo" to "ちょん",
        "yuuki" to "やりちん",
        "junji" to "無職"
    )

    baka.forEach { (k, v) ->
        println("だまれ、${v}")
    }
}

// 出力
// だまれ、社長
// だまれ、ちょん
// だまれ、やりちん
// だまれ、無職
```

# で、言いたいのは？
## mutable云々
Basic Syntax Part 1で、「var」「val」で**この変数、帰れるの？**が決められるってことあったよね。

Listだけではなく、他のCollectionでも「mutable云々」があるし、

タイプ自体も「Mutable云々」あるのね。

俺でもKotlinのCollectionを全部知ってるわけでもないし、そこまで知る必要もないし、知りたくもないね。

ググればすぐ分かるだろう？

一番重要なのは「CollectionのClass自体に、Mutable, Immutable2種類あるんだよねー」

ぐらいでいい。

# 宿題
「こういったコード書いてください」の意味ではない。

ふっと投げた話題で5分でも考えたらいいのよ。

## 宿題1
変数自体で `val`と`var`があります。

Collection自体のMutabilityと、変数の可変性はどうなるかな？

結果をみてみんなで議論しようか？

```kotlin
    var hueruBakaVar = mutableListOf("Harada", "Yuuki", "ManaminoDanna")
    var huenaiBakaVar = listOf("Harada", "Yuuki", "ManaminoDanna")
    val hueruBakaVal = mutableListOf("Harada", "Yuuki", "ManaminoDanna")
    val huenaiBakaVal = listOf("Harada", "Yuuki", "ManaminoDanna")
    
    hueruBakaVar.add("Matsuken")
    huenaiBakaVar.add("Matsuken")
    hueruBakaVal.add("Matsuken")
    huenaiBakaVal.add("Matsuken")
    
    println(hueruBakaVar)
    println(huenaiBakaVar)
    println(hueruBakaVal)
    println(huenaiBakaVal)
```
KotlinもJVMの上で動くやつだから、原因まではどうでもいい。

色々調べたり、無視したりして

PointerやMemoryの概念あれば分かるかも？

## 宿題2
Setのこのコードで
```kotlin
fun main() {
    val baka: Map<String, String> = mapOf(
        "matuken" to "社長",
        "koo" to "ちょん",
        "yuuki" to "やりちん",
        "junji" to "無職"
    )

    baka.forEach { (k, v) ->
        println("だまれ、${v}")
    }
}
```

forEachってなんだろ？と考えてみよ。

あと、「だまれ」なんかはじゅんじ以外には言わないようにして見ましょう

俺の頭の中で5つぐらい方法浮かんでるから、

実装面で質問あれば聞いて(どうせ誰も読まないから、俺の頭の中のケースが増えるだけでしょう)

Hint : if(k), Interface, Abstract class
