import React from 'react';
import './Title.css';

class Title extends React.Component{
    render(){
        return (<p className="title">{this.props.title}</p>);
    }
}

export default Title;