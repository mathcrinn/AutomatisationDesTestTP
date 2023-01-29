pipeline {
    agent any

    stages {
        stage('test') {
            steps {
                bat 'mvn clean'
                bat 'mvn test' 
            }
        }
        stage('Package') {
            steps {
                bat 'mvn clean'
                bat 'mvn package' 
            }
        }
        stage('Generate Cucumber Report'){
        	steps{
        		
        	}
 
       	}
    }
}