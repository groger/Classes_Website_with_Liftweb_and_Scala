package ca.polymtl.log4420
package snippet

import net.liftweb._
import util.Helpers._

import xml.NodeSeq

object Programmes extends SnippetDB {
  def render: NodeSeq => NodeSeq =
    {
      //val programmesComite = CheminementInjector.DB.make.map( db => db.programmes ).openOr( throw new Error("cannot load db") )
      /*val cheminements = CheminementInjector.DB.make.map( db => db.cheminements.keys ).
      openOr( throw new Error("cannot load db") ) */

      /* ".programme *" #> programmes.map{ programme => {
      ".nom" #> programme.genie &
      ".concentration *" #> cheminement.titre
      }} */

      ".programme *" #> programmes.map { //comite est le genie, programmes est la liste des cheminements
        //on regroupe les cheminements par titre: un titre est une concentration mais on a plusieurs cheminements pour un meme titre, par exemple titre: classique on a les cheminements:classique2009, classique2010...
        case (comite, cheminement) => {
          ".nom" #> comite.genie &
            ".concentration *" #> cheminement.groupBy(_.titre).map {

              case (titre, programmesavecTitre) => {

                ".nomconcen" #> titre &
                  ".annee" #> programmesavecTitre.map { c =>
                    {
                      "a *" #> (c.anneeDebut) &
                      "a [href]" #> (Cheminement.menuComite.calcHref(c))
                        
                    }
                  }
                // "a [href]" #> Cheminement.comite.calcHref( cheminement )

                //donne acces à l'année de début

              }
            }
        }
      }

    }

}
