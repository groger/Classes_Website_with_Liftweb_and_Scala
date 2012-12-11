package bootstrap.liftweb

import ca.polymtl.log4420.snippet.Cheminement
import net.liftweb._
import net.liftweb.http._
import net.liftweb.sitemap._

class Boot
{
  def boot()
  {
    LiftRules.addToPackages( "ca.polymtl.log4420" )


    val entries = List(

        Menu.i("Home") / "index",
        Menu.i("Programmes") / "Programmes",
        Menu.i("Équipe") / "Equipe",
        Menu.i("Designer Friendly") / "DesignerFriendly",
        Menu( Cheminement.comite ),                         // Cheminement / Logiciel / Multimedia / 2009
        Menu( Cheminement.cheminement )             // Cheminement / :hashCode / Cours / LOG1000
    )

    LiftRules.setSiteMap( SiteMap( entries : _* ) )

    LiftRules.early.append( _.setCharacterEncoding("UTF-8") )

    LiftRules.htmlProperties.default.set( (r: Req) =>
      new Html5Properties(r.userAgent)
    )
  }
}
