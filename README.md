# game-profiler

## Prerequisites

* `PostgreSQL 14+`

## Usage

After startup, go to [https://localhost:8300/swagger-ui/index.html](https://localhost:8300/swagger-ui/index.html) to access the Swagger UI Interface.
Keep in mind that if the default port (`8300`) is changed, the port for `app.swagger.server.url` from config file should be updated as well.

## Config

Config file: `application.yml`

| Property                     |                       Default                       | Description                                                                                                |
|:-----------------------------|:---------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------|
| `server.port`                |                        8300                         | Can be changed in config file or by set environment variable `GP_PORT`                                     |
| `spring.datasource.url`      | `jdbc:postgresql://127.0.0.1:5432/game_profiler_db` | Can be changed in config file or by set environment variables `GP_DB_HOSTNAME`, `GP_DB_PORT`, `GP_DB_NAME` |
| `spring.datasource.username` |                      `dbuser`                       | Can be changed in config file or by set environment variable `GP_DB_USERNAME`                              |
| `spring.datasource.password` |                     `passw0rd`                      | Can be changed in config file or by set environment variable `GP_DB_PASSWORD`                              |
