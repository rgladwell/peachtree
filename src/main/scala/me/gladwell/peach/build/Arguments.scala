package me.gladwell.peach.build

private class Arguments(args: Seq[String]) {

  def quotedArgs: Seq[String] = args match {
    case Nil => args
    case _ => parseQuoted(args.toList)
  }

  private def parseQuoted(args: List[String]): List[String] = {
    val quoteStart = args.indexWhere(_.startsWith("\""))
    if(quoteStart == -1) args
    else {
      val quoteEnds = args.indexWhere(_.endsWith("\""))
      if(quoteEnds == -1) args
      else args.slice(0, quoteStart) ++
        (unquote(args.slice(quoteStart, quoteEnds + 1))
            :: parseQuoted(args.slice(quoteEnds + 1, args.length)))
    }
  }

  private def unquote(args: Seq[String]): String = (args mkString " ").drop(1).dropRight(1)

}
