# Docker

## Images

- https://hub.docker.com/u/in28min
- Currency Exchange Service 
	- in28min/mmv2-currency-exchange-service:0.0.1-SNAPSHOT
- Currency Conversion Service
	- in28min/mmv2-currency-conversion-service:0.0.1-SNAPSHOT
- Eureka
	- in28min/mmv2-naming-server:0.0.1-SNAPSHOT
- API GATEWAY
	- in28min/mmv2-api-gateway:0.0.1-SNAPSHOT

## URLS

#### Currency Exchange Service
- http://localhost:8000/currency-exchange/from/USD/to/INR

#### Currency Conversion Service
- http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
- http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10

#### Eureka
- http://localhost:8761/

#### Zipkin
- http://localhost:9411/

#### API GATEWAY
- http://localhost:8765/currency-exchange/from/USD/to/INR
- http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10
- http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10
- http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10

#### Commands
```
docker run -p 9411:9411 openzipkin/zipkin:2.23
docker login
docker push mjuharia76/mmv3-currency-exchange-service:0.0.13-SNAPSHOT
docker push mjuharia76/mmv3-currency-conversion-service:0.0.13-SNAPSHOT
docker-compose --version
docker-compose up
docker push in28min/mmv2-naming-server:0.0.1-SNAPSHOT
docker push in28min/mmv2-currency-conversion-service:0.0.1-SNAPSHOT
docker push in28min/mmv2-api-gateway:0.0.1-SNAPSHOT
watch -n 0.1 curl http://localhost:8000/sample-api
```

#### More Commands, including Kubernetes
```
kompose convert -f docker-compose.yaml

gcloud components install gke-gcloud-auth-plugin
glcoud auth login

// Connect to the Kubernetes cluster - https://console.cloud.google.com/ use evegar google credentials.
gcloud container clusters get-credentials moso-cluster --region us-east1 --project alert-inquiry-403617
gcloud container clusters get-credentials moso-cluster --region us-central1 --project alert-inquiry-403617

// Create and expose currency-exchange-service on port 8000
kubectl create deployment currency-exchange --image=mjuharia76/mmv3-currency-exchange-service:0.0.12-SNAPSHOT
kubectl expose deployment currency-exchange --type=LoadBalancer --port=8000
http://localhost:8000/currency-exchange/from/USD/to/INR
http://35.237.29.244:8000/currency-exchange/from/USD/to/INR

// Create and expose currency-conversion-service on port 8100
kubectl create deployment currency-conversion --image=mjuharia76/mmv3-currency-exchange-service:0.0.11-SNAPSHOT
kubectl expose deployment currency-conversion --type=LoadBalancer --port=8100
http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10
http://35.237.29.244:8000/currency-conversion-feign/from/USD/to/INR

docker run -p 8080:8080 in28min/hello-world-rest-api:0.0.1.RELEASE
 
kubectl create deployment hello-world-rest-api --image=in28min/hello-world-rest-api:0.0.1.RELEASE
kubectl expose deployment hello-world-rest-api --type=LoadBalancer --port=8080
kubectl scale deployment hello-world-rest-api --replicas=3
kubectl delete pod hello-world-rest-api-58ff5dd898-62l9d
kubectl autoscale deployment hello-world-rest-api --max=10 --cpu-percent=70
kubectl edit deployment hello-world-rest-api #minReadySeconds: 15
kubectl set image deployment hello-world-rest-api hello-world-rest-api=in28min/hello-world-rest-api:0.0.2.RELEASE
 
gcloud container clusters get-credentials in28minutes-cluster --zone us-central1-a --project solid-course-258105
kubectl create deployment hello-world-rest-api --image=in28min/hello-world-rest-api:0.0.1.RELEASE
kubectl expose deployment hello-world-rest-api --type=LoadBalancer --port=8080
kubectl set image deployment hello-world-rest-api hello-world-rest-api=DUMMY_IMAGE:TEST
kubectl get events --sort-by=.metadata.creationTimestamp
kubectl set image deployment hello-world-rest-api hello-world-rest-api=in28min/hello-world-rest-api:0.0.2.RELEASE
kubectl get events --sort-by=.metadata.creationTimestamp
kubectl get componentstatuses
kubectl get pods --all-namespaces
 
kubectl get events
kubectl get pods
kubectl get replicaset
kubectl get deployment
kubectl get service
 
kubectl get pods -o wide
 
kubectl explain pods
kubectl get pods -o wide
 
kubectl describe pod hello-world-rest-api-58ff5dd898-9trh2
 
kubectl get replicasets
kubectl get replicaset
 
kubectl scale deployment hello-world-rest-api --replicas=3
kubectl get pods
kubectl get replicaset
kubectl get events
kubectl get events --sort.by=.metadata.creationTimestamp
 
kubectl get rs
kubectl get rs -o wide
kubectl set image deployment hello-world-rest-api hello-world-rest-api=DUMMY_IMAGE:TEST
kubectl get rs -o wide
kubectl get pods
kubectl describe pod hello-world-rest-api-85995ddd5c-msjsm
kubectl get events --sort-by=.metadata.creationTimestamp
 
kubectl set image deployment hello-world-rest-api hello-world-rest-api=in28min/hello-world-rest-api:0.0.2.RELEASE
kubectl get events --sort-by=.metadata.creationTimestamp
kubectl get pods -o wide
kubectl delete pod hello-world-rest-api-67c79fd44f-n6c7l
kubectl get pods -o wide
kubectl delete pod hello-world-rest-api-67c79fd44f-8bhdt
 
gcloud container clusters get-credentials in28minutes-cluster --zone us-central1-c --project solid-course-258105
docker login
docker push in28min/mmv2-currency-exchange-service:0.0.11-SNAPSHOT
docker push in28min/mmv2-currency-conversion-service:0.0.11-SNAPSHOT
 
kubectl create deployment currency-exchange --image=in28min/mmv2-currency-exchange-service:0.0.11-SNAPSHOT
kubectl expose deployment currency-exchange --type=LoadBalancer --port=8000
kubectl get svc
kubectl get services
kubectl get pods
kubectl get po
kubectl get replicaset
kubectl get rs
kubectl get all
 
kubectl create deployment currency-conversion --image=in28min/mmv2-currency-conversion-service:0.0.11-SNAPSHOT
kubectl expose deployment currency-conversion --type=LoadBalancer --port=8100
 
kubectl get svc --watch
 
kubectl get deployments
 
kubectl get deployment currency-exchange -o yaml >> deployment.yaml 
kubectl get service currency-exchange -o yaml >> service.yaml 
 
kubectl diff -f deployment.yaml
kubectl apply -f deployment.yaml
 
kubectl delete all -l app=currency-exchange
kubectl delete all -l app=currency-conversion
 
kubectl rollout history deployment currency-conversion
kubectl rollout history deployment currency-exchange
kubectl rollout undo deployment currency-exchange --to-revision=1
 
kubectl logs currency-exchange-9fc6f979b-2gmn8
kubectl logs -f currency-exchange-9fc6f979b-2gmn8 
 
kubectl autoscale deployment currency-exchange --min=1 --max=3 --cpu-percent=5 
kubectl get hpa // Creates a Horizontal POD Autoscaler (hpa)
kubectl delete hpa currency-exchange
 
kubectl top pod
kubectl top nodes
kubectl get hpa
kubectl delete hpa currency-exchange
 
kubectl create configmap currency-conversion --from-literal=CURRENCY_EXCHANGE_URI=http://currency-exchange
kubectl get configmap
 
kubectl get configmap currency-conversion -o yaml >> configmap.yaml
 
watch -n 0.1 curl http://34.66.241.150:8100/currency-conversion-feign/from/USD/to/INR/quantity/10
 
docker push in28min/mmv2-currency-conversion-service:0.0.12-SNAPSHOT
docker push in28min/mmv2-currency-exchange-service:0.0.12-SNAPSHOT
```

### AWS CLI COMMANDS

```
$ aws configure
AWS Access Key ID [None]: 
AWS Secret Access Key [None]: 
Default region name [None]: us-east-1
Default output format [None]:

$ aws iam list-users
{
    "Users": [
        {
            "Path": "/",
            "UserName": "movses",
            "UserId": "AIDA2KVB2HBU642B2SRFM",
            "Arn": "arn:aws:iam::710082705513:user/movses",
            "CreateDate": "2019-08-17T19:57:09+00:00",
            "PasswordLastUsed": "2023-11-04T13:01:08+00:00"
        }
    ]
}

$ aws eks update-kubeconfig --region us-east-1 --name moso-cluster
https://docs.aws.amazon.com/eks/latest/userguide/getting-started-eksctl.html

kubectl create configmap kafka-consumer --from-literal=CUSTOMER_SERVICE_URI=http://customer-service


kubectl apply -f deployment.yaml 
kubectl get all -l app=customer-service -n moso-dev
kubectl delete all -l app=customer-service -n moso-dev
kubectl logs customer-service-779498f74-m9v6k -n moso-dev
kubectl exec -ti busybox -n moso-dev -- nslookup customer-service
kubectl describe pod customer-service-779498f74-m9v6k -n moso-dev

watch -n 0.1 curl http://172.100.141.137:7100/actuator/health/readiness

kubectl create deployment customer-service --image=mjuharia76/mmv3-customer-service:0.0.3-SNAPSHOT --namespace=moso-namespace
kubectl expose deployment customer-service --type=LoadBalancer --port=7100
kubectl create namespace moso-dev
kubectl delete namespace moso-dev

```

### KAFKA 

```
Using Kafaka on cloud. Using upstash at following URL:
https://upstash.com/ use evgar google credentials

#Install Ubuntu on Windows
wsl --install
username: mj89033
passwd: mj89033

kafka-topics.sh --bootstrap-server localhost:9092 --list

```
