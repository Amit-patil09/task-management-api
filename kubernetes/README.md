# Kubernetes Deployment

## Overview

The Task Management API is deployed using Kubernetes through MicroK8s.

Kubernetes manages the application Pods and exposes the application using a NodePort Service.

## Kubernetes Resources

### 1. Deployment

File: deployment.yaml

- Deployment name: task-management-api
- Container port: 8080
- Container image: task-management-api:1.0
- Replicas: Configured in deployment.yaml
- Health checks: Liveness and readiness probes

### 2. Service

File: service.yaml

- Service name: task-management-service
- Service type: NodePort
- NodePort: 30080
- Target port: 8080

## Deployment Commands

Apply the Deployment:

    microk8s kubectl apply -f kubernetes/deployment.yaml

Apply the Service:

    microk8s kubectl apply -f kubernetes/service.yaml

## Verify Deployment

Check nodes:

    microk8s kubectl get nodes

Check deployments:

    microk8s kubectl get deployments

Check Pods:

    microk8s kubectl get pods

Check Services:

    microk8s kubectl get services

## Access the Application

Open Firefox inside the Ubuntu VM:

    http://localhost:30080/todos

## API Testing

Add a task:

    curl -X POST http://localhost:30080/todos -H "Content-Type: application/json" -d '{"task":"Buy Milk"}'

Retrieve tasks:

    curl http://localhost:30080/todos

## Scaling the Application

Scale to three replicas:

    microk8s kubectl scale deployment task-management-api --replicas=3

For the in-memory task demonstration, use one replica to avoid requests reaching Pods with separate task lists.

## Conclusion

Kubernetes provides deployment, container orchestration, service discovery, and application management for the Task Management API.
