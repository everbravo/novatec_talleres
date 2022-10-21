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