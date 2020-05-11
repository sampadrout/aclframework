#!groovy
node('acl-slave') {
    stage('Git checkout') { // for display purposes
        git branch:'develop-mobile', url: 'https://github.com/sampadrout/aclframework.git'
    }
    stage('Build') { // for display purposes
        sh "./gradlew clean build"
    }
    stage('Run') { // for display purposes
        sh "java -jar build/libs/Automation-1.0-SNAPSHOT.jar"
    }
    stage('Build Report') {
        script {
            allure([
                    includeProperties: false,
                    jdk: '',
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'allure-results']],
                    report: "allure-report"
            ])
        }
    }
    stage('Publish Report'){
        publishHTML (target: [
                reportDir: 'allure-report',
                reportFiles: 'index.html',
                reportName: "Mobile Test Report"
        ])
    }
}