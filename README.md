# Operación fuego de quasar

### Trilateracion

Para realizar la prueba se hizo necesario utilizar el algoritmo de trilateracion "La trilateración es un método matemático para determinar las posiciones relativas de objetos usando la geometría de triángulos de forma análoga a la triangulación. A diferencia de esta, que usa medidas de ángulo (junto con al menos una distancia conocida para calcular la localización del sujeto), la trilateración usa las localizaciones conocidas de dos o más puntos de referencia, y la distancia medida entre el sujeto y cada punto de referencia. Para determinar de forma única y precisa la localización relativa de un punto en un plano bidimensional usando solo trilateración, se necesitan generalmente al menos 3 puntos de referencia."

### Arquitectura

![image](https://user-images.githubusercontent.com/17581875/150808130-e3f146c4-1339-4cb3-835d-5b9405369b76.png)

1. Creacion del proyecto en AWS
2. Cliente se conecta a una API expuesta por medio de un ApiGateway
3. ApiGateway ejecuta una funcion lambda construida con java 8 y spring boot
