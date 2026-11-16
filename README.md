# Task Management REST API – DevOps Project

## Project Overview

This project is a Task Management REST API developed using Spring Boot and deployed using DevOps tools. It demonstrates the complete workflow of source code management, continuous integration, configuration management, containerization, and container orchestration.

The application allows users to add tasks and retrieve all stored tasks through REST API endpoints.

## Technologies Used

| Technology | Purpose |
|---|---|
| Java 21 | Application runtime |
| Spring Boot | REST API development |
| GitHub | Source code management and version control |
| Jenkins | Continuous Integration (CI), build and testing |
| Ansible | Configuration management and automation |
| Docker | Application containerization |
| Kubernetes (MicroK8s) | Container orchestration and deployment |
| Maven | Build and dependency management |
| curl / Firefox | API testing and response display |

## DevOps Workflow

1. **GitHub:** Source code is maintained in a GitHub repository.
2. **Jenkins:** A Jenkins Freestyle job named `task-management-api-ci` retrieves the source code and runs the Maven build and test process.
3. **Ansible:** Ansible playbook automates the configured application environment tasks.
4. **Docker:** The Spring Boot application is packaged into a Docker image named `task-management-api:1.0`.
5. **Kubernetes:** The application is deployed using MicroK8s. Kubernetes Deployment manages the application Pods, while a NodePort Service exposes the application.
6. **REST API Testing:** POST and GET requests are used to add and retrieve tasks.

## Ansible Configuration

The Ansible project contains:

- `inventory.ini` – Inventory configuration.
- `playbook.yml` – Automation tasks.
- `variables.yml` – Variables used by the playbook.
- `roles/` – Ansible role structure.

Execute the playbook using:

```bash
ansible-playbook -i inventory.ini playbook.yml --ask-become-pass
```

## Docker Configuration

The application is packaged into a Docker image:

- Image name: `task-management-api`
- Tag: `1.0`
- Base runtime: Eclipse Temurin Java 21 JRE

View Docker images:

```bash
sudo docker images
```

## Kubernetes Deployment

The application is deployed on a local MicroK8s Kubernetes cluster.

| Resource | Name |
|---|---|
| Deployment | `task-management-api` |
| Service | `task-management-service` |
| NodePort | `30080` |
| Application Port | `8080` |

Check Kubernetes resources:

```bash
microk8s kubectl get nodes
microk8s kubectl get deployments
microk8s kubectl get pods
microk8s kubectl get services
```

## REST API Endpoints

The application provides the following endpoints:

| HTTP Method | Endpoint | Description |
|---|---|---|
| POST | `/todos` | Add a new task |
| GET | `/todos` | Retrieve all tasks |

### Add a Task

Example: Add Buy Milk.

```bash
curl -X POST http://localhost:30080/todos \
-H "Content-Type: application/json" \
-d '{"task":"Buy Milk"}'
```

Example: Add Buy Fruits.

```bash
curl -X POST http://localhost:30080/todos \
-H "Content-Type: application/json" \
-d '{"task":"Buy Fruits"}'
```

### Retrieve All Tasks

```bash
curl http://localhost:30080/todos
```

Example JSON response:

```json
[
  {
    "id": 1,
    "task": "Buy Milk"
  },
  {
    "id": 2,
    "task": "Buy Fruits"
  }
]
```

## Access the Application in a Browser

Open Firefox inside the Ubuntu VM and visit:

```text
http://localhost:30080/todos
```

The browser displays the JSON response returned by the deployed REST API.

**Note:** This project currently implements a backend REST API, not a separate graphical frontend. Therefore, the browser displays JSON rather than a webpage with task input fields or buttons.

## Important Implementation Note

The current application stores tasks in memory. Tasks may be lost when the application restarts or its Pod is recreated. A single application replica is used for consistent task demonstration because separate Pods have separate in-memory data.

## Project Outcome

The project demonstrates:

- Source code management using GitHub.
- Automated build and testing using Jenkins.
- Configuration management using Ansible.
- Containerization using Docker.
- Application deployment using Kubernetes.
- REST API testing using POST and GET methods.
- Retrieving application data through a web browser.

## Conclusion

This project demonstrates how DevOps tools can be integrated with a Spring Boot REST API to manage the software development and deployment workflow, from source code management to containerized Kubernetes deployment and API testing.
