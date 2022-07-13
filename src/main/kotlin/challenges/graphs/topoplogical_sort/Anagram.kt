package challenges.graphs.topoplogical_sort


fun main() {
    println(Anagram().isAnagram("car", "rsc"))
}

class Anagram {
    fun anagram(string1: String, string2: String): Boolean {
        return string1.toCharArray().sorted().joinToString("") == string2.toCharArray().sorted().joinToString("")

//        val resultMap1 = hashMapOf<Char, Int>()
//        val resultMap2 = hashMapOf<Char, Int>()
//
//        if (string1.length != string2.length) return false
//
//        for (i in string1.indices) {
//            if (resultMap1.containsKey(string1[i])) {
//                resultMap1[string1[i]] = resultMap1[string1[i]]!! + 1
//            } else resultMap1[string1[i]] = 1
//            if (resultMap2.containsKey(string2[i])) {
//                resultMap2[string2[i]] = resultMap2[string2[i]]!! + 1
//            } else resultMap2[string2[i]] = 1
//        }
//
//        resultMap1.forEach { i ->
//            if (resultMap1[i.key] != resultMap2[i.key]) {
//                return false
//            }
//            return true
//        }
//
//        return false


    }

    fun isAnasgram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val store = IntArray(26)
        for (i in s.indices) {
            store[s[i].code - 'a'.code]++
            store[t[i].code - 'a'.code]--
        }
        for (n in store) if (n != 0) return false
        return true
    }

    fun isAnagram(s: String, t: String): Boolean {
        val hm1 = HashMap<Char, Int>()
        val hm2 = HashMap<Char, Int>()
        for (i in s.indices) {
            hm1[s[i]] = hm1.getOrDefault(s[i], 0) + 1
        }
        for (i in t.indices) {
            hm2[t[i]] = hm2.getOrDefault(t[i], 0) + 1
        }
        return hm1 == hm2
    }
}