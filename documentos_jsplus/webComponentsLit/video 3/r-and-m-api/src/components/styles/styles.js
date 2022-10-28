import { css } from "lit";

export const styles = css`
  :host{
        display:block;
      }
      .container{
        text-align:center;
      }
      get-data{
        display:none;
      }
      .card{
        background-color:#fff;
        border-radius:2px;
        display:inline-block;
        height:300px;
        width:200px;
        margin:1rem;
        position:relative;
        text-align:center;
        box-shadow:0px 1px 3px rgba(0,0,0,0.12) 0 1px 0 rgba(0,0,0,0.24);
        transition: all 0.3s cubic-bezier(.25, .8, .25, .1);
      }
      .card:hover{
        box-shadow:0px 14px 28px rgba(0,0,0,0.12) 0 10px 10 rgba(0,0,0,0.24);
      }
      .card img{
        width:70%;
      }`;
