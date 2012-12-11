package ca.polymtl.log4420
package snippet

import net.liftweb._
import util.Helpers._
import sitemap.{*, Menu}
import http.{S, SHtml, Templates}
import sitemap.Loc.Template

import xml.NodeSeq

class ModifierCours( params: ( model.Cheminement, model.Cours ) )
{
  def modifier: NodeSeq => NodeSeq =
  {
    identity
  }
}

object ModifierCours
{
  val menuModifierCours = Menu.params[ ( model.Cheminement, model.Cours ) ](
    "ModifierCours",
    "Modifier Cours",
    model.Cheminements.findCoursById _,
    model.Cheminements.pathCoursById _
  ) / "Cheminement" / * / "Cours" / *  >> template

  lazy val cheminement = menuModifierCours.toLoc

  lazy val template = Template( () => Templates( "ModifierCours" :: Nil ) openOr <b>template not found</b> )
}
