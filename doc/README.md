# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)
Autor/a: Youssra Labib   uvus:youlab

## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente.
  * **fp.tipos.netflix**: Paquete que contiene los tipos del proyecto.
  * **test**: Paquete que contiene las clases de test del proyecto.
  * **utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset del proyecto.
    * **netflix_originals.csv**: Archivo csv que contiene datos de diferentes partidas de ajedrez.
    
## Estructura del *dataset*

El dataset original Netflix originals Dataset se puede obtener de la URL [http://kaggle.com/abhimanyudasarwar/netflix-originals](http://kaggle.com/abhimanyudasarwar/netflix-originals). Originalmente tiene 8 columnas y cada fila contiene datos sobre una serie de netflix. El dataset usado en este proyecto tiene 9 columna, 7 se han tomado del dataset original, y dos, el boleano de mundial y el número de visualizaciones, se han generado de forma aleatoria. A continuación se describen las 9 columnas del dataset:

* **title**: de tipo cadena, contiene el nombre de la serie.
* **genre**: de tipo cadena,indica el genero de la serie. 
* **original_network**: de tipo cadena, indica la plataforma en la que está disponible la serie.
* **premiere**: de tipo fecha, indica la fecha de estreno de la serie.
* **seasons**: de tipo entero, indica el numero de temporadas de la serie.
* **episodes**: de tipo entero, indica el numero de capitulos de la serie.
* **status**: de tipo cadena, indica el estado de la serie. Puede tomar los valores: ENDED,RENEWED,PENDING.
* **worldwide**:  de tipo booleano, indica si la serie es disponible en todo el mundo o solo en algunos paises.
* **viewers**: de tipo deciamal, contiene el numero de visualizaciones por 1000000 de la serie.

## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - Netflix
Representa una serie de netflix concreta.
**Propiedades**:

- _titulo_, de tipo _String_, consultable. contiene el nombre de la serie.
- _genero_, de tipo _String_, consultable. Contiene el el genero de la serie.
- _plataforma_, de tipo _String_, consultable. Indica la plataforma en la que está disponible la serie, que seria Netflix.
- _fEstreno_, de tipo _LocalDate_, consultable. Indica la fecha de estreno de la serie.
- _temporadas_, de tipo _Integer_, consultable y modificable. Contiene el numero de temporadas de la serie.
- _capitulos_, de tipo _Integer_, consultable y modificable. Contiene el numero de capitulos de la serie.
- _estado_, de tipo _Estado_, consultable y modificable. Indica el estado de la serie. Puede tomar los valores: ENDED,RENEWED,PENDING.
- _mundial_, de tipo _Boolean_, consultable y modificable. indica si la serie es disponible en todo el mundo o solo en algunos paises. 
- _visualizaciones_, de tipo _Double_, consultable. Indica el numero de visualizaciones por 1000000.
- _tipoClasificacion_, de tipo _TipoClasificacion_, consultable. Indica el tipo de clasificacion. Puede tomar los valores A(si las visualizaciones son mayor que 30), B(si las visualizaciones son entre 10 y 30), C(si las visualizaciones son menores que 10).


**Constructores**: 

- C1: Crea un objeto de tipo ```Netflix``` a partir de los siguientes parámetros: ```String titulo, String genero, String plataforma, LocalDate fEstreno, Integer capitulos, Boolean mundial, Double visualizaciones```.Tiene un parámetro por la propiedad del tipo estado y las temporadas.
- C1: Crea un objeto de tipo ```Netflix``` a partir de los siguientes parámetros: ```String titulo, String genero, String plataforma, LocalDate fEstreno, Integer temporadas,Integer capitulos, Estado estado,Boolean mundial, Double visualizaciones```.

**Restricciones**:
 
- R1: el titulo no puede ser nulo
- R2: las visualizaciones deben ser mayor que cero.
***Criterio de igualdad**: Dos series son iguales si su titulo y fecha de estreno son iguales.

**Criterio de ordenación**: Por titulo y fecha de estreno.

#### Tipos auxiliares

- Estado, enumerado. Puede tomar los valores  ENDED,RENEWED,PENDING.
- TipoClasificacion, enumerado. Puede tomar los valores A, B, C.


**Otras operaciones**:
- _void agregarPartida(Partida p)_: Añade una partida de ajedrez al objeto.
- _Double getPromedioDuracionesMedias(TipoVictoria vic)_: Devuelve la media de la duración media(en segundos) por turno de las partidas. Si la media no se puede calcular, devuelve cero.
- _Map<String, Double> getPorcentajesSiguienteMovimiento(String movimiento, Integer numeroMovimiento)_: Devuelve un Map en el que las claves son movimientos siguientes al dado como parámetro (según el movimiento y la posición en la que se hace), y los valores el porcentaje de veces que se ha hecho ese movimiento. Por ejemplo,     si el movimiento es "Nc6" y el número de movimiento es el 6, el Map contiene como claves los movimientos hechos en séptimo lugar tras un movimiento "Nc6". Los valores serán el porcentaje de veces que se han hecho esos movimientos. Eleva ```IllegalArgumentException```si numeroMovimiento no es mayor o igual que uno.
- _Double getPorcentajeVictoriasDeApertura(String apertura, Resultado resultado)_: Devuelve el porcentaje de partidas que incluyen la cadena de apertura en su apertura y cuyo resultado es el dado como parámetro.
- _SortedSet<Partida> getNPartidasMasCortas(Integer anyo, Integer n)_: Devuelve un conjunto ordenado con las n partidas más cortas jugadas en el año dado como parámetro. El conjunto estará ordenado por el número de movimientos de la partida.
- _List<String> getNMejoresJugadores(Integer anyo, Integer n)_: Devuelve una lista con los ids de los n jugadores con más victorias en el año dado como parámetro.
- _Long getTiempoTotalJuego(String idJugador)_: Devuelve el total de minutos jugados por el jugador dado como parámetro.
- _String getJugadorMasVictorias(Integer anyo, Resultado resultado)_:
Devuelve true si hay algún jugador que tenga más de n victorias.
- _Map<TipoVictoria, String> getGanadorNPorTipoVictoria(Integer n)_:
Devuelve un map en el que las claves son los tipos de victoria y el valor es el enésimo jugador con más rating entre los jugadores que han tenido victorias de ese tipo. Es decir, si hacemos un ranking de los jugadores según su rating, nos quedaríamos con el que está en la posición n.


