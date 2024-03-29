# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)
Autor/a: Youssra Labib   uvus:youlab

## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente.
  * **fp.tipos.netflix**: Paquete que contiene los tipos del proyecto.
  * **test**: Paquete que contiene las clases de test del proyecto.
  * **utiles**:  Paquete que contiene las clases de utilidad. 
  * **common**: Paquete que contiene los tipos auxiliares del proyecto.
* **/data**: Contiene el dataset del proyecto.
    * **netflix_originals.csv**: Archivo csv que contiene datos de diferentes partidas de ajedrez.
    
## Estructura del *dataset*

El dataset original Netflix originals Dataset se puede obtener de la URL [http://kaggle.com/abhimanyudasarwar/netflix-originals](http://kaggle.com/abhimanyudasarwar/netflix-originals). Originalmente tiene 8 columnas y cada fila contiene datos sobre una serie de netflix. El dataset usado en este proyecto tiene 9 columna, 7 se han tomado del dataset original, y dos, el boleano de mundial y el número de visualizaciones, se han generado de forma aleatoria. A continuación se describen las 9 columnas del dataset:

* **title**: de tipo cadena, contiene el nombre de la serie.
* **genre**: de tipo cadena,indica el genero de la serie. 
* **original_network**: de tipo List<String>, indica la plataforma en la que está disponible la serie.
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
- _plataforma_, de tipo _List<String>_, consultable. Indica las plataformas en la que está disponible la serie.
- _fEstreno_, de tipo _LocalDate_, consultable. Indica la fecha de estreno de la serie.
- _temporadas_, de tipo _Integer_, consultable y modificable. Contiene el numero de temporadas de la serie.
- _capitulos_, de tipo _Integer_, consultable y modificable. Contiene el numero de capitulos de la serie.
- _estado_, de tipo _Estado_, consultable y modificable. Indica el estado de la serie. Puede tomar los valores: ENDED,RENEWED,PENDING.
- _mundial_, de tipo _Boolean_, consultable y modificable. indica si la serie es disponible en todo el mundo o solo en algunos paises. 
- _visualizaciones_, de tipo _Double_, consultable. Indica el numero de visualizaciones por 1000000.
- _tipoClasificacion_, de tipo _TipoClasificacion_, consultable. Indica el tipo de clasificacion. Puede tomar los valores A(si las visualizaciones son mayor que 30), B(si las visualizaciones son entre 10 y 30), C(si las visualizaciones son menores que 10).


**Constructores**: 

- C1: Crea un objeto de tipo ```Netflix``` a partir de los siguientes parámetros: ```String titulo, String genero, String plataforma, LocalDate fEstreno, Integer capitulos, Boolean mundial, Double visualizaciones```.Tiene un parámetro por la propiedad del tipo estado y las temporadas.
- C2: Crea un objeto de tipo ```Netflix``` a partir de los siguientes parámetros: ```String titulo, String genero, String plataforma, LocalDate fEstreno, Integer temporadas,Integer capitulos, Estado estado,Boolean mundial, Double visualizaciones```.
- C3: Crea un objeto del tipo contenedor con todos los elementos del stream.


**Restricciones**: 
- R1: el titulo no puede ser nulo
- R2: los capitulos deben ser mayor que cero.
***Criterio de igualdad**: Dos series son iguales si su titulo y fecha de estreno son iguales.

**Criterio de ordenación**: Por titulo y fecha de estreno.

#### Tipos auxiliares

- Estado, enumerado. Puede tomar los valores  ENDED,RENEWED,PENDING.
- TipoClasificacion, enumerado. Puede tomar los valores A, B, C.

##### Factoria Netflix
Clase de factoría para construir objetos de tipo Job.
- leerNetflix:recibe como parámetro una cadena con el formato de las líneas del fichero CSV, y devuelve un objeto del tipo Netflix a partir de esa cadena. Emplea el constructor a partir de String.
- leerSeries:recibe como parámetro una cadena que contiene el nombre y ruta del fichero CSV, y devuelve una lista de objetos del tipo Netflix. También utiliza el constructor a partir de String.

##### Tipo Contenedor - Series
Clase contenedora de los objetos de tipo Job.

#### Propiedades:

* **movies** , de tipo <List>, consultable y modificable.
- Constructores: -C1: Constructor por defecto. Crea un objeto de tipo Series sin ninguna serie almacenada. -C2: Constructor con un parámetro de tipo Collection. Crea un objeto de tipo Series con las series incluidas en la colección dada como parámetro.

- Criterio de igualdad:Dos Series son iguales si lo es su propiedad serie, es decir si contienen los mismos objetos de tipo Netflix.

- Representación como cadena: Imprime por pantalla el atributo movies asi como el número de objetos del contenedor.


##### Otras operaciones:

- getNumeroSeries(): devuelve el número de objetos de tipo Netflix del contenedor.
- anadirSerie(Netflix n): añade el Netflix n al contenedor.
- añadirColeccion(Collection c): añade la colleción c al contenedor.
- eliminarSerie(Netflix n): elimina la serie n de la colección.
- existeSerieEnPlataforma(String plataforma): devuelve true si existe alguna serie en la plataforma pasada por parámetro.
- getMediaVisualizacionSerie(String titulo): retorna la visualizacion media del titulo de la serie pasada por parámetro.
- getSeriesLargas(): devuelve un conjunto con las series de mas de 10 capitulos.
- getSeriesPorCategoria():retorna un diccionario que agrupa series por categoria.
- getNumeroSeriesPorEstado(): devueve un diccionario que cuenta el número de series por estado.
- existeSerieConGeneroStream(String genero):Devuelve alguna serie con un genero pasado por parámetro 
- getMediaVisualizacionNetflixStream(String genero): Devuelve la media de visualizacion de las series con genero pasado por parámetro
- getSeriesLargasStream(): Devuelve las series con más de 10 capitulos
- getSerieMundialMaxTemporadas():Devuelve las series mundiales con más temporadas
- getSerieMundialEstadoOrdenadoFechaVisualizacion(Estado e):Devuelve las series mundiales de estado pasado por parámetro ordenadas por fecha de estreno de la serie y después por visualizacion.
- getNumeroSeriesPorEstadoStream(): Devuelve un diccionario contador: seies por estados
- getTitulosPorEstadoStream():Devuelve un diccionario que obtiene por cada estado los titulos de las series.
- getVisualizacionPorFechaStream():Devuelve un map en el que las claves son los años de la fecha de estreno y los valores la serie con mayor visualizaciones (max)
- getSeriesPeoresPorEstado(): Devuelve un SortedMap en el que las claves son los estados y los valores son listas con las n peores series de ese estado.
- getMejorSeriePorMedia():  Calcula un map con la visualizacion media por genero y devuelve el genero con mayor visualizacion


