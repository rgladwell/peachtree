package me.gladwell.peachtree

import java.io.File
import java.io.StringReader
import java.io.StringWriter
import java.io.Writer
import scala.io.Source
import org.monkey.mustache._
import java.io.BufferedReader
import org.yaml.snakeyaml.Yaml

trait MustachePageModule extends PageModule {

  class Template (
    val frontMatter: Map[String, String],
    val content: String
  )

  private def parseMustacheTemplate(source: Source): Template = {
    def isDeliminator(line: String): Boolean = {
      "(^[-]{3,}$)".r.pattern.matcher(line).matches()
    }

    val lines = source.getLines
    var line = lines.next
    while (line.isEmpty) line = lines.next
    if (!isDeliminator(line)) {
      throw new IllegalArgumentException("No YAML Front Matter");
    }

    val sb = new StringBuilder();
    line = lines.next
    while (!isDeliminator(line)) {
        sb.append(line);
        sb.append("\n");
        line = lines.next
    }

    new Template(frontMatter = parseYamlFrontMatter(sb.toString), content = new Mustache(source)(Dictionary()))
  }

  private def parseYamlFrontMatter(yaml: String): Map[String,String] = {
    import scala.collection.JavaConversions._
    val yamlLoader = new Yaml
    yamlLoader.load(yaml) match {
      case map: java.util.Map[String, String] => map.toMap
      case _ => throw new ClassCastException
    }
  }

  class MustachePage(private val template: Template) extends Page {
    def content = template.content
    def layout = Some(template.frontMatter("layout"))
  }

  class MustachePageLoader extends PageLoader {
    def load(source: Source) = new MustachePage(parseMustacheTemplate(source))
  }

  def validPage(file: File): Boolean = file.getName().endsWith(".mustache")

  def pageLoader = new MustachePageLoader

}
