// @author Soto Setzke, David
// @author Menhorn, Friedrich
require(
["app/afficher",
"app/basic",
"app/deplacer",
"app/terminer",
"app/dragndrop"],

  function(afficher, basic, deplacer, terminer, dragndrop){
        
	$('select[name="sigle"]').change(function () {
		var li = $(this).closest('li.session');
		var coursName = $(this).find(':selected').text();
		if (!basic.isAvailable(coursName, li))
			$(this).closest('li.cours-options').addClass('wrong-session');
		else
			$(this).closest('li.cours-options').removeClass('wrong-session');
	});

	dragndrop.activer();
	
	$('li.cours').mouseover(function(evt) {
		if ($(this).attr('id'))
			afficher.afficher(this.id, false);
		else if (!$(this).hasClass('cours-options')) {
			var id = $('span.sigle', $(this)).text().trim();
			afficher.afficher(id, true);
		}
	});
	
	$('select[name="sigle"]').mouseover(function (evt) {
		var selected = $(this).find(':selected').text();
		if (selected)
			afficher.afficher(selected, false);
	});
	
	$('li.cours').mouseout(function(evt) {
		afficher.effacer(this.id);
	});
    
});