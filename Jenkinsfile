pipeline {
    agent any
    stages {
        stage('Checkout Codebase'){
            steps {
                echo 'Checking out codebase...checking and ad'
                git branch: 'main', url:'git@github.com:abiexx/SWAproject.git'
            }
           }
        stage('Build') {
            steps {
                echo 'Buildinggg..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }