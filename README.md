
## High-Level design

![App Screenshot](https://github.com/niloymcs17/java-microservice/blob/main/readme/Untitled.png?raw=true)


## Documentation

[Documentation](https://github.com/niloymcs17/java-microservice/blob/main/readme/Catalogue%20%20Service.docx)


# Assumptions

    1.	A real-time Database is not present. Item data and Service provider's data are static and predefined and
         are shared between all three services.
    2.	No security layer is implemented for the services, considering there is no login for the customer,
         service provider, or admin.
    3.	We have no UI to show notifications so to update the order status we need to manually hit
         admin service - API through Postman. 
    4.	Order service holds order data locally, so if we have multiple instances of order service,
        data will be inconsistent.Also, if order service is stopped or restored, order data will be gone.
