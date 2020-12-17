mvn clean package -DskipTests=true

# Make docker use the minikube docker daemon
eval $(minikube docker-env)

# Build the Docker images (in minikube)

# Registry
cd registry
docker build -t heroes/registry .
cd ..

# Camp
cd camp
docker build -t heroes/camp .
cd ..

# Arena
cd arena
docker build -t heroes/arena .
cd ..

# Promoter
cd promoter
docker build -t heroes/promoter .
cd ..

# Frontend
cd frontend
docker build -t heroes/fronted .
cd ..

# Apply the Kubernetes resources
kubectl apply -f k8s
