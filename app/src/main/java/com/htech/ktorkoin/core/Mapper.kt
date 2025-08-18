package com.htech.ktorkoin.core

interface Mapper<I, O> {
    fun map(input: I): O
}