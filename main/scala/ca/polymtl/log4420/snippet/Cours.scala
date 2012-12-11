package ca.polymtl.log4420
package snippet

import net.liftweb._
import http.js.JsCmds
import http.SHtml
import http.S
import util.CssSel
import util.Helpers._

import xml.{ Elem, NodeSeq }
import tools.nsc.io.Socket.Box

object Cours {

  def apply(cours: model.Cours, cheminement: model.Cheminement): NodeSeq => NodeSeq =
    {
      def Terminecours =
      {
        if(cheminement.EstTermine(cours))
        {
          cheminement.coursTermine= cheminement.coursTermine - cours
        }
        else{
          cheminement.coursTermine= cheminement.coursTermine + cours
        }

      }

      ".cours [id]" #> cours.sigle &
        ".sigle *" #> cours.sigle &
        ".titre *" #> cours.titre &
        ".credits *" #> cours.credit.toString &
        ".disponibilite" #> ("li *" #> cours.disponibilite.map(_.toString)) &
        ".pre-requis" #> ("li *" #> cours.prerequis.map(_.sigle)) &
        ".co-requis" #> ("li *" #> cours.corequis.map(_.sigle)) &
        ".triplet .theorie *" #> cours.triplet.theorie.toString &
        ".triplet .lab *" #> cours.triplet.lab.toString &
        ".ua .genie *" #> cours.ua.genie.toString &
        ".ua .conception *" #> cours.ua.conception.toString &
        ".ua .math *" #> cours.ua.math.toString &
        ".ua .science *" #> cours.ua.science.toString &
        ".ua .complementaire *" #> cours.ua.complementaire.toString &
        ".termine"  #> SHtml.onSubmitUnit(Terminecours _) &
        ".cours [class+] " #> {if(cheminement.EstTermine( cours )) "cours-terminer" else ""} &
        "#deplacer *" #> {
          val inventory = cours.allDispo(cheminement.sessions) // On aurait pu appeler cours.disponibilite non ?
          val options: List[(model.Session, String)] = inventory.map(i => (i, i.periode.toString() + i.annee.toString))
          val default = Some(inventory.head)
          SHtml.selectObj[model.Session](options, default, (xs: model.Session) => {
            
            cheminement.sessions.foreach(ses => {
              if(ses.cours.contains(cours))
                ses.cours = ses.cours.filterNot(_ == cours)
            })
            xs.moveCours(cours)
            println("Session " + xs.annee + " " + xs.periode)
            var url = S.request.map( _.uri ).openOr( "/" )
            S.redirectTo( url )
            
          })
        }

    }

}
