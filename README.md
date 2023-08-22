## GitHub Repository Information API

This project implements an API that allows API consumers to retrieve information about GitHub repositories based on specific acceptance criteria.
The API provides endpoint to list repositories for a given GitHub user and return specific information about each repository.
Additionally, the API handles error scenarios such as non-existing users and unsupported response formats.

### Prerequisites

Before you start using the GitHub Repository Information API, make sure you have the following:

    Java Development Kit (JDK) (version 17 or higher)
    Maven (Optional)

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/VaynerAkaWalo/Github-Repository-Information-API.git
    ```

2. Navigate to the project directory:

    ```bash
    cd github-repo-info-api
    ```

3. Build the project using Maven: (if maven installed u can replace `./mvnw` with `mvn`)

    ```bash
    ./mvnw clean install
    ```

### Run

```bash
./mvnw spring-boot:run
```

### Usage
List Repositories for a GitHub User

Endpoint: `GET /api/repositories/{username}`

#### Parameters
* `username` (required): GitHub username for which to list repositories.


#### Headers
* `Accept: application/json` (required): To receive the response in JSON format.


#### Response

```json
    [
      {
        "name": "repository-name",
        "owner_login": "login",
        "branches": [
          {
            "name": "branch-name",
            "sha": "commit-sha"
          },
          ...
        ]
      },
      ...
]

```

#### Error Handling

If the provided GitHub username does not exist, the API will respond with a 404 status code and the following JSON format:

```json
{
  "status": 404,
  "message": "User not found"
}
```

If the request header includes Accept: application/xml, the API will respond with a 406 status code and the following JSON format:

```json
{
  "status": 406,
  "message": "Unsupported media type"
}
```

Access to the GitHub API is rate-limited, especially for unauthorized users. Therefore, I do not recommend searching for users with a large number of repositories, as retrieving data requires at least n + 1 queries (where n is number of user repositories), which quickly exhausts the limit. When the limit is exceeded, the API will respond with a 403 status code and the following JSON format:

```json
{
   "status": 403,
   "message": "Rate limit exceeded!"
}
```

If you encounter a 403 code, please wait a few minutes before using the API again.