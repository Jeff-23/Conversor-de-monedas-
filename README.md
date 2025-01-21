# Conversor-de-monedas-
Este proyecto es una aplicación de consola desarrollada en Java que permite convertir valores de Pesos Colombianos (COP) a otras monedas internacionales en tiempo real, utilizando tasas de cambio obtenidas de una API pública.

Objetivo del proyecto
El objetivo principal de este proyecto es poner en práctica los conceptos aprendidos en Java, como:

Orientación a objetos (OOP).
Consumo de APIs externas.
Manejo de errores.
Trabajo con listas y colecciones de datos.
Características
Conversión de Pesos Colombianos (COP) a diversas monedas internacionales, incluyendo:
USD - Dólar estadounidense.
EUR - Euro.
GBP - Libra esterlina.
Consumo de datos en tiempo real desde la API de tasas de cambio.
Interfaz de usuario interactiva en la consola.
Manejo de errores, como problemas de conexión o entradas inválidas.
Tecnologías utilizadas
Lenguaje: Java
API utilizada: ExchangeRate API.
IDE: IntelliJ IDEA
Cómo ejecutar el proyecto
Clona el repositorio o descarga el código fuente.
Asegúrate de tener instalado Java 17 o superior.
Compila y ejecuta el archivo ConversorMonedas.java:
bash
Copiar
Editar
javac ConversorMonedas.java
java ConversorMonedas
Sigue las instrucciones en la consola para seleccionar una moneda y realizar la conversión.
Requisitos previos
Conexión a internet para obtener las tasas de cambio en tiempo real.
Java instalado en tu máquina.
Estructura del código
Clase principal: ConversorMonedas
Métodos:
main: Controla la lógica de la aplicación.
obtenerTasasDeCambio: Obtiene las tasas de cambio desde la API.
convertirMoneda: Realiza la conversión entre COP y la moneda seleccionada.
