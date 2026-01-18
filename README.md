# PrototipoLavanderiaLita
Prototipo de um programa de terminal em java para o gerenciamento de uma lavanderia independente

Para executar, deve rodar o comando dentro da pasta LavanderiaLita/dist
java -jar LavanderiaLita.jar -h

dessa forma ira aparecer uma lista de comandos


Considerações:
O trabalho foi feito pensando em ter um ambiente gráfico pelo terminal, tanto
que a maior parte do tempo foi dedicado a criacão das telas. Para velas é possivel usar os comando -c -f e -s, sendo o -s uma aba de cadastrar um cliente.

todos os contratos de operações estão dentro da pasta LavanderiaLita/src/Manager.

É possivel observar que com o comando -h, existem as --func, elas são a tentativa de colocar os contratos de operações para rodar dentro do código, foi uma implementação de última hora, e só consegui testar o comando iniciarFeedback, então não tenho certeza se os outros estão funcionado.

Foi possivel implementar a classe Screen e DaoBehavior, que são classes que automatizam o processo de criacão das classe.

Não foi possivel implementar um visual para retornar os valores, então todos os dados armazenados ficam em LavanderiaLita/saves em formato de txt na forma de dados separados por ;
