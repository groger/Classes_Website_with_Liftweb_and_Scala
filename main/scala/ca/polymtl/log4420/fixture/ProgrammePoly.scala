package ca.polymtl.log4420
package fixture

import model._

object ProgrammePoly
{
	val INF1005C = 
    Cours(
    	"INF1005C",
    	"Programmation procédurale",
    	Triplet( 3, 3, 3 ),
    	UA( 2, 1 ),
    	Set( 
    		Disponibilite( Set( Automne, Hiver, Ete ) )
    	)
    )

    val INF1500 = 
    Cours(
    	"INF1500",
    	"Logique des systèmes numériques",
    	Triplet( 3, 1.5, 4.5),
    	UA( 0.5, 0, 1.5, 1, 0 ),
    	Set( 
    		Disponibilite( Set( Automne, Hiver ) )
    	)
    )

    val MTH1101 = 
    Cours(
    	"MTH1101",
    	"Calcul I",
    	Triplet( 2, 2, 2),
    	UA( 0, 0, 2 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver, Ete ) )
    	)
    )

    val MTH1006 = 
    Cours(
    	"MTH1006",
    	"Algèbre linéaire",
    	Triplet( 2, 2, 2 ),
    	UA( 0, 0, 2 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver, Ete ) )
    	)
    )

    val LOG3005I =
    Cours(
    	"LOG3005I",
    	"Épreuves initiales de communication",
    	Triplet( ),
    	UA( ),
    	Set(
			Disponibilite( Set( Automne, Hiver ) )
    	)
    )

    val INF1040 =
    Cours(
    	"INF1040",
    	"Introduction à l'ingénierie informatique",
    	Triplet( 3, 3, 3 ),
    	UA( 0, 0, 1.5, 0, 1.5 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver ) )
    	)

    )

    val INF1010 =
    Cours(
    	"INF1010",
    	"Programmation orientée objet",
    	Triplet( 3, 3, 3 ),
    	UA( 2, 1 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver ) ),
    		PreRequis( Set( INF1005C ) )
    	)
    )

    val LOG1000 =
    Cours(
    	"LOG1000",
    	"Ingénierie logicielle",
    	Triplet( 3, 1.5, 4.5 ),
    	UA( 2, 1 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver ) ),
    		PreRequis( Set( INF1005C ) )
    	)
    )

    val INF1600 =
    Cours(
    	"INF1600",
    	"Architecture des micro-ordinateurs",
    	Triplet( 3, 1.5, 4.5 ),
    	UA( 2, 1 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver ) ),
    		PreRequis( Set( INF1005C, INF1500 ))
    	)
    )

    val MTH1102 =
    Cours(
    	"MTH1102",
    	"Calcul II",
    	Triplet( 2, 2, 2 ),
    	UA( 0, 0, 2 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver, Ete ) ),
    		PreRequis( Set( MTH1101 ) ),
    		CoRequis( Set( MTH1006 ) )
    	)
    )

    val INF1995 =
    Cours(
    	"INF1995",
    	"Projet initial ingénierie informatique, travail en équipe",
    	Triplet( 1.5, 6, 4.5 ),
    	UA( 0, 0, 2, 0.5, 1.5 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver ) ),
    		PreRequis( Set( INF1040 ) ),
    		CoRequis( Set( INF1600, LOG1000 ) )
    	)
    )

    val LOG2810 =
    Cours(
      "LOG2810",
      "Structures discrètes",
      Triplet( 3, 2, 4 ),
      UA( 1.5, 1.5 ),
      Set(
        Disponibilite( Set( Automne, Hiver ) )
      )
    )

    val INF2010 =
    Cours(
    	"INF2010",
    	"Structures de données et algorithmes",
    	Triplet( 3, 1.5, 4.5 ),
    	UA( 1.5, 1.5 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver ) ),
    		PreRequis( Set( INF1010 ) ),
    		CoRequis( Set( LOG2810, LOG1000 ) )
    	)
    )

    val LOG2410 =
    Cours(
    	"LOG2410",
    	"Conception logicielle",
    	Triplet( 3, 1.5, 4.5 ),
    	UA( 1, 2 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver ) ),
    		PreRequis( Set( INF1010, LOG1000 ) )
    	)
    )

    val LOG2420 = 
    Cours(
    	"LOG2420",
    	"Analyse et conception des interfaces utilisateurs",
    	Triplet( 3, 1.5, 4.5 ),
    	UA( 1.5, 1.5 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver ) ),
    		CoRequis( Set( INF2010 ) )
    	)
    )

    val MTH2302D =
    Cours(
    	"MTH2302D",
    	"Probabilités et statistique",
    	Triplet( 4, 2, 3 ),
    	UA( 0, 0, 3 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver ) ),
    		CoRequis( Set( MTH1101 ) )
    	)
    )

    val INF2705 =
    Cours(
    	"INF2705",
    	"Infographie",
    	Triplet( 3, 3, 3 ),
    	UA( 1.5, 1.5 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver ) ),
    		PreRequis( Set( INF2010, MTH1006 ) )
    	)
    )

    val INF2610 =
    Cours(
    	"INF2610",
    	"Noyau d'un système d'exploitation",
    	Triplet( 3, 1.5, 4.5 ),
    	UA( 2, 1 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver ) ),
    		PreRequis( Set( INF1010, INF1600 ) )
    	)
    )

    val GCH1520 =
    Cours(
    	"GCH1520",
    	"Génie du vivant",
    	Triplet( 3, 1.5, 4.5 ),
    	UA( 1, 0, 0, 2 ),
    	Set( 
    		Disponibilite( Set( Automne, Hiver ) ) 
    	)
    )

    val INF2990 =
    Cours(
    	"INF2990",
    	"Projet de logiciel graphique interactif",
    	Triplet( 1.5, 6, 4.5 ),
    	UA( 1, 2.5, 0, 0, 0.5 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver ) ),
    		PreRequis( Set( INF1995, INF2010, LOG2410 ) ),
    		CoRequis( Set( INF2705 ) ) // INF2705 ou LOG2420
    	)
    )

    val INF3710 =
    Cours(
    	"INF3710",
    	"Fichiers et bases de données",
    	Triplet( 3, 1.5, 4.5 ),
    	UA( 1.5, 1.5 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver, Ete ) ),
    		PreRequis( Set( INF2010 ) ),
    		CoRequis( Set( INF2610 ) )
    	)
    )

    val MTH1115 = 
    Cours( 
    	"MTH1115",
    	"Équations différentielles",
    	Triplet( 3, 2, 4 ),
    	UA( 0, 0, 3 ),
    	Set(
    		Disponibilite( Set( Automne, Hiver, Ete ) ),
    		PreRequis( Set( MTH1006, MTH1101 ) )
    	)
	)

	val LOG3430 =
	Cours(
		"LOG3430",
		"Méthodes de test et de validation du logiciel",
		Triplet( 3, 1.5, 4.5 ),
		UA( 1, 2 ),
		Set(
			Disponibilite( Set( Automne, Hiver ) ),
			PreRequis( Set( LOG1000, LOG2810, MTH2302D ) )
		)
	)

	val INF3405 =
	Cours(
		"INF3405",
		"Réseaux informatiques",
		Triplet( 3, 1.5, 4.5 ),
		UA( 2, 1 ),
		Set(
			Disponibilite( Set( Automne, Hiver, Ete ) ),
			CoRequis( Set( MTH2302D ) )
		)
	)

	val PHS1101 = 
	Cours(
		"PHS1101",
		"Mécanique pour ingénieurs",
		Triplet( 2, 2, 5 ),
		UA( 2.25, 0.75 ),
		Set(
			Disponibilite( Set( Automne, Hiver, Ete ) )
		)
	)

	val SSH5201 =
	Cours(
		"SSH5201",
		"Économique de l'ingénieur",
		Triplet( 3, 1.5, 4.5 ),
		UA( 0, 0, 0, 0, 3 ),
		Set(
			Disponibilite( Set( Automne, Hiver, Ete ) ),
			MinCredits( 27 )
		)
	)

	val MTH2210A =
	Cours(
		"MTH2210A",
		"Calcul scientifique pour ingénieurs",
		Triplet( 3, 3, 3 ),
		UA( 0, 0, 3 ),
		Set(
			Disponibilite( Set( Automne, Hiver, Ete ) ),
			PreRequis( Set( MTH1115 ) ),
			CoRequis( Set( INF1005C ) )
		)
	)

	val SSH5501 =
	Cours(
		"SSH5501",
		"Éthique appliquée à l'ingénierie",
		Triplet( 3, 0, 3 ),
		UA( 0, 0, 0, 0, 2 ),
		Set(
			Disponibilite( Set( Automne, Hiver, Ete ) ),
			MinCredits( 27 )
		)
	)

	val LOG3210 =
	Cours(
		"LOG3210",
		"Éléments de langages et compilateurs",
		Triplet( 3, 1.5, 4.5 ),
		UA( 1.5, 1, 0.5 ),
		Set(
			Disponibilite( Set( Automne, Hiver ) ),
			PreRequis( Set( LOG1000, LOG2810, INF2010 ) )
		)
	)

	val LOG3000 =
	Cours(
		"LOG3000",
		"Processus du génie logiciel",
		Triplet( 3, 1.5, 4.5 ),
		UA( 2, 1 ),
		Set(
			Disponibilite( Set( Automne, Hiver ) ),
			PreRequis( Set( INF2990 ) )
		)
	)

	val LOG3005 = 
	Cours(
		"LOG3005",
		"Communication écrite et orale",
		Triplet( 0.5, 0, 2.5 ),
		UA( 0, 0, 0, 0, 1 ),
		Set(
			Disponibilite( Set( Automne, Hiver ) )
		)
	)

	val LOG3900 =
	Cours(
		"LOG3900",
		"Projet d'évolution d'un logiciel",
		Triplet( 1.5, 6, 4.5 ),
		UA( 3.5, 0.5 ),
		Set(
			Disponibilite( Set( Automne, Hiver ) ),
			PreRequis( Set( INF2990 ) ),
			CoRequis( Set( LOG3000, LOG3005 ) )
		)
	)

	val PHS4700 = 
	Cours(
		"PHS4700",
		"Physique pour multimédia",
		Triplet( 3, 0, 6 ),
		UA( 2, 1 ),
		Set(
			Disponibilite( Set( Automne ) ),
			PreRequis( Set( MTH2210A ) )
		)
	)

	val INF4710 =
	Cours(
		"INF4710",
		"Introduction aux technologies multimedia",
		Triplet( 3, 1.5, 4.5 ),
		UA( 2.25, 0.75 ),
		Set(
			Disponibilite( Set( Automne ) ),
			PreRequis( Set( INF1010 ) )
		)
	)

	val INF4725 =
	Cours(
		"INF4725",
		"Traitement de signaux et d'images",
		Triplet( 3, 1.5, 4.5 ),
		UA( 2.25, 0, 0.75 ),
		Set(
			Disponibilite( Set( Automne ) ),
			PreRequis( Set( INF1005C, MTH1102 ) )
		)
	)

	val LOG3410 =
	Cours(
		"LOG3410",
		"Exigences et spécifications du logiciel",
		Triplet( 3, 1.5, 4.5 ),
		UA( 2, 1 ),
		Set(
			Disponibilite( Set( Automne ) ),
			PreRequis( Set( INF2990 ) )
		)
	)

	val INF4715 =
	Cours(
		"INF4715",
		"Ingénierie des applications multimédia interactives",
		Triplet( 2, 3, 4 ),
		UA( 1, 2 ),
		Set(
			Disponibilite( Set( Hiver ) ),
			PreRequis( Set( INF2705 ) )
		)
	)

	/* Début des cours à option multimedia */

	val INF4402 =
	Cours( 
		"INF4402",
		"Systèmes répartis sur Internet",
		Triplet( 3, 1.5, 4.5 ),
		UA( 2, 1 ),
		Set(
			Disponibilite( Set( Automne ) ),
			PreRequis( Set( INF3405 ) )
		)
	)

	val INF4730 =
	Cours(
		"INF4730",
		"Systèmes parallèles",
		Triplet( 3, 1.5, 4.5 ),
		UA( 2, 1 ),
		Set( 
			Disponibilite( Set( Automne ) ),
			PreRequis( Set( INF2610 ) )
		)
	)

	val LOG4420 =
	Cours(
		"LOG4420",
		"Conception de sites web dynamiques et transactionnels",
		Triplet( 3, 1.5, 4.5 ),
		UA( 1.5, 1.5 ),
		Set(
			Disponibilite( Set( Automne ) ),
			PreRequis( Set( INF3710 ) ),
			MinCredits( 60 )
		)
	)

	val INF8702 =
	Cours(
		"INF8702",
		"Infographie avancée",
		Triplet( 3, 3, 3 ),
		UA( 1.5, 1, 0.5 ),
		Set(
			Disponibilite( Set( Automne ) ),
			PreRequis( Set( INF2705 ) )
		)
	)

	val INF4215 =
	Cours(
		"INF4215",
		"Introduction à l'intelligence artificielle",
		Triplet( 3, 1.5, 4.5 ),
		UA( 1.5, 1.5 ),
		Set(
			Disponibilite( Set( Hiver ) ),
			PreRequis( Set( LOG2810, MTH2302D ) )
		)
	)

	val INF4405 =
	Cours(
		"INF4405",
		"Informatiques mobile",
		Triplet( 3, 1.5, 4.5 ),
		UA( 2, 1 ),
		Set(
			Disponibilite( Set( Hiver ) ),
			PreRequis( Set( INF3405 ) )
		)
	)

	val INF4420A =
	Cours(
		"INF4420A",
		"Sécurité informatique",
		Triplet( 3, 1.5, 4.5 ),
		UA( 2, 0.5, 0, 0, 0.5 ),
		Set(
			Disponibilite( Set( Automne, Hiver ) ),
			PreRequis( Set( INF2610, INF3405 ) )
		)
	)

	val LOG4430 =
	Cours(
		"LOG4430",
		"Architecture logicielle et conception avancée",
		Triplet( 3, 1.5, 4.5 ),
		UA( 1, 2 ),
		Set(
			Disponibilite( Set( Automne, Hiver ) ),
			PreRequis( Set( LOG2410 ) )
		)
	)

	val SSH5100A =
	Cours(
		"SSH5100A",
		"Sociologie de la technologie",
		Triplet( 3, 0, 6 ),
		UA( 0, 0, 0, 0, 3 ),
		Set(
			Disponibilite( Set( Automne, Hiver, Ete ) ),
			MinCredits( 30 )
		)
	)

	val SSH5100B =
	Cours(
		"SSH5100B",
		"Sociologie de la technologie",
		Triplet( 3, 0, 6 ),
		UA( 0, 0, 0, 0, 3 ),
		Set(
			Disponibilite( Set( Automne, Hiver, Ete ) ),
			MinCredits( 30 )
		)
	)

	val SSH5100C =
	Cours(
		"SSH5100C",
		"Sociologie de la technologie",
		Triplet( 3, 0, 6 ),
		UA( 0, 0, 0, 0, 3 ),
		Set(
			Disponibilite( Set( Automne, Hiver, Ete ) ),
			MinCredits( 30 )
		)
	)

	val LOG4910 =
	Cours(
		"LOG4910",
		"Projet intégrateur final en multimédia",
		Triplet( 1, 12, 5 ),
		UA( 0, 6 ),
		Set(
			Disponibilite( Set( Automne, Hiver ) ),
			PreRequis( Set( LOG3900 ) ),
			MinCredits( 85 )
		)
	)

	val ING4901 =
	Cours(
		"ING4901",
		"Projet intégrateur en développement durable",
		Triplet( 1, 9, 8 ),
		UA( 0, 6 ),
		Set(
			Disponibilite( Set( Automne, Hiver ) ),
			PreRequis( Set( LOG3900 ) )
		)
	)

  // Génie logiciel
  val ComiteLogiciel = ComiteProgramme( "Logiciel" )
  val ComiteCivil = ComiteProgramme( "Civil" )

  // MULTIMEDIA
	val logicielMultimedia2009 =
	Cheminement(
		"Multimedia",
		ComiteLogiciel,
		List(
			Session( 
				Automne, Annee(2009),
				List( INF1005C, INF1500, MTH1101, MTH1006, LOG3005I, INF1040 )
			),
			Session(
				Hiver, Annee(2010),
				List( INF1010, LOG1000, INF1600, MTH1102, INF1995 )
			),
			Session(
				Ete, Annee(2010),
				Nil
			),
			Session(
				Automne, Annee(2010),
				List( INF2010, LOG2410, LOG2420, LOG2810, MTH2302D )
			),
			Session(
				Hiver, Annee(2011),
				List( INF2705, INF2610, GCH1520, INF2990, INF3710 )
			),
			Session(
				Ete, Annee(2011),
				Nil
			),
			Session(
				Automne, Annee(2011),
				List( MTH1115, LOG3430, INF3405, PHS1101, SSH5201 )
			),
			Session(
				Hiver, Annee(2012),
				List( MTH2210A, SSH5501, LOG3210, LOG3000, LOG3900 )
			),
			Session(
				Ete, Annee(2012),
				Nil
			),
			Session(
				Automne, Annee(2012),
				List( PHS4700, INF4710, INF4725, LOG4420, LOG3410 )
			),
			Session(
				Hiver, Annee(2013),
				List( INF4715, INF4215, LOG4910, SSH5100B, LOG4910 )
			)
		),
    Set()
	)

  // CLASSIQUE
  val logicielClassique2009 =
  Cheminement(
    "Classique",
    ComiteLogiciel,
    List( Session( Automne, Annee( 2009 ), Nil ) ),
    Set()
  )
  
  val logicielClassique2010 =
  Cheminement(
    "Classique",
    ComiteLogiciel,
    List( Session( Automne, Annee( 2010 ), Nil ) ),
    Set()
  )
  
  val logicielClassique2011 =
  Cheminement(
    "Classique",
    ComiteLogiciel,
    List( Session( Automne, Annee( 2011 ), Nil ) ),
    Set()
  )
  
  
// SECURITE MOBILITE
 val logicielSecuriteMobilite2009 =
 Cheminement(
  "SecuriteMobilite",
  ComiteLogiciel,
  List( Session( Automne, Annee( 2009 ), Nil ) ),
  Set()
 )
 
 val logicielSecuriteMobilite2010 =
 Cheminement(
  "SecuriteMobilite",
  ComiteLogiciel,
  List( Session( Automne, Annee( 2010 ), Nil ) ),
  Set()
 )
 
 val logicielSecuriteMobilite2011 =
 Cheminement(
  "SecuriteMobilite",
  ComiteLogiciel,
  List( Session( Automne, Annee( 2011 ), Nil ) ),
  Set()
 )
 
}