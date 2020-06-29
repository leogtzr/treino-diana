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

Recuerde también que Java solo maneja herencia simple, solo puedes extender o heredar de una clase a la vez, lo siguiente es inválido:

```java
class Versa extends Carro, Transporte {

}
```
El compilador marcaría un error ahí. Hay maneras de "simular" herencia múltiple por medio del uso de interfaces.

Todo lo anterior nos dice que las siguientes declaraciones son válidas:

```java
Animal lazy = new Perro();
```

```java
Perro dog = new Labrador();
```

```java
Carro miVersa = new Versa();
```

Lo siguiente se ve raro pero es igual de válido:
```java
Object lazy = new Perro();
```

Es válido porque **Object** es la clase padre de todas las clases.

Y aquí nos metemos con otro conjunto de palabras, frases o vocabulario que necesito que domine. Supongamos la siguiente declaración:

```java
Animal tommy = new Perro();
```
Sobre la declaración anterior podemos decir lo siguiente, y es super importante que todo lo que ponga a continuación se le 
ocurra de manera natural:

- *tommy* es un Perro.
- El tipo de referencia de *tommy* es "Animal".
- "tommy" apunta a un "Perro", aquí haré una parada para explícarle detenidamente a qué me refiero con esto de "referencia".

Lo que está al lado izquiero del "=" es la referencia, es lo apunta a algo concreto (new Perro()).

Una referencia es algo que apunta a algo. En Java tenemos dos zonas de principales de memoria.
El **stack** y el **heap**.
En el stack se guardan las referencias y las variables primitivas, con guardar me refiero a que en esta zona de memoria podemos entender que se guardan las direcciones de memoria que referencian los objetos que están en el **heap**.

| reference name | address |
|----------------|---------|
| lazy| 0xab7|
| versa | 0xbd2|

Entonces, cuando vea un método como el siguiente:

```java
public void foo(Animal an) {

}
```

Usted debe pensar algo como:

El método "foo" recibe como argumento una referencia de tipo "Animal".

¿Y qué le podemos pasar al método foo()?

Cualquier cosa que esté al mismo nivel de Animal o abajo, ejemplo:

```java
foo(new Perro());
```

```java
foo(new Animal());
```

```java
foo(new Labrador());
```

```java
foo(new Chihuahua());
```

Esto es **polimorfismo**, algo que explicaré un poco más adelante.

### Tiempo de hacer algunos ejercicios.

Coloque en el directorio "ejercicios", 5 ejemplos de abstracciones y algunas clases concretas, es decir, algo como:
```java
class Animal {}

class Perro extends Animal {}

class Chihuahua extends Perro {}
```

Piense en 5 abstracciones y declare sus clases.


## Uso de clases abstractas en Java

Para esta explicación necesito que explore el proyecto de NetBeans (code-snippets), abra el archivo
"Animal.java", contiene algo como esto:

```java
package com.training.domain.animal;

public abstract class Animal {
    public abstract void hacerRuido();
}

```

Nótese cómo se ha utilizado el modificador "abstract". En Java existen diversos modificadores.
"abstract" es uno, y con dicho modificador le decimos al compilador que "Animal" es una clase abstracta. Fíjese también que hay dentro la declaración o firma de un método llamado
"hacerRuido()" de tipo *void*. Lo importante aquí con dicho método es que
no tiene implementación, no hay algo como:
```java
public void hacerRuido() {

}
```

Ojo con la siguiente pregunta, teniendo en cuenta la clase anterior ¿cree usted que lo siguiente es válido?

```java
Animal miPerro = new Animal();
```

La respuesta es ¡No!, el compilador daría un error, el porqué es muy sencillo.
¿Cómo podría crear un objeto la máquina virtual JVM si "Animal" no tiene forma?
La clase es abstracta, carece de forma. La finalidad u objetivo de una
clase abstracta es ser extendida, se espera que una clase concreta implemente o dé comportamiento
a lo estipulado en la clase abstracta Animal.

Como conclusión, no se pueden crear instancias u objetos de clases Abstractas, por la simple
razón de que es abstracta, carece de forma, de comportamiento, la máquina virtual no sabría
qué forma o implementación darle al método "hacerRuido".

Abra la clase "Gato" en el mismo paquete y verá algo como esto:
```java
public class Gato extends Animal {
    @Override
    public void hacerRuido() {
        System.out.println("Miauuuuu");
    }
}

```

De esto podemos decir:

- Gato extiende de Animal.
- Gato es una implementación de Animal.
- Gato es una clase concreta.
- Gato extiende de Animal y dá un comportamiento específico basado en su propia naturaleza ("Miauuuu").
- Animal es la clase base o padre de Gato.

Se habrá usted fijado en la anotación @Override, ¿para qué sirve?

La explicación es sencilla, es simplemente un mecanismo del lenguaje para que quien esté leyendo el código fuente sepa que en ese punto se está sobreescribiendo el método desde una clase padre.
Imagina que es una clase de más 500 líneas de código y con varios métodos, y que ninguno de estos métodos tiene la anotación @Override, sería difícil saber en qué punto el programador
está sobreescribiendo un método de la clase Padre, claro que hoy en día hay 
IDEs que nos lo dicen pero bueno ... para eso sirve el @Override.

### Algunas reglas sobre las clases abstractas

- Si algún método tiene el modificador "abstract" entonces la clase debe ser marcada como "abstract":
```java
class X {
    abstract void foo();
}
```
tiene que ser cambiada a 
```java
abstract class X {
    abstract void foo();
}
```
- Si un método tiene el modificador "abstract" entonces no puede tener implementación, lo siguiente sería un error:
```java
public abstract void foo() {
    /// 
}
```
La explicación es la misma, con el modificador estamos diciendo que "no tiene forma", que quien sea
que extienda de la clase debe de dar el comportamiento específico.
- Una clase abstracta puede extender de otra clase abstracta, lo siguiente es perfectamente válido:
```java
abstract class Transporte {
    // ...
}

abstract class Auto extends Transporte {
    // ... 
}
```