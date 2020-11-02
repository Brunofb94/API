API feita com Java utilizando o Framework(Spring boot), para integrar ao aplicativo 'DaVida'

URL endpoints routes /user GET POST /user/{id} DELETE UPDATE /relato GET POST /relato/{id} DELETE UPDATE /artigo GET POST /artigo/{id} DELETE UPDATE /comentario GET POST /comentario/{id} DELETE UPDATE /curso GET POST /curso/{id} DELETE UPDATE

Para Acessar um banco de dados terá duas opções uma H2-console(Banco de dados local memoria)a outra opção é o banco da ORACLE, para conseguir acessar, escolha umas das opções de configuração no arquivo h2sconfig.txt, copie e cole a opção desejada no arquivo Application.properties.

Caso escolha o oracle todas as entidades terão que ter o ID como 'Auto' ou descomentar as annotantions das gerações de sequences

