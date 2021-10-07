pipeline{
       agent any 
               stages {
               	stage('One'){
                     steps{
                         echo 'Hello'
                     }
               }
               	stage('Two'){
                     steps{
                         input('Hello this is jenkins')
                     }
              }
               	stage('Three'){
                     when{
                        not{
                        branch"master"
                        }
                     }
                     steps{
                     echo "Hello everyone"
                     }
               }
               	stage('Four'){
                             parallel{
                                 stage('Unit Test'){
                                            steps{
                                            echo "Running the unit test..."
                                          }
                                 }
                                 stage('Integration test'){
                                     agent{
                                       any{
                                       reuseNode false
                                       image 'ubuntu'
                                       }
                                     }
                                     steps {
                                     echo 'Running the integration test..'
                                     }
                                 }
                             }
                          } 
         }
           
}