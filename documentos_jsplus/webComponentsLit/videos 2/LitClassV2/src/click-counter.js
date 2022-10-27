import { LitElement, html, css } from "lit";
import './msg-feedback.js';

class ClickCounter extends LitElement {
    static get properties() {
        return {
        inicio: {
            type: Number
        }
        }
    }

    static get styles() {
        return css`
        :host {
            display: inline block;
            border: 1px solid black;
        }
        `
    }

    get feedback() {
        return this.shadowRoot.getElementById('notification');
    }

    constructor() {
        super();
        this.inicio = 0;
    }

    incrementar() {
        if (this.inicio == 5){
            this.feedback.open("Has llegado a cinco clicks");
            this.inicio = 0;
        }
        return this.inicio ++;
    }

    render() {
        return html`
            <div class="container">
                <div>
                    <slot></slot>
                </div>
                <p>Inicio: ${this.inicio}</p>
                <button @click="${this.incrementar}" > Clickear </button>
                <msg-feedback id="notification"></msg-feedback>
            </div>
            `
    }

}

customElements.define('click-counter', ClickCounter);
