import { LitElement, html, css } from "lit";
class HolaMundo extends LitElement {

    static styles = [

        css`
            :host {
                display: block;
            }
        `
    ];

    static get properties(){
        return{
            desde:{type:String, reflect:true}
        }
    }

    constructor(){
        super();
        this.desde = "algun lugar";
    }
    
    render() {
        return html`
            <slot></slot>
            <p>${this.desde}</p>
            `;
    }
}

customElements.define('hola-mundo', HolaMundo);