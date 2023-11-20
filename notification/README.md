# notification app

Port 8090 for application, swagger and h2 database

Detailed description of api in swagger.

Short description:
1. Method POST /api/notification - Send notification to recipient from body with subject and message from body
2. Application has a schedule job that retries messages with error. Max number of retries is 3. Then status of message will be broken.

Process of sending all notifications is async.
