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
List<String> baka = new ArrayList<>(Arrays.asList("マツケン", "ゆうき", "くー"));
System.out.println(baka);
baka.add("じゅんじ");
System.out.println(baka);

// 出力
// [マツケン, ゆうき, くー]
// [マツケン, ゆうき, くー, じゅんじ]
```

Javaの場合、ListはInterfaceらしく、そのタイプ自体ではなく、

ArrayList, LinkedList, Vectorしかできないらしいね。めんど！

KotlinはListのままで使えるよ～

```kotlin
var baka = mutableListOf("マツケン", "ゆうき", "くー")
baka.add("じゅんじ")
println(baka)

// 出力
// [マツケン, ゆうき, くー, じゅんじ]
```

### Mutable?
Basic Syntax Part 1で話したけど、最新の言語のトレンドかはわからないが

「基本的に、変数は可変にしないように」の考え方が多いよね。

実務経験あればめっちゃ共感できると思う。

### 通常のList
```kotlin
var hueruBaka = mutableListOf("マツケン", "ゆうき", "くー")
var huenaiBaka = listOf("マツケン", "ゆうき", "くー")

println(hueruBaka)
println(huenaiBaka)

hueruBaka.add("じゅんじ")

// Compile error here
// huenaiBaka.add("じゅんじ")
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
重複した要素をがないリストのことね。

```kotlin
fun main() {
	val baka = setOf("マツケン", "ゆうき", "くー", "こうき", "じゅんじ", "じゅんじ", "じゅんじ")
    println(baka)
}

// 出力
// [マツケン, ゆうき, くー, こうき, じゅんじ]
```

説明どおり、重複してるのは1個にしとく感じだよね。

大事なのは、「**重複要素を入れても、エラーとかにはならない**」ことね。

実務では、定義してる対象をリストアップして、重複しちゃっても構わない場合

Setにしちゃえばバグらないことだよね。

### 宿題
事例では、じゅんじが3回馬鹿リストに入っても1回だけ格納されるね(やさしいね～)。

でも、Setの中身がClassでもちゃんと比較してくれるかな？

```kotlin
fun main() {
    val baka = setOf(
        Baka("マツケン"),
        Baka("ゆうき"),
        Baka("くー"),
        Baka("こうき"),
        Baka("じゅんじ"),
        Baka("じゅんじ"),
        Baka("じゅんじ")
    )

    baka.forEach{
        println(it)
    }
}

class Baka(val name: String) {
    override fun toString(): String {
        return name
    }
}
```

## Map
Collectionクラスを継承してるわけではないやつだけど、

Kotlinで色々やったら結構遭遇するやつだよね。

Key-Value組み合わせなにかをしたいとき、これが一番。

JavaのHashMapみたいな感じかな？

```kotlin
fun main() {
    val baka: Map<String, String> = mapOf(
        "マツケン" to "会長",
        "ゆうき" to "新婚",
        "じゅんじ" to "既婚",
        "くー" to "独居老人"
    )

    baka.forEach { (k, v) ->
        println("${v}の${k}")
    }
}

/* 出力
会長のマツケン
新婚のゆうき
既婚のじゅんじ
独居老人のくー
*/
```

# で、言いたいのは？
## mutable云々
Basic Syntax Part 1で、「var」「val」で**この変数、変える？**が決められるってことあったよね。

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
    var hueruBakaVar = mutableListOf("マツケン", "ゆうき", "くー")
    var huenaiBakaVar = listOf("マツケン", "ゆうき", "くー")
    val hueruBakaVal = mutableListOf("マツケン", "ゆうき", "くー")
    val huenaiBakaVal = listOf("マツケン", "ゆうき", "くー")
    
    hueruBakaVar.add("こうき")
    huenaiBakaVar.add("こうき")
    hueruBakaVal.add("こうき")
    huenaiBakaVal.add("こうき")
    
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
        "マツケン" to "会長",
        "ゆうき" to "新婚",
        "じゅんじ" to "既婚",
        "くー" to "独居老人"
    )

    baka.forEach { (k, v) ->
        println("${v}の${k}")
    }
}
```

forEachってなんだろ？と考えてみよ。

あと、独居老人は可哀想だから出力しないようにするならどうすればいいかな？

Hint : if, Interface, Abstract class
