let fileInput = document.createElement('input');
fileInput.id = 'fileUpload';
fileInput.type = 'file';
fileInput.accept = 'text/csv, aplication/csv';
//document.body.appendChild(fileInput);

const formatoCsv = (txt) => {
    let lineas = txt.replace(/\r/g).split('\n');
    console.log(lineas);
    return lineas.map ((linea) =>{
        let valores = linea.split(';');
        if(valores.valueOf('undefined') != -1){
            valores.length = valores.length-1;
            return valores;
        }else{
            return valores;
        }
        
    });
}

const conversorArreglo = ((lineas) => {
    let salida = [];
    let fila = 0; columna = 0;
    lineas.forEach(linea => {
        linea.forEach((celda)=>{
            if(salida[fila] === undefined){salida[fila] = [];}
            salida[fila][columna] = celda;
            columna++;
        })
        columna = 0;
        fila++;
    });
    return salida;
});

const readFile = (e) => {
    let file = e.target.files[0];
    let reader = new FileReader();
    reader.readAsText(file, 'utf-8');
    reader.onload = (archivo) => {
        let lineas = formatoCsv(archivo.target.result);
        let arreglo = conversorArreglo(lineas);
        //console.log(arreglo);
        let cantFilas = arreglo.length;
        let catCols = arreglo[0].length;
        drawTable("content", arreglo)
        console.log(`filas ${cantFilas} columnas ${catCols}`)
    }
}

fileInput.addEventListener('change', readFile, false);

function drawTable(contenedor, arreglo){
    const container = document.getElementById(contenedor);
    if(container.childNodes.length > 0){
        let tabla = document.querySelector('table');
        container.removeChild(tabla);
    }
    const tablero = document.createElement("table");
    tablero.id = 'tabla1';
  
    for (let i = 0; i < arreglo.length; i++) {
      var fila = document.createElement("tr");
  
      for (let j = 0; j < arreglo[i].length; j++) {
        var columna = document.createElement("td");
        columna.innerText = arreglo[i][j];
        fila.appendChild(columna);
      }
      tablero.appendChild(fila);
      tablero.setAttribute("style", "border: black 2px solid; border-collapse: collapse;")
    }
  
    container.appendChild(tablero);
}

const prepararData = ((idtabla) => {
    const tabla = document.getElementById(idtabla);
    let data ='';
    if(tabla){
        for (let f=0, fila; fila = tabla.rows[f]; f++){
            for (let c = 0, col; col=fila.cells[c]; c++){
                //console.log(col.innerText);
                data += col.innerText + ';';
            }
            data = data.replace(/.$/, '');
            data += '\n';
        }
    }
    
    descargarArchivo(data);
});

const descargarArchivo = (data) => {
    const fileName = 'ArchivoS.csv';
    let reader = new FileReader();
    let blob = new Blob(['\ufeff', data], {type: 'text/csv'});
    reader.readAsDataURL(blob);
    reader.onload = ((e) => {
        let link = document.createElement('a');
        link.href = e.target.result;
        link.target = '_blank';
        link.download = fileName;
        let eventoClie = new MouseEvent('click', {
            view:window,
            bubbles: true,
            cancelable: true
        });

        link.dispatchEvent(eventoClie);
        (window.URL).revokeObjectURL(link.href);
    });
}

var datos = [];
var cabe = [];

function obtenerDatos(){
    let nombre = document.getElementById('nombre').value;
    let apellidos = document.getElementById('apellidos').value;
    let mail = document.getElementById('mail').value;
    let fnacimiento = document.getElementById('fnac').value;
    let identificacion = document.getElementById('ident').value;
    let nacionalidad = document.getElementById('nac').value;
    let sexo = document.getElementById('sex').value;
    let ocupacion = document.getElementById('ocup').value;

    cabe = [
        'Nombre',
        'Apellidos',
        'E-mail',
        'Fecha Nacimiento',
        'Identificación',
        'Nacionalidad',
        'Sexo',
        'Ocupación'
    ];

    let arreglo = [
        nombre, 
        apellidos,
        mail,
        fnacimiento,
        identificacion,
        nacionalidad,
        sexo,
        ocupacion 
    ];

    datos.push(arreglo);

    //console.log(datos);
    crearTabla(datos, cabe);

}

function almacenDatos(arreglo){
    
}

function crearTabla(arreglo, arrCols){
    const container = document.getElementById('content');
    const contButt = document.getElementById('btns');
    const desc = document.createElement('button');
    const tabla = document.createElement('table');
    tabla.id='tablaDatos';
    if(container.childNodes.length > 0){
        let tabla = document.querySelector('table');
        container.removeChild(tabla);
    }

    const cabecera = document.createElement('thead');
    const filaCab = document.createElement('tr');
    arrCols.forEach(d => {
        let col = document.createElement('td');
        col.innerText = d;
        filaCab.appendChild(col);
    });
    cabecera.appendChild(filaCab);
    tabla.appendChild(cabecera);

    const cuerpo = document.createElement('tbody');
    arreglo.forEach(f => {
        let fil = document.createElement("tr");
        f.forEach(g=>{
            let c = document.createElement('td');
            c.innerText = g;
            fil.appendChild(c);
        });
        cuerpo.appendChild(fil);
    });
    
    tabla.appendChild(cuerpo);
    container.appendChild(tabla);

    if(contButt.childNodes.length > 0){
        let btn = document.getElementById('btnDes');
        contButt.removeChild(btn);
    }
        
    desc.id = 'btnDes';
    desc.innerText = 'Descargar Datos';
    desc.setAttribute('onclick',"prepararData('tablaDatos');");
    contButt.appendChild(desc);
    
    
}

