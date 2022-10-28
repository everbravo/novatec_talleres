import { LitElement, html } from "lit";
import {style} from './styles/ApiTemplateStyle';

export class ApiTemplate extends LitElement {
  static get styles(){
    return style;
  }

  render(){
    return html`
      <div class="container">
        <h1>The <strong>Rick and Morty</strong> Api</h1>
        <p class="title">LitElement</p>
      </div>
      `;
  }

}
customElements.define('api-template', ApiTemplate);
