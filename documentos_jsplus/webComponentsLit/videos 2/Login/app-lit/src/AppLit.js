import { LitElement, html, css } from 'lit';
import './login-lit';

export class AppLit extends LitElement {
  static get properties() {
    return {
      succes:{type:Boolean}
    };
  }

  static get styles() {
    return css`
        login-lit {
            display: flex;
            position: absolute;
            right: 38%;
            top: 10%;
        }
    `;
  }

  render() {
    return html`
     ${this.succes ? html`<h1>Bienvenido!!</h1>`: html`<login-lit @login="${this._hiddenlogin}"></login-lit>`}
     `;
  }

  _hiddenlogin() {
    this.succes = true;
  }
}
