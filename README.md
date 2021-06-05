# projeto-web

Neste projeto foi criado um Sistema de Cadastro de Produtos

FERRAMENTAS UTILIZADAS:
* IDE Eclipse
* Maven (maven-archetype-webapp)
* Java 8
* Wildfly 11
* Registros foram salvos em memoria
* Arquitetura utilizada: Padrão MVC

FUNCIONALIDADES:
* Na tela inicial temos 3 botões:
    * Login: Fazer cadastro de usuario
    * Logon: Entrar na sua conta
    * Acessar: Acessar lista de produtos
* Funcionalidades tela de login:
    * Campos de email, nome e senha
        * Se o email já existir, retorna um aviso informando "email já cadastrado" e não efetua o cadastro
        * Todos os campos devem ser preenchidos, se não forem retorna avisos
    * Botão Cadastrar
        * Se todos os campos forem preenchidos direciona para a tela Logon
* Funcionalidades tela de logon:
    * Campos de email e senha
        * Se o email não tiver cadastrado retorna aviso e não efetua acesso
        * Se a senha não for correspondente retorna aviso e não efetua acesso
        * Todos os campos devem ser preenchidos, se não forem retorna avisos
    * Botao Acessar
        * Se o email tiver cadastrado e a senha tiver correta, direciona para a tela de listagem de produtos
* Funcionalidades tela de listagem de produtos:
    * Botao Novo Produto: direciona para a tela de cadastro de produto
    * Tabela de produtos
        * Lista os produtos salvos no repositorio
        * Inicia vazia(atualiza conforme for adicionando produtos)
        * Cada produto tem um botao de editar(direciona para tela de edição de produtos) e um de excluir(pede confirmação de remoção)
 * Funcionalidades tela de cadastro de produtos:
    * Campos de codigo(>0 e não pode ser repetido), descrição(<=100 caracteres) e preço(>R$0.0): restrições implementadas
        * Todos os campos devem ser preenchidos, se não forem retorna avisos
        * Botao de salvar: verifica se os dados são válidos
              * Se sim, efetua a edição
              * Se não, retorna avisos
 * Funcionalidades tela de edição de produtos:
    * Campos de codigo, descrição e preço
        * Todos os campos devem ser preenchidos, se não forem retorna avisos
        * Campo codigo é do tipo readonly
        * Botao de salvar: verifica se os dados são válidos
              * Se sim, efetua a edição
              * Se não, retorna avisos
              
    
        
