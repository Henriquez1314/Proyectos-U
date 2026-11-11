# Guía de Trabajo Práctico Semana 13 - Programación III

Este proyecto contiene la implementación completa y detallada de la Guía de Trabajo Práctico de la Semana 13 para la asignatura de Programación III, enfocada en el **Manejo de Excepciones en Java**.

---

## 1. Descripción del Proyecto

El proyecto aborda los conceptos fundamentales del control y gestión de errores en Java:
- Manejo de excepciones con `try`, `catch`, `finally`.
- Propagación y lanzamiento de excepciones utilizando `throw` y `throws`.
- Creación de Excepciones Personalizadas (*Checked* vs *Unchecked*).
- Captura de múltiples excepciones y operador Multi-catch.
- Re-lanzamiento de excepciones (*Re-throwing*).
- Gestión de recursos automáticos mediante `AutoCloseable` y `try-with-resources`.
- Caso Integrador: Procesamiento de compras en la caja de una tienda en línea.

---

## 2. Estructura del Proyecto

```text
Programacion-Semana13/
├── .idea/
├── Programacion-Semana13.iml
├── README.md
└── src/
    └── main/
        └── java/
            └── semana13/
                ├── excepciones/
                │   ├── ExcepcionSaldoInsuficiente.java
                │   ├── ExcepcionStockInsuficiente.java
                │   └── ExcepcionProductoNoEncontrado.java
                │
                ├── tienda/
                │   ├── Producto.java
                │   ├── Cuenta.java
                │   ├── Carrito.java
                │   ├── TiendaOnline.java
                │   ├── Compra.java
                │   └── MainTienda.java
                │
                └── ejercicios/
                    ├── ej1/
                    │   └── MainEj1.java
                    ├── ej2/
                    │   └── MainEj2.java
                    ├── ej3/
                    │   └── MainEj3.java
                    ├── ej4/
                    │   ├── ExcepcionEdadInvalida.java
                    │   └── MainEj4.java
                    ├── ej5/
                    │   └── MainEj5.java
                    ├── ej6/
                    │   └── MainEj6.java
                    └── ej7/
                        ├── RecursoSimulado.java
                        └── MainEj7.java
```

---

## 3. Conceptos Clave Desarrollados

### 3.1. Excepciones Checked vs Unchecked
- **Checked Exceptions (Verificadas):** Heredan directamente de `java.lang.Exception`. El compilador obliga a manejarlas explícitamente mediante un bloque `try-catch` o declararlas en la firma del método con `throws`.
- **Unchecked Exceptions (No Verificadas):** Heredan de `java.lang.RuntimeException`. Representan errores de programación o condiciones inesperadas en tiempo de ejecución. No es obligatorio declararlas ni capturarlas explícitamente.

### 3.2. Propagación de Excepciones (`throw` y `throws`)
- `throw`: Palabra clave utilizada dentro del cuerpo de un método para instanciar y lanzar explícitamente un objeto de excepción.
- `throws`: Se utiliza en la declaración del método para advertir a los invocadores que el método puede emitir ciertos tipos de excepciones verificadas.

### 3.3. Bloque `finally` y `try-with-resources`
- `finally`: Bloque opcional que se ejecuta **siempre**, independientemente de si se lanzó o capturó una excepción. Útil para liberar recursos manualmente.
- `try-with-resources`: Introducido en Java 7, gestiona automáticamente el cierre de cualquier recurso que implemente la interfaz `AutoCloseable`, eliminando la necesidad de bloques `finally` explícitos para cerrar streams o conexiones.

---

## 4. Ejecución de Programas desde IntelliJ IDEA

Cada ejercicio y el Caso Integrador cuentan con su propio método `main`. Puedes ejecutarlos individualmente haciendo clic secundario en la clase deseada y seleccionando **Run '...main()'**:

1. `semana13.tienda.MainTienda` — Caso Integrador (Caja de Tienda Online)
2. `semana13.ejercicios.ej1.MainEj1` — Captura básica de excepciones (`ArithmeticException`, `InputMismatchException`)
3. `semana13.ejercicios.ej2.MainEj2` — Propagación de excepciones (`throw` y `throws`)
4. `semana13.ejercicios.ej3.MainEj3` — Bloque `finally` y garantía de liberación
5. `semana13.ejercicios.ej4.MainEj4` — Excepciones personalizadas (*Checked* vs *Unchecked*)
6. `semana13.ejercicios.ej5.MainEj5` — Captura múltiple y Multi-catch
7. `semana13.ejercicios.ej6.MainEj6` — Re-lanzamiento (*re-throwing*) de excepciones
8. `semana13.ejercicios.ej7.MainEj7` — Manejo de recursos con `try-with-resources`

---

## 5. Preguntas de Comprensión y Respuestas

**1. ¿Cuál es la diferencia fundamental entre una excepción Checked y una Unchecked?**  
Las excepciones *Checked* deben ser gestionadas obligatoriamente en tiempo de compilación (`try-catch` o `throws`), mientras que las *Unchecked* derivan de `RuntimeException` y el compilador no exige su tratamiento explícito.

**2. ¿Cuándo se ejecuta el bloque `finally`?**  
El bloque `finally` se ejecuta **siempre**, tanto si el bloque `try` finaliza con éxito como si ocurre una excepción (incluso si dentro del `try` o `catch` existe una sentencia `return`).

**3. ¿Qué ventaja ofrece la instrucción `try-with-resources` sobre `try-catch-finally` tradicional?**  
Garantiza el cierre automático e incondicional de los recursos que implementen `AutoCloseable`, evitando fugas de memoria y reduciendo código repetitivo en bloques `finally`.

**4. ¿Por qué es importante el orden de los bloques `catch` al capturar múltiples excepciones?**  
Las excepciones deben capturarse desde la clase más específica (subclase) a la más general (superclase). De lo contrario, las subclases quedarán inalcanzables y causarán un error de compilación.

---

## 6. Estado de Compilación

Todos los módulos y clases han sido compilados y verificados con éxito mediante el compilador `javac` de Java.
