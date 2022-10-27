import { LitElement, html, css } from "lit";

class MsgFeedback extends LitElement {
  static get properties() {
    return{
        msg:{type:String},
        opened:{type:Boolean}
    }
  }

    static get styles() {
        return css`
        div{
            position:fixed;
            bottom:0px;
            left:0px;
            overflow:hidden;
            height:0;
            display:flex;
            align-items:center;
            justify-content:center;
            background-color:#e74c3c;
            color:white;
            width:100%;
            transition: all 0.7s ease-in;
            font-size:1px;
            font-family:"Arial,Tahoma,sans-serif";
        }
        .opened{
            height:100px;
            font-size: 2em;
        }
        `
    }

    constructor() {
        super();
        this.msg = "Hola Ever";
    }

    open(msg) {
        this.msg = msg;
        this.opened = true;
        setTimeout(() => this.opened = false, 3000);
    }

    render(){
        return html`
            <div class="${this.opened ? 'opened' : ''}">
                ${this.msg}
            </div>
        `
    }

}

customElements.define('msg-feedback', MsgFeedback);