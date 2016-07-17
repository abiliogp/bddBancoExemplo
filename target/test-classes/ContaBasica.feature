#language: pt
Funcionalidade: Gerenciamento de conta básica
  Como um correntista do Banco BDD
  Com o objetivo de criar e gerenciar uma conta

  Contexto: 
    Dado um operador de contas básica

  Cenário: Criar uma nova conta no Banco BDD
    Dado as informações do cliente
      | nome       | Johnny Cash    |
      | nascimento | 26/02/1932     |
      | rg         |     1111111111 |
      | cpf        | 000.000.000-00 |
      | endereco   | Kingsland      |
      | profissao  | Compositor     |
    Quando cadastrar a conta do cliente no Banco BDD
    Entao devo receber um número de agência
    E um número da conta

  Cenário: Buscar a conta de um cliente
    Dado um nome de um cliente "Johnny Cash"
    Quando buscar a conta
    Então devo receber um número válido

  Cenário: Depositar um valor na conta
    Dado um nome de um cliente "Johnny Cash"
    E um valor para deposito 1000
    Quando buscar a conta
    E depositar o valor
    Então devo receber um comprovante


  
