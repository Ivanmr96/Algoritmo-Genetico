# :bug: Algoritmo-Genetico :bug:

 Programa que ejecutará un algoritmo genético que tendrá como objetivo una frase.
  
 Un algoritmo genetico hace evolucionar una población de elementos, sometiendola a 
 una selección, decidiendo cuales son los elementos mejores adaptados, hasta llegar a un objetivo.

 El algoritmo tiene los siguientes pasos:

 1. **Inicialización**: Se genera una población inicial aleatoria. En este caso de cadena de caracteres.

 2. **Evaluación**: Se determinará una puntuación de aptitud a cada elemento de la población. (Cuáles son los más fuertes)
    En este caso, los elementos más fuertes serán las cadenas de caracteres que más se parezcan a la frase objetivo.

 3. **Selección**: Se escogen dos (pueden ser dos o más) padres.
    ¿Cómo se escogen los padres?
    Cada elemento tendrá una probabilidad de ser elegido como padre según su aptitud, a más aptitud, más probabilidad de
    tener descendencia. En este caso la probabilidad aumentará de forma exponencial.

 4. **Reproducción**: Una vez se han cogido los padres, se deben cruzar sus "genes" para crear un elemento hijo.
    En este caso los "genes" serán las letras del elemento.
    Se cogerán las letras pares de un padre y las impares del otro para dar lugar a un nuevo elemento.
  
 5. **Mutación**: Debe existir una probabilidad (baja) de que se aplique una mutación al nuevo elemento,
    En este caso, la mutación será cambiar un caracter de forma completamente aleatoria por otro
