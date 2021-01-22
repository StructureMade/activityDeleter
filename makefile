dev:
	mvn clean
	mvn install -DskipTests=true
	docker build -f Dockerfile -t activitydeleter .
	docker-compose up
