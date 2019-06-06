<h1>Trab Bank</h1>
<p>Casos de uso e video disponiveis em: <a href="https://drive.google.com/drive/folders/1yNIEybakDNf_AyRnBcVqe7C_sxsFCt26?usp=sharing">link</a></p>
<p>Swagger com aplicação rodando: <a href="http://localhost:8080/swagger-ui.html">link</a></p>

<h2>Padrões de projeto</h2>

<h3>1 Builder</h3>
<p>
    Implementado durante a construção de um cliente<br />
</p>

<img src="./imgsreadme/builder.png"> 

<h3>2 DAO</h3>
<p>
    DAO para lidar com o acesso ao banco e manipulação das entendodades<br />
</p>
 
<img src="./imgsreadme/DAO.png"> 

<h3>3 DTO</h3>
<p>
    DTO para transferir dados<br />
</p>
 
<img src="./imgsreadme/DTO.png"> 

<h3>4 MVC</h3>
<p>
    A arquitetura do projeto utiliza MVC<br />
</p>
<!--  
<img src="./imgsreadme/DTO.png">  -->


<h3>5 Stateless</h3>
<p>
    O @Bean do spring boot implementa o padrão stateless<br />
</p>

<img src="./imgsreadme/stateless.png">

<h3>6 Factory</h3> 
<p>
    Implementado para entregar uma instancia de conta dependendo do tipo passado como argumento.
</p>

<img src="./imgsreadme/factory.png">

<p>Para criação de uma conta</p> 

<h3>7 Chain of Responsibility</h3>
<p>
    A chor identifica qual o metodo deve tratar a solicitação de transação<br />
</p>
 
<img src="./imgsreadme/chain-2.png"> 

<h3>7.1 Chain of Responsibility</h3>
<p>
    Utilizado para ter acesso a cadeia de requisição e a partir HttpHeaders que é o handler colocar o token no header<br />
</p>
 
<img src="./imgsreadme/chain.png"> 
