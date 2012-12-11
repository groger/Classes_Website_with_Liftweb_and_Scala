package ca.polymtl.log4420
package model

import annotation.tailrec

case class Cours( 
	sigle: String,
	var titre: String,
	triplet: Triplet,
  ua: UA,
  regles: Set[Regle]
)
{
  def credit = ( triplet.theorie + triplet.lab + triplet.individuel ) / 3

  // petit bug dans mon design de classe :(
  // deux dispo => on prend la première
  // une dispo => on la prend
  // aucune dispo => None
  @tailrec
  private def first[A](reglesf: Set[Regle])( func: PartialFunction[Regle,List[A]] ): List[A] =
  {
    if( reglesf.isEmpty ) Nil
    else
    {
      val r = reglesf.head
      if ( func.isDefinedAt(r) )
      {
        func(r)
      }
      else
      {
        first( reglesf.tail )( func )
      }
    }
  }

  def disponibilite: List[Periode] =
  {
    first(regles){ case Disponibilite( dispo ) => dispo.toList }
  }

  def corequis: List[Cours] =
  {
    first(regles){ case CoRequis( cours ) => cours.toList }
  }

  def prerequis: List[Cours] =
  {
    first(regles){ case PreRequis( cours ) => cours.toList }
  }

  def allDispo( sessions: List[Session] ): List[Session] = { val dispoCours = disponibilite.toSet

    for { session <- sessions if( dispoCours.contains( session.periode ) ) }
    yield session

  }


}

case class Triplet(
  var theorie: BigDecimal = 0,
  var lab: BigDecimal = 0,
  var individuel: BigDecimal = 0
)

case class UA(
  genie: BigDecimal = 0,
  conception: BigDecimal = 0,
  math: BigDecimal = 0,
  science: BigDecimal = 0,
  complementaire: BigDecimal = 0
)

sealed trait Regle
case class Disponibilite( periodes: Set[Periode] ) extends Regle
case class PreRequis( prerequis: Set[Cours] ) extends Regle
case class CoRequis( corequis: Set[Cours] ) extends Regle
case class MinCredits( min: BigDecimal ) extends Regle

sealed trait Periode
case object Hiver extends Periode
{
  override def toString = "Hiver"
}

case object Ete extends Periode
{
  override def toString = "Été"
}

case object Automne extends Periode
{
  override def toString = "Automne"
}