pipeline{
    agent any
    stages{
        stage('CheckOut'){
            echo 'Pulling code from the Git repo'
            // this is an automatic process
        }
        stage('Compile'){
            echo 'Compiling the backend source code'
            sh 'mvn clean compile'
        }

        stage('Run Tests'){
            echo 'Executing JUnit tests'
            sh 'mvn test'
        }

        stage('Package'){
            echo 'Packagin applications in WAR'
            sh 'mvn package -DskipTests'
        }


        stage('Deploy to Tomcat') {
            steps {
                echo 'Deploying WAR file directly to external Tomcat...'

                // 1. Clear out any old versions of the app in your specific Tomcat folder
                sh 'rm -f "/media/utkarsh/New Volume3/DevOps/Tomcat/apache-tomcat-10.1.55/webapps/jenkins-demo.war"'
                sh 'rm -rf "/media/utkarsh/New Volume3/DevOps/Tomcat/apache-tomcat-10.1.55/webapps/jenkins-demo/"'

                // 2. Copy the fresh WAR file into your Tomcat webapps folder
                sh 'cp target/jenkins-demo-0.0.1-SNAPSHOT.war "/media/utkarsh/New Volume3/DevOps/Tomcat/apache-tomcat-10.1.55/webapps/jenkins-demo.war"'

                echo 'Deployment complete! Tomcat is auto-unzipping and hosting the application.'
            }
        }

    }
}