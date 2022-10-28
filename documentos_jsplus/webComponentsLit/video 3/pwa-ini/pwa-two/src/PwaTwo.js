import { LitElement, html, css } from 'lit';
import './views/pwa-home';
import './views/pwa-contact';
import './views/pwa-about';

export class PwaTwo extends LitElement {
  static get properties() {
    return {
      title: { type: String },
      selected: { type:String},
    };
  }

  static get styles() {
    return css`
      :host{
        display: block;
        margin:30px;
        font-family: monospace;
        font-size: 20px;
      }
      div.content{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
      }
      div{
        margin:10px;
      }
      a{
        text-decoration: none;
      }
      .hiden{
        display:none;
      }
      .hiden[active]{
        display:block;
      }
    `;
  }

  constructor() {
    super();
    this.title = 'Web Progressive Aplication (PWA)';
    this.selected = 'home';
  }

  render() {
    return html`
      <div class="content">
      <div>${this.title}</div>
      <div class="links">
        <a href="#" @click="${this.go}" name="home">Home</a>
        <a href="#" @click="${this.go}" name="about">About</a>
        <a href="#" @click="${this.go}" name="contact">Contact me</a>
      </div>
      <div class="text-body">
        
          <pwa-home title="What is Lorem Ipsum?" class="hiden" ?active=${this.selected == 'home'}></pwa-home>
          
          <pwa-about  class="hiden" ?active=${this.selected == 'about'}></pwa-about>
          
          <pwa-contact  class="hiden" ?active=${this.selected == 'contact'}></pwa-contact>
          
      </div>
      </div>
    `;
  }
  go(e) {
    e.preventDefault();
    let sel = e.target.getAttribute('name');
    if (sel === 'home') {
      this.selected = 'home';
    } else if (sel === 'about') {
      this.selected = 'about';
    } else if (sel === 'contact') {
      this.selected = 'contact';
    }
  }
}
