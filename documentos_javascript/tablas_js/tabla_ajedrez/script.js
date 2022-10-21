'use=strict;'
const divPadre = document.querySelector('div');

const fichasPW = ["TCA","C","A","R","RR","A","C","T"];

const tablero = document.createElement('table');

for (var x = 0; x < 8; x++){
    
    var fila = document.createElement('tr');
    
    for (var y = 0; y < 8; y++){

        var columna = document.createElement('td');

        let res = (x+y)%2;
        if(res === 0){
            columna.setAttribute('class', 'white red');
            fila.appendChild(columna);
        }else{
            columna.setAttribute('class', 'black');
            fila.appendChild(columna);
        }

        if(x===0){
            fichasPW.forEach(valor => columna.innerText = valor);
        }

    }

    tablero.appendChild(fila);

}
divPadre.appendChild(tablero);