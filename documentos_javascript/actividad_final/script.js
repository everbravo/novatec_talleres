'use=strict;'
/*Oh Dios, el tema es hacer un cajero electrónico, 
ingresa el cliente con usuario y contraseña, 
pide dinero, 
se valida si tiene el dinero disponible, 
se saca el dinero, 
se descuenta de la cuenta y se muestran los detalles del movimiento, 
se persiste la información y listo*/

const content = document.getElementById('contenedor');
const content2 = document.getElementById('contents');
const btns = document.getElementById('btns');

const login = () =>{

    let lblUser = document.createElement('label');
    lblUser.setAttribute('for', 'usuario');
    lblUser.innerText = 'Usuario: ';

    let usuario = document.createElement('input');
    usuario.setAttribute('type', 'text');
    usuario.name = 'usuario';
    usuario.id = 'usuario';

    let lblPass = document.createElement('label');
    lblPass.setAttribute('for', 'passwd');
    lblPass.innerText = 'Password: ';

    let passwd = document.createElement('input');
    passwd.setAttribute('type', 'password');
    passwd.name = 'passwd';
    passwd.id = 'passwd';

    let btnSend = document.createElement('button');
    btnSend.setAttribute('onclick', 'inicioOnclick();');
    btnSend.innerText = 'Ingresar';

    content2.appendChild(lblUser);
    content2.appendChild(usuario);
    content2.appendChild(lblPass);
    content2.appendChild(passwd);
    content.appendChild(content2);
    btns.appendChild(btnSend);

}

const registro = () =>{
    let lblUser = document.createElement('label');
    lblUser.setAttribute('for', 'usuario');
    lblUser.innerText = 'Usuario: ';

    let usuario = document.createElement('input');
    usuario.setAttribute('type', 'text');
    usuario.name = 'usuario';
    usuario.id = 'usuario';

    let lblPass = document.createElement('label');
    lblPass.setAttribute('for', 'passwd');
    lblPass.innerText = 'Password: ';

    let passwd = document.createElement('input');
    passwd.setAttribute('type', 'password');
    passwd.name = 'passwd';
    passwd.id = 'passwd';

    let lblNombre = document.createElement('label');
    lblNombre.setAttribute('for', 'nombre');
    lblNombre.innerText = 'Nombre: ';

    let nombre = document.createElement('input');
    nombre.setAttribute('type', 'text');
    nombre.name = 'nombre';
    nombre.id = 'nombre';

    let lblApellido = document.createElement('label');
    lblApellido.setAttribute('for', 'apellido');
    lblApellido.innerText = 'Apellidos: ';

    let apellido = document.createElement('input');
    apellido.setAttribute('type', 'text');
    apellido.name = 'apellido';
    apellido.id = 'apellido';

    let lblDocumento = document.createElement('label');
    lblDocumento.setAttribute('for', 'documento');
    lblDocumento.innerText = 'Documento: ';

    let documento = document.createElement('input');
    documento.setAttribute('type', 'number');
    documento.name = 'documento';
    documento.id = 'documento';

    let lblCorreo = document.createElement('label');
    lblCorreo.setAttribute('for', 'email');
    lblCorreo.innerText = 'Correo: ';

    let correo = document.createElement('input');
    correo.setAttribute('type', 'email');
    correo.name = 'email';
    correo.id = 'email';

    let btnSend = document.createElement('button');
    btnSend.setAttribute('onclick', 'crearArregloUsuario();');
    btnSend.innerText = 'Almacenar Datos';

    content2.appendChild(lblUser);
    content2.appendChild(usuario);
    content2.appendChild(lblPass);
    content2.appendChild(passwd);
    content2.appendChild(lblNombre);
    content2.appendChild(nombre);
    content2.appendChild(lblApellido);
    content2.appendChild(apellido);
    content2.appendChild(lblDocumento);
    content2.appendChild(documento);
    content2.appendChild(lblCorreo);
    content2.appendChild(correo);
    content.appendChild(content2);
    btns.appendChild(btnSend);

}

const generarCuenta = () => {
    return Math.round((Math.random(100000)*100000));
}

const crearArregloUsuario = () => {
    let numeroCuenta = generarCuenta();
    let usuario = document.getElementById('usuario').value;
    let passwd = document.getElementById('passwd').value;
    let nombre = document.getElementById('nombre').value;
    let apellidos = document.getElementById('apellido').value;
    let documento = document.getElementById('documento').value; 
    let correo = document.getElementById('email').value;

    let arrdata = [{
        'usuario':usuario,
        'passwd':passwd,
        'nombre':nombre,
        'apellidos':apellidos,
        'documento':documento,
        'correo':correo,
        'cuenta':{
            'numero':numeroCuenta,
            'saldo':0,
            'movimiento':[]
        }
    }];

    registrarUsuario(arrdata);
}

const registrarUsuario = (arrdata) => {
    let name = arrdata[0]['usuario'];
    let almacen = arrdata[0];

    localStorage.setItem(name, JSON.stringify(almacen));
    let resp = buscarUsuario(name);
    if(resp !== null){
        alert("usuario guardado! ");
        window.location.href = window.location.href;
    }
}

const buscarUsuario = (nameuser) => {
    let datos = localStorage.getItem(nameuser);
    if (datos !== null){
        return JSON.parse(datos);
    }else{
        alert('no existe');
        return null;
    }
}

var datos = null;

const iniciarSesion = (usuario, passwd) => {
        datos = buscarUsuario(usuario);
        if (datos !== null){
            if(datos['usuario'] === usuario && datos['passwd'] === passwd){
                alert('inicio de sesión exitoso!');
                //TODO: aciones inico
                limpiarIndex();
                armarMenuUsuario(datos);
            }else{
                reject(`problema de autenticación a user: ${usuario} `);
            }
        }
}

const inicioOnclick = () => {
    let nus = document.getElementById('usuario').value;
    let pw = document.getElementById('passwd').value;
    iniciarSesion(nus,pw);
}

function limpiarIndex(){
    let btnLog = document.getElementById('login');
    let btnReg = document.getElementById('register');
    let hr = document.querySelector('hr');
    document.body.removeChild(btnLog);
    document.body.removeChild(hr);
    document.body.removeChild(btnReg);
    content.removeChild(content2);
    document.body.removeChild(btns);
}

const armarMenuUsuario = (datos) => {
    let cabecera = document.getElementById('cabecera');
    let lblCab = document.createElement('label');
    lblCab.innerText =  `Hola ${datos['nombre'].toUpperCase()} Bienvenido al banco chevére`;

    let text1 = document.createElement('p');
    text1.innerText = "Menú principal: ";

    let btnIng = document.createElement('button');
    btnIng.setAttribute('onclick', 'ingresarDinero();');
    btnIng.innerText = 'Ingresar Dinero';

    let btnRet = document.createElement('button');
    btnRet.setAttribute('onclick', 'retirarDinero();');
    btnRet.innerText = 'Retirar Dinero';

    let lblCant = document.createElement('label');
    lblCant.setAttribute('for', 'cantidad');
    lblCant.innerText = 'Cantidad: ';

    let cantidad = document.createElement('input');
    cantidad.setAttribute('type', 'number');
    cantidad.name = 'cantidad';
    cantidad.id = 'cantidad';

    content.appendChild(lblCant);
    content.appendChild(cantidad);

    cabecera.appendChild(lblCab);
    cabecera.appendChild(text1);
    cabecera.appendChild(document.createElement('label'));
    cabecera.appendChild(btnIng);
    cabecera.appendChild(btnRet);

}

const ingresarDinero = () => {
    let cantidadIng = document.getElementById('cantidad').value;
    let saldoActual = datos['cuenta']['saldo'];
    let nuevoSaldo = saldoActual + Math.abs(cantidadIng);
    let nmov = {'valor':Math.abs(cantidadIng), 'descripcion':'ingreso'};

    datos['cuenta']['saldo'] = nuevoSaldo;
    datos['cuenta']['movimiento'].push(nmov);

    localStorage.setItem(datos['usuario'], JSON.stringify(datos));

    let final = datos['cuenta']['movimiento'].length-1;
    alert(`Señor(a) ${datos['nombre'].toUpperCase()} ${datos['apellidos'].toUpperCase()} su transaccion de ${datos['cuenta']['movimiento'][final]['descripcion']} por $ ${cantidadIng} de su cuenta N° ${datos['cuenta']['numero']} fue aprobada!, por lo anterior queda con un saldo de ${datos['cuenta']['saldo']}`);
}

const retirarDinero = () => {
    let cantidadRet = document.getElementById('cantidad').value;
    let saldoActual = datos['cuenta']['saldo'];
    
    const cambiarValor = (r)=>{
        if(r){
            let nuevoSaldo = saldoActual - Math.abs(cantidadRet);
            let nmov = {'valor':Math.abs(cantidadRet), 'descripcion':'retiro'};

            datos['cuenta']['saldo'] = nuevoSaldo;
            datos['cuenta']['movimiento'].push(nmov);

            localStorage.setItem(datos['usuario'], JSON.stringify(datos));

            let final = datos['cuenta']['movimiento'].length-1;

            alert(`Señor(a) ${datos['nombre'].toUpperCase()} ${datos['apellidos'].toUpperCase()} su transaccion de ${datos['cuenta']['movimiento'][final]['descripcion']} por $ ${cantidadRet} de su cuenta N° ${datos['cuenta']['numero']} fue aprobada!, por lo anterior queda con un saldo de ${datos['cuenta']['saldo']}`);
        }
        
    }

    verificarDisponible(saldoActual, cantidadRet).then(result => cambiarValor(result)).catch(error => alert(error));
}

const verificarDisponible = (saldoActual, cantRetirar) => {
    return new Promise((resolve, reject)=>{
        let res = Math.abs(saldoActual) - Math.abs(cantRetirar);
        if (res >= 0 ){
            resolve(true);
        }else{
            reject(false);
        }
    });
}
