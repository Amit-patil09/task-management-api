# Task Management REST API – DevOps Project

## 1. Project Overview

This project is a Task Management REST API developed using Spring Boot and deployed using DevOps tools.

It demonstrates source code management, Continuous Integration, configuration management, containerization, and Kubernetes deployment.

The application allows users to add tasks and retrieve all stored tasks through REST API endpoints.

## 2. Technologies Used

| Technology | Purpose |
|---|---|
| Java 21 | Application runtime |
| Spring Boot | REST API development |
| Maven | Build and dependency management |
| GitHub | Source code management |
| Jenkins | Continuous Integration |
| Ansible | Configuration management |
| Docker | Containerization |
| Kubernetes (MicroK8s) | Container orchestration |
| curl / Firefox | API testing |

## 3. Project Structure

```text
task-management-api/
├── src/
├── pom.xml
├── Dockerfile
├── deployment.yaml
├── service.yaml
├── ansible/
│   ├── inventory.ini
│   ├── playbook.yml
│   ├── variables.yml
│   └── roles/
│       └── task-api/
│           ├── tasks/main.yml
│           └── handlers/main.yml
├── jenkins/
│   └── README.md
└── README.md
## 4. DevOps Workflow

### GitHub
Used for source code management and version control.

### Jenkins – Continuous Integration
- Job: task-management-api-ci
- Type: Freestyle Project
- Branch: main
- Build command: clean test package
- Build trigger: Poll SCM (H/2 * * * *)
- Post-build action: Archive target/*.jar

### Ansible – Configuration Management

Ansible automates application environment configuration.

Execute:

    cd ansible
    ansible-playbook -i inventory.ini playbook.yml --ask-become-pass

### Docker – Containerization

- Image: task-management-api
- Tag: 1.0
- Base image: Eclipse Temurin Java 21 JRE

Check images:

    sudo docker images

### Kubernetes – Deployment

| Resource | Name |
|---|---|
| Deployment | task-management-api |
| Service | task-management-service |
| NodePort | 30080 |
| Application Port | 8080 |

Check resources:

    microk8s kubectl get nodes
    microk8s kubectl get deployments
    microk8s kubectl get pods
    microk8s kubectl get services

## 5. REST API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | /todos | Add a new task |
| GET | /todos | Retrieve all tasks |

### Add Buy Milk

    curl -X POST http://localhost:30080/todos -H "Content-Type: application/json" -d '{"task":"Buy Milk"}'

### Add Buy Fruits

    curl -X POST http://localhost:30080/todos -H "Content-Type: application/json" -d '{"task":"Buy Fruits"}'

### Retrieve All Tasks

    curl http://localhost:30080/todos

## 6. Browser Access

Open Firefox inside Ubuntu:

    http://localhost:30080/todos

The browser displays the JSON response returned by the deployed REST API.

Note: This project currently implements a backend REST API, not a separate graphical frontend.

## 7. Project Outcome

- Source code management using GitHub.
- Automated build and testing using Jenkins.
- Configuration management using Ansible.
- Containerization using Docker.
- Deployment using Kubernetes.
- REST API testing using POST and GET requests.

## 8. Implementation Note

The application currently stores tasks in memory. Tasks may be lost when the application restarts or its Pod is recreated. A single replica is used for consistent task demonstration.

## 9. Conclusion

This project demonstrates the integration of DevOps tools with a Spring Boot REST API, covering source code management, automated builds, configuration management, containerization, Kubernetes deployment, and API testing.
