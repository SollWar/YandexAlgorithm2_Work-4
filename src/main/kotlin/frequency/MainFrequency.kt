package frequency

import java.io.File

fun main() {
    val monsters = mutableListOf<Pair<Int, String>>()

    val map = hashMapOf<String, Int>()
    File("input.txt").forEachLine {
        val input = it.split(" ")
        for (i in input){
            map += if (map.containsKey(i)) {
                i to (map.getValue(i) + 1)
            } else {
                i to 1
            }
        }
    }
    for (i in map) {
        monsters.add((i.value) to (i.key))
    }
    val comparator = compareBy<Pair<Int, String>>() {it.first}.reversed().thenBy { it.second } // Сложная штука для сортировки
    monsters.sortWith(comparator)
    for (i in monsters) {
        println(i.second)
    }
}