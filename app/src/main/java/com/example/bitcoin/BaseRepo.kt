package com.example.bitcoin

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


abstract class BaseRepo {
    fun <T> apicall(call: suspend () -> T): Flow<State<T>> =
        flow {
            emit(State.Loading)
            emit(State.Success(data = call.invoke()))
        }.catch { error ->
            emit(State.Error(error))
        }.flowOn(Dispatchers.IO)

//     fun <T> calls():String = "sad" class body is defiend
}