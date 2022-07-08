import './App.css';
import Header from './components/header/Header';
import Signos from './components/main/Main';

function App() {
  return (
    <div className="App">
      <Header />
      <Signos.Lista>
        <Signos.Item signo="Aquário" local="assets/aquario.jpg" dataInicio="21/01" dataFim="19/02"/>
        <Signos.Item signo="Peixes" local="assets/peixes.jpg" dataInicio="20/02" dataFim="20/03"/>
        <Signos.Item signo="Áries" local="assets/aries.jpg" dataInicio="21/03" dataFim="20/04"/>
        <Signos.Item signo="Touro" local="assets/touro.jpg" dataInicio="21/04" dataFim="21/05"/>
        <Signos.Item signo="Gêmeos" local="assets/gemeos.jpg" dataInicio="22/05" dataFim="21/06"/>
        <Signos.Item signo="Câncer" local="assets/cancer.jpg" dataInicio="22/06" dataFim="23/07"/>
        <Signos.Item signo="Leão" local="assets/leao.jpg" dataInicio="24/07" dataFim="23/08"/>
        <Signos.Item signo="Virgem" local="assets/virgem.jpg" dataInicio="24/08" dataFim="23/09"/>
        <Signos.Item signo="Libra" local="assets/libra.jpg" dataInicio="24/09" dataFim="23/10"/>
        <Signos.Item signo="Escorpião" local="assets/escorpiao.jpg" dataInicio="24/10" dataFim="22/11"/>
        <Signos.Item signo="Sagitário" local="assets/sagitario.jpg" dataInicio="23/11" dataFim="21/12"/>
        <Signos.Item signo="Capricórnio" local="assets/capricornio.jpg" dataInicio="22/12" dataFim="20/01"/>
      </Signos.Lista>
    </div>
  );
}

export default App;
