package challenges.graphs.topoplogical_sort

import java.util.*

fun main() {
    println(Palindrome().isPalindrome("Ama ma"))
}

class Palindrome {
//
//    fun isPalindrome(str: String): Boolean {
//        var left  = 0
//        var right = str.length - 1
//
//        while (left < right) {
//            while (left < right && !alphaNumeric(str[left]))
//                left += 1
//
//            while (right > left && !alphaNumeric(str[right]))
//                right -= 1
//
//            left += 1
//            right -= 1
//            return str[left].lowercaseChar() == str[right].lowercaseChar()
//        }
//        return false
//    }
//
//    fun alphaNumeric(str: Char): Boolean {
//        return str in 'a'..'z' || str in 'A'..'Z'||
//                str.isDigit()
//    }


    fun isPalindrome(s: String): Boolean {
        var content = StringBuilder()
        for (i in s.indices)
            if (Character.isLetterOrDigit(s[i]))
                content.append(s[i])

        content = StringBuilder(content.toString().lowercase(Locale.getDefault()))
        val value = content.toString()
        return value == content.reverse().toString()
    }

    fun swap(a: Char, b: Char): CharArray {
        var c = a
        var d = b
        var e = c
        c = d
        d = e

        return charArrayOf(c, d)
    }
}