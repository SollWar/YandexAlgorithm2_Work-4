package election

import java.io.File

fun main() {
    val map = sortedMapOf<String, Int>()
    File("input.txt").forEachLine {
        val input = it.split(" ")
        map += if (map.containsKey(input[0])) {
            input[0] to (map.getValue(input[0]) + input[1].toInt())
        } else {
            input[0] to input[1].toInt()
        }
    }

    for (it in map) {
        println("${it.key} ${it.value}")
    }
    /*
    for (i in map) {
        File("output.txt").writeText("${i.key} ${i.value}\n")
    }
    */
}
