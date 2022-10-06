# Proyecto del salon grupal

## Redaccion de planteamiento

Tenemos un Banco que necesariamente ocupa clientes para existir y cuenta con 3 tipos de cuentas. En el banco puedes realizar transacciones, depositos y retiros entre las cuentas del mismo banco y no importa si las cuentas sean del mismo propetario. Los clientes deben tener una cuenta y un identificador unico. Las cuentas deben tener un tipo de cuenta definido en ellas, identificador unico y saldo.

La "base de datos" del banco de toda la informacion que maneja, se registra en un archivo csv.
El registro de las transacciones se registran en otro archivo csv diferente, pero nunca se elimina el historial de las anteriores.

## Clases

* Banco: Cuenta con las acciones que realiza un banco junto con su informacion, dicha informacion se encuentra en un archivo csv.

* Cliente: Datos de la persona que el banco tiene registrado.

* Cuenta: Es la cuenta del mismo banco da al cliente, hay 3 tipos de cuentas:

    * Cuenta1: por especificar.

    * Cuenta2: por especificar.

    * Cuenta2: por especificar.

* Transacciones: Hace el registro de cuando hay intento de transaccion, guardando los registros en un archivo csv especificado.

## Librerias

Las clases no mencionadas no ocuparon importar una libreria en especial.

### Banco

import java.util.Scanner;

import java.io.File;

import java.io.FileNotFoundException;

### Transacciones

import java.util.Scanner;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.PrintWriter;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;


## Funcional

* El programa lee los datos del archivo csv y los asigna en sus respectivos espacios (clientes y cuentas).
* Se usa Scanner para leer el archivo csv.
* La informacion es estatica en archivos csv.
* Las acciones de deposito, retiro y transferencia funcionan.


## Limitacion

* Se ocupa ArrayList para crear lista de objetos.

* Sin uso de colections y arraylist.

* El cliente solo puede tener una cuenta.

* 

# Archivo CSV

* info.csv
    Esta acomodado de la siguiente manera Nombre, ID_propetario, ID_Cuenta y saldo.

* Transacciones.csv
    Aqui se registra todas las acciones de retiro, deposito y transaccion independientemente si su caso es valido o no.