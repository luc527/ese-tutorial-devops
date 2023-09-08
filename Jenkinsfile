pipeline {
    agent any
    tools {
        jdk 'jdk_17'
        maven 'Maven'
    }
    stages {
        stage('Initialize') {
            steps {
                echo 'Iniciando...'
            }
        }
        stage('Build') {
            steps {
                dir('devopsnapratica') {
                    echo 'Esse é um pipeline de exemplo'
                    sh 'mvn install -Dquarkus.http.port=8084'
                }
            }
        }
    }
}