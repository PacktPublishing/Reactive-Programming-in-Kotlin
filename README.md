## [Get this title for $10 on Packt's Spring Sale](https://www.packt.com/B08677?utm_source=github&utm_medium=packt-github-repo&utm_campaign=spring_10_dollar_2022)
-----
For a limited period, all eBooks and Videos are only $10. All the practical content you need \- by developers, for developers

# Reactive Programming in Kotlin
This is the code repository for [Reactive Programming in Kotlin](https://www.packtpub.com/application-development/reactive-programming-kotlin?utm_source=github&utm_medium=repository&utm_campaign=9781788473026), published by [Packt](https://www.packtpub.com/?utm_source=github). It contains all the supporting project files necessary to work through the book from start to finish.
## About the Book
In today's app-driven era, when programs are asynchronous and responsiveness is so vital, reactive programming can help you write code that's more reliable, easier to scale, and better-performing. Reactive programming is revolutionary. With this practical book, Kotlin developers will first learn how to view problems in the reactive way, and then build programs that leverage the best features of this exciting new programming paradigm.
## Instructions and Navigation
All of the code is organized into folders. Each folder starts with a number followed by the application name. For example, Chapter02.



The code will look like the following:
```
async(CommonPool) {
  Observable.range(1, 10)
  .subscribeOn(Schedulers.trampoline())//(1)
  .subscribe {
    runBlocking { delay(200) } 
    println("Observable1 Item Received $it")
}
```

We will be using Java 8 and Kotlin 1.1.50 for the programs in this book, so Oracle's JDK 1.8 along with Kotlin 1.1.50 (this can be skipped downloading if you're using IntelliJ IDEA) will be required. You will need an environment to write and compile your Kotlin code (I strongly recommend Intellij IDEA, but you can use anything of your choice), and preferably a build automation system such as Gradle or Maven. Later in this book, we will use Android Studio (2.3.3 or 3.0). Everything you need in this book should be free to use and not require commercial or personal licensing (we are using the IntelliJ IDEA Community Edition)

## Related Products
* [Kotlin Programming By Example](https://www.packtpub.com/application-development/kotlin-programming-example?utm_source=github&utm_medium=repository&utm_campaign=9781788474542)

* [Mastering Android Development with Kotlin](https://www.packtpub.com/application-development/mastering-android-development-kotlin?utm_source=github&utm_medium=repository&utm_campaign=9781788473699)

* [Reactive Programming With Java 9](https://www.packtpub.com/application-development/reactive-programming-java-9?utm_source=github&utm_medium=repository&utm_campaign=9781787124233)

### Suggestions and Feedback
[Click here](https://docs.google.com/forms/d/e/1FAIpQLSe5qwunkGf6PUvzPirPDtuy1Du5Rlzew23UBp2S-P3wB-GcwQ/viewform) if you have any feedback or suggestions.
