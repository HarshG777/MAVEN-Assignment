pipeline {
    agent any
  
    tools {
          maven 'sonarmaven'  // Install Maven tool in Jenkins
      }


    stages {
        stage('CheckOut') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('SonarQube Analysis') {
            environment {
                SONAR_TOKEN = credentials('sonarQub-token') // Replace with your Jenkins credential ID
            }
            steps {
                bat """
                mvn clean verify sonar:sonar -Dsonar.projectKey=MAVEN-Assignment -Dsonar.projectName='MAVEN-Assignment' -Dsonar.host.url=http://localhost:9000 -Dsonar.token=$(SONAR_TOKEN)
                """
            }
        }
    }

    post {
        success {
            echo "Pipeline executed successfully with code coverage!"
        }
        failure {
            echo "Pipeline failed. Check the logs for details."
        }
    }
}
