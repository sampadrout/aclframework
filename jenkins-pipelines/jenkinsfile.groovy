#!groovy
node('acl-slave') {
    stage('Git checkout') { // for display purposes
        git 'https://github.com/sampadrout/aclframework.git'
    }
    stage('Build') { // for display purposes
        sh "/.gradlew clean build"
    }
    stage('Run') { // for display purposes
        sh "java -jar build/libs/Automation-1.0-SNAPSHOT.jar"
    }
    stage('Build Report') {
        try {
            sh "allure generate -c allure-results"
        } catch (err) {

        } finally {
            publishHTML (target: [
                    reportDir: 'allure-results',
                    reportFiles: 'index.html',
                    reportName: "Mobile Test Report"
            ])
        }
    }
}