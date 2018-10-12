# # MDIExample

Este proyecto, está enfocado al uso de los **Multiple-Document Interface** también conocidos como **MDI** incorporando la conexión a bases de datos MySQL. Se repasarán contenidos como: 

- Creación de Formularios MDI-Parent
- Creación de Formularios MDI-Child
- Descarga e incorporación de libreria Connector/J
- Creación de Clase de conexión a Base de Datos
- Utilización de CRUD desde formularios a Base de Datos

## MDI-Parent

Los MDI Parent, son formularios de tipo JFrameForm, en los que incorporamos dos elementos escenciales para usarse como **Formulario Padre**: JMenu y JDesktopPane

## MDI-Child

Para trabajar con formularios dentro de un MDI-Parent, es necesario que los "hijos" sean creados como JInternalFrame, todo esto, asumiento que estamos trabajando con la librería gráfica Swing.