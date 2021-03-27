import { StatusBar } from 'expo-status-bar';
import React, { useState } from 'react';
import { SafeAreaView, StyleSheet, Text, TextInput, Button } from 'react-native';
import AppDataService from './services/AppDataService';

export default function App() {

  const [nome, setNome] = useState('');
  const [cpf, setCpf] = useState('');
  const [email, setEmail] = useState('');
  const [telefone, setTelefone] = useState('');
  const [idade, setIdade] = useState(0);
  const [dataNascimento, setDataNascimento] = useState('');
  const [grupo, setGrupo] = useState(null);

  const handleAdd = event => {
    
    const pessoa = {
      
      nome: nome,
      cpf: cpf,
      telefone: telefone,
      email: email,
      idade: idade,
      dataNascimento: dataNascimento,
      grupo:{
        codigo: grupo
      }
    };

    AppDataService.cadastrarPessoa(pessoa);

  }

  return (
    <SafeAreaView style={styles.container}>
      <Text style={styles.title}>Cadastro Vaccine</Text>
      
      <TextInput style={styles.input} 
        placeholder='Nome' 
        placeholderTextColor='#FFF' 
        onChangeText={setNome}
        value={nome}>  
      </TextInput>

      <TextInput style={styles.input} 
        placeholder='CPF' 
        placeholderTextColor='#FFF'
        onChangeText={setCpf}
        value={cpf}></TextInput>
      
      <TextInput style={styles.input} 
        placeholder='Telefone' 
        placeholderTextColor='#FFF'
        onChangeText={setTelefone}
        value={telefone}></TextInput>

      <TextInput style={styles.input} 
        placeholder='Email'
        placeholderTextColor='#FFF'
        onChangeText={setEmail}
        value={email}></TextInput>
      
      <TextInput style={styles.input} 
        placeholder='Idade' 
        placeholderTextColor='#FFF' 
        onChangeText={setIdade}
        value={idade}></TextInput>
      
      <TextInput style={styles.input} 
        placeholder='Data de nascimento' 
        placeholderTextColor='#FFF'
        onChangeText={setDataNascimento}
        value={dataNascimento}></TextInput>

      <TextInput style={styles.input} 
        placeholder='Grupo' 
        placeholderTextColor='#FFF'
        onChangeText={setGrupo}
        value={grupo}></TextInput>
      
      <Button title='CADASTRAR' onPress={handleAdd}></Button>
      <StatusBar style="auto" />
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    justifyContent: 'center',
  },
  input:{
    alignItems: 'center',
    margin: 10,
    padding: 10,
    borderWidth: 1,
    borderRadius: 5,
    borderColor: '#0D458D',
    fontSize: 20,
    color: '#FFF',
    backgroundColor: '#0D458D'
  },
  title:{
    textAlign: 'center',
    fontSize: 22,
    marginVertical: 8
  }
});
