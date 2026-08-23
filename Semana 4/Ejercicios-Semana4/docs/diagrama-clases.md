classDiagram

class Vehiculo {
-String placa
-String marca
-int kilometraje
+Vehiculo(String placa, String marca, int kilometraje)
+Vehiculo(String placa, String marca)
+recorrer(int km)
+nuevo(String placa, String marca) Vehiculo
}

class ConfiguracionReporte {
-String titulo
-String formato
-boolean incluirGraficos
-boolean incluirDetalles
+Builder
}

class Pedido {
-int numero
-double total
-String estado
+Pedido(int numero)
}

class Suscripcion {
-String usuario
-String plan
-LocalDate inicio
-int meses
+Suscripcion(String usuario)
+premium(String usuario) Suscripcion
+gratuita(String usuario) Suscripcion
}

class Empleado {
-String nombre
-List~String~ tareas
+Empleado(String nombre)
+getTareas() List~String~
+agregarTarea(String tarea)
+calcularPlanilla()
+generarReporte()
}

class Registro {
-int contador
-String estado
+Registro()
}

class LibroBiblioteca {
-String titulo
-String autor
-int ejemplaresDisponibles
+LibroBiblioteca(String titulo, String autor, int ejemplares)
+LibroBiblioteca(String titulo, String autor)
+unico(String titulo, String autor) LibroBiblioteca
+prestar() boolean
}