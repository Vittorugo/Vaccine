import { Component } from "react";
import { Table , message, Button} from 'antd';

import PessoaDataService from '../services/PessoaDataService';

const { Column } = Table;

export default class ListaPessoas  extends Component{

   constructor(props){
      super(props);
      this.state = {
         pessoa: [],
         message: null
      }
   }

   componentDidMount(){
      this.refreshPessoas();
   }

   refreshPessoas(){
      PessoaDataService.retrieveAllPessoas().then(
         response => {
            console.log(response);
            this.setState({pessoa: response.data})
         }
      )
   }

   success = (pessoa) => {
      if(pessoa.vacinada){
         pessoa.vacinada =false;
      } else {
         pessoa.vacinada = true;
      }

      PessoaDataService.updatePessoa(pessoa, pessoa.codigo);
      message.success("Status alterado com sucesso!")
   }

   render(){   
      return(
         <div className="container">
            <h2>PESSOAS CADASTRADAS</h2>
            <div className="container">
               <Table dataSource={this.state.pessoa}>
                  <Column title="NOME" dataIndex="nome" key="nome" />
                  <Column title="CPF" dataIndex="cpf" key="cpf" />
                  <Column title="TELEFONE" dataIndex="telefone" key="telefone" />
                  <Column title="EMAIL" dataIndex="email" key="email" />
                  <Column title="VACINADA" dataIndex="vacinada" key="vacinada"
                           render={(text, pessoa) => (<p>{String(pessoa.vacinada)}</p>)}/>
                  <Column title="ATUALIZAR"  key="atualizar" 
                           render={(text, pessoa) =>
                              (<Button onClick={() => this.success(pessoa)} type="primary">Alterar Status</Button>)
                           } />
               </Table>
            </div>
         </div>
      );
   }
}