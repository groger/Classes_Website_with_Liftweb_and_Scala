package ca.polymtl.log4420
package snippet

import net.liftweb._
import util.Helpers._

import xml.NodeSeq

object Session
{
  def apply( session: model.Session, cheminement: model.Cheminement ): NodeSeq => NodeSeq =
  {
    ".cours" #> session.cours.map( cours => Cours( cours, cheminement ) ) &
    ".periode *" #> session.periode.toString &
    ".annee *" #> session.annee.toString &
    ".total-credits *" #> session.totalCredits.toString
  }

}
