# Contus Test Application

## Description

This project provides APIs to manage project assignments to users and retrieve lists of users and places based on assigned project counts.

## Database Design

![Alt Text](Contus_Tech/ContusApplication/db_schema.png)

## APIs Provided

### Users Controller

1. **Assign Projects to User**
   - **POST** `/api/v1/users`
   - Assign one or multiple projects to a user.

2. **List Users with Assigned Project Counts**
   - **GET** `/api/v1/users/users-project-count`
   - Retrieves a list of users sorted by the number of projects assigned to them.

### Project Controller

1. **Assign Project to User**
   - **POST** `/api/v1/project/assign?userId=<userId>&projectName=<projectName>`
   - Endpoint to assign a specific project to a user identified by `userId`.

### Places Controller

1. **List Places with Assigned Project Counts**
   - **GET** `/api/v1/places/places-project-count`
   - Retrieves a list of places sorted by the number of projects assigned to them.

## Features

- **Unit Tested:** ProjectService is thoroughly tested to ensure reliability.
- **Exception Handling:** All possible exceptions are handled gracefully to maintain API robustness.
- **Documentation:** Methods are documented using the Javadoc framework for clear understanding.
- **Code Quality:** Maintained to high standards, adhering to SonarLint recommendations.
- **Lombok Integration:** Reduces boilerplate code, enhancing code readability and maintainability.

## Usage

1. **Assign Projects to User**
   - Use the `/api/v1/users` endpoint with a POST request to assign project(s) to a user.

2. **Retrieve Users Ordered by Assigned Project Count**
   - Access `/api/v1/users/users-project-count` with a GET request to get users sorted by the number of projects assigned to them.

3. **Assign Project to User**
   - Utilize `/api/v1/project/assign?userId=<userId>&projectName=<projectName>` for assigning a specific project to a user.

4. **Retrieve Places Ordered by Assigned Project Count**
   - Retrieve places sorted by project count using `/api/v1/places/places-project-count` with a GET request.


## Contributing

Contributions are welcome! Please fork the repository and submit pull requests to contribute new features, improvements, or bug fixes.

## License

This project is licensed under the [MIT License](link-to-license-file), which means you are free to use, modify, and distribute the software as you like, with attribution.

