import './App.css';
import Card from './components/card/Card';
import Title from './components/title/Title';

function App() {
  return (
    <div className='Page'>
      <div className='Header'>
        <Title title="TOY STORY SPORT CLUB"/>
      </div>

      <div className='technicalInf'>
        <Card in0="Brasão" imgDir="assets/toystory.jpg" in1="07/07/2022" in2="Orlando" in3="EUA" />
        <Card in0="Tecnico" imgDir="assets/andy.png" in1="Andy"/> 
      </div>

      <div className='headline'>
        <Title title="ESCALAÇÃO"/>
        <div><div>
          <Card in0="Bala no Alvo" imgDir="assets/balanoalvo.png" in1="Zagueiro" in2="2" in3="6" />
          <Card in0="Porquinho" imgDir="assets/porquinho.jpg" in1="Zagueiro" in2="77" in3="4" /> 
          <Card in0="Rex" imgDir="assets/rex.png" in1="Zagueiro" in2="4" in3="500" />
          <Card in0="Et" imgDir="assets/et.jpg" in1="Meio Campo" in2="72" in3="502" /> 
          <Card in0="Jessie" imgDir="assets/jessie.jpg" in1="Atacante" in2="17" in3="17" />
          <Card in0="Polvo" imgDir="assets/polvo.png" in1="Goleiro" in2="1" in3="20" /> 
          <Card in0="Chunk" imgDir="assets/chunk.png" in1="Meio Campo" in2="78" in3="20" />
          <Card in0="Woody" imgDir="assets/woody.png" in1="Atacante" in2="10" in3="17" />
          <Card in0="Dinossauro" imgDir="assets/dinossauro.jpg" in1="Meio Campo" in2="42" in3="1000" />
          <Card in0="Wheezy" imgDir="assets/wheezy.jpg" in1="Lateral Esquerda" in2="12" in3="6" />
          <Card in0="Bopeep" imgDir="assets/bopeep.jpg" in1="Lateral Direita" in2="15" in3="9" />
        </div></div>
      </div>

      <div className='Footer'>
        <Title title="RESERVA"/>
        <div><div>
          <Card in0="Buzz" imgDir="assets/buzz.png" in1="Atacante" in2="23" in3="17" />
          <Card in0="Garfinho" imgDir="assets/garfinho.png" in1="Zagueiro" in2="22" in3="3" /> 
          <Card in0="Slinky" imgDir="assets/slinky.jpg" in1="Zagueiro" in2="99" in3="6" />
          <Card in0="Lotso" imgDir="assets/lotso.png" in1="Zagueiro" in2="87" in3="4" /> 
          <Card in0="Sr Cabeça Batata" imgDir="assets/srbatata.png" in1="Zagueiro" in2="54" in3="2" />
          <Card in0="Sra Cabeça Batata" imgDir="assets/srabatata.png" in1="Lateral" in2="57" in3="5" /> 
          <Card in0="Soldado" imgDir="assets/soldado.png" in1="Atacante" in2="999" in3="3" />
        </div></div>
      </div>
    </div>
  );
}

export default App;
