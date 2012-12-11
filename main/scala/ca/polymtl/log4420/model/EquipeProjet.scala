package ca.polymtl.log4420.model

case class Membre( firstName: String, lastName: String, email: String )

object EquipeProjet
{
  val members = List(
    Membre("Alexandre","Lision","alexandre.lision@polymtl.ca"),
    Membre("Alexandre","Lision","alexandre.lision@polymtl.ca")
  )
}