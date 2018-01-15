pipeline {
    agent { label 'small' }
    options { buildDiscarder(logRotator(numToKeepStr: '25')); disableConcurrentBuilds() }

    stages {
        stage('Test') {

            steps {
                sh './gradlew clean check'
                junit 'build/test-results/junit-platform/*.xml'
            }
        }

        stage('Publish') {
            environment { BINTRAY_USER = "ci-weltn24" }
            when { branch 'master' }

            steps {
                withCredentials([[$class: 'StringBinding', credentialsId: 'BINTRAY_API_KEY_CI_WELTN24', variable: 'BINTRAY_PASS']]) {
                    sh './gradlew bintrayUpload'
                }
            }
        }
    }
}