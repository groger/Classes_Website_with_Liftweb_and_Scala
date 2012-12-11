// @author Soto Setzke, David
// @author Menhorn, Friedrich
define(['./basic'], function(basic) {

	return {
		activer: function () {
			var removeNonId = function (i,e) { return $(e).attr('id'); };
		
			$('li.cours').filter(removeNonId).attr('draggable', true);
			$('li.cours-options').attr('draggable', true);

			$('li.cours').bind('dragstart', function(event) {
				event.originalEvent.dataTransfer.setData("text/plain", event.target.getAttribute('id'));
				console.log('dragstart, id: '+event.target.getAttribute('id'));
			});
			
			$('li.cours-options').bind('dragstart', function(event) {
				var titleFirstCours = $('span.sigle', $('li.cours', $(event.target)).get(0)).html().replace(/^\s+|\s+$/g,"");
				event.originalEvent.dataTransfer.setData("text/plain", titleFirstCours);
			});
		  
			$('li.session').bind('dragover', function(event) {
				event.preventDefault();
			});
		  
		  	$('li.session').bind('drop', function(event) {
				var id = event.originalEvent.dataTransfer.getData("text/plain");
				var toAppend = $('#'+id);
				if ($(toAppend).length!=0) {
					var ul = event.target;
					while (!($(ul).hasClass('session'))) {
						   ul = ul.parentNode;
					}

					if (basic.isAvailable(id, ul)) {
					$('ul.liste-cours', ul).append(document.getElementById(id));

                        var per = $(ul).children('.periode').text();
                        var ann = $(ul).children('.annee').text();
                        var sess = per+ann;
                        toAppend.find('#deplacer select option').attr('selected',false);
                        toAppend.find('#deplacer select option').filter(function() {
                        return $(this).text() == sess;
                        }).attr('selected',true);

                        toAppend.find('#form-deplacer').submit() ;


					}
					event.preventDefault(); 
				}
				else {
					var result = $('li.cours-options').filter(function(i,e) {
						var currTitle = $('span.sigle', $(this).get(0)).html().replace(/^\s+|\s+$/g,"");
						return id == currTitle;
					}).get(0);
					$(this).append(result);
					var selected = $('select[name="sigle"]', result).find(':checked').text();
					if (selected != "") {
						var liSession = $(result).closest('li.session');
						if (basic.isAvailable(selected, liSession))
							$(result).removeClass('wrong-session');
						else
							$(result).addClass('wrong-session');
					}
					
				}
				});
		}
	}
});