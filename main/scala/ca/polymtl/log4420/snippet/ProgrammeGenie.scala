package ca.polymtl.log4420
package snippet

import fixture.ProgrammeDB

import net.liftweb._
import http.js.JsCmds
import util.Helpers._

import xml.NodeSeq
import http.{SHtml, DispatchSnippet}

object ProgrammeGenie  extends DispatchSnippet
{
  def dispatch = { case "render" => render }

  def render: NodeSeq => NodeSeq =
  {
    "button [onclick]" #> SHtml.ajaxInvoke( () => {
      println("hey")
      JsCmds.Alert("hey")
    })
  }
}
