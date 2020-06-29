# Training for the next interview

## Cómo correr el código fuente

El código para este mini training está en un proyecto de NetBeans

Para evitarnos problemas sugiero que hagas esto antes que todo:
- Instalar NetBeans (la versión más reciente)
- Instalar la versión más reciente de JDK, yo actualmente estoy usando
Java 14.
- Agregar el directorio "bin" de la instalación de Java al PATH de Windows
o Linux, esto hará posible que invoques el compilador desde la línea de comandos.
Eso realmente no es para efectos del "training", todo programador Java debe tener este setup.
Debe de ser capaz de invocar rápidamente por medio de la línea de comandos
al compilador.

Deberías ser capaz de ver algo así cuando invocas al comando javac y java con su opción **-version**

```
0 [12:11]leo@lein ~ $ javac -version
javac 14
0 [12:11]leo@lein ~ $ java -version
openjdk version "14" 2020-03-17
OpenJDK Runtime Environment (build 14+36-1461)
OpenJDK 64-Bit Server VM (build 14+36-1461, mixed mode, sharing)
0 [12:11]leo@lein ~ $ 
```
- Instalar la versión más reciente de Maven.

## Sobre las clases y la clase Object

Todas las clases extienden de la clase Object, Object es la clase padre de todas las clases.

Si usted por ejemplo explora el **javadoc** para la clase String verá algo así:

https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/String.html

![imgs](imgs/string-object.png)

Es importante que recuerde que todas las clases extienden de Object.

## Sobre la Herencia y el vocabulario

Es importante forjar un vocabulario cuando estamos en un contexto de *Programación Orientada a Objectos* u OOP en inglés (Object Oriented Programming).

Es importante que usted siempre explique la herencia o hable en términos de ella usando frases como:

- "La clase X extiende de la clase Y"
- "La clase X está en la misma jerarquía que Y"
- "Clase X es un Y"
- "La clase X hereda de Y"
- "La clase Y es la clase padre de X"

Y similares ... aquí lo importante es que con estas frases usted da a entender a la persona que escucha
que usted entiende bien quién extiende/hereda de quién.

## "Is-A" "Has-A"

Si usted ve la siguiente declaración de clase:
```java
class Animal {

}
```

Y luego ve la siguiente clase:
```java
class Perro extends Animal {

}
```

Es importante que aterrice la idea de que "Perro" **es un** "Animal". **Es un** por el
simple hecho de que *Perro* está en la misma jerarquía que "Animal".

Lo correcto es explicarlo de la siguiente manera:

- Perro es un Animal
- Perro extiende de Animal
- Perro hereda de Animal
- Animal está arriba de Perro, Perro está abajo de Animal.
- Perro es algo más específico que Animal.

**OJO!**

![imgs](imgs/jelga.jpg)

Es super importante que entiendas esto, hay cosas abstractas y cosas específicas.

Si yo te digo, por favor dibújame un "animal", o si te digo "calcúlame el área de una figura", o si te pregunto "¿qué ruido hace el animal?"

Fíjate que estoy hablando en términos abstractos, porque tu respuestas serían:

- ¿Qué animal puedo dibujar?
- ¿De qué figura calculo el área?
- ¿De qué animal hablamos como para saber qué ruido hace?

Hay cosas que son abstractas, que no tienen una forma específica, todos esos ejemplos
deberían ser o **clases abstractas** o **interfaces** que lo veremos más adelante.

Volvamos a lo que decía antes del *meme*, "Perro es algo más específico" que "Animal".

Porque con "Perro" ya sabemos algo, ya sabemos en específico qué animal es, ya hasta
podemos saber qué ruido hace el animal.

- "Labrador" es más específico que "Perro".
- "Labrador" es una clase hija de "Animal", Labrador es un Animal (is-a).
- Perro es la clase base de Labrador.
- Animal es la clase base de Perro y de Labrador.

Lo que estoy tratando de explicarle es el concepto de "is-a" el cual es un tema super
tratado en cualquier libro de Programación Orientada a Objetos.

Imagine que alguien dice:
- Me compré un carro.

El que escucha se preguntará "¿Qué carro?, el que dijo que se compró un carro está hablando de manera "abstracta", no tiene forma aún lo que dice.
Tendrá forma hasta que haya algo específico, algo concreto, hasta que diga algo como:
"Me compré un carro Nissan Versa", ¡Ah, aquí es diferente! ya sabemos lo específico.

```java
abstract class Carro {
    // propiedades
}
```

```java
class Versa extends Carro {

}
```

También podríamos decir que *Versa* es una implementación de la clase Carro. ¿Por qué una implementación? porque ya no estamos hablando en términos generales (abstracciones), sino que 
ya damos vida a algo concreto.

Todo lo anterior nos dice que las siguientes declaraciones son válidas:

```java
Animal lazy = new Perro();
```

```java
Perro dog = new Labrador();
```
Y aquí nos metemos con otro conjunto de palabras, frases o vocabulario que necesito que domine.

### package (abstract)

