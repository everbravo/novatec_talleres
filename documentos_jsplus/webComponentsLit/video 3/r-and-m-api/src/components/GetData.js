import { LitElement } from "lit";

export class GetData extends LitElement {

    static get properties() {
        return {
            url : {type:String},
            metho : {type:String},
        }
    }
  
    firstUpdated(){
        this.getData();
    }

    _sendData(data){
        this.dispatchEvent(new CustomEvent('ApiData', {
            detail:{data},
            bubbles:true,
            composed: true
        }));
    }

    getData(){
        fetch(this.url, {method:this.metho})
           .then(response => {
            if(response.ok) return response.json();
            return Promise.reject(response);
           })
           .then((data) => {
                this._sendData(data);
            })
           .catch(error => {
                console.warn("algo no funcionó correctamente", error);
            });
    }
}

customElements.define('get-data', GetData); 
