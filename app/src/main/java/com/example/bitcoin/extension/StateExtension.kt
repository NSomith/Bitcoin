package com.example.bitcoin.extension

import com.example.bitcoin.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

fun <T, R> State<T>.map(transform: (T) -> R): State<R> {
    return when (this) {
        is State.Success -> State.Success(transform(data))
        is State.Error -> State.Error(exception)
        is State.Loading -> State.Loading
    }
}

fun <T> Flow<State<T>>.doOnSuccess(action: suspend (T) -> Unit): Flow<State<T>> =
    transform { state ->
        if (state is State.Success) {
            action(state.data)
        }
        return@transform emit(state)
    }
