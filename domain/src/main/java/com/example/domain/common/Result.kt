package com.example.domain.common

/**
 * Created by Festus Kiambi on 7/1/19.
 */
sealed class Result<out E, out V> {

    data class Value<out V>(val value: V) : Result<Nothing, V>()

    object Loading : Result<Nothing, Nothing>()

    data class Error<out E>(val error: E) : Result<E, Nothing>()

    companion object Factory {
        //higher order functions take functions as parameters or return a function
        //Kotlin has function types name: () -> V
        inline fun <V> build(function: () -> V): Result<Exception, V> =
            try {
                Value(function.invoke())
            } catch (e: java.lang.Exception) {
                Error(e)
            }

        fun buildLoading(): Result<Exception, Nothing> {
            return Loading
        }
    }

}