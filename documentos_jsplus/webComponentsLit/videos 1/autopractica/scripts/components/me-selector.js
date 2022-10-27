import { LitElement, html, css } from "lit";

class MeSelector extends LitElement {
    static styles =[ 
        css`
            :host{
                display:inline-block;
                position:relative;
                border:1px solid black;
                background-color:#fc9;
            }
            .flex-container{
                display:flex;
                flex-direction:column;
                justify-content:center;
                align-items:center;
                padding:10px;
            }
            div{
                margin:10px;
            }
            select{
                width:70%;
                font-size:14px;
            }
        `
    ];

    static properties = [
        {type: String, reflect: true, attribute: false}
    ];


    render(){
        return html`
            <div class="flex-container">
        <div id="head">
            <h2>Custom selector</h2>
        </div>
        <div id="body">
            <div>
                <label for="nombre">Nombre: </label>
                <input type="text" name="nombre" id="nombre"/>
            </div>
            <div>
                <label for="nombre" style="width:30%">Tipo: </label>
                <select>
                    <option>Seleccione una opción</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
            </div>
        </div>
        <div id="tail">
            <button id="btn">Confirmar</button>
        </div>
    </div>
            `;
    }
    
}
customElements.define("me-selector", MeSelector);