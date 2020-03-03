// Powered by Infostretch

timestamps {

    node () {

        stage ('Checkout') {
            checkout([$class: 'GitSCM', branches: [[name: '*/gp2']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '88f4da1f-91a4-41fc-b1d8-8bd1e8b6bd26', url: 'https://github.com/DavidNavarreICS/SharesPortfolio1.git']]])
        }

        stage ('Build') {
            // Ant build step
            withAnt(installation: 'Ant10.5') {
                if(isUnix()) {
                    sh "ant clean jar checkstyle findbugs sonar "
                } else {
                    bat "ant clean jar checkstyle findbugs sonar "
                }
            }
        }
        stage('Check Style') {
            recordIssues(tools: [checkStyle()])
        }
        stage('Find Bugs') {
            recordIssues(tools: [findBugs(useRankAsPriority: true)])
        }
        stage('JUnit') {
            junit allowEmptyResults: true, testResults: '**/build/report/*.xml'
        }
    }
}