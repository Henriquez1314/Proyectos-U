8.1 Ejercicio de autoevaluación: encuentre el error

Automovil es una clase concreta porque no está declarada como abstract,
pero no implementa el método abstracto calcularImpuestoAnual() que hereda
de Vehiculo.

Hace falta agregar el método calcularImpuestoAnual() con @Override y
definir su propia fórmula de cálculo.


8.2 Ejercicio práctico 1: una quinta subclase, Proveedor

Se creó la clase Proveedor como subclase de Persona. La clase contiene
el atributo montoFacturado, utiliza super(nombre, dui) en el constructor
e implementa calcularBeneficioAnual() aplicando un descuento del 3%.

La prueba realizada en Main.java produjo:

Comercial Ríos (DUI: 06554321-8)
Beneficio: 240.0

8.3 Ejercicio práctico 2: refactorización de la superclase

La clase Persona fue convertida en una clase abstracta y se agregó el
método abstracto calcularBeneficioAnual().

Las subclases Cliente, Empleado, Estudiante, Docente y Voluntario
implementan correctamente dicho método.

El proyecto compila y ejecuta correctamente sin errores.


8.4 Ejercicio práctico 3: herencia multinivel

Sobre la jerarquía de la Semana 6 se agregaron tres subclases de segundo
nivel, cada una hija de una subclase existente y no de Persona. Así la
herencia queda en tres niveles: Persona -> {Empleado, Docente, Cliente} ->
 subclase de segundo nivel.

Gerente extends Empleado. Agrega el atributo tamanoEquipo y calcula el
beneficio con super.calcularBeneficioAnual() + (tamanoEquipo * 25.0), es
decir reutiliza la fórmula del salario del padre en lugar de duplicarla.

DocenteInvestigador extends Docente. Agrega numeroPublicaciones y calcula
el beneficio con super.calcularBeneficioAnual() + (numeroPublicaciones *
30.0).

ClienteVIP extends Cliente. Agrega puntosAcumulados y calcula el beneficio
con super.calcularBeneficioAnual() + (puntosAcumulados * 2.0). La clase y
el método calcularBeneficioAnual() se declaran final para cerrar la
jerarquía y evitar que una futura subclase altere la fórmula del beneficio.

El uso de super en los tres casos es la clave del ejercicio: el método
heredado ejecuta primero el cálculo de la clase padre y luego la subclase
suma su propio aporte, de modo que agregar un nivel no obliga a reescribir
la lógica del nivel anterior.

Prueba realizada en Main.java produjo:

Marta Díaz (DUI: 05123456-7) | Gerente, equipo de 5 personas
Beneficio: 245.0

Dr. Iván Reyes (DUI: 07321456-9) | Investigador, 4 publicaciones
Beneficio: 480.0

Rosa Méndez (DUI: 04876543-2) | VIP, 150 puntos
Beneficio: 750.0

Como ClienteVIP sigue siendo un Cliente y un Gerente sigue siendo un
Empleado, las tres instancias se recorren juntas en un arreglo de tipo
Persona. Ese recorrido demuestra el polimorfismo: el mismo llamada a
calcularBeneficioAnual() ejecuta la versión correcta segun el tipo real del
objeto, y los instanceof solo se usan para leer atributos que existen
unicamente en ciertas ramas (getTamanoEquipo, getNumeroPublicaciones).
