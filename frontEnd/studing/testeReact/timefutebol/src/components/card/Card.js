import React from 'react';
import './Card.css'

class Card extends React.Component{
    constructor(props){
        super(props);
        if(this.props.in0 === "Brasão"){
            this.saida = (
                <div className="card"  style={{width: "100%",height: "500px"}}>
                    <p className="nome titulo">{this.props.in0}</p>
                    <img className='imagemCard' src={this.props.imgDir} alt={this.props.imgDir}/>
                    <p className="nome font"><b>Data da fundação: </b>{this.props.in1}</p>
                    <p className="nome font"><b>Cidade: </b>{this.props.in2}</p>
                    <p className="nome font"><b>País: </b>{this.props.in3}</p> 
                </div>
            );
        }
        else if(this.props.in0 === "Tecnico"){
            this.saida = (
                <div className="card">
                    <p className="nome titulo">{this.props.in0}</p>
                    <img className='imagemCard' src={this.props.imgDir} alt={this.props.imgDir}/>
                    <p className="nome titulo">{this.props.in1}</p> 
                </div>
            );
        }
        else{
            this.saida = (
                <div className="card">
                    <p className="nome titulo">{this.props.in0}</p>
                    <img className='imagemCard' src={this.props.imgDir} alt={this.props.imgDir}/> 
                    <p className="nome font"><b>Posição: </b>{this.props.in1}</p>
                    <p className="nome font"><b>Camisa: </b>{this.props.in2}</p>
                    <p className="nome font"><b>Idade: </b>{this.props.in3}</p>
                </div>
            );
        }
    }
    render(){
        return(this.saida);
    }
}

export default Card;