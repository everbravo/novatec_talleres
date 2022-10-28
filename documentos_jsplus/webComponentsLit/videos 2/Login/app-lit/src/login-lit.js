import { LitElement, html, css } from "lit";

export class LoginLit extends LitElement{
    
    static get styles() {
        return css`
            .container {
                border: solid 3px #11ce76;
                border-radius: 10px;
                width: 350px;
                height: 400px;
                text-align: center;
            }
            input {
                width: 90%;
                height: 30px;
                margin-top: 8vh;
                border: solid 1px #414141;
                border-top: 0px;    
                border-radius: 5px;
            }
            button {
                width: 60%;
                height: 40px;
                background: #11ce76;
                color: #414141;
                border: none;
                border-radius: 6px;
                margin-top: 8vh;
            }
            button:hover {
                background: #0da35d;
                cursor: pointer;
            }
            `;
    }

    render(){
        return html`
            <div class="container">
                <h2>Login LitElement</h2>
                <input id="ema" type="text" placeholder="Enter your email"/>
                <input id="pass" type="password" placeholder="Enter your password"/>
                <button @click="${this._login}">Sign in</button>
            </div>
            `;
    }

    _login() {
        let email = this.shadowRoot.getElementById('ema').value;
        const pass = this.shadowRoot.querySelector("#pass").value;

        if(!!email && !!pass) {
            this.dispatchEvent(new CustomEvent('login', {
                detail: { succes: true },
                bubbles: true, composed: true
            }));
        }else{
            console.log("algunos datos no fueron encontrados");
        }
    }

}

customElements.define('login-lit', LoginLit);