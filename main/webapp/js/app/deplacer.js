// @author Soto Setzke, David
// @author Menhorn, Friedrich
define(['./basic'], function(basic) {
	return {
		deplacer: function (coursLi, newSession) {
			var strArray = newSession.split(" ");
			var session = strArray[0];
			var year = strArray[1];
			var newSessionLi = basic.getSessionLi(session, year);
			$('ul:firstChild', newSessionLi).append(coursLi);
		}
	};
});
