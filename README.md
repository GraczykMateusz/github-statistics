## Github statistics (In progress)

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/GraczykMateusz/github-statistics/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/GraczykMateusz/github-statistics/tree/master)

### Application Requirements

The application should meet the following requirements:

- [x] User Login Input: Allow users to input a login and display a response.
- [x] Event Dispatch: Regardless of whether the login is found, asynchronously send an event to log the attempt in the database.
- [x] Real-Time Updates: Listen for changes in the database and display these changes in real-time on a chart using Kafka, Debezium and Websocket.
- [x] Responsiveness: The application should be responsive, providing an optimal user experience across various devices and screen sizes.
- [x] API Documentation: Include Swagger UI to visualize and interact with the API.
- [ ] Automated Testing: Include unit tests, integration tests, and end-to-end (e2e) tests. These tests should be automatically executed during the CI build process.

### Docker Deployment: 

To set up the necessary environmentn, execute:

```docker
docker compose up -d
```

### Screenshots

<img src="docs/chart.png" width="685px" height="auto"/>

<img src="docs/response.png" width="685px" height="auto"/>

<img src="docs/api_swagger.png" width="685px" height="auto"/>

<img src="docs/user_not_found.png" width="685px" height="auto"/>
