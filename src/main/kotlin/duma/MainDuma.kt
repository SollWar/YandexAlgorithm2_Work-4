package duma

import java.io.File

fun main() {
    val votes = mutableMapOf<String, Double>() // Партии и их голоса
    var allCount = 0 // Всего голосов
    File("input.txt").forEachLine {
        val input = it.split(" ")
        val buffer = StringBuffer()
        val count = input[input.size - 1].toDouble()
        for (i in 0..input.size - 2) {
            buffer.append(input[i] + " ")
        }
        votes += buffer.toString() to count
        allCount += count.toInt()
    }
    var total = 0 // Всего мест после первого раунда
    val quotient = allCount / 450.00 // Первое избирательное частное
    for (i in votes) { // Меняем кол-во голосов на кол-во полученных мест
        i.setValue(i.value/quotient)
        total += i.value.toInt()
    }
    var freeVotes = 450 - total // Свободных мест
    val voteSort = mutableListOf<Pair<String, Double>>() // Лист для сортировки дробных частей
    if (freeVotes != 0) {
        for (i in votes) {
            voteSort.add(i.key to (i.value - i.value.toInt())) // Сохраняем в лист дробные части
        }
    }
    voteSort.sortWith(compareBy<Pair<String, Double>>() {it.second}.reversed()) // Сортируем

    while (freeVotes != 0) { // Добавляем недостающие голоса
        for (i in voteSort) {
            votes += i.first to (votes.getValue(i.first) + 1)
            freeVotes --
            if (freeVotes == 0) break
        }
    }

    for (i in votes) {
        println("${i.key}${i.value.toInt()}") // Выводим только целую часть
    }
}