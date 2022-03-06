package tolyaKarp

fun main() {
    val n = readLine()!!.toInt()
    val pack = sortedMapOf<Long, Long>()
    repeat (n) {
        val input = readLine()!!.split(" ")
        pack += if (pack.containsKey(input[0].toLong())) {
            input[0].toLong() to (pack.getValue(input[0].toLong()) + input[1].toLong())
        } else {
            input[0].toLong() to input[1].toLong()
        }
    }
    for (it in pack) {
        print("${it.key} ${it.value}\n")
    }
}