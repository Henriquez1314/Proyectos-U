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