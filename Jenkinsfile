pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Aarav-S2005/tictactoe-app-DevOps.git'
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
                sh 'docker run --rm tictactoe-app java -jar app.jar auto'
            }
        }

        stage('Run App') {
            steps {
                sh 'docker run --rm tictactoe-app'
            }
        }
    }

    post {
        success {
            echo '✅ Build and deployment completed successfully!'
        }
        failure {
            echo '❌ Build failed!'
        }
    }
}
