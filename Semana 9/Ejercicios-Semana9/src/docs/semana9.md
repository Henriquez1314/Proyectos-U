# Guía de Trabajo Práctico — Programación III — Semana 9

**Unidad III (Semanas 9+): Polimorfismo — Contenido 3.1: Ligadura estática y ligadura dinámica**
**Fuente:** `Semana9_GuiaTrabajo_ProgramacionIII_UPED.pdf` (17 páginas, docente: Ing. Oscar Armando Contreras Álvarez, ciclo 02-2026).

La Semana 9 **no introduce sintaxis nueva** de Java: explica *cómo y cuándo* el compilador y la JVM deciden qué código ejecutar. La jerarquía `Persona` **no se toca** (quedó cerrada al final de la Unidad II). El caso nuevo (instrumentos musicales) vive en un paquete independiente `com.uped.musica`.

---

## 0. Nota obligatoria: una inconsistencia de la guía en la sección 7

La guía presenta un conflicto interno que impide compilar literalmente su sección 7:

- **§7.1** declara `protected String tipo = "generico";` en `com.uped.musica.modelo.Instrumento`.
- **§7.3** ubica `MainBanda` en el paquete `com.uped.musica` (distinto de `modelo`) y ejecuta `System.out.println(i.tipo);`.

En Java, un miembro `protected` solo es accesible desde el **mismo paquete** o desde **subclases** (y, para acceder a través de una instancia desde otro paquete, solo si el tipo de la referencia es la subclase). `MainBanda` está en otro paquete y **no** es subclase de `Instrumento`, por lo que `i.tipo` **no compila**.

> **Decisión tomada (validada):** se cambió únicamente el modificador del campo `tipo` de `protected` a `public` en `Instrumento` y `Guitarra` de la sección 7. Todo lo demás de la guía se respeta: paquete de `MainBanda` (`com.uped.musica`), la llamada `i.tipo` y la salida exacta. El fenómeno de **ocultamiento de variables** (que es el objetivo pedagógico) se conserva intacto: `Guitarra` sigue redeclarando su propio campo `tipo`.

Ninguna otra parte de la guía tiene este problema: en §8.3 (`Instrumento`/`Violin`) el campo `tipo` no tiene modificador y todas las clases están en el **mismo** paquete `com.uped.violin`, por lo que `v.tipo` sí compila.

---

## 1. Organización del proyecto (sección 4 de la guía)

```
Ejercicios-Semana9/
├── src/main/java/com/uped/proyecto/            ← SIN CAMBIOS (jerarquía Persona)
│   ├── Main.java
│   └── modelo/ Persona, Cliente, Empleado, Estudiante, Docente,
│                Voluntario, Proveedor, Gerente, DocenteInvestigador, ClienteVIP
├── src/docs/
│   ├── diagrama-clases.md                      ← SIN CAMBIOS (S7)
│   ├── respuesta.md                            ← SIN CAMBIOS (S6/S7)
│   ├── semana8.md                              ← SIN CAMBIOS (S8)
│   └── semana9.md                              ← NUEVO (este documento)
└── src-ejemplos/
    └── com/uped/
        ├── musica/                             ← NUEVO (sección 7)
        │   ├── MainBanda.java
        │   ├── modelo/ Instrumento (abstracta), Guitarra, Piano, Bateria
        │   └── demo/ DemoReglas.java           ← NUEVO (demos de la sección 6)
        ├── sensores/                           ← NUEVO (8.1)
        │   ├── Sensor.java, SensorTemperatura.java, MainSensor.java
        ├── violin/                             ← NUEVO (8.3)
        │   ├── Instrumento.java, Violin.java, MainViolin.java
        ├── figuras/ …                          ← SIN CAMBIOS (S8)
        ├── notificaciones/ …                   ← SIN CAMBIOS (S8)
        └── transporte/ …                       ← SIN CAMBIOS (S8)
```

El paquete `com.uped.musica` es exclusivo de esta guía. Los ejemplos de verificación 8.1 y 8.3 se dejaron en paquetes propios (`com.uped.sensores`, `com.uped.violin`) para no mezclarlos con el proyecto incremental.

---

## 2. Sección 5 — Qué es la ligadura y cómo se resuelve (Bloque I)

**Ligadura (binding):** conectar una llamada `objeto.metodo()` con el código real que la resuelve.

| Tipo de ligadura | Cuándo se decide | Quién decide |
|---|---|---|
| **Estática** | En tiempo de **compilación**, antes de ejecutar | El compilador (`javac`), leyendo el código fuente |
| **Dinámica** | En tiempo de **ejecución**, mientras corre | La JVM, consultando el **objeto real** |

### 5.1 Tipo declarado frente a tipo real

```java
Instrumento i = new Guitarra();
//   ^tipo declarado      ^tipo real
```

- El **tipo declarado** (`Instrumento`) determina **qué métodos son válidos llamar** sobre `i`.
- El **tipo real** (`Guitarra`) determina **qué versión** de un método sobrescrito **se ejecuta**.

### 5.2 Primer caso estático: los campos (field hiding)

El acceso a un campo se resuelve **siempre** por el tipo declarado, sin importar el tipo real. `Guitarra` redeclara `tipo`, pero **no lo sobrescribe: lo oculta**.

```java
Instrumento i = new Guitarra();
System.out.println(i.tipo);   // campo -> ligadura ESTÁTICA -> "generico"
i.tocar();                    // método sobrescrito -> ligadura DINÁMICA -> "Rasgueo de cuerdas"
```

Salida (verificada con `com.uped.musica.MainBanda` y también en §5.2 de la guía):

```
generico
Rasgueo de cuerdas
```

### 5.3 Segundo caso estático: métodos `static`

Un método `static` pertenece a la **clase**, no al objeto. Si una subclase declara uno con la misma firma, lo **oculta**, no lo sobrescribe.

```java
Instrumento i = new Guitarra();
System.out.println(i.identificar());  // static -> ligadura ESTÁTICA -> "Instrumento generico"
```

### 5.4 Tercer y cuarto caso estático: `private` y `final`

| Modificador | Por qué es ligadura estática |
|---|---|
| `private` | No es visible fuera de su clase, ni para subclases. Ninguna subclase puede sobrescribirlo: solo existe **una** versión posible. |
| `final` | Está **prohibido** sobrescribirlo. Si nadie puede cambiar su comportamiento, el compilador ya conoce qué código se ejecutará siempre. |

Demostración en vivo (`com.uped.musica.demo.DemoReglas`, caso `PrivadaBase`/`PrivadaHija`):

```
h.mostrar() -> base-privado     (derecho de la base; sonido() es private y no se sobrescribe)
h.sonido()  -> hija-privado     (método independiente, NO es una sobrescritura)
```

El hilo común: **la ligadura estática ocurre donde NO puede existir más de una versión del comportamiento.**
En §7, `mostrarTipo()` es `final`; por eso `i.mostrarTipo()` imprime `Tipo declarado: generico` leyendo `Instrumento.tipo` (ver §4 de este documento).

### 5.5 Quinto caso estático: la sobrecarga (overloading)

Con varios métodos del mismo nombre y distintos parámetros, el **compilador** elige cuál usar según los **tipos de los argumentos escritos**. Se demuestra en la sección 6.3.

### 5.6 Ligadura dinámica: el mecanismo de dynamic dispatch

Cuando un método de instancia (**no** `static`, **no** `private`, **no** `final`) es sobrescrito con `@Override`, la JVM decide en ejecución consultando la tabla de métodos de la clase real del objeto:

1. La JVM llega a `instr.tocar()`.
2. Consulta el objeto **real** (no el tipo declarado).
3. Localiza la tabla de métodos de esa clase real (p. ej. `Piano`).
4. Busca `tocar()` y obtiene la dirección del código.
5. Ejecuta ese código específico.

### 5.7 Un arreglo con tres tipos reales distintos

```java
Instrumento[] banda = { new Guitarra(), new Piano(), new Bateria() };
for (Instrumento instr : banda) {
    instr.tocar();
}
```

Aunque el bucle tiene **una** línea, cada iteración imprime algo distinto porque `instr` apunta a un objeto real diferente. Ninguna salida se decidió al compilar.

### 5.8 Tabla comparativa completa

| Elemento | Ligadura estática | Ligadura dinámica |
|---|---|---|
| Campos (atributos) | **Siempre** (field hiding) | Nunca |
| Métodos `static` | **Siempre** | Nunca |
| Métodos `private` | **Siempre** | Nunca |
| Métodos `final` | **Siempre** | Nunca |
| Métodos sobrecargados | **Siempre** (overloading) | No aplica |
| Métodos de instancia sobrescritos | Nunca | **Siempre** (overriding) |

---

## 3. Sección 6 — Reglas prácticas y errores comunes (Bloque II)

Los tres casos de este bloque **compilan sin aviso**, por eso son peligrosos.

### 6.1 Llamar un método sobrescribible desde un constructor

Los constructores se ejecutan de **superclase hacia subclase**. Si el constructor de la superclase llama a un método sobrescrito, la ligadura es **dinámica**, pero el objeto **aún no está completamente construido**.

Demostración (`DemoReglas`, `InstrumentoConstructor`/`PianoConstructor`):

```
=== 6.1 Constructor llama a metodo sobrescribible ===
null
```

**Por qué `null`:** el constructor de `InstrumentoConstructor` llama a `tocar()`. Por ligadura dinámica se ejecuta el `tocar()` de `PianoConstructor`, que imprime `modelo`. Pero el constructor de `PianoConstructor` **todavía no corrió**, así que `modelo` sigue valiendo `null`. Regla práctica: **evitar llamar métodos sobrescribibles dentro de un constructor.**

### 6.2 El tipo declarado limita qué es válido escribir

Si la referencia se declara como `Instrumento`, el **compilador rechaza** llamar a un método propio de `Guitarra`, aunque el objeto real lo tenga.

```java
InstrumentoBase instr = new GuitarraConAfinar();
// instr.afinarCuerdas();   // NO compila
if (instr instanceof GuitarraConAfinar g) {  // downcasting seguro (patrón Java 16+)
    g.afinarCuerdas();       // SI compila
}
```

Demostración:

```
=== 6.2 Tipo declarado y downcasting seguro ===
instr.tocar() ->
sonido base
Afinando cuerdas (metodo propio de Guitarra)
```

El compilador solo permite llamar miembros declarados en el tipo declarado; para acceder a algo propio de la subclase hace falta **downcasting explícito**, y —como se practicó en la Semana 7— conviene comprobar antes con `instanceof`.

### 6.3 No confundir sobrecarga con sobrescritura

Si al sobrescribir se cambia por error el tipo de un parámetro, Java **no avisa**: crea silenciosamente un método **sobrecargado** nuevo, y el original de la superclase sigue existiendo sin sobrescribirse.

```java
class InstrumentoSobrecarga { void tocar(int volumen) { ... } }
class PianoSobrecarga extends InstrumentoSobrecarga {
    // @Override   <- si se agrega, el compilador SI avisa
    void tocar(double volumen) { ... }   // NO sobrescribe: sobrecarga
}
```

Demostración:

```
=== 6.3 Sobrecarga vs sobrescritura ===
generico (tocar(int))     // p.tocar(5)   -> elige la version int heredada
piano (tocar(double))     // p.tocar(5.0) -> elige la version double propia
```

`int` y `double` son tipos distintos: `tocar(double)` **no** sobrescribe a `tocar(int)`, lo **sobrecarga**. `PianoSobrecarga` termina con dos métodos independientes, resueltos por **ligadura estática** según el tipo del argumento. **`@Override` es la red de seguridad:** obliga al compilador a verificar que la firma coincide exactamente y avisa con error si no.

### 6.4 Árbol de decisión rápido

| Pregunta | Resultado |
|---|---|
| ¿Es un campo (atributo)? | **Sí → Estática** |
| ¿Es `static`, `private` o `final`? | **Sí → Estática** |
| ¿Hay varias firmas con el mismo nombre (overloading)? | **Sí → Estática** (según los argumentos escritos) |
| ¿Es un método de instancia sobrescrito con `@Override`? | **Sí → Dinámica** (según el objeto real) |

---

## 4. Sección 7 — Ejemplo integrador: la banda de Instrumento

### 4.1 Archivos (literal de la guía, con el ajuste documentado en §0)

| Archivo | Contenido |
|---|---|
| `com/uped/musica/modelo/Instrumento.java` | `public abstract class`; `public String tipo = "generico"`; `public abstract void tocar();`; `public static String identificar()` → `"Instrumento generico"`; `public final void mostrarTipo()` → `"Tipo declarado: " + tipo` |
| `com/uped/musica/modelo/Guitarra.java` | `extends Instrumento`; `public String tipo = "cuerda"` (oculta); `@Override tocar()` → `Rasgueo de cuerdas`; `public static String identificar()` → `"Guitarra"` |
| `com/uped/musica/modelo/Piano.java` | `@Override tocar()` → `Teclas resonando` |
| `com/uped/musica/modelo/Bateria.java` | `@Override tocar()` → `Golpe de tambores` |
| `com/uped/musica/MainBanda.java` | prueba completa de §7.3 |

### 4.2 Verificación línea por línea antes de ejecutar (§7.3 de la guía)

1. `i.tipo` → **campo**, ligadura **estática**: usa el tipo declarado `Instrumento`. Imprime `generico`.
2. `i.identificar()` → **`static`**, ligadura **estática**: usa el tipo declarado. Imprime `Instrumento generico`.
3. `i.mostrarTipo()` → **`final`**, ligadura **estática**. El campo `tipo` que lee está escrito dentro de `Instrumento` y nunca se sobrescribió: se compiló contra `Instrumento.tipo`. Imprime `Tipo declarado: generico`.
4. `i.tocar()` → **método de instancia sobrescrito**, ligadura **dinámica**: usa el tipo real `Guitarra`. Imprime `Rasgueo de cuerdas`.
5. El bucle final invoca `tocar()` sobre cada elemento del arreglo, resolviendo cada llamada por el **tipo real** de ese elemento.

### 4.3 Salida real (coincide con la guía)

```
generico
Instrumento generico
Tipo declarado: generico
Rasgueo de cuerdas
--- banda completa ---
Rasgueo de cuerdas
Teclas resonando
Golpe de tambores
```

**Punto clave (§7.3):** el tercer resultado (`Tipo declarado: generico`) sorprende porque, aunque el objeto real es una `Guitarra`, `mostrarTipo()` **nunca fue sobrescrito**: su código sigue siendo el de `Instrumento`, y toda referencia a `tipo` dentro de ese código se resolvió al compilar contra `Instrumento.tipo`. **Los campos nunca son polimórficos**, ni siquiera cuando el método heredado no cambia.

---

## 5. Sección 8.1 — Autoevaluación de sensores

Archivos de verificación: `com/uped/sensores/Sensor.java`, `SensorTemperatura.java`, `MainSensor.java`.

```java
Sensor s = new SensorTemperatura();
System.out.println(s.unidad);    // campo -> estatica -> "generica"
System.out.println(s.version()); // static -> estatica -> "Sensor v1"
s.medir();                       // sobrescrito -> dinamica -> "25.4 celsius"
```

**Salida real (coincide con la guía):**

```
generica
Sensor v1
25.4 celsius
```

**Por qué:**
- `s.unidad` usa el campo de `Sensor`: es un **campo**, resuelto por el **tipo declarado** (`Sensor`) → ligadura estática → `generica`.
- `s.version()` usa el método **`static`** de `Sensor`: los `static` no participan del despacho dinámico → ligadura estática → `Sensor v1`.
- `s.medir()` ejecuta la **implementación sobrescrita** de `SensorTemperatura`: método de instancia sobrescrito → ligadura dinámica. **Dentro** de ese `medir()` sobrescrito, el campo `unidad` se lee desde el código de `SensorTemperatura`, por lo que accede a `SensorTemperatura.unidad = celsius` → `25.4 celsius`.

---

## 6. Sección 8.2 — Revisión del proyecto propio (sin modificar código)

Proyecto incremental: `com.uped.proyecto` (jerarquía `Persona`). **No se agregó ni cambió ninguna clase.**

### 6.1 Llamada polimórfica real identificada

En `src/main/java/com/uped/proyecto/Main.java:51-57`:

```java
for (Persona persona : personas) {          // personas: Persona[] con tipos reales variados
    System.out.println(
            persona.presentarse()
                    + " -> $"
                    + persona.calcularBeneficioAnual()
    );
}
```

El arreglo `personas` (líneas 43-49) contiene **tipo real** `Cliente`, `Empleado`, `Estudiante`, `Docente` y `Voluntario`, pero la **referencia** `persona` está declarada como `Persona`.

### 6.2 Qué método se sobrescribe y cuál se ejecuta

`calcularBeneficioAnual()` está declarado **abstracto** en `Persona.java:17` y **sobrescrito con `@Override`** en cada subclase, por ejemplo:

- `Cliente.java:18-21` → `comprasAnuales * 0.05`
- `Empleado.java:20-23` → `salario * 0.10`
- `Gerente.java:16-19` → `super.calcularBeneficioAnual() + (tamanoEquipo * 25.0)`

Al ejecutar el bucle se observa (salida real) que para `Gerente` se ejecuta la versión de `Gerente` (245.0), para `DocenteInvestigador` la suya (480.0), etc. Es decir, **se ejecuta la versión de la clase real**, no una versión genérica.

### 6.3 Tipo declarado, tipo real y por qué es dinámica

| Punto del código | Tipo declarado | Tipo real | Ligadura |
|---|---|---|---|
| `Main.java:51` bucle sobre `personas` | `Persona` | `Cliente`/`Empleado`/`Estudiante`/`Docente`/`Voluntario` | — |
| `persona.calcularBeneficioAnual()` | `Persona` | el del objeto en esa iteración | **Dinámica** (método de instancia sobrescrito con `@Override`) |

**Por qué es dinámica:** `calcularBeneficioAnual()` es un método de instancia, **no** `static`/`private`/`final`, y está sobrescrito. El compilador solo comprueba que el método exista en el tipo declarado `Persona`; **cuál** versión se ejecuta se decide en ejecución consultando el **objeto real** (dynamic dispatch).

### 6.4 Campo de la misma jerarquía (acceso por tipo declarado)

En `Persona.java:5-6` hay dos campos `protected`:

```java
protected String nombre;
protected String dui;
```

El acceso a `nombre`/`dui` se resuelve **siempre por el tipo declarado**. Por ejemplo, dentro de `Persona.presentarse()` (`Persona.java:13-15`) y de `Empleado.actualizarNombre()` (`Empleado.java:12-14`), toda lectura/escritura de `nombre` se compila contra **`Persona.nombre`**, sin importar el tipo real.

> **Precisión importante:** en la jerarquía `Persona` **no hay ocultamiento de variables** (ninguna subclase redeclara `nombre` ni `dui`), así que aquí el efecto observable es solo el **enlace en tiempo de compilación** al campo de la superclase. El caso de *field hiding* real (dos campos con el mismo nombre) se ve en `com.uped.musica`: `Guitarra.tipo` **oculta** `Instrumento.tipo`, y `i.tipo` imprime el de `Instrumento`.

### 6.5 Tarjeta para el tablero Kanban (preparada)

```
Tarjeta: [Semana 9] 8.2 — Identificar ligadura dinámica en el proyecto propio
Columna: Hecho
Resultado: llamada polimórfica confirmada; NO se requieren cambios de código
Detalle:
  - Llamada: com.uped.proyecto.Main (lineas 51-57 y 131-146)
      persona.calcularBeneficioAnual()
  - Tipo declarado: Persona (abstracta)
  - Tipo real: Cliente / Empleado / Estudiante / Docente / Voluntario (y Gerente,
      DocenteInvestigador, ClienteVIP en el segundo recorrido)
  - Metodo sobrescrito: calcularBeneficioAnual() (abstracto en Persona.java:17;
      @Override en cada subclase) -> ligadura DINAMICA (dynamic dispatch)
  - Campo de la jerarquia: Persona.nombre / Persona.dui (protected) -> acceso por
      tipo declarado (ligadura ESTATICA). Nota: no hay field hiding en esta jerarquia.
  - Jerarquia Persona: SIN CAMBIOS
Evidencia: src/docs/semana9.md (seccion 6); compilacion de com.uped.proyecto sin errores
```

> **Actividad manual pendiente:** actualizar el tablero Kanban con esta tarjeta (no automatizable desde el código).

---

## 7. Sección 8.3 — Trazado integral (`Instrumento` / `Violin`)

Copia fiel del ejemplo (verificada con `com.uped.violin.MainViolin`, **sin** cambiar el código del ejemplo):

```java
class Instrumento {
    String tipo = "generico";
    Instrumento() { System.out.println("Construyendo: " + resumen()); }
    final String resumen() { return "tipo=" + tipo; }
    static String catalogo() { return "Catalogo base"; }
    void tocar() { System.out.println("...generico..."); }
}
class Violin extends Instrumento {
    String tipo = "cuerda frotada";
    static String catalogo() { return "Catalogo cuerdas"; }
    @Override void tocar() { System.out.println("Nota sostenida"); }
}
Instrumento v = new Violin();
System.out.println(v.tipo);
System.out.println(v.catalogo());
v.tocar();
```

### 7.1 Trazado en orden

1. **`Instrumento v = new Violin();`** → se ejecuta **primero** el constructor de `Instrumento` (de superclase a subclase), **antes** de inicializar los campos de `Violin`.
2. **Dentro del constructor de `Instrumento`** se llama `resumen()`.
3. **`final resumen()`** → ligadura **estática** (es `final` y no se sobrescribe). Además, el campo `tipo` que usa está escrito dentro de `Instrumento`, por lo que se enlaza a **`Instrumento.tipo`**, que en ese instante vale `"generico"` (`Violin.tipo` **aún no existe**).
   - Imprime: `Construyendo: tipo=generico`
4. Terminado el constructor de `Instrumento`, recién ahí se inicializa el campo de `Violin`: `tipo = "cuerda frotada"`.
5. **`System.out.println(v.tipo);`** → **campo**, ligadura **estática** por el tipo declarado `Instrumento` → imprime `generico` (aunque el objeto real es un `Violin` cuyo `tipo` es `"cuerda frotada"`).
6. **`System.out.println(v.catalogo());`** → método **`static`**, ligadura **estática** por el tipo declarado `Instrumento` → imprime `Catalogo base` (no `Catalogo cuerdas`).
7. **`v.tocar();`** → método de instancia **sobrescrito** con `@Override` → ligadura **dinámica** por el tipo real `Violin` → imprime `Nota sostenida` (no `...generico...`).

### 7.2 Salida completa correcta

```
Construyendo: tipo=generico
generico
Catalogo base
Nota sostenida
```

**Conclusión:** el constructor de la superclase se ejecuta antes de inicializar los campos de la subclase; por eso `resumen()` ve `tipo=generico`. La línea `v.tipo` y `v.catalogo()` son estáticas (campo y método `static`); solo `v.tocar()` es dinámica.

---

## 8. Sección 9 — Lista de verificación final

| # | Punto | Estado |
|---|---|---|
| 1 | Puedo explicar la diferencia entre el **tipo declarado** y el **tipo real** de una referencia | ✔ (secciones 2.1, 4.2, 7.1) |
| 2 | Sé que los **campos** y los métodos **`static`, `private` y `final`** se resuelven en tiempo de compilación (ligadura estática) | ✔ (secciones 2.2, 2.3, 2.4 y demos) |
| 3 | Sé que un **método de instancia sobrescrito con `@Override`** se resuelve en ejecución (ligadura dinámica, *dynamic dispatch*) | ✔ (secciones 2.6, 4.2 línea 4, 7.1 punto 7) |
| 4 | Resolví el ejercicio de autoevaluación **8.1** | ✔ (sección 5; salida verificada `generica / Sensor v1 / 25.4 celsius`) |
| 5 | Identifiqué una llamada polimórfica en mi proyecto y expliqué su ligadura dinámica (**8.2**) | ✔ (sección 6; `Main.java:51-57`) |
| 6 | Intenté trazar el ejercicio reto **8.3** antes de la sesión en clase | ✔ (sección 7; salida verificada) |

### Actividades manuales pendientes (fuera del código)

- **Tablero Kanban:** registrar la tarjeta de la sección 8.2 (texto preparado en §6.5). Requiere intervención manual.
- **Confirmar en clase** el trazado de 8.3 y la solución de 8.1 (según pide la guía, antes de ver la solución).

---

## 9. Sección 10 — Glosario de términos

Definiciones de la guía, con un ejemplo breve del código implementado.

- **Ligadura (*binding*):** proceso mediante el cual se conecta una llamada a un método o un acceso a un campo con el código o la dirección de memoria real que lo resuelve.
  *Ejemplo:* `instr.tocar()` se “liga” al `tocar()` de la clase real del objeto.

- **Ligadura estática:** ligadura resuelta en **tiempo de compilación**, con base en el **tipo declarado** de una referencia o en los tipos de los argumentos escritos en el código.
  *Ejemplo:* `i.tipo` (campo) y `i.identificar()` (`static`) en `MainBanda`.

- **Ligadura dinámica:** ligadura resuelta en **tiempo de ejecución**, con base en el **tipo real** del objeto al que apunta una referencia.
  *Ejemplo:* `instr.tocar()` en el bucle del arreglo `banda`.

- **Dynamic dispatch (despacho dinámico):** mecanismo mediante el cual la **JVM** consulta, en tiempo de ejecución, la tabla de métodos de la **clase real** de un objeto para decidir qué código ejecutar.
  *Ejemplo:* las tres salidas distintas (`Rasgueo…`, `Teclas…`, `Golpe…`) de una misma línea `instr.tocar()`.

- **Tipo declarado:** tipo con el que se crea una variable de referencia; determina **qué miembros son válidos llamar** sobre ella.
  *Ejemplo:* `Instrumento i = new Guitarra();` → el tipo declarado es `Instrumento`.

- **Tipo real:** tipo del objeto que efectivamente existe en memoria, asignado con `new`; determina **qué versión** de un método sobrescrito se ejecuta.
  *Ejemplo:* en `Instrumento i = new Guitarra();` el tipo real es `Guitarra`.

- **Ocultamiento de variables (*field hiding*):** fenómeno por el cual un campo declarado en una subclase con el mismo nombre que uno de la superclase **no lo sobrescribe**, sino que crea un espacio de memoria independiente; el acceso a cualquiera de los dos se decide por **ligadura estática**.
  *Ejemplo:* `Guitarra.tipo` oculta `Instrumento.tipo`; `i.tipo` imprime `generico`.

---

## 10. Pruebas finales, archivos y cumplimiento

### 10.1 Comandos ejecutados (JDK 25; el entorno no tiene Maven)

```powershell
# 1) Proyecto incremental (Persona) - sin cambios
javac -encoding UTF-8 -d target\classes (Get-ChildItem -Recurse -Filter *.java src\main\java).FullName
java  -cp target\classes com.uped.proyecto.Main

# 2) Casos nuevos de la Semana 9
javac -encoding UTF-8 -d target\ejemplos (Get-ChildItem -Recurse -Filter *.java src-ejemplos).FullName
java  -cp target\ejemplos com.uped.musica.MainBanda
java  -cp target\ejemplos com.uped.musica.demo.DemoReglas
java  -cp target\ejemplos com.uped.sensores.MainSensor
java  -cp target\ejemplos com.uped.violin.MainViolin
```

### 10.2 Resultados reales

| # | Ejecución | Resultado | Estado |
|---|---|---|---|
| 1 | `javac` `src/main/java` | 0 errores | ✔ |
| 2 | `javac` `src-ejemplos` | 0 errores (13 archivos nuevos + 13 de S8) | ✔ |
| 3 | `com.uped.musica.MainBanda` | idéntico a la guía §7.3 | ✔ |
| 4 | `com.uped.musica.demo.DemoReglas` | `null` (6.1), downcasting (6.2), sobrecarga (6.3), `private` (5.4) | ✔ |
| 5 | `com.uped.sensores.MainSensor` | `generica / Sensor v1 / 25.4 celsius` | ✔ |
| 6 | `com.uped.violin.MainViolin` | `Construyendo: tipo=generico / generico / Catalogo base / Nota sostenida` | ✔ |
| 7 | `com.uped.proyecto.Main` | salida idéntica a Semana 7/8 (245.0, 480.0, 750.0, 200/85/500/360/240) | ✔ |
| 8 | `git diff --stat` | sin modificaciones de archivos versionados de S6/S7/S8 | ✔ |

### 10.3 Archivos creados / modificados

**Creados (Semana 9 únicamente):**

| Archivo | Rol |
|---|---|
| `src-ejemplos/com/uped/musica/modelo/Instrumento.java` | §7.1 (abstracta) |
| `src-ejemplos/com/uped/musica/modelo/Guitarra.java` | §7.2 |
| `src-ejemplos/com/uped/musica/modelo/Piano.java` | §7.2 |
| `src-ejemplos/com/uped/musica/modelo/Bateria.java` | §7.2 |
| `src-ejemplos/com/uped/musica/MainBanda.java` | §7.3 |
| `src-ejemplos/com/uped/musica/demo/DemoReglas.java` | §6.1, 6.2, 6.3 y §5.4 |
| `src-ejemplos/com/uped/sensores/Sensor.java` | §8.1 |
| `src-ejemplos/com/uped/sensores/SensorTemperatura.java` | §8.1 |
| `src-ejemplos/com/uped/sensores/MainSensor.java` | §8.1 |
| `src-ejemplos/com/uped/violin/Instrumento.java` | §8.3 |
| `src-ejemplos/com/uped/violin/Violin.java` | §8.3 |
| `src-ejemplos/com/uped/violin/MainViolin.java` | §8.3 |
| `src/docs/semana9.md` | documentación de §5–§10 |

**Modificados:** ninguno de la jerarquía `Persona`, ni `pom.xml`, ni `Ejercicios-Semana7.iml`, ni Semanas 6/7/8.

### 10.4 Cumplimiento punto por punto de la guía

| Sección de la guía | Cumplido | Evidencia |
|---|---|---|
| §4 Organización `src-ejemplos/com/uped/musica/` | ✔ | estructura creada |
| §5 Bloque I (estática/dinámica) | ✔ | §2 del doc + `MainBanda`/`DemoReglas` |
| §6 Bloque II (6.1–6.4) | ✔ | §3 del doc + `DemoReglas` |
| §7 Ejemplo integrador | ✔ | `com.uped.musica.*` + salida idéntica |
| §8.1 Sensores | ✔ | `com.uped.sensores.*` + salida idéntica |
| §8.2 Proyecto propio | ✔ | §6 del doc + tarjeta Kanban |
| §8.3 Trazado integral | ✔ | `com.uped.violin.*` + §7 del doc |
| §9 Lista de verificación | ✔ | §8 del doc |
| §10 Glosario | ✔ | §9 del doc |

**No verificado / manual:** actualización del tablero Kanban (requiere acción humana).

### 10.5 Nota de compilación

El entorno **no tiene Maven**; la verificación se hizo con `javac`/`java` directos (JDK 25.0.2), igual que en la Semana 8. El `iml` ya incluye `src-ejemplos` como *source folder*; no se modificó Maven, ni el `pom.xml`, ni los `.iml`.
