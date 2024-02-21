# Bookshop Api Rest

BookshopApiRest is a REST API built with Spring Boot and Maven, designed to offer a wide range of functionalities for an online bookstore. From publishing books and scheduled events to making purchases, the API encompasses all essential features of a modern bookstore. 
With a robust Tokens based authentication system for all operations, comprehensive security for data and transactions is ensured, providing users with confidence and peace of mind in their interactions with the API.

## Key Features

- **Secure Login and Registration:** The system offers a secure login and registration process for users, ensuring the protection of their personal and access data. Robust security measures are implemented to safeguard confidential information during these operations.

- **Secure Authentication and Authorization:** 
It employs a JWT (JSON Web Tokens) system to enable users to securely perform designated functions. It provides secure login and registration, ensuring the protection of users' data.

- **Advanced Functionalities for Administrators:** Administrators have access to various management functions, including full management of books, users, scheduled events, and more. This allows for efficient and comprehensive administration of all aspects of the system by administrators.

## Technologies Used

- Spring Boot: Simplifies the development of Java applications, particularly those based on the Spring framework.
- Maven: Dependency management and build automation tool for Java projects.
- Spring Security: Provides authentication, authorization, and other security features for Spring applications.
- JWT (JSON Web Tokens): Used for secure authentication and authorization.

## Installation and Usage

To install and use this project, follow these steps:

1. Clone this repository to your local machine.
2. Make sure you have Maven installed.
3. Navigate to the project directory and build the project:

    ```bash
    mvn clean install
    ```

4. Run the application:

    ```bash
    java -jar target/bookshop-api-rest.jar
    ```

## License

This project is licensed under the MIT License. For more details, please read the LICENSE file.

## Contact

If you have any questions or comments about the project, feel free to contact us via email or by opening an issue in this repository.
