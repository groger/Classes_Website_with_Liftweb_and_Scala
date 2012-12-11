package ca.polymtl.log4420
package fixture

import model.{ Annee, ComiteProgramme, Cheminement }

object ProgrammeDB {
  var idCounter = 0

  def multimedia = ProgrammePoly.logicielMultimedia2009

  val cheminements = collection.mutable.Map.empty[Int, Cheminement]
  val programmes = collection.mutable.Map.empty[ComiteProgramme, List[Cheminement]]

  def getAllProgrammes =
    {
      programmes
    }

  def get(id: Int) =
    {
      cheminements.get(id)
    }

  def find(comite: ComiteProgramme, titre: String, annee: Annee): Option[Cheminement] =
    {
      // on va chercher tous les cheminements qui respecte cette condition
      val res = cheminements.values.filter(cheminement =>
        (cheminement.titre == titre) &&
          (cheminement.owner == comite) &&
          (cheminement.sessions match {
            case head :: rest if head.annee == annee => true
            case _ => false
          }))

      // on s'attend à un seul cheminement pour cette ressource
      if (res.size == 1) Some(res.head)
      else if (res.size == 0) {
        println("Ce cheminement n'existe pas")
        None
      } else {
        val ressourcesIdentique = res.map(_.toString).mkString
        println("Plusieurs cheminement pour une seule ressource " + ressourcesIdentique)
        None
      }
    }

  def add(cheminement: Cheminement) {
    cheminement.owner match {

      // Ajoute un nouveau programme de génie ( cheminement d'un comité de programme )

      case comite @ ComiteProgramme(_) => {

        val programme = programmes.getOrElse(comite, List.empty[Cheminement])
        programmes(comite) = cheminement :: programme
      }

      case _ => // Rien
    }

    cheminement.id = idCounter
    cheminements(idCounter) = cheminement

    idCounter += 1
  }

  def reset() {
    cheminements.clear()
    programmes.clear()

    add(ProgrammePoly.logicielMultimedia2009)
    add(ProgrammePoly.logicielSecuriteMobilite2009)
    add(ProgrammePoly.logicielSecuriteMobilite2010)
    add(ProgrammePoly.logicielSecuriteMobilite2011)
    add(ProgrammePoly.logicielClassique2009)
    add(ProgrammePoly.logicielClassique2010)
    add(ProgrammePoly.logicielClassique2011)

  }

  reset()
}