package challenges.graphs.topoplogical_sort

import java.util.*


fun main(args: Array<String>) {
   println(Arrays.deepToString( GroupAnagram().groupAnagram(arrayOf("hello", "anan", "llohe", "mns", "naan","aann"))))
}

class GroupAnagram {
    fun groupAnagram(strs: Array<String>): Array<Array<String>> {
        if (strs.isEmpty() || strs.size < 2) {
            throw IllegalStateException("array should contain at least 2 elements")
        }

        var first: String
        val result = arrayListOf<Array<String>>()

        for (i in 0 until strs.size - 1) {
            first = strs[i]
            for (j in (i + 1) until strs.size) {
                if (isAnagram(first, strs[j])) {
                    result.add(arrayOf(first, strs[j]))
                }
            }
        }

        return result.toTypedArray()
    }

    fun isAnagram(s1: String, s2: String): Boolean {
        return s1.toCharArray().sorted().joinToString("") ==
                s2.toCharArray().sorted().joinToString("")
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>?>? {
        val res: MutableList<List<String>?> = ArrayList()
        if (strs.isEmpty()) return res
        val map: HashMap<String?, MutableList<String>?> = HashMap<String?, MutableList<String>?>()
        for (s in strs) {
            val hash = CharArray(26)
            for (c in s.toCharArray()) {
                hash[c.code - 'a'.code]++
            }
            val str = String(hash)
            if (map[str] == null) {
                map[str] = ArrayList()
            }
            map[str]!!.add(s)
        }
        res.addAll(map.values)
        return res
    }
}