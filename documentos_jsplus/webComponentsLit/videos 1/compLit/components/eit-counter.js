import { LitElement, html, css } from "lit";
import { WiredButton } from 'wired-elements/lib/wired-button.js';
import { WiredInput } from 'wired-elements/lib/wired-input.js';
import { WiredCard } from 'wired-elements/lib/wired-card.js';
import { WiredSlider } from 'wired-elements/lib/wired-slider.js';

export class EitCounter extends LitElement {
    static styles = [
        css`
            :host {
                display: inline block;
            }
            h2{
                font-size: 1.5em;
                font-weight: normal;
            }
            wired-button{
                margin: 0.5em;
                background-color:aquamarine;
            }
            wired-button.decrement{
                margin: 0.5em;
                background-color:#fcc;
            }
            p.number{
                font-size: 3em;

            }
        `
    ];

    static properties = {
        counter: { type: Number, reflect:true },
        quantity: {type: Number}
        
    }

    constructor() {
        super();
        this.counter = 10;
        this.quantity = 10;
    }


    get cantidad () {
        return this.shadowRoot.getElementById('cantidad').value;
    }

    doChangeQuantity(e){
        this.quantity = e.detail.value;
    }

    increment = () => {
            this.counter += parseInt(this.shadowRoot.getElementById('cantidad').value);
        }
  
    decrement(){
        this.counter-= parseInt(this.cantidad);
    }

    render() {
        return html`
        <wired-card elevation="3">
            <slot></slot>
            <p class="number">${this.counter}</p>
            <p>
                <wired-input id="cantidad" type="number" .value="${this.quantity}"></wired-input>
                <br>
                <wired-slider value="10" min="5" max="15" @change=${this.doChangeQuantity}></wired-slider>
            </p>
            <wired-button @click=${this.increment}>+</wired-button>
            <wired-button class="decrement" @click=${this.decrement}>-</wired-button>
        </wired-card>
        `;
    }
}

customElements.define("eit-counter", EitCounter);
