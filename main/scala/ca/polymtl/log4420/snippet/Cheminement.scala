package ca.polymtl.log4420
package snippet

// Lift
import net.liftweb._
import sitemap.Loc.Template
import sitemap.{*, Menu}
import http._
import util.Helpers._
import net.liftweb.http.SHtml
import xml.NodeSeq
import http.js.JsCmds
import net.liftweb.http.js.JsCmds
import util.Helpers._
import net.liftweb.http.js._
import JsCmds._
import scala.xml.Text
import http._
import util.Helpers._
import xml.NodeSeq
import ca.polymtl.log4420.fixture.ProgrammeDB


object Cheminement
{
  // permet de convertir un url dans un cheminement
	// https://github.com/MasseGuillaume/SEO-Friendly-Menu-Params
  // url: cheminement / comite / titre cheminement / annee debut


  // https://github.com/MasseGuillaume/SEO-Friendly-Menu-Params
  val menuComite = Menu.params[ model.Cheminement ](
    "CheminementComite",                                                                  // name
    "Cheminement Comité",                                                                 // link text
    model.Cheminements.findByComite _,
    model.Cheminements.pathByComite _                                                               // model => List[String]
  ) / "Cheminement" / * / * / * >> template                                               // url: Cheminement / Logiciel / Multimedia / 2009

  lazy val comite = menuComite.toLoc                                                      // loc to add in sitemap

  val menuCheminement = Menu.param[ model.Cheminement ](                                // ibid
    "Cheminement",
    "Cheminement",
    model.Cheminements.findById _,
    model.Cheminements.pathById _
  ) / "Cheminement" / * >> template                                                       // url: Cheminement / cheminement.hashcode

  lazy val cheminement = menuCheminement.toLoc

  lazy val template = Template( () => Templates ("Cheminement" ::Nil) openOr <b>template not found</b>)
}
class Cheminement( cheminement: model.Cheminement ) extends DispatchSnippet
{
  // pour eviter de faire de la reflexion dans le html
  // ( https://www.assembla.com/spaces/liftweb/wiki/More_on_Snippets )
  def dispatch = { case "render" => render }

  def render: NodeSeq => NodeSeq =
  {                                                                                      // when url is Cheminement / Logiciel / Multimedia / 2009
    ".addresse [href]" #> S.request.map( _.uri ) &                                       // showes Cheminement / Logiciel / Multimedia / 2009
    ".addresse2 [href]" #> ( "/Cheminement/" + cheminement.hashCode.toString ) &         // showes Cheminement / cheminement.hashcode
    ".session *" #> cheminement.sessions.map( session => Session( session, cheminement ) ) &
    "#ajout-session" #> SHtml.onSubmitUnit(() => {
      
      cheminement.ajoutSession()
      println("Ajout Session")
      var url = S.request.map( _.uri ).openOr( "/" )
      S.redirectTo( url )
    }) &
    "#cloner-cheminement" #> SHtml.onSubmitUnit(() => {
      System.out.println("cloner-cheminement");
      ProgrammeDB.add(cheminement)
      S.redirectTo( "/Cheminement/" + cheminement.id )
    })

    // ".ajouter-cours" #> ...
  }
  
  
}
