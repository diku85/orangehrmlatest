pipeline {
    agent any   // Run on any available agent

    stages {
        stage('Checkout') {
            steps {
                // Pull code from GitHub
                git branch: 'main', url: 'https://github.com/diku85/orangehrmlatest.git'
            }
        }

        stage('Build') {
            steps {
                // Compile and build the project
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run unit tests
                bat 'mvn test'
            }
        }
    }
}