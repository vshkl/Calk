package com.vshkl.calk

sealed class InputAction {
    data class Add(val value: String) : InputAction()
    object Remove : InputAction()
    object Parentheses : InputAction()
    object Clear : InputAction()
    object Equals : InputAction()

    companion object {

        fun fromKey(key: Key): InputAction {
            return when (key) {
                Key.Backspace -> Remove
                Key.Clear -> Clear
                Key.Decimal -> Add(".")
                Key.Divide -> Add("÷")
                Key.Equals -> Equals
                Key.Minus -> Add("-")
                Key.Multiply -> Add("×")
                is Key.Number -> Add(key.number.toString())
                Key.Parentheses -> Parentheses
                Key.Percent -> Add("%")
                Key.Plus -> Add("+")
            }
        }
    }
}
