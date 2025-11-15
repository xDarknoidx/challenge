# Prueba Técnica Inditex

Proyecto hecho con arquitectura Hexagonal, Spring 6 y Spring Boot 3 para la explotación de una Tabla llamada Prices, la cual, contiene los datos de comercio electrónico de la compañia y, en la que se refleja el precio final(PVP) y la tarifa que aplica a un producto de una cadena entre unas fechas dadas, devolviendose la tarifa asociada a una fecha, brand_id y product_id.

## Configuración Entorno

Para el funcionamiento de la aplicación se necesitaran las siguientes versiones de los siguientes aplicativos:
- Java v17.
- Maven 3.9.9 o superior.
- Lombok Plugin.
- Intellij Idea.


## Campos de la Tabla Prices

Dentro de la tabla Prices, tenemos las siguientes columnas que se ven en la imagen a continuación:
![image](https://github.com/user-attachments/assets/a9df2749-f912-4486-b506-2c0f5a724db3)


Dichos campos son los siguientes:
- **ID**: identificador unico de cada elemento. **Tipo**: *BIGINT*
- **BRAND_ID**: foreign key de la cadena del grupo. **Tipo**: *INTEGER*
- **START_DATE**: fecha rango inicial en el que aplica el precio de una tarifa indicada. **Tipo**: *TIMESTAMP(6)*
- **END_DATE**: fecha rango final en el que aplica el precio de una tarifa indicada. **Tipo**: *TIMESTAMP(6)*
- **PRICE_LIST**: Identificador de la tarifa de precios aplicable. **Tipo**: *INTEGER*
- **PRODUCT_ID**: Identificador código de producto. **Tipo**: *INTEGER*
- **PRIORITY**: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico). **Tipo**: *INTEGER*
- **PRICE**: precio final de venta. **Tipo**: *FLOAT(53)*
- **CURR**: iso de la moneda. **Tipo**: *CHARACTER VARYING(255)*

## Endpoints Expuestos

La aplicación realizada tiene los siguientes endpoints:
    
- **Get Price**: Llamada Rest para la obtención de los datos de una tarifa asociados a los datos de entrada que se envián en la propia url de petición llamados date(Fecha de aplicación tarifa), brandId(Marca), productId(Identificador Producto).
    
    1. **Tipo**: *GET*
    2. **URL**: */hexagonal-test-inditex/api/v1/prices/get-price/{date}/{brandId}/{productId}*. 
    Ejemplo de url: **/hexagonal-test-inditex/api/v1/prices/get-price/2020-05-26 10:00:32/1/35455**
    3. **Response**:
    ```
    {
        "productId": 35455,
        "brandId": 1,
        "priority": 1,
        "startDate": "2020-06-15 00:00:00",
        "endDate": "2020-06-15 11:00:00",
        "price": "30.5 EUR"
    }
    ```
