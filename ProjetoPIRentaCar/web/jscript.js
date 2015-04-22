function disponibilidade(i){
    var filial = document.getElementById("filial");
    filial.setAttribute("value", i);
    var url = 'Disponibilidade';
    
    var myAjax = new Ajax.Request(  
        url,{  
                method: 'POST',  
                parameters: filial,  
                onComplete: showResponse  
            }  
    );
}


