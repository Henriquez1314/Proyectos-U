# Guía de Trabajo Práctico Semana 12 - Programación III

Este proyecto contiene la implementación completa de la Guía de Trabajo Práctico de la Semana 12 para la asignatura de Programación III.

## 1. DESCRIPCIÓN DEL PROYECTO

El proyecto aborda los conceptos fundamentales de la Programación Orientada a Objetos en Java:
- Polimorfismo y Ligadura (estática y dinámica).
- Sobrecarga y Sobrescritura de métodos.
- Clases Abstractas e Interfaces.
- Métodos Default en Interfaces.
- Uso de `instanceof` y Casting.

## 2. ESTRUCTURA DEL PROYECTO

```text
Programacion-Semana12/
└── src/
    └── main/
        └── java/
            └── semana12/
                ├── biblioteca/
                │   ├── Material.java (Clase Abstracta)
                │   ├── Prestable.java (Interfaz)
                │   ├── Digital.java (Interfaz)
                │   ├── Libro.java
                │   ├── Revista.java
                │   ├── EBook.java
                │   ├── Mapa.java
                │   ├── Biblioteca.java
                │   └── MainBiblioteca.java (Programa Principal)
                │
                └── ejercicios/
                    ├── ej1/ (Ligadura: Plantas)
                    ├── ej2/ (Sobrecarga Tipos Primitivos)
                    ├── ej3/ (¿Compila? - Errores Comunes)
                    ├── ej4/ (Default Heredado o Sobrescrito)
                    ├── ej5/ (Encontrar los Errores)
                    ├── ej6/ (Diseño Gimnasio)
                    ├── ej7/ (Extensión Audiolibro)
                    └── ej8/ (Reto: Todo Junto)
```

## 3. CONCEPTOS CLAVE

### 3.1. Ligadura Estática vs. Dinámica
- **Ligadura Estática:** Ocurre en tiempo de compilación. Se aplica a métodos estáticos, atributos y métodos finales. El compilador decide qué método llamar basándose en el **tipo declarado** de la variable.
- **Ligadura Dinámica:** Ocurre en tiempo de ejecución. Se aplica a métodos de instancia sobrescritos. La JVM decide qué método llamar basándose en el **tipo real** (objeto en memoria) de la variable.

### 3.2. Sobrecarga vs. Sobrescritura
- **Sobrecarga (Overloading):** Mismo nombre de método pero diferente firma (parámetros) dentro de la misma clase o jerarquía.
- **Sobrescritura (Overriding):** Misma firma de método en una subclase para proporcionar una implementación específica de un método de la superclase.

### 3.3. Interfaces y Métodos Default
Las interfaces pueden definir métodos con implementación utilizando la palabra clave `default`. Esto permite añadir funcionalidades a interfaces existentes sin romper las clases que las implementan.

## 4. EJECUCIÓN DE PROGRAMAS

Cada ejercicio y el caso integrador tienen su propio método `main`. Puedes ejecutarlos individualmente desde IntelliJ IDEA:

1. `semana12.biblioteca.MainBiblioteca`
2. `semana12.ejercicios.ej1.MainEj1`
3. `semana12.ejercicios.ej2.MainEj2`
4. `semana12.ejercicios.ej3.MainEj3`
5. `semana12.ejercicios.ej4.MainEj4`
6. `semana12.ejercicios.ej5.MainEj5`
7. `semana12.ejercicios.ej6.MainEj6`
8. `semana12.ejercicios.ej7.MainEj7`
9. `semana12.ejercicios.ej8.MainEj8`

## 5. RESPUESTAS A PREGUNTAS DE COMPRENSIÓN (SECCIÓN 10)

**1. ¿Qué sucede si una clase no implementa un método abstracto de su superclase?**
Debe declararse como abstracta también, de lo contrario el compilador generará un error indicando que la clase debe implementar todos los métodos abstractos heredados.

**2. ¿Se puede sobrescribir un método estático?**
No. Los métodos estáticos se "ocultan" (hiding), no se sobrescriben. La ligadura es estática, por lo que se llama al método del tipo declarado, no del tipo real.

**3. ¿Cuál es la diferencia entre `instanceof` y el casting?**
`instanceof` es un operador que verifica si un objeto es de un tipo determinado (devuelve true/false). El casting es la operación de convertir una referencia de un tipo a otro tipo compatible (usualmente de superclase a subclase).

**4. ¿Cuándo se prefiere una interfaz sobre una clase abstracta?**
Se prefiere una interfaz cuando se desea definir un comportamiento común (una "capacidad") entre clases que no necesariamente comparten una jerarquía de herencia ("es-un"). Las clases abstractas se prefieren cuando hay un estado compartido (atributos) y una relación conceptual fuerte.

## 6. LISTA DE VERIFICACIÓN (SECCIÓN 11)

- [x] El proyecto utiliza Java 21.
- [x] Se implementó la clase abstracta Material con método abstracto.
- [x] Se implementaron las interfaces Prestable y Digital.
- [x] Se usó el método default para la multa en Prestable.
- [x] Se aplicó polimorfismo en el catálogo de la Biblioteca.
- [x] Se demostró la diferencia entre ligadura estática y dinámica.
- [x] Se implementaron los 8 ejercicios adicionales.
- [x] El código compila y ejecuta correctamente sin errores.
