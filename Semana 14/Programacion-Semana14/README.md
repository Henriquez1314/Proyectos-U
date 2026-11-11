# Programacion-Semana14

**Universidad:** Universidad Politécnica (UPED)  
**Materia:** Programación III  
**Semana:** 14  
**Unidad IV:** Excepciones  
**Tema:** Jerarquía checked y unchecked  

---

## Descripción del Proyecto

Este proyecto contiene la implementación completa y detallada de la **Guía de Trabajo Práctico Semana 14** para la asignatura de Programación III. El contenido está enfocado en el estudio profundo de la **jerarquía de excepciones en Java**, diferenciando entre excepciones **checked** y **unchecked**, y practicando el manejo de múltiples catch, polimorfismo de excepciones y casos integradores.

El proyecto sigue la misma estructura y estilo de organización que la **Semana 13**, manteniendo uniformidad en el repositorio y facilidad de apertura en **IntelliJ IDEA**.

---

## Estructura de Carpetas

```
Programacion-Semana14/
├── .idea/
├── README.md
├── Programacion-Semana14.iml
└── src/
    └── main/
        └── java/
            └── semana14/
                ├── bloque1/          (Jerarquía de excepciones)
                │   ├── Jerarquia.java
                │   ├── Recursion.java
                │   └── Hotel.java
                │
                ├── bloque2/          (Excepciones checked y unchecked)
                │   ├── Espera.java          (No compila - InterruptedException sin atender)
                │   ├── Espera2.java       (Compila - try-catch con checked)
                │   ├── Nunca.java           (No compila - capturar checked que no puede producirse)
                │   └── Nunca2.java        (Compila - excepción unchecked)
                │
                ├── bloque3/          (Varios catch y jerarquía)
                │   ├── Orden.java           (No compila - orden incorrecto de catch)
                │   ├── Orden2.java        (Compila - orden correcto de catch)
                │   └── Multi.java         (Multi-catch NumberFormatException y NullPointerException)
                │
                ├── integrador/       (Caso Integrador: Cotizador de reservas de hotel)
                │   └── Reservas.java
                │
                └── ejercicios/       (Ejercicios de práctica sección 10)
                    ├── Ej2.java         (Clasificación de excepciones con letras A, B, C)
                    ├── Ej6.java         (Cuatro resultados de manejo de excepciones)
                    ├── Ej7Mal.java      (Incorrecta - dos errores de compilación)
                    └── Ej7.java         (Corregida - catch ordenados adecuadamente)
                   
                └── teoria/           (Trabajo autónomo sección 11)
                    └── CuadroComparativo.java
```

---

## Descripción de Cada Clase

### Bloque I - Jerarquía de excepciones
- **Jerarquia.java**: Muestra las cadenas de herencia de diferentes excepciones utilizando `getSuperclass()`. Imprime la relación entre `Throwable`, `Error`, `Exception` y `RuntimeException`. Para cada excepción mostrada, indica si es Error (problema de sistema) o Exception (verificada/no verificada).
- **Recursion.java**: Demuestra el funcionamiento de `StackOverflowError` mediante recursión infinita. Captura el error y muestra su tipo y mensaje explicativo.
- **Hotel.java**: Implementa catch polimórfico. Un único bloque `catch (RuntimeException e)` captura diferentes tipos de excepciones en tiempo de ejecución. Muestra el tipo real mediante `getClass().getSimpleName()`.

### Bloque II - Excepciones checked y unchecked
- **Espera.java**: Ejemplo intencional **que NO compila** porque `InterruptedException` lanza dentro del try pero no es atendida (falta bloque catch o declaración throws). Conservado con su error didáctico.
- **Espera2.java**: Muestra cómo atender las excepciones checked mediante `try-catch` adecuado. El programa compila y ejecuta sin errores.
- **Nunca.java**: Ejemplo intencional **que NO compila** porque se intenta capturar una excepción checked (`IOException`) que no puede producirse dentro del bloque try actual. Conservado con su error didáctico.
- **Nunca2.java**: Muestra el ejemplo que SÍ compila con una excepción unchecked (`ArithmeticException`). Al ser `RuntimeException`, no es obligatorio declararla ni capturarla explícitamente, pero se captura demostrando buenas prácticas.

### Bloque III - Varios catch y jerarquía
- **Orden.java**: Ejemplo intencional **que NO compila** por orden incorrecto de catch. Se captura `RuntimeException` (superclase) antes que `ArithmeticException` (subclase), causando error "unreachable exception type". Conservado con su error didáctico.
- **Orden2.java**: Ordena los catch correctamente, desde la excepción más específica (`ArithmeticException`) hasta la más general (`Exception`). Demuestra el funcionamiento de los distintos catch.
- **Multi.java**: Utiliza multi-catch para capturar `NumberFormatException` y `NullPointerException` en una sola sentencia `catch`. Muestra los resultados de los diferentes casos (excepción, éxito).

### Caso Integrador - Cotizador de reservas de hotel
- **Reservas.java**: Programa que maneja un arreglo de tarifas, procesa cinco solicitudes de reserva, recibe tipo de habitación, noches y cantidad de personas, calcula precio por persona, simula la espera de confirmación usando `Thread.sleep(10)`, y maneja `NumberFormatException`, `ArithmeticException` e `IndexOutOfBoundsException` mediante multi-catch, y `InterruptedException` obligatoriamente. Continúa procesando las demás reservas aunque una solicitud presente errores.

### Ejercicios de Práctica (Sección 10)
- **Ej2.java**: Muestra las letras A, B y C según el tipo de excepción capturada (ArithmeticException, NumberFormatException, ArrayIndexOutOfBoundsException).
- **Ej6.java**: Muestra los cuatro resultados indicados en la guía: ArithmeticException capturado, NumberFormatException capturado, ArrayIndexOutOfBoundsException capturado y operación exitosa.
- **Ej7Mal.java**: Versión incorrecta con dos errores de compilación (catch inalcanzable y InterruptedException no atendida), conservada para estudio.
- **Ej7.java**: Versión corregida con catch ordenados adecuadamente y manejo de InterruptedException.

### Teoría - Trabajo Autónomo (Sección 11)
- **CuadroComparativo.java**: Muestra un cuadro comparativo con 6 excepciones de Java: 2 checked (IOException, SQLException) y 4 unchecked (ArithmeticException, NullPointerException, ClassCastException, FileNotFoundException). Para cada una incluye: nombre, categoría, cadena de herencia, situación que la provoca y cómo responder ante ella.

---

## Explicación de los Conceptos Aplicados

1. **Jerarquía de excepciones**: Se exploró la relación de herencia entre `Throwable` (la raíz), `Error` (errores de sistema graves) y `Exception` (excepciones que pueden ser verificadas o no). Dentro de `Exception`, se diferencian las **checked** (heredan directamente de `Exception`, deben ser atendidas en compilación) de las **unchecked** (heredan de `RuntimeException`, no es obligatorio atenderlas en compilación).

2. **Excepciones checked vs unchecked**: Se diferenciaron mediante ejemplos prácticos. Las checked (como `InterruptedException`, `IOException`, `SQLException`) obligan a escribir código `try-catch` o declarar `throws`. Las unchecked (como `ArithmeticException`, `NullPointerException`, `ArrayIndexOutOfBoundsException`) son típicas errores de programación que el compilador no exige tratar explícitamente.

3. **Polimorfismo de excepciones**: Un bloque `catch (RuntimeException e)` puede capturar cualquier excepción que sea subclase de `RuntimeException` en tiempo de ejecución, y se puede determinar el tipo real con `e.getClass().getSimpleName()`.

4. **Orden de catch**: Las excepciones deben capturarse desde la más específica (subclase) hasta la más general (superclase). Si se captura una superclase antes que una subclase, la subclase queda inalcanzable y causa error de compilación.

5. **Multi-catch**: Desde Java 7, es posible capturar múltiples excepciones en un solo bloque `catch` utilizando el operador pipe (`|`). Las variables capturadas en multi-catch son final implicitly.

6. **Thread.sleep(10)**: Utilizado en el caso integrador para simizar la espera de confirmación de reservas. Al ser una excepción checked, debe ser manejada obligatoriamente con try-catch o declarada en `throws`.

---

## Instrucciones para Ejecutar los Programas

### Requisitos previos
- Tener instalado **Java JDK 8** o superior.
- Tener configurado **IntelliJ IDEA** (Community Edition o Ultimate).

### Pasos para ejecutar desde IntelliJ IDEA

1. **Abrir el proyecto:**
   - Iniciar IntelliJ IDEA.
   - Seleccionar `Open` y navegar hasta: `C:\Proyectos U\Program 3\Semana 14\Programacion-Semana14`.
   - Importar el proyecto como proyecto Java estándar (no es necesario Maven/Gradle, es un proyecto plano con estructura de carpetas `src`).

2. **Compilar el proyecto:**
   - Verificar que todos los archivos tengan sintaxis correcta.
   - Los archivos diseñados para no compilar intencionalmente (`Espera.java`, `Nunca.java`, `Orden.java`, `Ej7Mal.java`) permanecerán en carpetas aisladas y no impedirán la compilación del resto.
   - Hacer clic en `Build` -> `Build Project` o presionar `Ctrl + F9`.

3. **Ejecutar clases individuales:**
   - Cada archivo contiene su propio método `main()`.
   - Para ejecutar un ejemplo específico, hacer clic secundario (botón derecho) sobre la clase deseada en el explorador de archivos y seleccionar **Run 'Clase.main()'**.
   - Alternativamente, usar la línea de comandos:
     ```
     cd C:\Proyectos U\Program 3\Semana 14\Programacion-Semana14\src\main\java
     javac semana14/bloque1/Jerarquia.java
     java semana14.bloque1.Jararquia
     ```

4. **Ejecutar el caso integrador:**
   - Ubicarse en: `Reservas.java` dentro de la carpeta `integrador`.
   - Ejecutar `Reservas.main()`.
   - El programa solicitará al usuario ingresar datos para 5 reservas a través de la consola.

---

## Identificación de Archivos que No Compilan Intencionalmente

Los siguientes archivos están diseñados con errores didácticos propositados para estudiar errores de compilación específicos. **Están separados aislados** en sus respectivas carpetas para que no impidan la compilación y ejecución del resto del proyecto:

1. **`Espera.java`** (Bloque II)
   - **Error:** `InterruptedException` lanzada dentro del `try` pero no atendida (falta `catch` o `throws`).
   - **Mensaje de error esperado:** "unreported exception java.lang.InterruptedException; must be caught or declared to be thrown"

2. **`Nunca.java`** (Bloque II)
   - **Error:** Se intenta capturar `IOException` pero esta excepción **no puede producirse** dentro del bloque `try` actual.
   - **Mensaje de error esperado:** Error de contexto donde `IOException` no es lanzado por el código en el `try`.

3. **`Orden.java`** (Bloque III)
   - **Error:** Orden incorrecto de `catch`. `RuntimeException` (superclase) va antes que `ArithmeticException` (subclase), haciendo inalcanzable a la subclase.
   - **Mensaje de error esperado:** "unreachable exception type ArithmeticException"

4. **`Ej7Mal.java`** (Ejercicios)
   - **Errores:** (1) `catch (Exception e)` inalcanzable por orden incorrecto, (2) `InterruptedException` no atendida en el bloque try.
   - **Mensajes de error esperados:** Errores de alcance de excepciones y excepción no reportada.

---

## Descripción del Caso Integrador

El **Cotizador de reservas de hotel** (`Reservas.java`) es un programa completo que simula un sistema de reservación hotelera con validación de entradas. El programa debe:

1. **Manejar un arreglo de tarifas:** Se definen tarifas base por tipo de habitación (Simple, Doble, Suite).
2. **Procesar cinco solicitudes de reserva:** Se iteran 5 veces para capturar diferentes escenarios.
3. **Recibir datos de entrada:** Tipo de habitación (1-3), número de noches y cantidad de personas.
4. **Calcular precio por persona:** `precioPorPersona = (tarifaBase * noches) / personas`.
5. **Simular espera de confirmación:** Usar `Thread.sleep(10)` para simular tiempo de procesamiento de reserva.
6. **Manejar `NumberFormatException`:** Si el usuario ingresa texto en campos numéricos.
7. **Manejar `ArithmeticException` e `IndexOutOfBoundsException` mediante multi-catch:** División por cero o acceso inválido a arreglo de tarifas.
8. **Manejar obligatoriamente `InterruptedException`:** Dado que `Thread.sleep(10)` lanza esta excepción checked.
9. **Continuar procesando reservas:** A pesar de errores en alguna solicitud, el programa continúa con las siguientes reservas.

### Resultados esperados de la ejecución del caso integrador

Al ejecutar `Reservas.java` y proporcionar las entradas según el ejemplo de la guía, se debe obtener una salida similar a:

```
=== CASO INTEGRADOR: COTIZADOR DE RESERVAS DE HOTEL ===

--- Procesando Reserva 1 ---
Tipo de habitación (1=Simple, 2=Doble, 3=Suite): 1
Número de noches: 2
Cantidad de personas: 1
Simulando espera de confirmación...
Reserva 1: $65 por persona

--- Procesando Reserva 2 ---
Tipo de habitación (1=Simple, 2=Doble, 3=Suite): 1
Número de noches: -1
Cantidad de personas: 1
Reserva 2: noches invalidas

--- Procesando Reserva 3 ---
Tipo de habitación (1=Simple, 2=Doble, 3=Suite): 1
Número de noches: 2
Cantidad de personas: 0
Reserva 3: datos inconsistentes (ArithmeticException)

--- Procesando Reserva 4 ---
Tipo de habitación (1=Simple, 2=Doble, 3=Suite): 5
Número de noches: 2
Cantidad de personas: 1
Reserva 4: datos inconsistentes (ArrayIndexOutOfBoundsException)

--- Procesando Reserva 5 ---
Tipo de habitación (1=Simple, 2=Doble, 3=Suite): 1
Número de noches: 2
Cantidad de personas: 1
Simulando espera de confirmación...
Reserva 5: $130 por persona

=== FIN DEL PROGRAMA: Todas las reservas procesadas ===
```

---

## Objetivos

1. **Comprender la jerarquía de excepciones en Java:** Identificar la relación entre `Throwable`, `Error`, `Exception`, `RuntimeException` y sus subclases.
2. **Diferenciar excepciones checked vs unchecked:** Saber cuándo es obligatorio manejar una excepción en compilación y cuándo no lo es.
3. **Practicar el manejo de múltiples `catch`:** Aprender el orden correcto (específico antes que general) y el uso de multi-catch.
4. **Aplicar polimorfismo de excepciones:** Usar `catch (RuntimeException e)` para capturar diferentes tipos de excepciones y determinar su tipo real con `getClass()`.
5. **Desarrollar el caso integrador:** Integrar todos los conceptos vistos en la semana para crear un programa funcional de cotización de reservas.
6. **Reconocer y analizar errores didácticos:** Identificar por qué ciertos ejemplos no compilan y cuál es el error específico de cada uno.
7. **Mejorar la estructura y buenas prácticas:** Mantener código sencillo, claro y ordenado, siguiendo convenciones consistentes con proyectos previos (Semana 13).

---

## Notas Finales

- Los archivos `Espera.java`, `Nunca.java` y `Orden.java` están incluidos con fines **educativos** para demostrar errores comunes en el manejo de excepciones. No deben corregirse eliminando su propósito didáctico; sirven como ejemplos de "lo que no hacer" o de errores comunes en principiantes.
- La estructura de paquetes `semana14.bloque1`, `semana14.bloque2`, etc., facilita la navegación y evita mezclas entre clases de diferentes apartados.
- Este proyecto está diseñado para ser abierto y trabajado completamente en **IntelliJ IDEA**, respetando la misma organización vista en la **Semana 13**.