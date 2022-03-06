package forum

fun main() {
    val n = readLine()!!.toInt()
    val message = mutableListOf<Pair<Int, String>>() // Список сообщений сключая темы с кодом и текстом
    val topic = mutableMapOf<String, Int>() // Список тем и кол-во сообщений в них
    message.add(-1 to "") // Что-бы нумерация шла с 1, а не с 0
    repeat(n) {
        val cod = readLine()!!.toInt()
        val str = readLine()!!
        if (cod == 0) {
            readLine() // Пропус строки с сообщением темы (По задаче не используется)
            topic += str to -1 // -1 потому-что рекурсивная функция считает тему как своё-же сообщение
        }
        message.add(cod to str)
    }
    for (i in 1..n) {
        recurs(i, message, topic) // Запуск рекурсивной функции
    }
    var max = 0
    var maxTopic = ""
    for (i in topic) { // Поиск самой популярной темы
        if (max < i.value) {
            max = i.value
            maxTopic = i.key
        }
    }
    println(maxTopic)
}

/**
 * Рекурсивная функция, идёт по сообщениям пока не находи тему, тогда увеличивает её счётчик на 1
 */
fun recurs(pos: Int, message: MutableList<Pair<Int, String>>, topic: MutableMap<String, Int>) {
    if (message[pos].first != 0) {
        recurs(message[pos].first, message, topic)
    } else if (message[pos].first == 0) {
        topic += message[pos].second to (topic.getValue(message[pos].second) + 1)
    }
}