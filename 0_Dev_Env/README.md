# TL;DR
そもそもKotlinはIntelliJを作ったJetBrain社が作った言語。

IntelliJ持ってない場合、簡単なものなら

[https://play.kotlinlang.org/](https://play.kotlinlang.org/)で遊ぼう。

ちなみに、TL;DRぐらいはエンジニアならどの意味か認知しといたほうがいい。

# Kotlinってなんだ？
ロシアのサンクトペテルブルグにある島の名前。

Kotlin言語作ろときにR&Dセンターがあった島らしいね。

(頑張ってNabeyoko言語作ろうか)

IntelliJ IDEAを作ったJetBrainsで作った言語。

## これからはエンジニアに遭逢したときに頭良さそうに見える豆知識
最近だと、Androidのアプリ開発のための公式言語になってから流行った感じ。

OracleがJavaの著作権でやらかしてから作った説が強い。

これ関連で熱く話し出すやつは疲れるから話すのやめよう

# で、開発環境は？
正直、IntelliJ以外で使うのは想像したことない。

仕事で４年ぐらいいじってるけど、やはりIntelliJが一番すぐれてる。

でもIntelliJは高いし、買えないとしてもいろんな環境はある。

## JetBrains Fleet
[JetBrain Fleet](https://www.jetbrains.com/fleet/)たるのがあるらしい。

Free for Previewだから有料になるかわからないけど、

おそらくVSCodeみたいに無料版とかになるんじゃない？

## Android Studio
[Android Studio](https://developer.android.com/)はGoogleが無料で配ってるらしいね

アプリ開発好きじゃなく経験ないから、経験者ならこれ使っていいよ

## Eclipse
[Eclipse Kotlin Plugin](https://marketplace.eclipse.org/content/kotlin-plugin-eclipse)

Java勉強するものなら幼馴染のやつ。

学生時代みんな使ってたけど、俺はC++だったから使ったことないね、遅いし。

これなら無料だから全然いいと思う。

## IntelliJ
[IntelliJ](https://www.jetbrains.com/idea/)

Kotlin関係なく、IDEそのものとしても神

有料で、ちょい高めだけどLicenseを年年間も続けたら、向こうに「ちょっと安くしてよー」とか交渉もできる。

## Kotlin-playground
[Kotlin-playground](https://play.kotlinlang.org/)

そもそも、「JavaこれはKotlinだとこんなのできるよ」的に勧めたいから

簡単なコードならここで動かした方が楽だよね

Compilerとか入れたくないし、お金も払いたくないし

## その他
[Kotlin IDEs](https://kotlinlang.org/docs/kotlin-ide.html)

Kotlin自体でもIDEから話してるから、多分必須不可な感じかな？

一応MacOS, Linux, WindowsそれぞれのCompilerは整えてるから一読して

Linuxで確認したけど(WSL2、Rocky Linux9) JavaがインストールされてないとCompileできない。

なぜか？は宿題として残す。

# 結論と考察
*一応MacOS, Linux, WindowsそれぞれのCompilerは整えてるから一読して*

この発言、賢いやつは「KotlinはCompileする言語だねー」と気付いたはず。

あと、基本的な文法の場合は[Playground](https://play.kotlinlang.org/)でやることで。