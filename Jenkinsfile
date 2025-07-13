pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                echo '소스 코드 체크아웃 중...'
                checkout scm
            }
        }
        
        stage('Setup') {
            steps {
                echo 'Python 환경 설정 중...'
                sh 'python3 --version'
                sh 'pip3 --version'
            }
        }
        
        stage('Install Dependencies') {
            steps {
                echo '의존성 설치 중...'
                sh 'pip3 install -r requirements.txt'
            }
        }
        
        stage('Test') {
            steps {
                echo '테스트 실행 중...'
                sh 'python3 -m unittest test_hello_world.py -v'
            }
            post {
                always {
                    echo '테스트 완료'
                }
            }
        }
        
        stage('Build') {
            steps {
                echo '애플리케이션 빌드 중...'
                sh 'python3 hello-world.py'
            }
        }
        
        stage('Deploy') {
            steps {
                echo '배포 준비 완료!'
                echo '실제 배포는 여기에 배포 스크립트를 추가하면 됩니다.'
            }
        }
    }
    
    post {
        always {
            echo '파이프라인 완료'
        }
        success {
            echo '빌드 성공! 🎉'
        }
        failure {
            echo '빌드 실패! ��'
        }
    }
} 