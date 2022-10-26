/*let compras = "🛒";

function hacerLaCompra(callback){
    setTimeout(function(){
        compras += "📦";
        callback();
    }, 2000);
}

hacerLaCompra(function(){
    console.log(compras);

    hacerLaCompra(function(){
        console.log(compras);
    });


});*/


/*let desarrollo = new Promise((resolve, reject) => {
        setTimeout(function () {
            const proyecto = "📦";
            let aleatorio = Math.random();
            if(aleatorio < 0.4){
                resolve(proyecto);
            }else{
                reject("🚫 no entregado a tiempo");
            }
        }, 1000);
    });

desarrollo.then((proyecto) => console.log(proyecto)).catch((err) => console.error(err)).finally(()=>console.log("Promesa finalizada")); */

/*let compras = "🛒";

function hacerLaCompra(){
    return new Promise((resolve)=>{
        setTimeout(function(){
            compras += "📦";
            console.log(compras);
            resolve();
            }, 2000);
    });
}

hacerLaCompra()
.then(() => hacerLaCompra())
.then(() => hacerLaCompra())
.then(() => hacerLaCompra())
.then(() => hacerLaCompra());*/

let arregloUsuarios = ['ever','alexander', 'rosa', 'manuela'];
const imprimirUsuarios = (arregloUsuarios) => {
    return new Promise((resolve, reject) => {
        setTimeout(function () {
            arregloUsuarios.forEach(z => {console.log(z)});
            resolve();
        }, 2000);
    });
}

imprimirUsuarios(arregloUsuarios).then(() => imprimirUsuarios(arregloUsuarios));
