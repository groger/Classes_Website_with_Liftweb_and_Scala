package ca.polymtl.log4420
package snippet

import model.EquipeProjet

import net.liftweb._
import http.DispatchSnippet
import util.Helpers._ 

import widgets.Gravatar 

object Equipe extends DispatchSnippet
{
	override def dispatch = 
	{
		case "render" => render
	}

	def render = 
	{
		".member *" #> EquipeProjet.members.map { member =>
			".gravatar" #> Gravatar( member.email, 50 ) &
			".firstname *" #> member.firstName &
			".lastname *" #> member.lastName
		}
	}
}