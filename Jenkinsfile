pipeline {
    agent any

    stages {
        stage('CheckOut') {
            steps {
                echo 'Pulling Spring Boot code from GitHub...'
            }
        }

        stage('Compile') {
            steps {
                echo 'Compiling source code...'
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Executing Test Suite...'
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging application into a deployable WAR file...'
                sh 'mvn package -DskipTests'
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                echo 'Deploying WAR file directly to external Tomcat...'
                sh 'rm -f "/media/utkarsh/New Volume3/DevOps/Tomcat/apache-tomcat-10.1.55/webapps/jenkins-demo.war"'
                sh 'rm -rf "/media/utkarsh/New Volume3/DevOps/Tomcat/apache-tomcat-10.1.55/webapps/jenkins-demo/"'
                sh 'cp target/FridayDeploys-0.0.1-SNAPSHOT.war "/media/utkarsh/New Volume3/DevOps/Tomcat/apache-tomcat-10.1.55/webapps/jenkins-demo.war"'
                echo 'Deployment complete!'
            }
        }
    }
}
