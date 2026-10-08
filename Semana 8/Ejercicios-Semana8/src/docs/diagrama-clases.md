# Diagrama de Clases - Semana 7

```mermaid
classDiagram

    class Persona {
        <<abstract>>
        #String nombre
        #String dui
        +Persona(String nombre, String dui)
        +String presentarse()
        +double calcularBeneficioAnual()* 
        +String describirActividad()*
    }

    class Cliente {
        -String telefono
        -double comprasAnuales
        +Cliente(String nombre, String dui, String telefono, double comprasAnuales)
        +String getTelefono()
        +double calcularBeneficioAnual()
        +String describirActividad()
    }

    class Empleado {
        -double salario
        +Empleado(String nombre, String dui, double salario)
        +void actualizarNombre(String nuevoNombre)
        +double getSalario()
        +double calcularBeneficioAnual()
        +String describirActividad()
    }

    class Estudiante {
        -String carnet
        -String carrera
        -double promedio
        +Estudiante(String nombre, String dui, String carnet, String carrera, double promedio)
        +void matricular(String materia)
        +double calcularBeneficioAnual()
        +String toString()
        +String describirActividad()
    }

    class Docente {
        -String especialidad
        -int añosExperiencia
        +Docente(String nombre, String dui, String especialidad, int añosExperiencia)
        +void impartirClase(String materia)
        +double calcularBeneficioAnual()
        +String toString()
        +String describirActividad()
    }

    class Voluntario {
        -double horasServicio
        +Voluntario(String nombre, String dui, double horasServicio)
        +double calcularBeneficioAnual()
        +String toString()
        +String describirActividad()
    }

    class Proveedor {
        -double montoFacturado
        +Proveedor(String nombre, String dui, double montoFacturado)
        +double calcularBeneficioAnual()
        +String toString()
        +String describirActividad()
    }

    class Gerente {
        -int tamanoEquipo
        +Gerente(String nombre, String dui, double salario, int tamanoEquipo)
        +int getTamanoEquipo()
        +double calcularBeneficioAnual()
        +String toString()
    }

    class DocenteInvestigador {
        -int numeroPublicaciones
        +DocenteInvestigador(String nombre, String dui, String especialidad, int aniosExperiencia, int numeroPublicaciones)
        +int getNumeroPublicaciones()
        +double calcularBeneficioAnual()
        +String toString()
    }

    class ClienteVIP {
        <<final>>
        -int puntosAcumulados
        +ClienteVIP(String nombre, String dui, String telefono, double comprasAnuales, int puntosAcumulados)
        +int getPuntosAcumulados()
        +double calcularBeneficioAnual()*
        +String toString()
    }

    Persona <|-- Cliente
    Persona <|-- Empleado
    Persona <|-- Estudiante
    Persona <|-- Docente
    Persona <|-- Voluntario
    Persona <|-- Proveedor
    Empleado <|-- Gerente
    Docente <|-- DocenteInvestigador
    Cliente <|-- ClienteVIP
```

**Notacion:** ▷ generalizacion (herencia). El triangulo hueco apunta siempre a la superclase: cada clase nueva hereda de su clase padre, formando la jerarquia multinivel (`Empleado ▷ Gerente` y `Docente ▷ DocenteInvestigador` como tercer nivel).

`*` metodo abstracto o no sobrescribible. En `ClienteVIP` marca `calcularBeneficioAnual()` declarado `final`.

`<<final>>` clase cerrada: no admite subclases.
