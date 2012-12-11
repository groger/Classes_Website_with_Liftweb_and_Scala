// @author Soto Setzke, David
// @author Menhorn, Friedrich
define(function() {

	// defines some basic helper functions
	
	return {
		// removes whitespaces from a string
		trim: function(str) {
			return str.replace(/^\s+|\s+$/g,"");
		},
	
		// returns a jquery li list with the specified session and year
		// session: session of the year, string
		// year: string
		// if year is empty, it will be ignored and all the sessions
		// with the same season will be returned
		getSessionLi: function(session, year) {
			var ftrim = this.trim;
			return $('li.session').filter(function (index) {
				var period = $('.periode', this);
				var annee = $('.annee', this);
				var bool1 = ftrim(period.html()) == ftrim(session)			;
				if (year !== "") {
					var bool2 = ftrim(annee.html()) == ftrim(year);
					return bool1 && bool2;
				}
				return bool1;
			});
		},
		
		// returns a jquery li element, corresponding to the given cours name
		// name: name of a cours to be returned, string
		getCoursForName: function(name) {
			var result = $('#'+name.replace(/^\s+|\s+$/g,""));
			if (result.length == 1)
				return result;
			else if (result.length === 0)
				return $('.cours').filter(function (index) {
					function ftrim(str) { return str.replace(/^\s+|\s+$/g,""); }
					var coursName = $('span.sigle', this).html();
					return ($(this).parent().hasClass('detail') && ftrim(name) == ftrim(coursName));
			});
		},

		getCoursForNameBackUp: function(name) {
			return $('.cours').filter(function (index) {
			function ftrim(str) { return str.replace(/^\s+|\s+$/g,""); }
				var coursName = $('span.sigle', this).html();
				return (ftrim(name) == ftrim(coursName));
			});
		},
		
		// returns a jquery list of li elements corresponding to courses which are prerequis of the specified cours
		// name: name of the course which prerequis should be returned, string
		getPrerequisForName: function(name) {
			var coursLi = this.getCoursForName(name);
			return $('.pre-requis', coursLi).children();
		},
		
		// returns a jquery list of li elements corresponding to courses which are corequis of the specified cours
		// name: name of the course which corequis should be returned, string
		getCorequisForName: function(name) {
			var coursLi = this.getCoursForName(name);
			return $('.co-requis', coursLi).children();
		},

		getCoCourses: function(coursName) {
			var isInList = function(name, list) {
				var result = false;
				list.each( function(i) {
						if ($(this).html() == name)
							result = true;
				} );
				return result;
			};
			var ftrim = basic.trim;
			var corequis = $(basic.getCorequisForName(coursName));
			var cocourses = $('.cours').filter( function(i) {
				var title = $('.sigle', this).text();
				return isInList(ftrim(title), corequis);
			});
			return cocourses;
		},
		
			// returns true if the two given courses are in the same session, false otherwise
			// cours1, cours2 : courses which should be checked, strings
		isCoursInSameSession: function(cours1, cours2) {
			var ftrim = this.trim;
			var getCFN = this.getCoursForName;
			function getSessName (coursName) {
				var sessionLi = getCFN(coursName).parent().parent();
				return ftrim($('.periode', sessionLi).text()).concat(ftrim($('.annee', sessionLi).text()));
			}
			var session1name = getSessName(cours1);
			var session2name = getSessName(cours2);
			return session1name == session2name;
		},
		
			// returns true if a given cours has not been finished yet
			// should be used as a filter function for cours lists
		isCoursNotFinished:  function (i) {
			if ($(this).attr('id'))
				return !($('input[type="checkbox"]', $(this)).is(':checked'));
			else
				return !($('input[type="checkbox"]', $(this).closest('.cours-options')).is(':checked'));
		},

			// returns true if, in the cheminement, coursToTrace is before coursName
			// coursName, coursToTraceName, name of the courses, strings
		isCoursBefore: function(coursName, coursToTraceName) {
			var cours1Option = this.isOptionCours(coursName);
			var cours2Option = this.isOptionCours(coursToTraceName);
			var ftrim = this.trim;
			var session = this.getCoursForName(coursName).closest('.session');
			var sessionToTrace = this.getCoursForName(coursToTraceName).closest('.session');
			var sessArr = [];
			sessArr["constSess"] = [];
			sessArr["traceSess"] = [];
			sessArr["constSess"]["periode"] = this.trim($('.periode', session).text());
			sessArr["constSess"]["year"] = this.trim($('.annee', session).text());
			sessArr["traceSess"]["periode"] = this.trim($('.periode', sessionToTrace).text());
			sessArr["traceSess"]["year"] = this.trim($('.annee', sessionToTrace).text());
			if (sessArr["constSess"]["year"] - sessArr["traceSess"]["year"] < 0)
				return false;
			if (sessArr["constSess"]["year"] - sessArr["traceSess"]["year"] > 0)
				return true;

			function periodeToInt(periode) {
				var result;
				switch (periode) {
					case "Hiver" : result = 0; break;
					case "Été" : result = 1; break;
					case "Automne" : result = 2; break;
				}
				return result;
			}

			return periodeToInt(sessArr["constSess"]["periode"]) - periodeToInt(sessArr["traceSess"]["periode"]) > 0;
		},

			// returns true if a given course is offered in a given session
			// coursName: name of the course, string
			// sessionLi: session, li element
		isAvailable: function(coursName, sessionLi) {
			var periode = this.trim($('span.periode', sessionLi).text());
			var cours = this.getCoursForName(coursName);
			var isIn = false;
			$('.disponibilite', cours).children().each( function(i, e) {
				if ($(e).text() == periode) isIn = true;
			});
			return isIn;
		},
		
			// returns true if cours1 is a subsequent of cours2
		isSubsequent: function(cours1Name, cours2Name) {
			var filterFunction = function (i) {
				return $(this).attr('id') == cours2Name;
			};
			var cours1 = this.getCoursForName(cours1Name);
			var cours2 = this.getCoursForName(cours2Name);
			var prequis = this.getPrequisForName(cours1Name);
			if (prequis.filter(filterFunction).length !== 0)
				return true;
			var corequis = this.getCorequisForName(cours1Name);
			return (corequis.filter(filterFunction).length !== 0);
		},
		
		isInList: function(name, list) {
			var result = false;
			list.each( function(i) {
					if ($(this).html() === name)
						result = true;
			} );
			return result;
		},
		
		// returns true if cours1 is a corequis of cours2
		isCorequis: function(cours1Name, cours2Name) {
			var ftrim = this.trim;
			var iil = this.isInList;
			var corequis = $(this.getCorequisForName(cours2Name));
			return corequis.filter(function (i,e) {
				return e.innerHTML.replace(/^\s+|\s+$/g,"") == cours1Name.replace(/^\s+|\s+$/g,"");
			}).length !== 0;
		},
		
		isPrerequis: function(cours1Name, cours2Name) {
			var ftrim = this.trim;
			var iil = this.isInList;
			var corequis = $(this.getPrerequisForName(cours2Name));
			return corequis.filter(function (i,e) {
				return e.innerHTML.replace(/^\s+|\s+$/g,"") == cours1Name.replace(/^\s+|\s+$/g,"");
			}).length !== 0;
		},
		
		isOptionCours: function(coursName) {
			return this.getCoursForName(coursName).parent().parent().hasClass('cours-options');
		}
	};
});
