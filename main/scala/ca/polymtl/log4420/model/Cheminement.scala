package ca.polymtl.log4420
package model

import net.liftweb.util.BasicTypesHelpers.asInt
import fixture.ProgrammeDB

// extractor patern: http://www.artima.com/pins1ed/extractors.html
object Cheminements {

  def findByComite(params: List[String]): Option[Cheminement] =
    {
      params match {
        case comite :: titreChem :: anneeDebut :: Nil =>
          {
            for {
              a <- asInt(anneeDebut)
              cheminement <- ProgrammeDB.find(ComiteProgramme(comite), titreChem, Annee(a))
            } yield cheminement
          }
        case _ => None
      }
    }

  def findById(id: String): Option[Cheminement] =
    {
      for {
        i <- asInt(id)
        cheminement <- ProgrammeDB.get(i)
      } yield cheminement
    }

  def pathByComite(cheminement: Cheminement): List[String] =
    {
      (cheminement.owner, cheminement.titre, cheminement.sessions) match {
        case (ComiteProgramme(comite), titre, first :: others) =>
          {
            comite :: titre :: first.annee.annee.toString :: Nil
          }
        case _ => {
          println("bug")
          Nil
        }
      }
    }

  def pathById(cheminement: Cheminement): String =
    {
      cheminement.id.toString

    }

  def findCoursById(params: List[String]): Option[(Cheminement, Cours)] =
    {
      def findCoursInCheminement(cheminement: Cheminement, sigle: String) =
        {
          cheminement.sessions.flatMap(_.cours).find(_.sigle == sigle)
        }

      params match {
        case cheminementIdS :: coursSigle :: Nil => {
          for {
            cheminement <- findById(cheminementIdS)
            cours <- findCoursInCheminement(cheminement, coursSigle)
          } yield (cheminement, cours)
        }
        case _ => None
      }
    }


  def pathCoursById(params: (Cheminement, Cours)): List[String] =
    {
      val (cheminement, cours) = params

      pathById(cheminement) :: cours.sigle :: Nil
    }

}

case class Cheminement(
  var titre: String,
  owner: Usager,
  var sessions: List[Session],
  var coursTermine: Set[Cours],
  var id: Int = 0) {
  def ajoutSession() {
    if (sessions.last.periode.toString().contentEquals("Été"))
      sessions = sessions ::: List(model.Session(Automne, sessions.last.annee, Nil))
    else if (sessions.last.periode.toString().contentEquals("Hiver"))
      sessions = sessions ::: List(model.Session(Ete, sessions.last.annee, Nil))
    else
      sessions = sessions ::: List(model.Session(Hiver, Annee(Integer.parseInt(sessions.last.annee.toString)+1), Nil))
  }
  def EstTermine(cours:Cours): Boolean =
  {
    coursTermine.contains(cours)
  }

  def anneeDebut: Option[String] = sessions match {
    case a :: b => {
      Some(a.annee.toString)
    }
    case _ => None
  }

  override def toString = titre + " " + anneeDebut.getOrElse("")


}

case class Session(
  periode: Periode,
  annee: Annee,
  var cours: List[Cours]) {
  
  def moveCours(c: Cours) {
    cours = cours.::(c)
  }
  def totalCredits = cours.map(_.credit).sum
}

case class Annee(annee: Int) {
  override def toString = annee.toString
}

sealed trait Usager
case class Etudiant() extends Usager
case class ComiteProgramme(genie: String) extends Usager
