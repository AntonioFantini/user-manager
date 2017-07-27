pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Build'
      }
    }
    stage('Test') {
      steps {
        parallel(
          "Test": {
            sleep 5
            
          },
          "Junit test": {
            sleep 3
            
          },
          "DB Unit": {
            echo 'DB Unit test'
            
          }
        )
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploy'
      }
    }
  }
}