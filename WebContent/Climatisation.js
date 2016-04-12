
$(document).ready(function(){

$("#sourceNbId").click(function(){
     
    $.ajax({
       url : 'ClimatisationAjax',
       type : 'GET',
       dataType : 'text', // On désire recevoir du HTML
       success : function(texte){ // code_html contient le HTML renvoyé
    	   $("#nbId").html(texte);
                    }
              });
   


		});
		});