# Sistema CRUD de Empleados

Proyecto individual desarrollado para el curso de **Programación 2** de la Universidad Mariano Gálvez de Guatemala.

## Descripción

Aplicación de escritorio desarrollada en **Java Swing** que permite gestionar información de empleados mediante las operaciones **CRUD**: crear, consultar, modificar y eliminar registros.

La aplicación utiliza **MySQL** como sistema de gestión de base de datos y **JDBC** para realizar la conexión y las operaciones sobre los datos.

## Tecnologías utilizadas

* Java
* Java Swing
* JDBC
* MySQL
* Maven
* Git y GitHub

## Funcionalidades

* Registrar empleados.
* Consultar y mostrar empleados en una tabla.
* Modificar empleados seleccionados.
* Eliminar empleados.
* Limpiar los campos del formulario.
* Actualizar la información mostrada.
* Validar los datos ingresados.

## Estructura del proyecto

```text
edu.umg.programacion2.sistema
├── conexion
│   └── ConexionBD.java
├── dao
│   └── EmpleadoDAO.java
├── modelo
│   └── Empleado.java
├── servicio
│   └── EmpleadoServicio.java
└── vista
    └── VentanaEmpleados.java
```

La aplicación utiliza una estructura por capas:

**Vista → Servicio → DAO → Base de datos**

Esta separación permite organizar mejor el código y distribuir las responsabilidades de cada componente.

## Base de datos

Base de datos utilizada:

`sistema_crud`

Tabla principal:

`empleados`

Campos:

* `id_empleado`
* `nombre_completo`
* `puesto`
* `salario`
* `telefono`
* `correo`

El identificador del empleado utiliza `AUTO_INCREMENT` para generar automáticamente los IDs.

## Ejecución

Para ejecutar el proyecto se necesita:

1. Tener Java y MySQL instalados.
2. Crear la base de datos y la tabla `empleados`.
3. Configurar los datos de conexión en `ConexionBD.java`.
4. Ejecutar la clase `VentanaEmpleados.java`.

## Autor

**Karen Jarquín**

Proyecto individual — Programación 2
Universidad Mariano Gálvez de Guatemala
