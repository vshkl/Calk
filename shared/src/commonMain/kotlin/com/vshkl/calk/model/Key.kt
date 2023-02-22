package com.vshkl.calk.model

sealed class Key {
    object Plus : Key()
    object Minus : Key()
    object Multiply : Key()
    object Divide : Key()
    object Equals : Key()
    object Clear : Key()
    object Decimal : Key()
    object Percent : Key()
    object Parentheses : Key()
    object Backspace : Key()
    data class Number(val number: Int) : Key()
}
