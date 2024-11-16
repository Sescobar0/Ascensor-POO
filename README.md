Clase Ascensor: El Ascensor es un sistema complejo que incluye control de movimiento entre pisos, 
gestión del estado de sus puertas, y procesamiento de solicitudes de movimiento. 
Utiliza varios componentes como las clases Puerta y Botonera para proporcionar una funcionalidad completa y segura









Herencia:

Boton_Ascensor, BotonPiso, y BotonPuertasAbiertas heredan de Boton.

Composición:

Ascensor contiene una instancia de Puerta y Botonera.

Botonera contiene una lista de Boton.

Piso contiene instancias de BotonSubir y BotonBajar.

SistemaControl contiene listas de Ascensor y Piso, y colas de Integer para solicitudes.

Asociación:

Boton_Ascensor y BotonPuertasAbiertas están asociadas a Ascensor.
