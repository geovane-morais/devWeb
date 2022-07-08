import React from 'react';
import './Main.css'

class Item extends React.Component{
    render(){
        return (
        <div className="boxSigno">
            <p className="nomeSigno">{this.props.signo}</p>
            <img className='imagemSigno' src={this.props.local} alt={this.props.local}/> 
            <p className="Font">{this.props.dataInicio} - {this.props.dataFim}</p>
        </div>
        );
    }
}

class Lista extends React.Component{
    render(){
        return (
        <div className="LISTA">
            {this.props.children}
        </div>
        );
    }
}

export default {Lista,Item};