# Algoritmo-Genetico

 Programa que ejecutar� un algoritmo gen�tico que tendr� como objetivo una frase.
 * 
 * Un algoritmo genetico hace evolucionar una poblaci�n de elementos, sometiendola a 
 * una selecci�n, decidiendo cuales son los elementos mejores adaptados, hasta llegar a un objetivo.
 * 
 * El algoritmo tiene los siguientes pasos:
 * 
 *  1. Inicializaci�n: Se genera una poblaci�n inicial aleatoria. En este caso de cadena de caracteres.
 *  2. Evaluaci�n: Se determinar� una puntuaci�n de aptitud a cada elemento de la poblaci�n. (Cu�les son los m�s fuertes)
 * 		En este caso, los elementos m�s fuertes ser�n las cadenas de caracteres que m�s se parezcan a la frase objetivo.
 *  3. Selecci�n: Se escogen dos (pueden ser dos o m�s) padres.
 * 			�C�mo se escogen los padres?
 * 			Cada elemento tendr� una probabilidad de ser elegido como padre seg�n su aptitud, a m�s aptitud, m�s probabilidad de
 * 			tener descendencia. En este caso la probabilidad aumentar� de forma exponencial.
 * 	4. Reproducci�n: Una vez se han cogido los padres, se deben cruzar sus "genes" para crear un elemento hijo.
 * 			En este caso los "genes" ser�n las letras del elemento.
 * 			Se coger�n las letras pares de un padre y las impares del otro para dar lugar a un nuevo elemento.
 * 	5. Mutaci�n: Debe existir una probabilidad (baja) de que se aplique una mutaci�n al nuevo elemento,
 * 			En este caso, la mutaci�n ser� cambiar un caracter de forma completamente aleatoria por otro.