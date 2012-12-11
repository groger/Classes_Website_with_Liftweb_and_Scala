// @author Soto Setzke, David
// @author Menhorn, Friedrich
define(['./basic'], function(basic) {
	return {
        check: function(checkbox){
            //console.log("Im am in terminer.check");
            if(checkbox.checked){
                //console.log("Im am in terminer.check.if");
                $(checkbox).parent().addClass('cours-terminer');
            }
            else{
                $(checkbox).parent().removeClass('cours-terminer');
            }
        }
    };
});
