# Operación fuego de quasar

### Arquitectura

1. Creacion del proyecto con Java 11, Framework spring boot.
2. Nube Heroku.

### Trilateracion

Para realizar la prueba se hizo necesario utilizar el algoritmo de trilateracion 

- Definicion: La trilateración es un método matemático para determinar las posiciones relativas de objetos usando la geometría de triángulos de forma análoga a la triangulación. A diferencia de esta, que usa medidas de ángulo (junto con al menos una distancia conocida para calcular la localización del sujeto), la trilateración usa las localizaciones conocidas de dos o más puntos de referencia, y la distancia medida entre el sujeto y cada punto de referencia. Para determinar de forma única y precisa la localización relativa de un punto en un plano bidimensional usando solo trilateración, se necesitan generalmente al menos 3 puntos de referencia. En wikipedia https://es.wikipedia.org/wiki/Trilateraci%C3%B3n#:~:text=La%20trilateraci%C3%B3n%20es%20un%20m%C3%A9todo,forma%20an%C3%A1loga%20a%20la%20triangulaci%C3%B3n.

- Se utilizo la dependencia:
```xml
<dependency>
    <groupId>com.lemmingapex.trilateration</groupId>
    <artifactId>trilateration</artifactId>
    <version>1.0.2</version>
</dependency>
```
### Documentacion

En las siguientes URL se puede consultar la documentación de los servicios

- https://op-fuego-quasar-ml.herokuapp.com/v2/api-docs
- https://op-fuego-quasar-ml.herokuapp.com/swagger-ui.html

### Pruebas Servicio

Url de la colección de postman para realizar el consumo de los servicios

- https://www.postman.com/redesposicionadas/workspace/test-mercado-libre/overview

- Seleccionar el entorno "env-fuego-quasar-local":

![image](https://user-images.githubusercontent.com/17581875/150932475-5fa6cda8-d489-4bf6-a7c1-2fd7555ef2e0.png)

