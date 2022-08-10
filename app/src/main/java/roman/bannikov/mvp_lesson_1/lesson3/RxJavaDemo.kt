package roman.bannikov.mvp_lesson_1.lesson3

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import kotlin.random.Random

private val dataSourceStr = listOf("A", "C", "B", "C", "D", "E", "F", "G", "A", "A", "C", "D", "C")
private val dataSourceInt = listOf(1, 2, 3, 4, 3, 23, 98, 12, 31, 1, 2, 2, 2)
private val dataSourceMix = listOf(1, 23, 98, 2, "C", "D", 2, 2, 2, 23, 12, 31, "B", "D", 1, 2)

fun main() {
//    showSimpleExample()
//    showIterableExample()
//    showSkipTakeOperatorsExample()
//    showMapOperatorExample()
//    showBestPracticeWithMapOperatorExample()
//    showDistinctOperatorExample()
//    showFilterOperatorExample()
//    showZipExample()
//    showMergeWithExample()
//    showFlatMapExample()
//    showDelayExample()
//    showSingleExample() //тут не запустится (просто сохранил код - он постоянно будет нужен)

}

private fun Disposable.disposeBy(bag: CompositeDisposable) {
    // private val bag = CompositeDisposable() // прописать вначале класса (фрагмента, адаптера)
    bag.add(this)
    // и не забыть в onDestroy() прописать bag.dispose()
    //что такое диспоуз смотри на третьем уроке на 1:36
}

private fun showSingleExampleWithExtensionFunction() { // subscribeByDefault() ниже ↓ ↓ ↓ ↓
    /*binding.pBar.visibility = View.VISIBLE
    Single.create<String> {
        it.onSuccess("Chota tam")
    }.subscribeByDefault()
        .subscribe(
            {
                binding.tvResult.text = it
                binding.pBar.visibility = View.GONE
            },
            {
                Log.d("@@@", it.message ?: "ok")
            }
        )*/ //не забывать про dispose() (lesson_3 01:36)
}

private fun <T> Single<T>.subscribeByDefault(): Single<T> {
    return this
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
}  // для функции выше  ↑ ↑ ↑ ↑

private fun showSingleExample() {
    val observableStr = Observable.just("One", "Two", "One", "Two")
    Single.create<String> {
        it.onSuccess("Chota tam")
    }.subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            {
                //do something
            },
            {
                //do something
            }
        )
}

private fun showDelayExample() {
    val observableStr = Observable.just("One", "Two", "Three", "Four")
    observableStr
        .flatMap { element ->
            val delay = Random.nextInt(1000)
            return@flatMap getUserInfo(element)
                .delay(delay.toLong(), TimeUnit.MILLISECONDS)
        }
        .subscribe(
            {
                //do something
            },
            {
                //do something
            }
        )
}

private fun showFlatMapExample() {
    val observableNames = Observable.just("One", "Two", "Three", "Four")
    observableNames
        .flatMap { element ->
            return@flatMap getUserInfo(element)
        }
        .subscribe(
            {
                println(it)
            },
            { error ->
                println(error)
            }
        )
}

private fun getUserInfo(name: String): Observable<List<String>> {
    return Observable.just(listOf(name, "email"))
}

private fun showMergeWithExample() {
    val observableNames = Observable.just("One", "Two", "Three", "Four")
    val observableMail = Observable.just("one@mail.ru", "two@mail.ru", "three@mail.ru")
    observableNames
        .mergeWith(observableMail)
        .subscribe(
            {
                println(it)
            },
            { error ->
                println(error)
            }
        )
}

private fun showZipExample() {
    //Пердставим, что у нас есть APIшка и к ней нужно отправить двойной запрос:
    val observableNames = Observable.just("Roman", "Raimond", "Roland", "@@@@@")
    //ВНИМАНИЕ!!! ЕСЛИ ЭЛЕМЕНТУ НЕТ ПАРЫ, ТО "ЗИПИТЬ" НЕ БУДЕТ (ЭЛЕМЕНТ ПОТЕРЯЕТСЯ)
    val observableMail = Observable.just("Rom@mail.ru", "Rai@mail.ru", "Rol@mail.ru")
    Observable.zip(observableNames, observableMail) { name, email ->
        return@zip "$name : $email"
    }.subscribe(
        {
            println(it)
        },
        { error ->
            println(error)
        }
    )
}

private fun showFilterOperatorExample() {
    Observable.fromIterable(dataSourceMix)
        .filter {
            it == "A" || it == "B" || it == "C" || it is Int
        }
        .distinct()
        .subscribe(
            { item ->
                println(item)
            },
            { error ->
                println(error)
            }
        )
}

private fun showDistinctOperatorExample() {
    Observable.fromIterable(dataSourceStr)
        .distinctUntilChanged()
        .distinct()
        .subscribe(
            { item ->
                println(item)
            },
            { error ->
                println(error)
            }
        )
}

private fun showBestPracticeWithMapOperatorExample() {
    Observable.fromIterable(dataSourceInt)
        .map(::mapToListAndAdd)
        .subscribe(
            {
                println(it)
            },
            { error ->
                println(error)
            }
        )
}

private fun mapToListAndAdd(value: Int): List<Int> {
    return listOf(value * 2)
}

private fun showMapOperatorExample() {
    Observable.fromIterable(dataSourceMix)
        .map {
            mutableListOf(it)
        }
        .map {
            it.add(0, "SS")
//            it.add(4,"X")//IndexOutOfBoundsException: Index: 4, Size: 2
            it.add(2)
            it.add("XXX")
            it.add("XXX")
            it.add(4, "X")// no error
            it.add("XXX")
            return@map it
        }
        .subscribe(
            {
                println(it)
            },
            { error ->
                println(error)
            }
        )
}

private fun showSkipTakeOperatorsExample() {
    Observable.fromIterable(dataSourceMix)
        .skip(1)
        .take(4)
        .skip(2)
        .subscribe(
            { element ->
                println(element)
            },
            { error ->
                println(error)
            }
        )
}

private fun showIterableExample() {
    Observable.just(1, 2, 21) //узнали, что такое есть и фсё
    Observable.just("one", "re", "sdf") //узнали, что такое есть и фсё
    //Пример поинтересней: эту запись используют почти всегда!
    Observable.just(dataSourceStr).subscribe(
        { element ->
            println(element)
        },
        { e ->
            //do something
        }
    )
    println()
    Observable.fromIterable(dataSourceStr).subscribe(
        { element ->
            println(element)
        },
        { error ->
            //do something
        }
    )
}

private fun showSimpleExample() { //ЗАПОМНИТЬ ЭТОТ ПРИМЕР!!!

    val observer = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) =
            Unit //удобная запись, если не хочешь реализовывать метод

        override fun onNext(t: Int) {
            println("Next: $t")
        }

        override fun onError(e: Throwable) {
            print("Something went wrong")
        }

        override fun onComplete() {
            print("Done")
        }

    }

    val observable = Observable.create<Int> { emitter ->
        try {
            dataSourceInt.forEach { element -> //или любое другое название
                emitter.onNext(element)
            }
        } catch (e: Throwable) {
            emitter.onError(e)
        }
        emitter.onComplete()
    }

    observable.subscribe(observer)
}
