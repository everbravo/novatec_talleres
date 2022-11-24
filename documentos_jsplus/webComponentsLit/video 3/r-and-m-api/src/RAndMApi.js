import { html, css, LitElement } from 'lit';
import './components/GetData';
import {styles} from './components/styles/styles';
import './components/api-template';

export class RAndMApi extends LitElement {
  static get styles() {
    return styles;
  }

  static get properties() {
    return {
      title: { type: String },
      wiki: {type: Array},
    };
  }

  constructor() {
    super();
    this.wiki = [];
    this.title = 'Hola';
    this.addEventListener('ApiData', (e)=>{
      console.log(e.detail.data.results);
      this._dataFormat(e.detail.data);
    });
  }

  _dataFormat(data) {
    let characters = [];
    data['results'].forEach((character) => {
      characters.push({
        img: character.image,
        name: character.name,
        species: character.species,
        status: character.status
      });
    });
    this.wiki = characters;
  }

  render() {
    return html`
      <get-data url="https://rickandmortyapi.com/api/character" metho="GET"></get-data>
      <api-template></api-template>
      <div class="container">
      ${this.dataTemplate}
      </div>
    `;
  }

  get dataTemplate() {
    return html`
      ${this.wiki.map(  (character) => html`
        <div class="card">
          <div class="card-content">
            <h2>${character.name}</h2>
            <img src="${character.img}">
            <p>${character.species} | ${character.status}</p>
          </div>
        </div>
      `)}
      `
  }
}
