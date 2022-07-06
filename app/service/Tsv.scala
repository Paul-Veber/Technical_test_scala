import scala.io.Source

package Tsv {

  import java.util.stream
  object Parse {
    def fileToIterator: Iterator[Array[String]] = {
      val stream = getClass.getResourceAsStream("/hn_logs.tsv")

      val tsvToIterator =
        Source
          .fromInputStream(stream)
          .getLines()
      val splitIterator = tsvToIterator
        .map(_.split("\t"))

      splitIterator
    }
  }
}
