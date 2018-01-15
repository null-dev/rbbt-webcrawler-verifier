pipeline {
    agent { label 'small' }
    options { buildDiscarder(logRotator(numToKeepStr: '25')); disableConcurrentBuilds() }

    stage('Test') {

        steps {
            sh './gradlew check'
            junit 'build/test-results/junit-platform/*.xml'
        }
    }

    stage('Publish') {
        environment { BINTRAY_USER = "ci-weltn24" }
        when { branch 'master' }

        steps {
            withCredentials([[$class: 'StringBinding', credentialsId: 'BINTRAY_API_KEY_CI_WELTN24', variable: 'BINTRAY_PASS']]) {
                sh './gradlew bintrayPublish'
            }
        }

        slackSend channel: 'section-tool-2', message: "Successfully published a new WeltContentApiClient version: ${env.BUILD_URL}"
    }
}