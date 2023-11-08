pipeline {
    agent any

    environment {
        MICROSERVICE_NAME = 'my-microservice' // This can be a parameter or environment variable
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build and Test') {
            steps {
                sh "mvn clean package -pl $MICROSERVICE_NAME" // Use a parameter or environment variable
            }
        }
        stage('Deploy') {
            steps {
                sh "docker build -t $MICROSERVICE_NAME ."
                sh "docker run -d -p 8080:8080 $MICROSERVICE_NAME"
            }
        }
    }
}



// pipeline {
//
//     agent any
//     stages {
//
//         stage('Checkout Codebase'){
//             steps{
//                 cleanWs()
//                 checkout scm: [$class: 'GitSCM', branches: [[name: '*/main']],userRemoteConfigs:
//                 [[credentialsId: 'github-ssh-key', url: 'git@github.com:abiexx/SWAproject.git']]]
//             }
//         }
//
//         stage('Build'){
//             steps{
//                 sh 'mkdir lib'
//                 sh 'cd lib/ ; wget https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.0/junit-platform-console-standalone-1.7.0-all.jar'
//                 sh 'cd src ; javac -cp "../lib/junit-platform-console-standalone-1.7.0-all.jar" CarTest.java Car.java App.java'
//             }
//         }
//
//         stage('Test'){
//             steps{
//                 sh 'cd src/ ; java -jar ../lib/junit-platform-console-standalone-1.7.0-all.jar -cp "." --select-class CarTest --reports-dir="reports"'
//                 junit 'src/reports/*-jupiter.xml'
//             }
//         }
//
//         stage('Deploy'){
//             steps{
//                 sh 'cd src/ ; java App'
//             }
//         }
//     }
//
// }
//


// pipeline {
//     agent any
//     stages {
//         stage('Checkout Codebase'){
//             steps {
//                 echo 'Checking out codebase...'
// //                 git branch: 'main', url:'git@github.com:abiexx/SWAproject.git'
//             }
//            }
//         stage('Build') {
//             steps {
//                 echo 'Buildinggg..'
//             }
//         }
//         stage('Test') {
//             steps {
//                 echo 'Testing..'
//             }
//         }
//         stage('Deploy') {
//             steps {
//                 echo 'Deployingsss....'
//             }
//         }
//     }
// }