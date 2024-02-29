pipeline {
    agent {
        docker {
            image 'alpine:latest'
        }
    }
    stages {
        stage('Create Text File') {
            steps {
                script {
                    sh 'echo "Hello, World!" > output.txt'
                }
            }
        }
    }
    post {
        success {
            archiveArtifacts 'output.txt'
        }
    }
}
