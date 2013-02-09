package me.gladwell.lanyon

class Site(val title: String, val pages: Seq[Page] = List(new Page(id = "index"))) {

}
