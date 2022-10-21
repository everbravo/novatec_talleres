'use=strict;'
const divPadre = document.querySelector('div');

const fichasPW = new Array ("T","C","A","R","RR","A","C","T");

const tablero = document.createElement('table');

for (var x = 0; x < 8; x++){
    
    var fila = document.createElement('tr');
    
    for (var y = 0; y < 8; y++){

        var columna = document.createElement('td');

        let res = (x+y)%2;
        if(res === 0){
            columna.setAttribute('class', 'white');
            columna.setAttribute('style', 'color:black; width: 2em; height:2em;');
            fila.appendChild(columna);
        }else{
            columna.setAttribute('class', 'black');
            columna.setAttribute('style', 'color:white; width: 2em; height:2em;');
            fila.appendChild(columna);
        }

        if(x==0){
            columna.innerText = fichasPW[y];
        }else if(x==1){
            columna.innerText = 'P';
        }

        if(x==7){
            columna.innerText = fichasPW[y];
        }else if(x==6){
            columna.innerText = 'P';
        }

    }

    tablero.appendChild(fila);

}
divPadre.appendChild(tablero);