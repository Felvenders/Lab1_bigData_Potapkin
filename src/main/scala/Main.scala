import scala.io.StdIn

/**
 * Lab1_Potapkin
 *
 * @author Danila Potapkin
 * @since 15.11.2024
 */

/**
 * 10. Распечатайте 5 самых длинных слов из текста.
 */
  object Main extends App {
    private def findLongestWords(text: String, count: Int = 5): List[String] = {
      text
        .split("\\s+")
        .map(_.replaceAll("[^a-zA-Zа-яА-Я]", ""))
        .filter(_.nonEmpty)
        .distinct
        .sortBy(-_.length)
        .take(count)
        .toList
    }

    private val defaultText =
      """Длинные тексты (лонгриды), где большой объем сочетается с глубоким погружением в тему, становятся все
        |более популярными в печатных и онлайновых изданиях, так как позволяют изданию выделиться из информационного
        |шума. Цели исследования – выявить распространенность лонгридов в российских СМИ и содержательные и
        |композиционные особенности этих текстов. Исследование включает мониторинг публикаций в центральных российских
        |изданиях и последующий контент-анализ 10 материалов из 10 печатных и онлайновых изданий. Выводы
        |исследования: лонгриды присутствуют в изданиях разных типов: от ежедневных газет − до нишевых новостных
        |сайтов. Они посвящены, как правило, описанию нового явления; имеют объем от 2 до 4 тыс. слов и построены по
        |композиционной схеме чередования примеров и обобщений.""".stripMargin

    println("Введите свой текст, или нажмите Enter для использования текста по умолчанию:")
    private val userInput = StdIn.readLine()
    val text = if (userInput.nonEmpty) userInput else defaultText

    private val longestWords = findLongestWords(text)

    println(s"${longestWords.length} самых длинных слов:")
    longestWords.zipWithIndex.foreach { case (word, index) =>
      println(s"${index + 1}: $word")
    }
}
