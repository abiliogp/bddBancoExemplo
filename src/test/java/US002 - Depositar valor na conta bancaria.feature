#language: pt
Funcionalidade: Depositar valor na conta bancaria
  Como um correntista do Banco BDD
  Eu quero depositar um valor
  Para ter um saldo disponivel na minha conta

  Contexto: 
    Dado um cliente com nome de "Johnny Cash"

  Cenário: Depositar um valor na conta
    Dado um nome de um cliente "Johnny Cash"
    E um valor para deposito 1000 reais
    Quando depositar o valor
    Então devo receber um comprovante
    E o saldo da conta deve aumentar em 1000 reais
