// @author Soto Setzke, David
// @author Menhorn, Friedrich
define(['./basic'], function( basic) {
	return {
		
		afficher: function (coursName, unselectedOption) {
			this.getSubsequents(coursName, basic.isCoursNotFinished);
			var precourses = this.getPreCourses(coursName);
			var cocourses = this.getCoCourses(coursName);
			var resultSessions = this.getSessions(coursName);
			precourses.filter(basic.isCoursNotFinished).each(function (i, e) {
				if (unselectedOption || basic.isCoursBefore(coursName, $(e).attr('id')))
					$(e).addClass('prerequis');
				else
					$(e).addClass('mismatch');
			});
			cocourses.filter(basic.isCoursNotFinished).each(function (i,e) {
				var currCours = $(e).attr('id');
				if (unselectedOption || basic.isCoursInSameSession(coursName, currCours) || basic.isCoursBefore(coursName, currCours))
					$(e).addClass('corequis');
				else
					$(e).addClass('mismatch');
			});
			resultSessions.addClass('disponible');
		},
	
		effacer: function (coursName) {
			var liCourses = $('.cours');
			var liSessions = $('.session');
			liSessions.removeClass('disponible');
			liCourses.removeClass('prerequis');
			liCourses.removeClass('mismatch');
			liCourses.removeClass('corequis');
			liCourses.removeClass('subsequent');
		},
	
		isInList: function(name, list) {
			var result = false;
			list.each( function(i) {
				if ($(this).html() == name)
						result = true;
			} );
			return result;
		},
	
		getSessions: function(coursName) {
			var ftrim = basic.trim;
			var cours = basic.getCoursForName(coursName);
			var dispoSession = $('.disponibilite', cours).children();
			var string = "";
			dispoSession.each( function(i) {
				string = string + $(this).text() + ".";
			} );
			sessions = string.split(".");
			var resultSessions = $('.session').filter(function (i) {
				var name = $('.periode', this).html();
				var contains = false;
				for (i = 0; i < sessions.length; i++) {
					if (ftrim(sessions[i]) == ftrim(name))
						contains=true;
				}
				return contains;
			});
			return resultSessions;
		},
	
		getPreCourses: function (coursName) {
			var ftrim = basic.trim;
			var iil = this.isInList;
			var prerequis = $(basic.getPrerequisForName(coursName));
			var precourses = $('.cours').filter( function(i) {
				var title = $('.sigle', this).text();
				return iil(ftrim(title), prerequis);
			});
			return precourses;
		},
	
		getCoCourses: function(coursName) {
			var ftrim = basic.trim;
			var iil = this.isInList;
			var corequis = $(basic.getCorequisForName(coursName));
			var cocourses = $('.cours').filter( function(i) {
				var title = $('.sigle', this).text();
				return iil(ftrim(title), corequis);
			});
			return cocourses;
		},

		
		getSubsequents: function(coursName, filterFunc) {
			$('.cours').filter(filterFunc).each( function(i, e) {
				$('.pre-requis, .co-requis', $(e)).children().each( function(i, e) {
					if ($(e).text().trim() == coursName) {
						var id = 0;
						var li = 1;
						var obj = [];
						// checks whether cours is an option cours
						if ($(e).parent().parent().attr('id')) {
							obj[id] = $(e).parent().parent().attr('id');
							obj[li] = basic.getCoursForName(obj[id]);
						}
						else {
							// the li is an option cours and we have to get
							// the selected option in order to get the id
							var sigle = $('.sigle', $(e).parent().parent()).text().trim();
							if ($('select[name="sigle"]', $(e).closest('.cours-options')).find(':selected').text() == sigle) {
								obj[id] = sigle;
								obj[li] = $(e).closest('.cours-options');
							}
							else
								return 0;
						}
						// check for rule violation
						if (basic.isCorequis(coursName, obj[id]) && !(basic.isCoursBefore(obj[id], coursName)) && !(basic.isCoursInSameSession(obj[id], coursName)))
							obj[li].addClass('mismatch');
						else if (basic.isPrerequis(coursName, obj[id]) && !(basic.isCoursBefore(obj[id], coursName)))
							obj[li].addClass('mismatch');
						else
							obj[li].addClass('subsequent');
					}
				});
			});
		}
	};
});
