const dividir = (num1, num2) => {
    return new Promise((resolve, reject) => {
        if(num2 <= 0){
            reject("Division por cero");
        }else{
            resolve(`${num1/num2}`);
        }
    });
}

dividir(2,9).then(respuesta => console.log(respuesta)).catch(error => console.log(error));

const estudiantes = [
    {id: 1, nombre:"Yeison"},
    {id: 2, nombre:"Ever"},
    {id: 3, nombre:"Camilo"},
    {id: 4, nombre:"Alexander"},
    {id: 5, nombre:"Julian"}
];

const materias = [
    {id: 1, nombre:"Matematicas"},
    {id: 2, nombre:"Español"}
];

const getEstudiante = (id) => {
    return new Promise((resolve, reject) => {
        const estudiante = estudiantes.find(e => e.id === id) ?. nombre;
        (estudiante) ? resolve(estudiante) : reject(`El estudiante con id ${id} no existe`);
    });
}

const getMateria = (id) => {
    return new Promise((resolve, reject) => {
        const materia = materias.find(e => e.id === id) ?. nombre;
        (materia) ? resolve(materia) : reject(`La materia con id ${id} no existe`);
    });
}

const numeroAleatorio = (range) => {
    let num = Math.round( Math.random(range)*range );
    if (num <= 0 || num === undefined){
        return numeroAleatorio(range);
    }else{
        return num;
    }
}

const getGruposEstudio = async () => {
    
    try {

        const arregloMat = [];
        const tamGrupos = [2,3];
        const estGlob = [];
        const tempMat = [];

        for(var df = 0; df < materias.length; df++){
            tempMat[df] = null;
        }

        for(var m = 0; m < materias.length;m++){

            const estuds = [];
            for(var e = 0; e < tamGrupos[m]; e++){
                estuds[e] = null;
            }
            

            for(var d = 0; d < estuds.length;d++){
                let id = numeroAleatorio(5);
                const est = await getEstudiante(id);
                if(estuds.indexOf(est) === -1 && estGlob.indexOf(est) === -1){
                    estGlob.push(est);
                    estuds[d] = est;
                }else{
                    d -= 1;
                }
            }

            let idMat = numeroAleatorio(2);
            const mat = await getMateria(idMat);
            if(tempMat.indexOf(mat) === -1){
                tempMat.push(mat);
                arregloMat.push({materia:mat, estudiantes:estuds});
            }else{
                m -= 1;
            } 
            
        }
        
        console.log({arregloMat});
    } catch (error) {
        console.log(error);
    }
}



