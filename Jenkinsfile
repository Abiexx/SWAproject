pipeline {
    agent any

   environment {
           MICROSERVICE_NAME = 'book-command-service'
       }

       tools {
           maven 'Maven' // Use the name you provided in Jenkins Global Tool Configuration
       }

       stages {
           stage('Checkout') {
               steps {
                   checkout scm
               }
           }

           stage('Build and Test') {
               steps {
                   script {
                       sh "mvn clean install -pl $MICROSERVICE_NAME"
                   }
               }
           }


//         stage('Deploy') {
//             steps {
//                 script {
//                     def dockerImage = "abiexx/$MICROSERVICE_NAME:latest"
//                     sh "docker build -t $dockerImage ."
//                     sh "docker run -d -p 8080:8080 $dockerImage"
//                 }
//             }
//         }
    }

    post {
        always {
            sh "docker stop $MICROSERVICE_NAME || true"
            sh "docker rm $MICROSERVICE_NAME || true"
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