:: Before running this script, Install Kubectl and Minikube and start it with `minikube start`

:: Rebuild the Spring Boot executable .jar files with maven
:: mvn clean package -DskipTests=true

:: Make docker use the minikube docker daemon to build the docker images inside minikube
@FOR /f "tokens=*" %%i IN ('minikube -p minikube docker-env') DO @%%i

:: Build the Docker images
:: Registry
cd registry
docker build -t heroes/registry .
cd ..

:: Camp
cd camp
docker build -t heroes/camp .
cd ..

:: Arena
cd arena
docker build -t heroes/arena .
cd ..

:: Promoter
cd promoter
docker build -t heroes/promoter .
cd ..

:: Frontend
cd frontend
docker build -t heroes/frontend .
cd ..

:: Apply the Kubernetes resources (minikube has to be the active kubectl context)
kubectl apply -f k8s

:: FURTHER TASKS:
:: - List pods with `kubectl get pods`
:: - Get logs with e.g. 'kubectl logs service/arena -f`
:: - Forward pod port to localhost with: `kubectl port-forward service/frontend 8080:8080` -> frontend service will be available on localhost:8080
:: - Call `http://localhost:8080/promoter/promoteFight` in a Browser to check if it still works.
:: - Undeploy with  `kubectl delete -f k8s` or `./undeploy.sh`
:: - Stop minikube if not needed anymore with `minikube stop`

:: Missing but optional:
:: - Ingress Configuration
:: - Dedicated Database Service with Persistent Volume Claim
:: - ConfigMap for environment Variables