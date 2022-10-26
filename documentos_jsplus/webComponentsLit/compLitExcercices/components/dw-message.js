import { LitElement, html, css } from "lit";

    class DwMessage extends LitElement {
        static styles = css`
        :host {
                display: block;
                border: 1px solid blueviolet;
                padding: 10px;
                margin-bottom: 20px;
            }
        .div{
            background-color: #fcc;
        }
        `

    render(){
        return html`
        <div class="diver">
            Hola
        </div>
        `
    }
}

customElements.define("dw-message", DwMessage);


