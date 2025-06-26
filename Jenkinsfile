pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Aarav-S2005/tictactoe-app-DevOps.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t tictactoe-app .'
            }
        }

        stage('Run App') {
            steps {
                sh 'docker run --rm tictactoe-app'
            }
        }
    }
}
