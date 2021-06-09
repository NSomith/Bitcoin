package com.example.bitcoin.extension

import com.example.bitcoin.State

fun <T, R> State<T>.map(transform: (T) -> R): State<R> {
    return when (this) {
        is State.Success -> State.Success(transform(data))
        is State.Error -> State.Error(exception)
        is State.Loading -> State.Loading
    }
}