# Magneto-api



Examen Mercadolibre

Magneto te ha contratado a ti para que desarrolles un proyecto que detecte si un
humano es mutante basándose en su secuencia de ADN.

En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla
de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras
iguales, de forma oblicua, horizontal o vertical.

Ejemplo (Caso mutante):
String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};


##Comenzando
Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.

###Pre-requisitos

-Tener instalado Java  JDK 11

-Tener instalado Maven

-Tener instaldo Docker 


### Instalación 

1 - instalar  mongo db en un contenedor 
-comandos

sudo docker pull mongo

sudo docker run -p 27017:27017 --name mongodb mongo 

Con esos dos comandos ya tienes un contenedor con mongodb corriendo y te conectaras con el puerto 27017

2 - Obtén el proyecto


git clone https://github.com/ND20011/Magneto-api.git


3 - Abrir una terminal apuntando a la carpeta del proyecto y ejejutar estos comando para inicializar el programa 

    mvn clean install
    
    cd ./target
    
    java -jar magneto-0.0.1-SNAPSHOT.jar 


### Construido con  

- Java 11
- Maven
- spring boot framework
- mongo db 


###Como probar el proyecto localmente   

    Usando postman
     
    para detectar si una persona es humano o mutante enviar una peticion post  
    http POST http://localhost:9000/api/persons/mutant 
    
    tendras que enviar un json con este formato 
    {
    "dna":[
    	"ATGCGA",
    	"CAGTGC",
    	"TTATGT",
    	"AGAACG",
    	"TTTTTT",
    	"CACTCC"]
    }
     Te devolvera un http 200-Ok si es mutante 
     Te devolvera un http 403-Forbidden si es humano 
      
     

   http GET http://localhost:9000/api/persons/stats
   
    Devuelve un Json con las estadísticas de las verificaciones de ADN:
   