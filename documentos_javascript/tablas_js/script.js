'use=strict;'
let contendor = document.getElementById("content");
console.log(contendor);

let tabla = "<table>"

let cabecera= "<tr>";
tabla+= "<td>Nombre</td>";
tabla+="<td>Documento</td>";
tabla+="<td>Telefono</td></tr>";

let datos= "<tr>";
tabla+= "<td>Ever</td>";
tabla+="<td>1214134</td>";
tabla+="<td>768978758</td></tr>";

datos += "<tr>";
tabla+= "<td>Yeison</td>";
tabla+="<td>45463523</td>";
tabla+="<td>234354653432</td></tr>";

datos += "<tr>";
tabla+= "<td>Julian</td>";
tabla+="<td>45342343</td>";
tabla+="<td>24313424434</td></tr>";

tabla += cabecera;
tabla += datos;

tabla += "</table>";

contendor.innerHTML = tabla;

let tab = document.querySelector("tabla");
tab.setAttribute("style", "border: 2px;background-color: cornsilk;");
