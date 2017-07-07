# language: pt

@classe
Funcionalidade: Manipulação de arquivos passados para classe

Como um usuário 
Eu quero abrir um arquivo
De modo que seja possível editá-lo

Cenário: Arquivo com nome invalido
Dado um arquivo com nome invalido
Quando ocorre a tentativa de abrir o arquivo
Então uma mensagem de erro e mostrada 

Cenário: Arquivo com nome valido para leitura
Dado um arquivo com nome valido para leitura
Quando esse arquivo e aberto e definido para leitura
Então resultado do arquivo e mostrado na tela

Cenario: Arquivo com nome valido para escrita
Dado um arquivo com nome valido para ser escrito
Quando esse arquivo e aberto e definido para escrita
Então escrita e realizada e mostrada na tela

Cenario: Saída de um arquivo válido
Dado que o usuario abriu um arquivo
Quando ele nao quer mais o modificar
Então ele decide sair

Cenario: Arquivo aberto e comando inválido é digitado
Dado que o usuario abriu corretamente um arquivo
Quando ele escolhe um comando nao valido
Então ele e avisado do ocorrido