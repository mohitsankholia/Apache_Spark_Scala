package scala.spark

import org.apache.spark._
import org.apache.log4j._

/**
 * @author Mohit Sankholia 
 *         on 09/01/23
 */
object WordCount {

  def main(args: Array[String]) {

    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)

    // Create a SparkContext using every core of the local machine
    val sc = new SparkContext("local[*]", "WordCount")

    // Read each line of my book into an RDD
    val input = sc.textFile("data/book.txt")

    // Split into words separated by a space character
    val words = input.flatMap(x => x.split(" "))

    // Count up the occurrences of each word
    val wordCounts = words.countByValue()

    // Print the results.
    wordCounts.foreach(println)
  }

}
