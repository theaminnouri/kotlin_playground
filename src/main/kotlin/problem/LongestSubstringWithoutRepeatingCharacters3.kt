package org.example.problem

import kotlin.math.max

object LongestSubstringWithoutRepeatingCharacters3 {

    fun execute() {
        println(lengthOfLongestSubstring("abcabcbb"))
    }

    fun optimalLengthOfLongestSubstring(s: String): Int {
        var length = 0
        var left = 0
        var right = 0
        val map = hashMapOf<Char, Int>()
        for (i in s.indices) {
            if (map.containsKey(s[i])) {
                left = max(left, map[s[i]]!! + 1)
            }
            right++
            map[s[i]] = i
            length = max(length, right - left)
        }
        return length
    }

    fun lengthOfLongestSubstring(s: String): Int {
        val chars = s.toCharArray()
        var length = 0
        var left = 0
        var right = 0
        val map = hashMapOf<Char, Int>()
        while (left < chars.size && right < chars.size) {
            if (map.containsKey(chars[right])) {
                left = map[chars[right]]!! + 1
                if (left >= chars.size) {
                    break
                }
                map.clear()
                map[chars[left]] = left
                right = left + 1
            } else {
                map[chars[right]] = right
                right++
            }
            length = max(length, map.size)
        }
        return length
    }
}
