import scala.util.matching.Regex

package Querry {
  object Count {
    def countQueriesWithDate(
        parsedFile: Iterator[Array[String]],
        date: String
    ): Int = {
      val filteredByDate =
        parsedFile.filter(queryDate => queryDate(0).startsWith(date)).map(_(1))

    return filteredByDate.distinct.length
    }

  }
}
